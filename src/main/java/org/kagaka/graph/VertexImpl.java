package org.kagaka.graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>VertexImpl class.</p>
 *
 * @author karl
 * @version $Id: $Id
 */
public class VertexImpl<T> implements Vertex<T> {

    Set<Vertex<T>> edges;
    private T t;

    /**
     * <p>Constructor for VertexImpl.</p>
     */
    public VertexImpl() {
        super();
        t = null;
        edges = Collections.synchronizedSet(new HashSet<Vertex<T>>());
    }

    /**
     * <p>Constructor for VertexImpl.</p>
     *
     * @param t a T object
     */
    public VertexImpl(final T t) {
        super();
        this.t = t;
        edges = Collections.synchronizedSet(new HashSet<Vertex<T>>());
    }

    /**
     * <p>Constructor for VertexImpl.</p>
     *
     * @param t a T object
     * @param edges a {@link java.util.Set} object
     */
    public VertexImpl(final T t, final Set<Vertex<T>> edges) {
        super();
        this.t = t;
        this.edges = edges;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int base = 1;  // TODO find way to get containing class if possible
        return prime * base + ((t == null) ? 0 : t.hashCode());
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        VertexImpl<T> other = (VertexImpl<T>) obj;
        if (t == null) {
            return other.get() == null;
        } else {
            return t.equals(other.get());
        }
    }

    /**
     * <p>get.</p>
     *
     * @return a T object
     */
    public T get() {
        return t;
    }

    /**
     * <p>set.</p>
     *
     * @param t a T object
     */
    public void set(final T t) {
        this.t = t;
    }

    /**
     * <p>Getter for the field <code>edges</code>.</p>
     *
     * @return a {@link java.util.Set} object
     */
    public Set<Vertex<T>> getEdges() {
        return edges;
    }

    /** {@inheritDoc} */
    public void setEdges(final Set<Vertex<T>> edges) {
        this.edges = edges;
    }

    /** {@inheritDoc} */
    public void addEdge(final Vertex<T> vertex) {
        edges.add(vertex);
    }

    /** {@inheritDoc} */
    public void addMutualEdge(final Vertex<T> vertex) {
        addEdge(vertex);
        if (!vertex.getEdges().contains(this)) {
            vertex.addEdge(this);
        }
    }

    /** {@inheritDoc} */
    public Vertex<T> getEdge(final int n) {
        int index = 0;
        for (Vertex<T> v : edges) {
            if (index == n) {
                return v;
            }
            index++;
        }
        return null;
    }

    /** {@inheritDoc} */
    public void removeEdge(final Vertex<T> vertex) {
        edges.remove(vertex);
        if (vertex.getEdges().contains(this)) {
            vertex.removeEdge(this);
        }
    }

    /**
     * <p>removeAllEdges.</p>
     */
    public void removeAllEdges() {
        // cannot use local remove Edge
        // so first remove mutual links back to this
        for (Vertex<T> vertex : edges) {
            vertex.getEdges().remove(this);
        }
        // then remove all edges
        edges.removeAll(edges);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("[%d]\n", this.hashCode()));
        sb.append(String.format("  Contents: %s %s\n", t.getClass(), t));
        sb.append("  Edges:\n");
        for (Vertex<T> edge : edges) {
            sb.append(String.format("    [%d]:%s", edge.hashCode(), edge.get()));
        }
        return sb.toString();
    }

}
