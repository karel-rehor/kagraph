package org.kagaka.cell;

import org.kagaka.graph.Vertex;

public interface VertexCell extends Cell {

    Vertex<VertexCell> getVertex();

    void setVertex(Vertex<VertexCell> vertex);

}
