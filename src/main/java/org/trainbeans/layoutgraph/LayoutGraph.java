package org.trainbeans.layoutgraph;

import java.util.List;

public interface LayoutGraph {
    List<ControlPoint> getControlPoints();

    List<TrackSegment> getTrackSegments();

    void addControlPoint(ControlPoint cp);

    void addTrackSegmentBetween(ControlPoint cp1, ControlPoint cp2);

    boolean containsTrackSegmentBetween(ControlPoint cp1, ControlPoint cp2);

    boolean containsPathBetween(ControlPoint cp1, ControlPoint cp2);

    List<TrackSegment> getPathsBetween(ControlPoint cp1, ControlPoint cp2);
}
