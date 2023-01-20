package org.kagaka.graph;

import java.util.List;
import java.util.Set;

public interface Graph<T> {

    public List<Vertex<T>> getVertices();
    
    public List<T> getContents();
    
    public void setVertices(List<Vertex<T>> vertices);
    public void addVertex(Vertex<T> vertex);
    public void removeVertex(Vertex<T> vertex);

    public Vertex<T> get(int index);    
    public Vertex<T> getVertexFromType(T item);
    
    public void addEdge(VertexImpl<T> v1, VertexImpl<T> v2);
    public void addMutualEdge(VertexImpl<T> v1, VertexImpl<T> v2);
    
    public void removeEdge(VertexImpl<T> v1, VertexImpl<T> v2);
    
    public Set<Vertex<T>> depthFirstTraversal(Vertex<T> origin);
    public Set<Vertex<T>> breadthFirstTraversal(Vertex<T> origin);
    
}
