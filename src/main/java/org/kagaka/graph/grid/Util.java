package org.kagaka.graph.grid;

import java.util.List;

import org.kagaka.graph.Graph;
import org.kagaka.graph.GraphProperties;
import org.kagaka.graph.Vertex;

// For Debugging purposes
public class Util {
    
    public static <T> void dumpVertices(Graph<T> graph) {
        List<Vertex<T>> vertices = graph.getVertices();
        for(Vertex<T> vt : vertices) {
            System.out.println(String.format("%d : %s", vertices.indexOf(vt), vt.get()));            
        }        
    }
    
    public static <T> void dumpGridByDims(Graph<T> graph, GraphProperties props) {
        
        if(props.get("height") == null || props.get("width") == null) {
            throw new IllegalStateException("Grid properties must have height and width");
        }
        
        int height = Integer.parseInt(props.get("height"));
        int width = Integer.parseInt(props.get("width"));
        
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

}
