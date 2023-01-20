package org.kagaka.graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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
public class GraphImpl<T> implements Graph<T> {

	protected List<Vertex<T>> vertices = new ArrayList<>();

	public GraphImpl(List<Vertex<T>> vertices) {
		super();
		this.vertices = vertices;
	}

	public GraphImpl() {
		super();
		this.vertices = new ArrayList<>();
	}

	public List<Vertex<T>> getVertices() {
		return vertices;
	}
	
	public List<T> getContents(){
	    
	    List<T> contents = new ArrayList<>();
	    for(Vertex<T> vertex: vertices) {
	        contents.add(vertex.get());
	    }
	    
	    return contents;
	    
	}

	public void setVertices(List<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

	public void addVertex(Vertex<T> vertex) {
		vertices.add(vertex);
	}

	public void removeVertex(Vertex<T> vertex) {
		for(Vertex<T> v : vertex.getEdges()){
			vertex.removeEdge(v);
		}
		vertices.remove(vertex);
	}

	public Vertex<T> get(int index){
	    return vertices.get(index);
	}

	public Vertex<T> getVertexFromType(T item) {
		int index = vertices.indexOf(new VertexImpl<>(item));
		return vertices.get(index);
	}

	public void addEdge(VertexImpl<T> v1, VertexImpl<T> v2) {
		v1.addEdge(v2);
	}

	public void addMutualEdge(VertexImpl<T> v1, VertexImpl<T> v2) {
		v1.addMutualEdge(v2);
	}

	public void removeEdge(VertexImpl<T> v1, VertexImpl<T> v2) {
		v1.removeEdge(v2);
	}
/*
	public Set<Vertex<? extends T>> getEdgesForVertexOf(T item){
		int index = vertices.indexOf(new Vertex<>(item));
		return vertices.get(index).getEdges();
	}
*/
	public String printGraph() {
		StringBuffer sb = new StringBuffer();
		for(Vertex<T> v : vertices) {
			sb.append(String.format("%s: %s\n", v, v.getEdges()));
		}
		return sb.toString();
	}

	public Set<Vertex<T>> depthFirstTraversal(Vertex<T> origin){
		Set<Vertex<T>> visited = new LinkedHashSet<>();
		Stack<Vertex<T>> stack = new Stack<>();
		stack.push(origin);

		while(!stack.empty()) {
			Vertex<T> fromStack = stack.pop();
			if(!visited.contains(fromStack)) {
				visited.add(fromStack);
				for(Vertex<T> v : fromStack.getEdges()) {
					stack.push(v);
				}
			}
		}

		return visited;
	}

	public Set<Vertex<T>> breadthFirstTraversal(Vertex<T> origin){
		Set<Vertex<T>> visited = new LinkedHashSet<>();
		Queue<Vertex<T>> queue = new LinkedList<>();
		queue.add(origin);
		visited.add(origin);

		while(!queue.isEmpty()) {
			Vertex<T> fromQueue = queue.poll();
			for(Vertex<T> v : fromQueue.getEdges()) {
				if(!visited.contains(v)) {
					visited.add(v);
					queue.add(v);
				}
			}
		}

		return visited;

	}

}
