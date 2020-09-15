package org.trainbeans.layoutgraph.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.trainbeans.layoutgraph.ControlPoint;

import static org.assertj.core.api.Assertions.assertThat;

public class LayoutGraphImplTest {

    @Test
    public void aLayoutGraphCanBeConstructed(){
        LayoutGraphImpl g = new LayoutGraphImpl();

        assertThat(g).isNotNull();
    }

    @Test
    public void aLayoutHasControlPoints(){
        LayoutGraphImpl g = new LayoutGraphImpl();

        assertThat(g.getControlPoints()).isNotNull();
    }

    @Test
    public void newControlPointsCanBeAddedToALayout(){
        LayoutGraphImpl g = new LayoutGraphImpl();

        ControlPoint cp = Mockito.mock(ControlPoint.class);

        g.addControlPoint(cp);

        assertThat(g.getControlPoints()).isNotNull().isNotEmpty().hasSize(1).contains(cp);

    }

    @Test
    public void aLayoutHasTrackSegments(){
        LayoutGraphImpl g = new LayoutGraphImpl();

        assertThat(g.getTrackSegments()).isNotNull();
    }

    @Test
    public void whenTwoControlPointsExist_aTrackSegmentCanBeAddedBetweenThem(){
        LayoutGraphImpl g = new LayoutGraphImpl();
        ControlPoint cp1 = Mockito.mock(ControlPoint.class);
        g.addControlPoint(cp1);
        ControlPoint cp2 = Mockito.mock(ControlPoint.class);
        g.addControlPoint(cp2);
        g.addTrackSegmentBetween(cp1,cp2);
        assertThat(g.getControlPoints()).isNotNull().isNotEmpty().hasSize(2).contains(cp1,cp2);
        assertThat(g.getTrackSegments()).isNotNull().isNotEmpty().hasSize(1);

    }

    @Test
    public void whenTwoControlPointsAreConnected_aTrackSegmentExistsBetweenThem(){
        LayoutGraphImpl g = new LayoutGraphImpl();
        ControlPoint cp1 = Mockito.mock(ControlPoint.class);
        g.addControlPoint(cp1);
        ControlPoint cp2 = Mockito.mock(ControlPoint.class);
        g.addControlPoint(cp2);
        g.addTrackSegmentBetween(cp1,cp2);

        assertThat(g.containsTrackSegmentBetween(cp1,cp2)).isTrue();
    }

    @Test
    public void whenTwoControlPointsAreConnected_aPathExistsBetweenThem(){
        LayoutGraphImpl g = new LayoutGraphImpl();
        ControlPoint cp1 = Mockito.mock(ControlPoint.class);
        g.addControlPoint(cp1);
        ControlPoint cp2 = Mockito.mock(ControlPoint.class);
        g.addControlPoint(cp2);
        g.addTrackSegmentBetween(cp1,cp2);

        assertThat(g.containsPathBetween(cp1,cp2)).isTrue();
    }

    @Test
    public void whenTwoControlPointsAreConnected_aPathBetweenThemCanBeRetrieved(){
        LayoutGraphImpl g = new LayoutGraphImpl();
        ControlPoint cp1 = Mockito.mock(ControlPoint.class);
        g.addControlPoint(cp1);
        ControlPoint cp2 = Mockito.mock(ControlPoint.class);
        g.addControlPoint(cp2);
        g.addTrackSegmentBetween(cp1,cp2);

        assertThat(g.getPathsBetween(cp1,cp2)).isNotEmpty().hasSize(1);
    }

}
