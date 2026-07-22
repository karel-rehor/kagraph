package org.kagaka.cell;

import org.kagaka.graph.Vertex;
import org.kagaka.transform.Transform;

/**
 *
 * @author karl
 * <p>
 * A Cell that is aware of a the Vertex that contains it.
 * <p>
 * Should be factory instantiated to bind Vertex and Cell.
 *
 */
public class VertexCellImpl extends CellImpl implements VertexCell {

    protected Vertex<VertexCell> vertex;

    protected VertexCellImpl(final Vertex<VertexCell> vertex) {
        super();
        this.vertex = vertex;
    }

    protected VertexCellImpl(final String id, final Vertex<VertexCell> vertex) {
        super(id);
        this.vertex = vertex;
    }

    public VertexCellImpl() {
        super();
        this.vertex = null;
    }

    public VertexCellImpl(final String id) {
        super(id);
        this.vertex = null;
    }

    public VertexCellImpl(final Transform transform) {
        super(transform);
        this.vertex = null;
    }

    public Vertex<VertexCell> getVertex() {
        return vertex;
    }

    public void setVertex(final Vertex<VertexCell> vertex) {
        this.vertex = vertex;
    }

}
