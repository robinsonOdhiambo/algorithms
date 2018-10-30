package com.robo.algorithms.graphs.ds;

public class UnionFind {
    private Integer[] uf;
    private Integer[] count;

    public UnionFind(int n) {
        uf = new Integer[n];
        count = new Integer[n];
        for(int i = 0; i < n; i++) {
            uf[i] = i;
            count[i] = 1;
        }
    }

    public int root(int v) {
        while(uf[v] != v) {
            v = uf[v];
        }
        return v;
    }

    public boolean isConnected(int v, int w) {
        return root(v) == root(w);
    }

    public void union(int v, int w) {
        int rootV = root(v);
        int rootW = root(w);
        if(count[rootV] > count[rootW]) {
            uf[rootW] = rootV;
            count[rootV] += count[rootW];
        } else {
            uf[rootV] = rootW;
            count[rootW] += count[rootV];
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        System.out.println("Are 0 and 2 connected ?" + uf.isConnected(0, 2));
        uf.union(0, 2);
        System.out.println("Are 0 and 2 connected ?" + uf.isConnected(0, 2));

        System.out.println("Are 1 and 3 connected ?" + uf.isConnected(1, 3));
        uf.union(1, 3);
        System.out.println("Are 1 and 3 connected ?" + uf.isConnected(1, 3));

        System.out.println("Are 1 and 4 connected ?" + uf.isConnected(1, 4));
        uf.union(1, 4);
        System.out.println("Are 1 and 4 connected ?" + uf.isConnected(1, 4));

        System.out.println("Are 0 and 1 connected ?" + uf.isConnected(0, 1));
        uf.union(0, 1);
        System.out.println("Are 0 and 1 connected ?" + uf.isConnected(0, 1));
        System.out.println("root of 0 is ?" + uf.root(0));
    }
}