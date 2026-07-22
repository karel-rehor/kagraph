package org.kagaka.graph;

import java.util.Hashtable;

public interface WeightedEdgeVertex<T> extends Vertex<T> {

    Double getMaxWeight();

    Double getMinWeight();

    Hashtable<WeightedEdgeVertex<T>, Double> getWeights();

    Double getWeight(WeightedEdgeVertex<T> key);

    void setWeight(WeightedEdgeVertex<T> key, Double val);

    void addEdge(WeightedEdgeVertex<T> vertex, Double weight);

    void addMutualEdge(WeightedEdgeVertex<T> vertex, Double weight, Double myWeight);

    void removeWeightedEdge(WeightedEdgeVertex<T> vertex);

    void removeAllWeightedEdges();

}
