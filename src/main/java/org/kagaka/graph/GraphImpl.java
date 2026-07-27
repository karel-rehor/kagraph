package org.kagaka.graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


/**
 * <p>GraphImpl class.</p>
 *
 * @author karl
 * @version $Id: $Id
 */
public class GraphImpl<T> implements Graph<T> {

    protected List<Vertex<T>> vertices = new ArrayList<>();

    /**
     * <p>Constructor for GraphImpl.</p>
     *
     * @param vertices a {@link java.util.List} object
     */
    public GraphImpl(final List<Vertex<T>> vertices) {
        super();
        this.vertices = vertices;
    }

    /**
     * <p>Constructor for GraphImpl.</p>
     */
    public GraphImpl() {
        super();
        this.vertices = new ArrayList<>();
    }

    /**
     * <p>Getter for the field <code>vertices</code>.</p>
     *
     * @return a {@link java.util.List} object
     */
    public List<Vertex<T>> getVertices() {
        return vertices;
    }

    /** {@inheritDoc} */
    public void setVertices(final List<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    /**
     * <p>getContents.</p>
     *
     * @return a {@link java.util.List} object
     */
    public List<T> getContents() {

        List<T> contents = new ArrayList<>();
        for (Vertex<T> vertex : vertices) {
            contents.add(vertex.get());
        }

        return contents;

    }

    /** {@inheritDoc} */
    public void addVertex(final Vertex<T> vertex) {
        vertices.add(vertex);
    }

    /** {@inheritDoc} */
    public void removeVertex(final Vertex<T> vertex) {
        for (Vertex<T> v : vertex.getEdges()) {
            vertex.removeEdge(v);
        }
        vertices.remove(vertex);
    }

    /** {@inheritDoc} */
    public Vertex<T> get(final int index) {
        return vertices.get(index);
    }

    /**
     * <p>getVertexFromType.</p>
     *
     * @param item a T object
     * @return a {@link org.kagaka.graph.Vertex} object
     */
    public Vertex<T> getVertexFromType(final T item) {
        int index = vertices.indexOf(new VertexImpl<>(item));
        return vertices.get(index);
    }

    /** {@inheritDoc} */
    public void addEdge(final VertexImpl<T> v1, final VertexImpl<T> v2) {
        v1.addEdge(v2);
    }

    /** {@inheritDoc} */
    public void addMutualEdge(final VertexImpl<T> v1, final VertexImpl<T> v2) {
        v1.addMutualEdge(v2);
    }

    /** {@inheritDoc} */
    public void removeEdge(final VertexImpl<T> v1, final VertexImpl<T> v2) {
        v1.removeEdge(v2);
    }

    /**
     * <p>printGraph.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String printGraph() {
        StringBuffer sb = new StringBuffer();
        for (Vertex<T> v : vertices) {
            sb.append(String.format("%s: %s\n", v, v.getEdges()));
        }
        return sb.toString();
    }

    /** {@inheritDoc} */
    public Set<Vertex<T>> depthFirstTraversal(final Vertex<T> origin) {
        Set<Vertex<T>> visited = new LinkedHashSet<>();
        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(origin);

        while (!stack.empty()) {
            Vertex<T> fromStack = stack.pop();
            if (!visited.contains(fromStack)) {
                visited.add(fromStack);
                for (Vertex<T> v : fromStack.getEdges()) {
                    stack.push(v);
                }
            }
        }

        return visited;
    }

    /** {@inheritDoc} */
    public Set<Vertex<T>> breadthFirstTraversal(final Vertex<T> origin) {
        Set<Vertex<T>> visited = new LinkedHashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(origin);
        visited.add(origin);

        while (!queue.isEmpty()) {
            Vertex<T> fromQueue = queue.poll();
            for (Vertex<T> v : fromQueue.getEdges()) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }

        return visited;

    }

}
