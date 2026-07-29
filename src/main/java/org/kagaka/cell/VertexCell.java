package org.kagaka.cell;

import org.kagaka.graph.Vertex;

/**
 * <p>VertexCell interface.</p>
 *
 * @author karl
 * @version $Id: $Id
 */
public interface VertexCell extends Cell {

    /**
     * <p>getVertex.</p>
     *
     * @return a {@link org.kagaka.graph.Vertex} object
     */
    Vertex<VertexCell> getVertex();

    /**
     * <p>setVertex.</p>
     *
     * @param vertex a {@link org.kagaka.graph.Vertex} object
     */
    void setVertex(Vertex<VertexCell> vertex);

}
