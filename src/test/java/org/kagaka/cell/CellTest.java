package org.kagaka.cell;

import org.junit.jupiter.api.Test;
import org.kagaka.test.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {

    @Test
    void basicInstantiationTest() {

        Cell c = new CellImpl();
        assertNotNull(c.getId());
        assertTrue(Util.defaultIdPattern.matcher(c.getId()).find());

    }

    @Test
    void setTransformTest() {
        FooCell fc = new FooCell("tadpole");
        assertEquals("tadpole", fc.widget);

        fc.setTransform(() -> {
            fc.widget = "frog";
        });

        fc.transform();
        assertEquals("frog", fc.widget);
    }

    class FooCell extends CellImpl implements Cell {

        String widget;

        public FooCell(final String widget) {
            super();
            this.widget = widget;
        }

    }

}
