package org.kagaka.graph;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.kagaka.GeneralKit;
import org.kagaka.cell.VertexCell;
import org.kagaka.cell.VertexCellImpl;
import org.kagaka.cell.VertexCellFactory;
import org.kagaka.graph.grid.Grid;
// import org.kagaka.life.cell.SimpleLifeVCell;


public class GraphFactoryImpl<T extends VertexCell> implements GraphFactory<T>{
 /*       
    public static Grid<VertexCell> createCellGrid(int width, int height){
        
        Grid<VertexCell> grid = new Grid<VertexCell>(width, height);
        
        int index = 0;
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
// TODO after debugging revert to random IDs
                        grid.addVertex((Vertex<VertexCell>) VertexCellFactory.createVertexCell(String.format("[%d,%d](%d)", i, j, index)).getVertex());
                index++;
            }
        }
        
        grid.joinVertices();
        
        return grid;
        
    }
    */
    
    // TODO Implement and test OR Remove this class

    @Override
    public Graph<T> createGraph(GraphProperties props) {
        throw new UnsupportedOperationException("This method not yet implemented");
    }
    
    /*
    
    public static Grid<SimpleLifeVCell> createSimpleLifeGrid(int width, int height){

        Grid<SimpleLifeVCell> grid = new Grid<SimpleLifeVCell>(width, height);

        int index = 0;
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                Vertex<SimpleLifeVCell> vertex = new Vertex<SimpleLifeVCell>();
             // TODO after debugging revert to random IDs
//                SimpleLifeVCell slvc = new SimpleLifeVCell(String.format("[%d,%d](%d)", i, j, index), null);
                SimpleLifeVCell slvc = new SimpleLifeVCell(GeneralKit.genHexId(GeneralKit.ID_LENGTH), null);
                VertexCellFactory.joinVertexCell(slvc, (Vertex)vertex);
                grid.addVertex((Vertex)vertex);
                
                index++;
            }
        }
        
        grid.joinVertices();

        return grid;
        
    } */

}
