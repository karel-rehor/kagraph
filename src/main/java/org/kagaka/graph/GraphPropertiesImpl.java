package org.kagaka.graph;

import java.util.HashMap;
import java.util.Set;

public class GraphPropertiesImpl implements GraphProperties {

    // TODO make props value not dependent on String, e.g. Class<?> ?
    private HashMap<String,String> props;
    
    
    
    public GraphPropertiesImpl() {
        super();
        // TODO Auto-generated constructor stub
        props = new HashMap<String, String>();
    }

    @Override
    public void set(String key, String value) {

        props.put(key, value);
    }

    @Override
    public String get(String key) {
        // TODO Auto-generated method stub
        return props.get(key);
    }

    @Override
    public Set<String> getKeys() {
        // TODO Auto-generated method stub
        return props.keySet();
    }

    @Override
    public void hasKey(String key) throws IllegalStateException {
        // TODO Auto-generated method stub
        if(!props.containsKey(key)) {
            throw new IllegalStateException(String.format("Properties must include key: %s", key));
        }
        
    }

}
