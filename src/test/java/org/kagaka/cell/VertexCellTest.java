package org.kagaka.cell;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.kagaka.graph.Vertex;
import org.kagaka.test.Util;

class VertexCellTest {

    @Test
    void baseTest() {
        VertexCell vc = VertexCellFactory.createVertexCell();
        
        assertTrue(Util.DEFAULT_ID_PATTERN.matcher(vc.getId()).find());
        assertEquals(vc, vc.getVertex().get());
        
        Vertex<VertexCell> holder = vc.getVertex();
        // dangerous - do not do this at home - for test only
        vc.setTransform(() -> {vc.setVertex(null);});        
        vc.transform();
        assertNull(vc.getVertex());
        vc.setVertex(holder);
        assertEquals(holder, vc.getVertex());
        
    }
    
}
