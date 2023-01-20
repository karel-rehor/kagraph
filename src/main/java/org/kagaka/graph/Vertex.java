package org.kagaka.graph;

import java.util.Set;

public interface Vertex<T> {
    
    public T get();
    public void set(T t);
    
    public Set<Vertex<T>> getEdges();
    public void setEdges(Set<Vertex<T>> edges);
    
    public void addEdge(Vertex<T> edge);
    public void addMutualEdge(Vertex<T> edge);
    
    public Vertex<T> getEdge(int i);
    public void removeEdge(Vertex<T> vertex);
    
    public void removeAllEdges();

}
