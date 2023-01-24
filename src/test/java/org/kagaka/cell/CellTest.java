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
    
}
