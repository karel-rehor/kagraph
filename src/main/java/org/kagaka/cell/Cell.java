package org.kagaka.cell;

import org.kagaka.transform.Transform;

public interface Cell {
    
    public String getId();
    
    public Transform getTransform();
    
    public void setTransform(Transform transform);
    
    public void transform();

}
