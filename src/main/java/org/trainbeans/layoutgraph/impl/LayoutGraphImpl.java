package org.trainbeans.layoutgraph.impl;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.Multigraph;
import org.trainbeans.layoutgraph.ControlPoint;
import org.trainbeans.layoutgraph.TrackSegment;

import java.util.ArrayList;
import java.util.List;

public class LayoutGraphImpl implements org.trainbeans.layoutgraph.LayoutGraph {

    private Graph<ControlPoint, TrackSegment> layoutGraph;

    public LayoutGraphImpl(){
        layoutGraph = new Multigraph<ControlPoint, TrackSegment>(TrackSegmentImpl.class);
    }

    public List<ControlPoint> getControlPoints() {
        return new ArrayList<ControlPoint>(layoutGraph.vertexSet());
    }

    public List<TrackSegment> getTrackSegments() {
        return new ArrayList<TrackSegment>(layoutGraph.edgeSet());
    }

    public void addControlPoint(ControlPoint cp) {
        layoutGraph.addVertex(cp);
    }

    public void addTrackSegmentBetween(ControlPoint cp1, ControlPoint cp2) {
        layoutGraph.addEdge(cp1,cp2);
    }

    public boolean containsTrackSegmentBetween(ControlPoint cp1, ControlPoint cp2) {
        return layoutGraph.containsEdge(cp1,cp2);
    }

    public boolean containsPathBetween(ControlPoint cp1, ControlPoint cp2) {
        PathFinderImpl pathFinder = new PathFinderImpl(layoutGraph);
        return !pathFinder.getPaths(cp1,cp2).isEmpty();
    }

    public List<TrackSegment> getPathsBetween(ControlPoint cp1, ControlPoint cp2) {
        PathFinderImpl pathFinder = new PathFinderImpl(layoutGraph);
        List<GraphPath<ControlPoint,TrackSegment>> paths = pathFinder.getPaths(cp1,cp2);
        return paths.stream().map(o -> o.getEdgeList()).findFirst().orElse(new ArrayList<>());
    }
}
