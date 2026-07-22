package org.kagaka.graph;

import java.util.Hashtable;

public class WeightedEdgeVertexImpl<T> extends VertexImpl<T> implements WeightedEdgeVertex<T> {

    static double maxWeight = 1.0;
    static double minWeight = -1.0;
    Hashtable<WeightedEdgeVertex<T>, Double> weights;

    public WeightedEdgeVertexImpl(final T t) {
        super(t);
        weights = new Hashtable<WeightedEdgeVertex<T>, Double>();
    }

    static void checkWeight(final double weight) {
        if (weight > maxWeight || weight < minWeight) {
            throw new IllegalArgumentException(
                String.format("The weight argument %.2f is out of bounds.  Max weight is %.2f,  Min weight is %.2f",
                weight, maxWeight, minWeight));
        }
    }

    @Override
    public Double getMaxWeight() {
        // TODO Auto-generated method stub
        return maxWeight;
    }

    @Override
    public Double getMinWeight() {
        // TODO Auto-generated method stub
        return minWeight;
    }

    @Override
    public Hashtable<WeightedEdgeVertex<T>, Double> getWeights() {
        // TODO Auto-generated method stub
        return weights;
    }

    @Override
    public Double getWeight(final WeightedEdgeVertex<T> key) {
        // if Hashtable.get() returns null cannot implicitly get Double.doubleValue()
        return weights.get(key);
    }

    @Override
    public void setWeight(final WeightedEdgeVertex<T> key, final Double val) {
        checkWeight(val);
        if (!edges.contains(key)) {
            throw new IllegalStateException(String.format("%s is not an edge of weighted vertex %s", key, this));
        }
        weights.put(key, val);
    }

    @Override
    public void addEdge(final WeightedEdgeVertex<T> vertex, final Double weight) {
        checkWeight(weight);
        edges.add(vertex);
        weights.put(vertex, weight);
    }

    @Override
    public void addMutualEdge(final WeightedEdgeVertex<T> vertex, final Double weight, final Double myWeight) {
        addEdge(vertex, weight);
        if (!vertex.getEdges().contains(this)) {
            vertex.addEdge(this, myWeight);
        }
    }

    @Override
    public void removeWeightedEdge(final WeightedEdgeVertex<T> vertex) {
        edges.remove(vertex);
        weights.remove(vertex);
        if (vertex.getEdges().contains(this)) {
            vertex.removeWeightedEdge(this);
        }
    }

    @Override
    public void removeAllWeightedEdges() {
        super.removeAllEdges();
        weights.clear();
    }

}
