package org.kagaka.cell;

import org.kagaka.transform.Transform;

public interface Cell {

    String getId();

    Transform getTransform();

    void setTransform(Transform transform);

    void transform();

}
