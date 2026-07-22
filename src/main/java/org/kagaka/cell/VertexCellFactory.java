package org.kagaka.cell;

//import java.lang.reflect.InvocationTargetException;

import org.kagaka.graph.Vertex;
import org.kagaka.graph.VertexImpl;
import org.kagaka.graph.WeightedEdgeVertex;

/**
 *
 * @author karl
 * <p>
 * Factory with methods for creating and binding vertices and vertex aware cells.
 */
public final class VertexCellFactory {

    private VertexCellFactory() {

    }

    public static VertexCell createVertexCell() {
        VertexImpl<VertexCell> vertex = new VertexImpl<VertexCell>();
        VertexCell vc = new VertexCellImpl(vertex);
        vertex.set(vc);
        return vc;
    }

    public static VertexCell createVertexCell(final String id) {
        VertexImpl<VertexCell> vertex = new VertexImpl<VertexCell>();
        VertexCell vc = new VertexCellImpl(id, vertex);
        vertex.set(vc);
        return vc;
    }

    public static VertexCell createVertexCell(final Vertex<VertexCell> vertex) {
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
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
            | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return vc == null ? null : (VertexCell)vc;

        }
      */
    public static VertexCell addCellToNewVertex(final VertexCell vc) {
        VertexImpl<VertexCell> vertex = new VertexImpl<VertexCell>();
        vertex.set(vc);
        vc.setVertex(vertex);
        return vc;
    }

    public static VertexCell joinVertexCell(final VertexCell vc, final Vertex<VertexCell> vertex) {
        vertex.set(vc);
        vc.setVertex(vertex);
        return vc;
    }

    public static VertexCell joinVertexCell(final VertexCell vc, final WeightedEdgeVertex<VertexCell> vertex) {
        vertex.set(vc);
        vc.setVertex(vertex);
        return vc;
    }


}
