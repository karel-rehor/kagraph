package org.kagaka.graph;

import java.util.Set;

/**
 * <p>Vertex interface.</p>
 *
 * @param <T> - any type
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
 * @version $Id: $Id
 */
public interface Vertex<T> {

    /**
     * <p>get.</p>
     *
     * @return a T object
     */
    T get();

    /**
     * <p>set.</p>
     *
     * @param t a T object
     */
    void set(T t);

    /**
     * <p>getEdges.</p>
     *
     * @return a {@link java.util.Set} object
     */
    Set<Vertex<T>> getEdges();

    /**
     * <p>setEdges.</p>
     *
     * @param edges a {@link java.util.Set} object
     */
    void setEdges(Set<Vertex<T>> edges);

    /**
     * <p>addEdge.</p>
     *
     * @param edge a {@link org.kagaka.graph.Vertex} object
     */
    void addEdge(Vertex<T> edge);

    /**
     * <p>addMutualEdge.</p>
     *
     * @param edge a {@link org.kagaka.graph.Vertex} object
     */
    void addMutualEdge(Vertex<T> edge);

    /**
     * <p>getEdge.</p>
     *
     * @param i a int
     * @return a {@link org.kagaka.graph.Vertex} object
     */
    Vertex<T> getEdge(int i);

    /**
     * <p>removeEdge.</p>
     *
     * @param vertex a {@link org.kagaka.graph.Vertex} object
     */
    void removeEdge(Vertex<T> vertex);

    /**
     * <p>removeAllEdges.</p>
     */
    void removeAllEdges();

}
