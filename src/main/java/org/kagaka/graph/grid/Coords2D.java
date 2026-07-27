package org.kagaka.graph.grid;

/**
 * <p>Coords2D class.</p>
 *
 * @author karl
 * @version $Id: $Id
 */
public class Coords2D {

    int x;
    int y;

    /**
     * <p>Constructor for Coords2D.</p>
     *
     * @param x a int
     * @param y a int
     */
    public Coords2D(final int x, final int y) {
        super();
        this.x = x;
        this.y = y;
    }

    /**
     * <p>Getter for the field <code>x</code>.</p>
     *
     * @return a int
     */
    public int getX() {
        return x;
    }

    /**
     * <p>Setter for the field <code>x</code>.</p>
     *
     * @param x a int
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * <p>Getter for the field <code>y</code>.</p>
     *
     * @return a int
     */
    public int getY() {
        return y;
    }

    /**
     * <p>Setter for the field <code>y</code>.</p>
     *
     * @param y a int
     */
    public void setY(final int y) {
        this.y = y;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("[%d,%d]", x, y);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object obj) {
        // TODO Auto-generated method stub
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Coords2D other = (Coords2D) obj;
        return this.x == other.x && this.y == other.y;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return 1009;
    }


}
