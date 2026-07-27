package org.kagaka.cell;

import org.kagaka.GeneralKit;
import org.kagaka.transform.Transform;

/**
 * <p>CellImpl class.</p>
 *
 * @author karl
 * <p>
 * Base class for anything that needs a unique ID and that can be transformed.
 * @version $Id: $Id
 */
public class CellImpl implements Cell {

    private final String id;
    protected Transform transform = () -> {
    };

    /**
     * <p>Constructor for CellImpl.</p>
     *
     * @param id a {@link java.lang.String} object
     */
    public CellImpl(final String id) {
        super();
        this.id = id;
        this.transform = () -> {
            System.out.println(this.id + ": I've been transformed!");
        };
    }

    /**
     * <p>Constructor for CellImpl.</p>
     */
    public CellImpl() {
        super();
        this.id = GeneralKit.genHexId(16);
        this.transform = () -> {
            System.out.println(this.id + " I've been transformed!");
        };
    }

    /**
     * <p>Constructor for CellImpl.</p>
     *
     * @param transform a {@link org.kagaka.transform.Transform} object
     */
    public CellImpl(final Transform transform) {
        super();
        this.id = GeneralKit.genHexId(GeneralKit.ID_LENGTH);
        this.transform = transform;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return getId();
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getId() {
        return id;
    }

    /**
     * <p>Getter for the field <code>transform</code>.</p>
     *
     * @return a {@link org.kagaka.transform.Transform} object
     */
    public Transform getTransform() {
        return transform;
    }

    /** {@inheritDoc} */
    public void setTransform(final Transform transform) {
        this.transform = transform;
    }

    /**
     * <p>transform.</p>
     */
    public void transform() {
        transform.doIt();

    }

}
