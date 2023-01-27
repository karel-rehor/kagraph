package org.kagaka.graph;

import java.util.Hashtable;

public interface WeightedEdgeVertex<T> extends Vertex<T> {
    
    public Double getMaxWeight();
    public Double getMinWeight();
    
    public Hashtable<WeightedEdgeVertex<T>, Double> getWeights();
    
    public Double getWeight(WeightedEdgeVertex<T> key);
    public void setWeight(WeightedEdgeVertex<T> key, Double val);
    
    public void addEdge(WeightedEdgeVertex<T> vertex, Double weight);
    public void addMutualEdge(WeightedEdgeVertex<T> vertex, Double weight, Double myWeight);
    
    public void removeWeightedEdge(WeightedEdgeVertex<T> vertex);
    public void removeAllWeightedEdges();
    
}
