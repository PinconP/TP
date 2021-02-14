package rectangle;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ColoredRectTest {
    ColoredRect cr1;
    ColoredRect cr2;
    ColoredRect cr3;

    @Before
    public void setUp() throws Exception {
        cr1 = new ColoredRect(new Point(0, 1), new Point(1, 0), Color.RED);
        cr2 = new ColoredRect(new Point(0, 1), new Point(1, 0),Color.GREEN);
        cr3 = new ColoredRect(new Point(0, 2), new Point(2, 0),Color.BLUE);
    }
    @After
    public void tearDown() throws Exception {
        cr1 = null;
        cr2 = null;
        cr3 = null;
        System.gc();
    }
}