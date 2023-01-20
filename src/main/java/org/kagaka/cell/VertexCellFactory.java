package org.kagaka.cell;

import org.kagaka.graph.Vertex;
import org.kagaka.graph.VertexImpl;

/**
 * 
 * @author karl
 *
 * Factory with methods for creating and binding vertices and vertex aware cells.  
 */
public class VertexCellFactory {
    
    public static VertexCell createVertexCell() {
        VertexImpl<VertexCell> vertex = new VertexImpl<VertexCell>();
        VertexCell vc = new VertexCellImpl(vertex);
        vertex.set(vc);
        return vc;
    }
    
    public static VertexCell createVertexCell(String id) {
        VertexImpl<VertexCell> vertex = new VertexImpl<VertexCell>();
        VertexCell vc = new VertexCellImpl(id, vertex);
        vertex.set(vc);
        return vc;
    }
    
    public static VertexCell createVertexCell(VertexImpl<VertexCell> vertex) {
        VertexCell vc = new VertexCellImpl(vertex);
        vertex.set(vc);
        return vc;
    }
    
    public static VertexCell addCellToNewVertex(VertexCell vc) {
        VertexImpl<VertexCell> vertex = new VertexImpl<VertexCell>();
        vertex.set(vc);
        vc.setVertex(vertex);
        return vc;
    }
    
    public static VertexCell joinVertexCell(VertexCell vc, Vertex<VertexCell> vertex) {
        vertex.set(vc);
        vc.setVertex(vertex);
        return vc;        
    }
    
  /*  
    public static SimpleLifeVCell joinVertexCell(SimpleLifeVCell slvc, Vertex<SimpleLifeVCell> vertex) {
        vertex.set(slvc);
        slvc.setVertex((Vertex)vertex);
        return slvc;        
    }
*/
    
}
