package com.robo.algorithms.graphs.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GraphTest
{
    private static final int COMMON_WEIGHT = 1;

    @Test
    public void testDirectedGraph() {
        Graph dg = new DirectedGraph(3);
        dg.addEdge(new Edge(0, 1, COMMON_WEIGHT));
        dg.addEdge(new Edge(0, 2, COMMON_WEIGHT));
        dg.addEdge(new Edge(2, 1, COMMON_WEIGHT));
        assertEquals(3, dg.V());
        assertEquals(3, dg.E());
    }

    @Test
    public void testUnDirectedGraph() {
        Graph ug = new UndirectedGraph(3);
        ug.addEdge(new Edge(0, 1, COMMON_WEIGHT));
        ug.addEdge(new Edge(0, 2, COMMON_WEIGHT));
        ug.addEdge(new Edge(2, 1, COMMON_WEIGHT));
        assertEquals(3, ug.V());
        assertEquals(6, ug.E());
    }
}