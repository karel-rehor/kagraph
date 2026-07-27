package org.kagaka.cell;

//import java.lang.reflect.InvocationTargetException;

import org.kagaka.graph.Vertex;
import org.kagaka.graph.VertexImpl;
import org.kagaka.graph.WeightedEdgeVertex;

/**
 *
 * Factory for creating VertexCells.
 *
 * @author karl
 * <p>
 * Factory with methods for creating and binding vertices and vertex aware cells.
 * @version $Id: $Id
 */
public final class VertexCellFactory {

    private VertexCellFactory() {

    }

    /**
     * <p>createVertexCell.</p>
     *
     * @return a {@link org.kagaka.cell.VertexCell} object
     */
    public static VertexCell createVertexCell() {
        VertexImpl<VertexCell> vertex = new VertexImpl<VertexCell>();
        VertexCell vc = new VertexCellImpl(vertex);
        vertex.set(vc);
        return vc;
    }

    /**
     * <p>createVertexCell.</p>
     *
     * @param id a {@link java.lang.String} object
     * @return a {@link org.kagaka.cell.VertexCell} object
     */
    public static VertexCell createVertexCell(final String id) {
        VertexImpl<VertexCell> vertex = new VertexImpl<VertexCell>();
        VertexCell vc = new VertexCellImpl(id, vertex);
        vertex.set(vc);
        return vc;
    }

    /**
     * <p>createVertexCell.</p>
     *
     * @param vertex a {@link org.kagaka.graph.Vertex} object
     * @return a {@link org.kagaka.cell.VertexCell} object
     */
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
    /**
     * <p>addCellToNewVertex.</p>
     *
     * @param vc a {@link org.kagaka.cell.VertexCell} object
     * @return a {@link org.kagaka.cell.VertexCell} object
     */
    public static VertexCell addCellToNewVertex(final VertexCell vc) {
        VertexImpl<VertexCell> vertex = new VertexImpl<VertexCell>();
        vertex.set(vc);
        vc.setVertex(vertex);
        return vc;
    }

    /**
     * <p>joinVertexCell.</p>
     *
     * @param vc a {@link org.kagaka.cell.VertexCell} object
     * @param vertex a {@link org.kagaka.graph.Vertex} object
     * @return a {@link org.kagaka.cell.VertexCell} object
     */
    public static VertexCell joinVertexCell(final VertexCell vc, final Vertex<VertexCell> vertex) {
        vertex.set(vc);
        vc.setVertex(vertex);
        return vc;
    }

    /**
     * <p>joinVertexCell.</p>
     *
     * @param vc a {@link org.kagaka.cell.VertexCell} object
     * @param vertex a {@link org.kagaka.graph.WeightedEdgeVertex} object
     * @return a {@link org.kagaka.cell.VertexCell} object
     */
    public static VertexCell joinVertexCell(final VertexCell vc, final WeightedEdgeVertex<VertexCell> vertex) {
        vertex.set(vc);
        vc.setVertex(vertex);
        return vc;
    }


}
