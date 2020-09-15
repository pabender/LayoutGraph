package org.trainbeans.layoutgraph.impl;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.BidirectionalDijkstraShortestPath;
import org.trainbeans.layoutgraph.ControlPoint;
import org.trainbeans.layoutgraph.TrackSegment;

import java.util.Collections;
import java.util.List;

public class PathFinderImpl {

    Graph<ControlPoint, TrackSegment> graph;
    ShortestPathAlgorithm<ControlPoint,TrackSegment> pathAlgorithm;

    public PathFinderImpl(Graph graph){
        this.graph = graph;
        pathAlgorithm = new BidirectionalDijkstraShortestPath<ControlPoint, TrackSegment>(this.graph);
    }

    List<GraphPath<ControlPoint,TrackSegment>> getPaths(ControlPoint start, ControlPoint end){
       return Collections.singletonList(pathAlgorithm.getPath(start,end));
    }

}
