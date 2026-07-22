package org.kagaka.graph;

import java.util.Set;

/**
 * @param <T>
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
 */

public interface Vertex<T> {

    T get();

    void set(T t);

    Set<Vertex<T>> getEdges();

    void setEdges(Set<Vertex<T>> edges);

    void addEdge(Vertex<T> edge);

    void addMutualEdge(Vertex<T> edge);

    Vertex<T> getEdge(int i);

    void removeEdge(Vertex<T> vertex);

    void removeAllEdges();

}
