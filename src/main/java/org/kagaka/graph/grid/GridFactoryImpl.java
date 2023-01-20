package org.kagaka.graph.grid;

import org.kagaka.cell.VertexCell;
import org.kagaka.cell.VertexCellFactory;
import org.kagaka.graph.Graph;
import org.kagaka.graph.GraphFactory;
import org.kagaka.graph.GraphProperties;
import org.kagaka.graph.Vertex;

public class GridFactoryImpl<T extends VertexCell> implements GraphFactory<T> {

    @Override
    public Graph<T> createGraph(GraphProperties props) {
        
        props.hasKey("height");    
        props.hasKey("width");
        
        int height = Integer.parseInt(props.get("height"));
        int width = Integer.parseInt(props.get("width"));

        Grid<VertexCell> grid = new Grid<VertexCell>(width, height);
        
        int index = 0;
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
// TODO after debugging revert to random IDs
                        grid.addVertex((Vertex<VertexCell>) VertexCellFactory.createVertexCell(String.format("[%d,%d](%d)", i, j, index)).getVertex());
//                // TODO after debugging revert to random IDs
//                grid.addVertex(VertexCellFactory.createVertexCell(String.format("[%d,%d](%d)", i, j, index)).getVertex());
                index++;
            }
        }
        
        grid.joinVertices();
        
        return (Graph<T>) grid;
    }

}
