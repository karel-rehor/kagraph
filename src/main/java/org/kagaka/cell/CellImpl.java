package org.kagaka.cell;

import org.kagaka.GeneralKit;
import org.kagaka.transform.Transform;

/**
 *
 * @author karl
 *
 * Base class for anything that needs a unique ID and that can be transformed.
 *
 */
public class CellImpl implements Cell{

    final private String id;
    protected Transform transform = () -> {};

    public CellImpl(String id) {
        super();
        this.id = id;
        this.transform = () -> {System.out.println(this.id + ": I've been transformed!");};
    }

    public CellImpl() {
        super();
        this.id = GeneralKit.genHexId(16);
        this.transform = () -> {System.out.println(this.id + " I've been transformed!");};
    }

    public CellImpl(Transform transform) {
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

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

}
