package org.kagaka.graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class GraphImpl<T> implements Graph<T> {

    protected List<Vertex<T>> vertices = new ArrayList<>();

    public GraphImpl(final List<Vertex<T>> vertices) {
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

    public void setVertices(final List<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    public List<T> getContents() {

        List<T> contents = new ArrayList<>();
        for (Vertex<T> vertex : vertices) {
            contents.add(vertex.get());
        }

        return contents;

    }

    public void addVertex(final Vertex<T> vertex) {
        vertices.add(vertex);
    }

    public void removeVertex(final Vertex<T> vertex) {
        for (Vertex<T> v : vertex.getEdges()) {
            vertex.removeEdge(v);
        }
        vertices.remove(vertex);
    }

    public Vertex<T> get(final int index) {
        return vertices.get(index);
    }

    public Vertex<T> getVertexFromType(final T item) {
        int index = vertices.indexOf(new VertexImpl<>(item));
        return vertices.get(index);
    }

    public void addEdge(final VertexImpl<T> v1, final VertexImpl<T> v2) {
        v1.addEdge(v2);
    }

    public void addMutualEdge(final VertexImpl<T> v1, final VertexImpl<T> v2) {
        v1.addMutualEdge(v2);
    }

    public void removeEdge(final VertexImpl<T> v1, final VertexImpl<T> v2) {
        v1.removeEdge(v2);
    }

    public String printGraph() {
        StringBuffer sb = new StringBuffer();
        for (Vertex<T> v : vertices) {
            sb.append(String.format("%s: %s\n", v, v.getEdges()));
        }
        return sb.toString();
    }

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
