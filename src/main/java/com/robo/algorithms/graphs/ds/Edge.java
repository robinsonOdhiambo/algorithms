package com.robo.algorithms.graphs.ds;

public class Edge implements Comparable<Edge> {
    private int v;
    private int u;
    private double weight;

    public Edge(int v, int u, double weight) {
        this.v = v;
        this.u = u;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int m) {
        return (m == v) ? this.u : this.v;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge that) {
        if(this.weight > that.weight) {
            return 1;
        } else if(this.weight < that.weight) {
            return -1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Edge)) return false;
        Edge that = (Edge) o;
        if(this.either() == that.either() &&
         that.other(that.either()) == this.other(this.either()))
         return true;
        
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + v;
        result = 31 * result + u;
        
        return result;
    }
}