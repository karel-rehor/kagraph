package org.kagaka.graph.grid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.kagaka.cell.VertexCell;
import org.kagaka.graph.GraphFactory;
import org.kagaka.graph.GraphProperties;
import org.kagaka.graph.GraphPropertiesImpl;
import org.kagaka.graph.Vertex;

class GridTest {

 //   @Disabled
    // TODO cleanup and add more asserts
    @Test
    void testCellGrid() {
        int height = 3;
        int width = 5;
        
        GraphProperties gridProps = new GraphPropertiesImpl();
        gridProps.set("height", Integer.toString(height));
        gridProps.set("width", Integer.toString(width));
        
        // TOO create factory and use create method
        GraphFactory<VertexCell> gridFactory = new GridFactoryImpl<VertexCell>();
        
        // Grid<VertexCellImpl> grid = GraphFactoryImpl.createCellGrid(width, height);
        
        Grid<VertexCell> grid = (Grid<VertexCell>) gridFactory.createGraph(gridProps);
        
        
        
        int hIndex = 0;
        int wIndex = 0;
        for(Vertex<? extends VertexCell> vc : grid.getVertices()) {
//            System.out.println("DEBUG vc [" + hIndex + "," + wIndex + "]"  + vc);
            System.out.println("DEBUG vc "  + vc);
            wIndex++;
            if(wIndex == width) {
                wIndex = 0;
                hIndex++;
            }
        }
        
        System.out.println("==========\n\n");
        // grid.dumpVertices();
        GridUtil.dumpVertices(grid);
        System.out.println("==========\n\n");
       // grid.dumpGridByDims();
        GridUtil.dumpGridByDims(grid, gridProps);
        
        System.out.println("DEBUG getVertexAt(1,2) " + grid.getVertexAt(1, 2).get());
        System.out.println("DEBUG getVertexAt(0,1) " + grid.getVertexAt(0, 1).get());
        System.out.println("DEBUG getVertexAt(2,3) " + grid.getVertexAt(2,3).get());
        
        grid.getVertexAt(1, 2).get().getTransform().doIt();
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                assertEquals(new Coords2D(i,j), grid.getVertexCoords(grid.getVertexAt(i, j)));
            }            
        }
        assertNull(grid.getVertexAt(0, grid.getWidth()+1));
        assertNull(grid.getVertexAt(grid.getHeight()+1, 0));
        /*
        System.out.println("DEBUG getCoords of Vertex at (2,0) : " + grid.getVertexCoords(grid.getVertexAt(2, 0)));
        System.out.println("DEBUG getCoords of Vertex at (0,1) : " + grid.getVertexCoords(grid.getVertexAt(0, 1)));
        System.out.println("DEBUG getCoords of Vertex at (1,3) : " + grid.getVertexCoords(grid.getVertexAt(1, 3)));
        System.out.println("DEBUG check equals Vertex(0,1) to Vertex(2,2) " + grid.getVertexAt(0, 1).equals(grid.getVertexAt(2, 2)));
        */
    }



}
