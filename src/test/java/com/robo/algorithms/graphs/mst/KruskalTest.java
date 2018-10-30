package com.robo.algorithms.graphs.mst;

import static org.junit.Assert.assertEquals;

import com.robo.algorithms.graphs.ds.Edge;
import com.robo.algorithms.graphs.ds.UndirectedGraph;

import org.junit.Test;

public class KruskalTest {
    @Test
    public void test() {
        UndirectedGraph ug = new UndirectedGraph(5);
        ug.addEdge(new Edge(0, 1, 0.3));
        ug.addEdge(new Edge(0, 4, 0.1));
        ug.addEdge(new Edge(1, 2, 0.9));
        ug.addEdge(new Edge(1, 3, 0.5));
        ug.addEdge(new Edge(1, 4, 0.2));
        ug.addEdge(new Edge(2, 3, 0.8));
        ug.addEdge(new Edge(3, 4, 0.4));
        
        Kruskal kMst = new Kruskal(ug);
        assertEquals(1.5, kMst.getWeight(), 0);
    }
}