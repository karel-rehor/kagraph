package org.kagaka.cell;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.kagaka.test.Util;

class CellTest {

    @Test
    void basicInstantiationTest() {
        
        Cell c = new CellImpl();
        assertNotNull(c.getId());
        assertTrue(Util.DEFAULT_ID_PATTERN.matcher(c.getId()).find());
        
    }

    class FooCell extends CellImpl implements Cell{
        
        String widget;

        public FooCell(String widget) {
            super();
            this.widget = widget;
        }
        
    }
    
    @Test
    void setTransformTest() {
        FooCell fc = new FooCell("tadpole");
        assertEquals("tadpole", fc.widget);
        
        fc.setTransform(() -> {fc.widget = "frog";});

        fc.transform();
        assertEquals("frog", fc.widget);
    }

}
