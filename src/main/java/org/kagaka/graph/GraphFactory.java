package org.kagaka.graph;

import org.kagaka.cell.VertexCell;

public interface GraphFactory<T extends VertexCell> {
    
    public Graph<T> createGraph(GraphProperties props); 

}
