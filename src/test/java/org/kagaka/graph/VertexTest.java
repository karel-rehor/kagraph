package org.kagaka.graph;

//import static org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
public class VertexTest {
	
	final Vertex<String> sv1 = new VertexImpl<String>("foo");
	final Vertex<String> sv2 = new VertexImpl<String>("bar");
	Vertex<String> svMutable = new VertexImpl<String>("walrus");
	
	class Coords{
		int x;
		int y;
		
		public Coords(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			//return super.toString();
			return String.format("[%d,%d]", x, y);
		}
		
		
		
	}
	
	
	Coords[][] grid = {{null, null, null}, {null, null, null}, {null, null, null}};
	
	List<Vertex<Coords>> connectedGrid = new ArrayList<Vertex<Coords>>();
	
	@BeforeAll
	public void setupGrid(){
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new Coords(i, j);
			}
		}
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				Vertex<Coords> v = new VertexImpl<Coords>(grid[i][j]);
				if(j > 0) { // add left edge
					v.addMutualEdge(connectedGrid.get((i * grid[i].length) + (j - 1)));
				}
				if(i > 0) { // add upper edge
					v.addMutualEdge(connectedGrid.get(((i - 1) * grid[i].length) + j));
				} 
				connectedGrid.add(v);
			} 
		}
				
	}
		
	@Test
	public void testStringVertexCore() {
		// fail("Not yet implemented");
		assertTrue(sv1.get() == "foo");
		assertTrue(sv2.get() == "bar");
		assertTrue(svMutable.get() == "walrus");
		assertTrue(sv1.getEdges().size() == 0);
		svMutable.set(sv1.get());
		assertTrue(svMutable.get() == sv1.get());
		System.out.println(String.format("DEBUG hashes sv1 %s : sv2 %s", sv1.hashCode(), sv2.hashCode()));
//		System.out.println(String.format("DEBUG ids sv1 %s : sv2 %s", sv1.getId(), sv2.getId()));
	}
	
	@Test
	public void testStringVertexCompare() {
		assertFalse(sv1 == sv2);
	}
	
	@Test
	public void testUpdateVertexContents() {
	    svMutable.set("penguin");
	    assertFalse(svMutable.get().equals("walrus"));
        assertTrue(svMutable.get().equals("penguin"));
	}
	
	@Test
	public void testAddEdge() {
		sv1.addEdge(sv2);
		assertTrue(sv1.getEdges().contains(sv2));
		assertFalse(sv2.getEdges().contains(sv1));
		System.out.println("DEBUG sv1 " + sv1);
		System.out.println("DEBUG sv2 " + sv2);
		sv1.removeEdge(sv2);
		assertTrue(sv1.getEdges().size() == 0);
	}
	
	@Test
	public void testAddMutualEdge() {
		sv1.addMutualEdge(sv2);
		assertTrue(sv1.getEdges().contains(sv2));
		assertTrue(sv2.getEdges().contains(sv1));
		System.out.println("DEBUG sv1 " + sv1);
		System.out.println("DEBUG sv2 " + sv2);
		sv1.removeEdge(sv2);
		assertTrue(sv1.getEdges().size() == 0);
		assertTrue(sv2.getEdges().size() == 0);
	}
	
	@Test
	public void testRemoveNonEdge() {
		sv1.removeEdge(svMutable);		
	}
	
	@Test
	public void testGetEdge() {
	    sv1.addMutualEdge(sv2);
	    sv1.addMutualEdge(new VertexImpl<String>("caspar"));
        assertEquals(sv2,sv1.getEdge(0));
        assertEquals("caspar", sv1.getEdge(1).get());
        sv1.removeAllEdges();
	}
	
	@Test
	public void testConnectedGrid() {
				
		for(Vertex<Coords> v : connectedGrid) {
			System.out.println("DEBUG v " + v);
		}
		Vertex<Coords> origin = connectedGrid.get(0);
//		Vertex<Coords> walker = (Vertex<Coords>)origin.getEdges().toArray()[0];

		// Depth first Traversal -- 
		Set<Coords> visited = new LinkedHashSet<Coords>();
		Stack<Vertex<? extends Coords>> stack = new Stack<Vertex<? extends Coords>>();
		stack.push(origin);
		// visited.add(origin);
		assertTrue(origin.get() == grid[0][0]);
		
		System.out.println("\n\nWALKING GRID DEPTH FIRST\n\n");
		
		
		while(!stack.empty()) {
			Vertex<? extends Coords> c = stack.pop();
			if(!visited.contains(c.get())) {
				visited.add(c.get());
//				System.out.println("DEBUG visited " + c);
				for(Vertex<? extends Coords> v : c.getEdges()) {
					stack.push(v);
				}
			}
		}
		
		for(Coords c : visited) {
			System.out.println("DEBUG visited " + c);
		}
		
		// Breadth first Traversal --
		Set<Coords> visited2 = new LinkedHashSet<Coords>();
		Queue<Vertex<? extends Coords>> queue = new LinkedList<Vertex<? extends Coords>>();
		queue.add(origin);
		visited2.add(origin.get());

		System.out.println("\n\nWALKING GRID BREADTH FIRST\n\n");
		
		while(!queue.isEmpty()) {
			Vertex<? extends Coords> c = queue.poll();
			for(Vertex<? extends Coords> v : c.getEdges()) {
				if(!visited2.contains(v.get())) {
					visited2.add(v.get());
//					System.out.println("DEBUG visited " + v);
					queue.add(v);
				}
			}
		}
		
		for(Coords c : visited2) {
			System.out.println("DEBUG visited " + c);
		}
		
		// assert all coords visited regardless of traversal method
		for(int i = 0; i < grid.length; i ++) {
			for(int j = 0; j < grid[i].length; j++) {
				assertTrue(visited.contains(grid[i][j]));
				assertTrue(visited2.contains(grid[i][j]));
			}
		}
				
	}

}
