package com.robo.algorithms.graphs.ds;

import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph implements Graph
{
    private List<Edge>[] adj;
    private Integer V;
    private Integer E = 0;

    public UndirectedGraph(int V) {
        adj = (List<Edge>[]) new List[V];
        this.V = V;
        for(int u = 0; u < this.V; u++) {
            adj[u] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(Edge e) {
        int v = e.either();
        int u = e.other(v);
        this.adj[v].add(e);
        this.adj[u].add(e);
        this.E += 2;
    }

    @Override
    public int V() {
        return this.V;
    }

    @Override
    public int E() {
        return this.E;
    }

    @Override
    public Iterable<Edge> adj(int v) {
        return this.adj[v];
    }
}