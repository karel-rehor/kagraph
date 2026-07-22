package org.kagaka.graph;

//import static org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(Lifecycle.PER_CLASS)
public class VertexTest {

    final Vertex<String> sv1 = new VertexImpl<String>("foo");
    final Vertex<String> sv2 = new VertexImpl<String>("bar");
    Vertex<String> svMutable = new VertexImpl<String>("walrus");
    Coords[][] grid = {{null, null, null}, {null, null, null}, {null, null, null}};
    List<Vertex<Coords>> connectedGrid = new ArrayList<Vertex<Coords>>();

    @BeforeAll
    public void setupGrid() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Coords(i, j);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Vertex<Coords> v = new VertexImpl<Coords>(grid[i][j]);
                if (j > 0) { // add left edge
                    v.addMutualEdge(connectedGrid.get((i * grid[i].length) + (j - 1)));
                }
                if (i > 0) { // add upper edge
                    v.addMutualEdge(connectedGrid.get(((i - 1) * grid[i].length) + j));
                }
                connectedGrid.add(v);
            }
        }

    }

    @Test
    public void testStringVertexCore() {
        // fail("Not yet implemented");
        assertSame("foo", sv1.get());
        assertSame("bar", sv2.get());
        assertSame("walrus", svMutable.get());
        assertEquals(0, sv1.getEdges().size());
        svMutable.set(sv1.get());
        assertSame(svMutable.get(), sv1.get());
//      System.out.println(String.format("DEBUG hashes sv1 %s : sv2 %s", sv1.hashCode(), sv2.hashCode()));
//      System.out.println(String.format("DEBUG ids sv1 %s : sv2 %s", sv1.getId(), sv2.getId()));
    }

    @Test
    public void testStringVertexCompare() {
        assertNotSame(sv1, sv2);
    }

    @Test
    public void testUpdateVertexContents() {
        svMutable.set("penguin");
        assertNotEquals("walrus", svMutable.get());
        assertEquals("penguin", svMutable.get());
    }

    @Test
    public void testAddEdge() {
        sv1.addEdge(sv2);
        assertTrue(sv1.getEdges().contains(sv2));
        assertFalse(sv2.getEdges().contains(sv1));
//      System.out.println("DEBUG sv1 " + sv1);
//      System.out.println("DEBUG sv2 " + sv2);
        sv1.removeEdge(sv2);
        assertEquals(0, sv1.getEdges().size());
    }

    @Test
    public void testAddMutualEdge() {
        sv1.addMutualEdge(sv2);
        assertTrue(sv1.getEdges().contains(sv2));
        assertTrue(sv2.getEdges().contains(sv1));
//      System.out.println("DEBUG sv1 " + sv1);
//      System.out.println("DEBUG sv2 " + sv2);
        sv1.removeEdge(sv2);
        assertEquals(0, sv1.getEdges().size());
        assertEquals(0, sv2.getEdges().size());
    }

    @Test
    public void testRemoveNonEdge() {
        sv1.removeEdge(svMutable);
    }

    @Test
    public void testGetEdge() {
        sv1.addMutualEdge(sv2);
        sv1.addMutualEdge(new VertexImpl<String>("caspar"));
        assertEquals(sv2, sv1.getEdge(0));
        assertEquals("caspar", sv1.getEdge(1).get());
        sv1.removeAllEdges();
    }

    @Test
    public void testConnectedGrid() {

        for (Vertex<Coords> v : connectedGrid) {
            if (v.get().getX() == 0 && v.get().getY() == 0) {
                assertEquals(2, v.getEdges().size());
                assertTrue(v.getEdges().contains(connectedGrid.get(1)));
                assertTrue(v.getEdges().contains(connectedGrid.get(3)));
            }
            if (v.get().getX() == 2 && v.get().getY() == 2) {
                assertEquals(2, v.getEdges().size());
                assertTrue(v.getEdges().contains(connectedGrid.get(7)));
                assertTrue(v.getEdges().contains(connectedGrid.get(5)));
            }
            if (v.get().getX() == 0 && v.get().getY() == 2) {
                assertEquals(2, v.getEdges().size());
                assertTrue(v.getEdges().contains(connectedGrid.get(1)));
                assertTrue(v.getEdges().contains(connectedGrid.get(5)));
            }
            if (v.get().getX() == 2 && v.get().getY() == 0) {
                assertEquals(2, v.getEdges().size());
                assertTrue(v.getEdges().contains(connectedGrid.get(7)));
                assertTrue(v.getEdges().contains(connectedGrid.get(3)));
            }
            if (v.get().getX() == 1 && v.get().getY() == 1) {
                assertEquals(4, v.getEdges().size());
                assertTrue(v.getEdges().contains(connectedGrid.get(7)));
                assertTrue(v.getEdges().contains(connectedGrid.get(5)));
                assertTrue(v.getEdges().contains(connectedGrid.get(3)));
                assertTrue(v.getEdges().contains(connectedGrid.get(1)));
            }
        }
    }

    class Coords {
        int x;
        int y;

        public Coords(final int x, final int y) {
            super();
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(final int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(final int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            //return super.toString();
            return String.format("[%d,%d]", x, y);
        }
    }

}
