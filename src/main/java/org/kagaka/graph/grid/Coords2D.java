package org.kagaka.graph.grid;

public class Coords2D {
    
    int x; 
    int y;
    
    public Coords2D(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("[%d,%d]", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Coords2D other = (Coords2D)  obj;
        return this.x == other.x && this.y == other.y;
    }
    
    
    
    

}
