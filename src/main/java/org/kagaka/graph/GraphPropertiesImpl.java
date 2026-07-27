package org.kagaka.graph;

import java.util.HashMap;
import java.util.Set;

/**
 * <p>GraphPropertiesImpl class.</p>
 *
 * @author karl
 * @version $Id: $Id
 */
public class GraphPropertiesImpl implements GraphProperties {

    private final HashMap<String, String> props;

    /**
     * <p>Constructor for GraphPropertiesImpl.</p>
     */
    public GraphPropertiesImpl() {
        super();
        props = new HashMap<String, String>();
    }

    /** {@inheritDoc} */
    @Override
    public void set(final String key, final String value) {

        props.put(key, value);
    }

    /** {@inheritDoc} */
    @Override
    public String get(final String key) {
        return props.get(key);
    }

    /** {@inheritDoc} */
    @Override
    public Set<String> getKeys() {
        return props.keySet();
    }

    /** {@inheritDoc} */
    @Override
    public void hasKey(final String key) throws IllegalStateException {
        if (!props.containsKey(key)) {
            throw new IllegalStateException(String.format("Properties must include key: %s", key));
        }

    }

}
