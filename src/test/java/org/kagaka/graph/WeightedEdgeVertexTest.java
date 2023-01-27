package org.kagaka.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.kagaka.cell.VertexCell;
import org.kagaka.cell.VertexCellFactory;
import org.kagaka.cell.VertexCellImpl;

class WeightedEdgeVertexTest {

    @Test
    void baseTest() {
        
        WeightedEdgeVertex<String> wevs = new WeightedEdgeVertexImpl<String>("Calico");
        
        assertEquals("Calico", wevs.get());
        assertEquals(0, wevs.getEdges().size());
        assertEquals(0, wevs.getWeights().size());
        
    }
    
    @Test
    void joinWeightedVerticesTest() {
        WeightedEdgeVertex<String> wevs1 = new WeightedEdgeVertexImpl<String>("Dee");
        WeightedEdgeVertex<String> wevs2 = new WeightedEdgeVertexImpl<String>("Dum");
        try {
            wevs1.addMutualEdge(wevs2, -5.0, 1.0);
        }catch(IllegalArgumentException iae) {
            assertEquals(0, wevs1.getEdges().size());
            assertEquals(0, wevs1.getWeights().size());
            assertEquals(0, wevs2.getEdges().size());
            assertEquals(0, wevs2.getWeights().size());
        }

        wevs1.addMutualEdge(wevs2, 0.5, 1.0);
        assertEquals(0.5, wevs1.getWeight(wevs2));
        assertEquals(1.0, wevs2.getWeight(wevs1));

        try {
            wevs1.setWeight(wevs2, 99.0);
        }catch(IllegalArgumentException iae) {
            assertEquals(0.5, wevs1.getWeight(wevs2));            
        }
        
        wevs1.setWeight(wevs2, -1.0);
        assertEquals(-1.0, wevs1.getWeight(wevs2));
        wevs1.removeWeightedEdge(wevs2);
        
        assertNull(wevs1.getEdge(0));
        assertNull(wevs2.getEdge(0));
        assertNull(wevs1.getWeight(wevs2));
        assertNull(wevs2.getWeight(wevs1));

        wevs1.addMutualEdge(wevs2, -0.1, 0.42);
        
        assertEquals(-0.1, wevs1.getWeight(wevs2));
        assertEquals(0.42, wevs2.getWeight(wevs1));
        
        wevs1.removeAllWeightedEdges();

        assertNull(wevs1.getEdge(0));
        assertNull(wevs2.getEdge(0));
        
    }
    
    class FooVCell extends VertexCellImpl implements VertexCell{
        
        String s = "water";
        
        String getS() {return s;}
    }
    
    @Test
    void createWithVertexCell() {
        WeightedEdgeVertex<VertexCell> wevVc = new WeightedEdgeVertexImpl<VertexCell>(null);
        VertexCell vc = VertexCellFactory.createVertexCell(wevVc);
        
        vc.transform();
        
        FooVCell fvc = new FooVCell();
        WeightedEdgeVertex<FooVCell> wevFvc = new WeightedEdgeVertexImpl<FooVCell>(fvc);
        VertexCellFactory.joinVertexCell((VertexCell)fvc, (Vertex)wevFvc);
        
        
        assertEquals(fvc, wevFvc.get());
        assertEquals(wevFvc, fvc.getVertex());
        
        
        assertEquals("water", wevFvc.get().getS());
        
        fvc.setTransform(() -> {fvc.s = "ICE";});
        fvc.transform();

        assertEquals("ICE", wevFvc.get().getS());
        
    }

}
