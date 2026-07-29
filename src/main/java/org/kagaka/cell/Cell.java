package org.kagaka.cell;

import org.kagaka.transform.Transform;

/**
 * <p>Cell interface.</p>
 *
 * @author karl
 * @version $Id: $Id
 */
public interface Cell {

    /**
     * <p>getId.</p>
     *
     * @return a {@link java.lang.String} object
     */
    String getId();

    /**
     * <p>getTransform.</p>
     *
     * @return a {@link org.kagaka.transform.Transform} object
     */
    Transform getTransform();

    /**
     * <p>setTransform.</p>
     *
     * @param transform a {@link org.kagaka.transform.Transform} object
     */
    void setTransform(Transform transform);

    /**
     * <p>transform.</p>
     */
    void transform();

}
