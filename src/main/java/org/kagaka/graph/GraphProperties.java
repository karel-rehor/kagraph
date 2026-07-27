package org.kagaka.graph;

import java.util.Set;

/**
 * <p>GraphProperties interface.</p>
 *
 * @author karl
 * @version $Id: $Id
 */
public interface GraphProperties {

    /**
     * <p>set.</p>
     *
     * @param key a {@link java.lang.String} object
     * @param value a {@link java.lang.String} object
     */
    void set(String key, String value);

    /**
     * <p>get.</p>
     *
     * @param key a {@link java.lang.String} object
     * @return a {@link java.lang.String} object
     */
    String get(String key);

    /**
     * <p>getKeys.</p>
     *
     * @return a {@link java.util.Set} object
     */
    Set<String> getKeys();

    /**
     * <p>hasKey.</p>
     *
     * @param key a {@link java.lang.String} object
     * @throws java.lang.IllegalStateException if any.
     */
    void hasKey(String key) throws IllegalStateException;

}
