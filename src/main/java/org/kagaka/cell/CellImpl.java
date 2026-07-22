package org.kagaka.cell;

import org.kagaka.GeneralKit;
import org.kagaka.transform.Transform;

/**
 *
 * @author karl
 * <p>
 * Base class for anything that needs a unique ID and that can be transformed.
 *
 */
public class CellImpl implements Cell {

    private final String id;
    protected Transform transform = () -> {
    };

    public CellImpl(final String id) {
        super();
        this.id = id;
        this.transform = () -> {
            System.out.println(this.id + ": I've been transformed!");
        };
    }

    public CellImpl() {
        super();
        this.id = GeneralKit.genHexId(16);
        this.transform = () -> {
            System.out.println(this.id + " I've been transformed!");
        };
    }

    public CellImpl(final Transform transform) {
        super();
        this.id = GeneralKit.genHexId(GeneralKit.ID_LENGTH);
        this.transform = transform;
    }

    @Override
    public String toString() {
        return getId();
    }

    public String getId() {
        return id;
    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(final Transform transform) {
        this.transform = transform;
    }

    public void transform() {
        transform.doIt();

    }

}
