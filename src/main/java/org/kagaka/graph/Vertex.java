package org.kagaka.graph;

import java.util.Set;

/**
 * @author karl
 * 
 * <p>
 * Vertex container of type T to be plugged into a graph.  
 * <p>
 * Edges are simply indicated by a Set of references to adjacent vertices containing the same type.
 * <p>
 * Edges can be one:
 *   <ul> 
 *    <li>One way directional - created with a call to simple addedge()</li>
 *    <li>Mutual or bi-directional - created with a call to addMutualEdge() </li>
 *    </ul>  
 * <p>
 * The Set collection is used to store edges in order to avoid creating any duplicates. 
 * It should also be synchronized. 
 *
 * @param <T>
 */

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
