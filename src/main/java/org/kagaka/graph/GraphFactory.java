package org.kagaka.graph;

import org.kagaka.cell.VertexCell;

public interface GraphFactory<T extends VertexCell> {

    <G extends Graph<T>> Graph<T> createGraph(GraphProperties props);

}
