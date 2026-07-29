package org.kagaka.graph;

import org.kagaka.cell.VertexCell;

/**
 * <p>GraphFactory interface.</p>
 *
 * @author karl
 * @version $Id: $Id
 */
public interface GraphFactory<T extends VertexCell> {

    /**
     * <p>createGraph.</p>
     *
     * @param props a {@link org.kagaka.graph.GraphProperties} object
     * @param <G> a G class
     * @return a {@link org.kagaka.graph.Graph} object
     */
    <G extends Graph<T>> Graph<T> createGraph(GraphProperties props);

}
