package org.kagaka.graph;

import java.util.Set;

public interface GraphProperties {
    
    public void set(String key, String value);
    public String get(String key);
    public Set<String> getKeys();
    
    public void hasKey(String key) throws IllegalStateException;

}
