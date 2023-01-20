package org.kagaka.graph.grid;

import org.kagaka.graph.VertexImpl;

public class GridVertex<T> extends VertexImpl<T> {

    Coords2D coords;

    public GridVertex(Coords2D coords) {
        super();
        this.coords = coords;
    }
    
    public GridVertex(int x, int y) {
        super();
        this.coords = new Coords2D(x, y);
    }

    public Coords2D getCoords() {
        return coords;
    }

    public void setCoords(Coords2D coords) {
        this.coords = coords;
    }
    
}
