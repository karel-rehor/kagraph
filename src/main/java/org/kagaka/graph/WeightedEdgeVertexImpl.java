package org.kagaka.graph;

import java.util.Hashtable;

public class WeightedEdgeVertexImpl<T> extends VertexImpl<T> implements WeightedEdgeVertex<T> {
    
    static double MAX_WEIGHT = 1.0;
    static double MIN_WEIGHT = -1.0;
    
    static void checkWeight(double weight) {
        if(weight > MAX_WEIGHT || weight < MIN_WEIGHT) {
            throw new IllegalArgumentException(String.format("The weight argument %.2f is out of bounds.  Max weight is %.2f,  Min weight is %.2f", 
                    weight, MAX_WEIGHT, MIN_WEIGHT)); 
        }
    }
    
    Hashtable<WeightedEdgeVertex<T>, Double> weights;
        
    public WeightedEdgeVertexImpl(T t) {
        super(t);
        weights = new Hashtable<WeightedEdgeVertex<T>, Double>();
    }
    
    @Override
    public Double getMaxWeight() {
        // TODO Auto-generated method stub
        return MAX_WEIGHT;
    }

    @Override
    public Double getMinWeight() {
        // TODO Auto-generated method stub
        return MIN_WEIGHT;
    }

    @Override
    public Hashtable<WeightedEdgeVertex<T>, Double> getWeights() {
        // TODO Auto-generated method stub
        return weights;
    }

    @Override
    public Double getWeight(WeightedEdgeVertex<T> key) {
        // if Hashtable.get() returns null cannot implicitly get Double.doubleValue()
        return weights.get(key);
    }

    @Override
    public void setWeight(WeightedEdgeVertex<T> key, Double val) {
        checkWeight(val);
        if(!edges.contains(key)) {
            throw new IllegalStateException(String.format("%s is not an edge of weighted vertex %s", key, this));
        }
        weights.put(key, val);        
    }

    @Override
    public void addEdge(WeightedEdgeVertex<T> vertex, Double weight) {
        checkWeight(weight);
        edges.add(vertex);
        weights.put(vertex, weight);
    }

    @Override
    public void addMutualEdge(WeightedEdgeVertex<T> vertex, Double weight, Double myWeight) {        
        addEdge(vertex, weight);
        if(!vertex.getEdges().contains(this)) {
            vertex.addEdge(this, myWeight);
        }
    }

    @Override
    public void removeWeightedEdge(WeightedEdgeVertex<T> vertex) {
        edges.remove(vertex);
        weights.remove(vertex);
        if(vertex.getEdges().contains(this)) {
            vertex.removeWeightedEdge(this);
        }
    }
    
    @Override
    public void removeAllWeightedEdges() {
        super.removeAllEdges();
        weights.clear();
    }


}
