package org.kagaka.graph.grid;

public class Coords2D {

    int x;
    int y;

    public Coords2D(final int x, final int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("[%d,%d]", x, y);
    }

    @Override
    public boolean equals(final Object obj) {
        // TODO Auto-generated method stub
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Coords2D other = (Coords2D) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return 1009;
    }


}
