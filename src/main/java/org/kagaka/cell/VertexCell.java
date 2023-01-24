package org.kagaka.cell;

import org.kagaka.graph.Vertex;

public interface VertexCell extends Cell {
    
    public Vertex<VertexCell> getVertex();
    
    public void setVertex(Vertex<VertexCell> vertex);

}
