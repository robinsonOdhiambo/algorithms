package com.robo.algorithms.graphs.ds;


public interface Graph {
    void addEdge(Edge e);
    int V();
    int E();
    Iterable<Edge> adj(int v);
}