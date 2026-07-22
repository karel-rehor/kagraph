package org.kagaka.graph;

import java.util.HashMap;
import java.util.Set;

public class GraphPropertiesImpl implements GraphProperties {

    private final HashMap<String, String> props;

    public GraphPropertiesImpl() {
        super();
        props = new HashMap<String, String>();
    }

    @Override
    public void set(final String key, final String value) {

        props.put(key, value);
    }

    @Override
    public String get(final String key) {
        return props.get(key);
    }

    @Override
    public Set<String> getKeys() {
        return props.keySet();
    }

    @Override
    public void hasKey(final String key) throws IllegalStateException {
        if (!props.containsKey(key)) {
            throw new IllegalStateException(String.format("Properties must include key: %s", key));
        }

    }

}
