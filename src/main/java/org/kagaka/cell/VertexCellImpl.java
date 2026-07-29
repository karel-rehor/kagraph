package org.kagaka.cell;

import org.kagaka.graph.Vertex;
import org.kagaka.transform.Transform;

/**
 * <p>VertexCellImpl class.</p>
 *
 * @author karl
 * <p>
 * A Cell that is aware of a the Vertex that contains it.
 * <p>
 * Should be factory instantiated to bind Vertex and Cell.
 * @version $Id: $Id
 */
public class VertexCellImpl extends CellImpl implements VertexCell {

    protected Vertex<VertexCell> vertex;

    /**
     * <p>Constructor for VertexCellImpl.</p>
     *
     * @param vertex a {@link org.kagaka.graph.Vertex} object
     */
    protected VertexCellImpl(final Vertex<VertexCell> vertex) {
        super();
        this.vertex = vertex;
    }

    /**
     * <p>Constructor for VertexCellImpl.</p>
     *
     * @param id a {@link java.lang.String} object
     * @param vertex a {@link org.kagaka.graph.Vertex} object
     */
    protected VertexCellImpl(final String id, final Vertex<VertexCell> vertex) {
        super(id);
        this.vertex = vertex;
    }

    /**
     * <p>Constructor for VertexCellImpl.</p>
     */
    public VertexCellImpl() {
        super();
        this.vertex = null;
    }

    /**
     * <p>Constructor for VertexCellImpl.</p>
     *
     * @param id a {@link java.lang.String} object
     */
    public VertexCellImpl(final String id) {
        super(id);
        this.vertex = null;
    }

    /**
     * <p>Constructor for VertexCellImpl.</p>
     *
     * @param transform a {@link org.kagaka.transform.Transform} object
     */
    public VertexCellImpl(final Transform transform) {
        super(transform);
        this.vertex = null;
    }

    /**
     * <p>Getter for the field <code>vertex</code>.</p>
     *
     * @return a {@link org.kagaka.graph.Vertex} object
     */
    public Vertex<VertexCell> getVertex() {
        return vertex;
    }

    /** {@inheritDoc} */
    public void setVertex(final Vertex<VertexCell> vertex) {
        this.vertex = vertex;
    }

}
