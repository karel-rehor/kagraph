package org.kagaka.graph;

import java.util.List;
import java.util.Set;

/**
 * 
 * @author karl
 * 
 * <p>
 * Joins together vertices into a traversable structure.
 * 
 * Vertices are stored as a List.  Edges between vertices will define the overall structure.  
 *
 * @param <T>
 * @see org.kagaka.graph.grid.Grid
 * 
 */
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
