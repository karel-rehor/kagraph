package org.kagaka.graph;

import java.util.Collections;
import java.util.HashSet;
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
 * The Set collection is used to store edges in order to avoid creating any duplicates. It is also synchronized. 
 *
 * @param <T>
 */
public class VertexImpl<T> implements Vertex<T> {

	private T t;

	Set<Vertex<T>> edges;

	public VertexImpl() {
		super();
		t = null;
		edges = Collections.synchronizedSet(new HashSet<Vertex<T>>());
	}

	public VertexImpl(T t) {
		super();
		this.t = t;
		edges = Collections.synchronizedSet(new HashSet<Vertex<T>>());
	}

	public VertexImpl(T t, Set<Vertex<T>> edges) {
		super();
		this.t = t;
		this.edges = edges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int base = 1;  // TODO find way to get containing class if possible
		return prime * base + ((t == null) ? 0 : t.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if((obj == null) || (getClass() != obj.getClass()))
			return false;
		VertexImpl other = (VertexImpl) obj;
		if( t == null) {
			if(other.get() != null) {
				return false;
			}
		}else if( ! t.equals(other.get())) {
            return false;
        }
		return true;
	}

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}

	public Set<Vertex<T>> getEdges() {
		return edges;
	}

	public void setEdges(Set<Vertex<T>> edges) {
		this.edges = edges;
	}

	public void addEdge(Vertex<T> vertex){
		edges.add(vertex);
	}

	public void addMutualEdge(Vertex<T> vertex) {
		addEdge(vertex);
		if(!vertex.getEdges().contains(this)) {
			vertex.addEdge((VertexImpl)this);
		}
	}

	public Vertex<T> getEdge(int n){
	    int index = 0;
	    for(Vertex<T> v : edges) {
	        if(index == n) {
	            return v;
	        }
	        index++;
	    }
	    return null;
	}

	public void removeEdge(Vertex<T> vertex) {
		edges.remove(vertex);
		if(vertex.getEdges().contains(this)) {
			vertex.removeEdge((VertexImpl)this);
		}
	}

	public void removeAllEdges() {
	    // cannot use local remove Edge
	    // so first remove mutual links back to this
	    for(Vertex<T> vertex: edges) {
	        if(vertex.getEdges().contains(this)) {
	            vertex.getEdges().remove(this);
	        }
	    }
	    // then remove all edges
	    edges.removeAll(edges);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("[%d]\n", this.hashCode()));
		sb.append(String.format("  Contents: %s %s\n", t.getClass(), t));
		sb.append("  Edges:\n");
		for(Vertex<T> edge : edges) {
			sb.append(String.format("    [%d]:%s", edge.hashCode(), edge.get()));
		}
		return sb.toString();
	}

}
