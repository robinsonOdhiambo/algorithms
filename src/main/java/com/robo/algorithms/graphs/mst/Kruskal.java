package com.robo.algorithms.graphs.mst;

import com.robo.algorithms.graphs.ds.UndirectedGraph;
import com.robo.algorithms.graphs.ds.UnionFind;
import com.robo.algorithms.graphs.ds.Edge;

import java.util.*;

public class Kruskal {
    private List<Edge> mst;
    private double weight = 0.0;

    public Kruskal(UndirectedGraph ug) {
        mst = new ArrayList<>();
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for(int v = 0; v < ug.V(); v++) {
            for(Edge e: ug.adj(v)) {
                edges.add(e);
            }
        }

        UnionFind uf = new UnionFind(ug.V());

        while(!edges.isEmpty()) {
            Edge e = edges.poll();
            int v = e.either();
            int u = e.other(v);
            if(!uf.isConnected(v, u)) {
                uf.union(v, u);
                mst.add(e);
                weight += e.getWeight();
            }
        }
    }

    public double getWeight() {
        return weight;
    }

    public Iterable<Edge> mst() {
        return mst;
    }
}