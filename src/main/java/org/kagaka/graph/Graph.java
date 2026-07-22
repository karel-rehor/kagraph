package org.kagaka.graph;

import java.util.List;
import java.util.Set;

/**
 *
 * @param <T>
 * @author karl
 *
 * <p>
 * Joins together vertices into a traversable structure.
 * <p>
 * Vertices are stored as a List.  Edges between vertices will define the overall structure.
 * @see org.kagaka.graph.grid.Grid
 *
 */
public interface Graph<T> {

    List<Vertex<T>> getVertices();

    void setVertices(List<Vertex<T>> vertices);

    List<T> getContents();

    void addVertex(Vertex<T> vertex);

    void removeVertex(Vertex<T> vertex);

    Vertex<T> get(int index);

    Vertex<T> getVertexFromType(T item);

    void addEdge(VertexImpl<T> v1, VertexImpl<T> v2);

    void addMutualEdge(VertexImpl<T> v1, VertexImpl<T> v2);

    void removeEdge(VertexImpl<T> v1, VertexImpl<T> v2);

    Set<Vertex<T>> depthFirstTraversal(Vertex<T> origin);

    Set<Vertex<T>> breadthFirstTraversal(Vertex<T> origin);

}
