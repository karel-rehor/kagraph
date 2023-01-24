package org.kagaka.cell;

import org.kagaka.graph.Vertex;
import org.kagaka.transform.Transform;

/**
 * 
 * @author karl
 * 
 * A Cell that is aware of a the Vertex that contains it.  
 * 
 * Should be factory instantiated to bind Vertex and Cell.  
 *
 */
public class VertexCellImpl extends CellImpl implements VertexCell {

    protected Vertex<VertexCell> vertex;

    protected VertexCellImpl(Vertex<VertexCell> vertex) {
        super();
        this.vertex = vertex;
    }

    protected VertexCellImpl(String id, Vertex<VertexCell> vertex) {
        super(id);
        this.vertex = vertex;
    }

    public VertexCellImpl() {
        super();
        this.vertex = null;
    }

    public VertexCellImpl(String id) {
        super(id);
        this.vertex = null;
    }

    public VertexCellImpl(Transform transform) {
        super(transform);
        this.vertex = null;
    }

    public Vertex<VertexCell> getVertex() {
        return vertex;
    }

    public void setVertex(Vertex<VertexCell> vertex) {
        this.vertex = vertex;
    }

}
