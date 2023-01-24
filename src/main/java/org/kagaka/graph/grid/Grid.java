package org.kagaka.graph.grid;

import java.util.List;

import org.kagaka.GeneralKit;
import org.kagaka.graph.GraphImpl;
import org.kagaka.graph.Vertex;

/**
 * 
 * @author karl
 * <p>
 * Graph in the shape of a two dimensional grid
 * <p>
 * Coordinate indices function from top to bottom and left to right, like when indexing monitor pixels.
 * @param <T>
 */
public class Grid<T> extends GraphImpl<T> {
    
    // index by raster e.g. top to bottom LR  
    
    final int height;
    final int width;
    final String id;
    
    public Grid(List<Vertex<T>> vertices, int width, int height) {
        super(vertices);
        this.height = height;
        this.width = width;
        this.id = GeneralKit.genHexId(GeneralKit.ID_LENGTH);
    }
    
    public Grid(int width, int height) {
        super();
        this.height = height;
        this.width = width;
        this.id = GeneralKit.genHexId(GeneralKit.ID_LENGTH);
    }
    

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public String getId() {
        return id;
    }

    // TODO - remove after debugging complete
    public void dumpVertices() {
        
        for(Vertex<T> vt : this.vertices) {
            System.out.println(String.format("%d : %s", vertices.indexOf(vt), vt.get()));            
        }
    }
    
    // TODO - remove after debugging complete
    public void dumpGridByDims() {
        
        StringBuffer sb = new StringBuffer();
        
        sb.append("width " + width + " height " + height + "\n");
        
        int index = 0;
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                sb.append("|" + i + "," + j + "(" + index + "}|");
                index++;            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    public void joinVertices() {
        if(vertices == null || vertices.size() < 2) {
            throw new IllegalStateException("Cannoint join grid vertices that have not been initialized to a grid larger than 2 items");
        }
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(j > 0 ) { // add left edge
                    (vertices.get((i * width) + j)).addMutualEdge(vertices.get((i * width) + (j - 1)));
                }
                if(i > 0 ) { // add upper edge
                    (vertices.get((i * width) + j)).addMutualEdge(vertices.get(((i - 1) * width) + j));
                }

            }
        }
                
    }
    
    public Vertex<T> getVertexAt(int x, int y){
        
        if(x >= this.height || y >= this.width) {
            return null;
        }
        
        return vertices.get((x * width) + y);
    }
    
    public Vertex<T> getVertexAt(Coords2D coord){
        if(coord.getX() >= this.height || coord.getY() >= this.width) {
            return null;
        }
        return vertices.get((coord.getX() * width) + coord.getY());
        
    }
    
    public T getAt(int x, int y){
        if(x >= this.height || y >= this.width) {
            return null;
        }
        return vertices.get((x * width) + y).get();
        
    }
    
    public T getAt(Coords2D coords){
        if(coords.getX() >= this.height || coords.getY() >= this.width) {
            return null;
        }
        return vertices.get((coords.getX() * width) + coords.getY()).get();    
    }

    
    public <U extends T> Coords2D getVertexCoords(Vertex<U> vertex) {
        int index = 0;
        for(Vertex<T> vt : vertices) {
            if(vt.equals(vertex)) {
                break;
            }
            index++;
        }
        Coords2D c = new Coords2D(index / this.width, index % this.width);
        return c;        
    }

}
