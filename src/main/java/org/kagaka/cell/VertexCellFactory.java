package org.kagaka.cell;

//import java.lang.reflect.InvocationTargetException;

import org.kagaka.graph.Vertex;
import org.kagaka.graph.VertexImpl;
import org.kagaka.graph.WeightedEdgeVertex;

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
    
    public static VertexCell createVertexCell(Vertex<VertexCell> vertex) {
        VertexCell vc = new VertexCellImpl(vertex);
        vertex.set(vc);
        return vc;
    }
/*    
    public static VertexCell createVertexCell(Class<VertexCell> clazz, Vertex<VertexCell> vertex) {
        Object vc = null;
        try {
            vc = clazz.getConstructor().newInstance();
            vertex.set((VertexCell)vc);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vc == null ? null : (VertexCell)vc;
        
    }
  */  
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
    
    public static VertexCell joinVertexCell(VertexCell vc, WeightedEdgeVertex<VertexCell> vertex) {
        vertex.set(vc);
        vc.setVertex(vertex);
        return vc;        
    }
    
        
}
