package org.kagaka.cell;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.kagaka.cell.VertexCellImpl;
import org.kagaka.cell.VertexCellFactory;
import org.kagaka.graph.VertexImpl;

class CellTest {

    @Test
    void test() {
        VertexCell vc = VertexCellFactory.createVertexCell();
        System.out.println(String.format("DEBUG vc.vertex %s", vc.getVertex()));
        vc.getTransform().doIt();; 
    }
    
    
 /* 
  * TODO move these tests to lifeToy project
  *   
    @Test
    void simpleLifeVCellTest() {
        VertexImpl<VertexCell> vertex = new VertexImpl<VertexCell>();
        SimpleLifeVCell slvc = new SimpleLifeVCell(null);
        VertexCellFactory.joinVertexCell(slvc, vertex);
        assertEquals(slvc.getVertex(), vertex);
        assertEquals(vertex.get(), slvc);
        slvc.doTransform();
        slvc.getTransform().doIt();
        System.out.println("");
        assertFalse(slvc.isAlive());
    }
    
    @Test
    void pairLifeVCellTest() {
        VertexImpl<VertexCell> v1 = new VertexImpl<VertexCell>();
        VertexImpl<VertexCell> v2 = new VertexImpl<VertexCell>();
        SimpleLifeVCell c1 = new SimpleLifeVCell(null);
        SimpleLifeVCell c2 = new SimpleLifeVCell(null);
        VertexCellFactory.joinVertexCell(c1, v1);
        VertexCellFactory.joinVertexCell(c2, v2);
        v1.addMutualEdge(v2);
        System.out.println("Transforming C1");
        c1.doTransform();
        System.out.println("Transforming C2");
        c2.doTransform();
        System.out.println("");
        assertEquals(1, c1.getVertex().getEdges().size());
        assertEquals(1, c2.getVertex().getEdges().size());
    }
    */

}
