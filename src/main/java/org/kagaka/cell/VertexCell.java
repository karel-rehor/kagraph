package org.kagaka.cell;

import org.kagaka.graph.Vertex;
import org.kagaka.graph.VertexImpl;

public interface VertexCell extends Cell {
    
    public Vertex<VertexCell> getVertex();
    
    public void setVertex(Vertex<VertexCell> vertex);

}
