package org.kagaka.graph;

import java.util.List;
import java.util.Set;

/**
 * <p>Graph interface.</p>
 *
 * @param <T> - any type
 * @author karl
 *
 * <p>
 * Joins together vertices into a traversable structure.
 * <p>
 * Vertices are stored as a List.  Edges between vertices will define the overall structure.
 * @see org.kagaka.graph.grid.Grid
 * @version $Id: $Id
 */
public interface Graph<T> {

    /**
     * <p>getVertices.</p>
     *
     * @return a {@link java.util.List} object
     */
    List<Vertex<T>> getVertices();

    /**
     * <p>setVertices.</p>
     *
     * @param vertices a {@link java.util.List} object
     */
    void setVertices(List<Vertex<T>> vertices);

    /**
     * <p>getContents.</p>
     *
     * @return a {@link java.util.List} object
     */
    List<T> getContents();

    /**
     * <p>addVertex.</p>
     *
     * @param vertex a {@link org.kagaka.graph.Vertex} object
     */
    void addVertex(Vertex<T> vertex);

    /**
     * <p>removeVertex.</p>
     *
     * @param vertex a {@link org.kagaka.graph.Vertex} object
     */
    void removeVertex(Vertex<T> vertex);

    /**
     * <p>get.</p>
     *
     * @param index a int
     * @return a {@link org.kagaka.graph.Vertex} object
     */
    Vertex<T> get(int index);

    /**
     * <p>getVertexFromType.</p>
     *
     * @param item a T object
     * @return a {@link org.kagaka.graph.Vertex} object
     */
    Vertex<T> getVertexFromType(T item);

    /**
     * <p>addEdge.</p>
     *
     * @param v1 a {@link org.kagaka.graph.VertexImpl} object
     * @param v2 a {@link org.kagaka.graph.VertexImpl} object
     */
    void addEdge(VertexImpl<T> v1, VertexImpl<T> v2);

    /**
     * <p>addMutualEdge.</p>
     *
     * @param v1 a {@link org.kagaka.graph.VertexImpl} object
     * @param v2 a {@link org.kagaka.graph.VertexImpl} object
     */
    void addMutualEdge(VertexImpl<T> v1, VertexImpl<T> v2);

    /**
     * <p>removeEdge.</p>
     *
     * @param v1 a {@link org.kagaka.graph.VertexImpl} object
     * @param v2 a {@link org.kagaka.graph.VertexImpl} object
     */
    void removeEdge(VertexImpl<T> v1, VertexImpl<T> v2);

    /**
     * <p>depthFirstTraversal.</p>
     *
     * @param origin a {@link org.kagaka.graph.Vertex} object
     * @return a {@link java.util.Set} object
     */
    Set<Vertex<T>> depthFirstTraversal(Vertex<T> origin);

    /**
     * <p>breadthFirstTraversal.</p>
     *
     * @param origin a {@link org.kagaka.graph.Vertex} object
     * @return a {@link java.util.Set} object
     */
    Set<Vertex<T>> breadthFirstTraversal(Vertex<T> origin);

}
