package org.kagaka.graph;

import java.util.Set;

public interface GraphProperties {

    void set(String key, String value);

    String get(String key);

    Set<String> getKeys();

    void hasKey(String key) throws IllegalStateException;

}
