package rectangle;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
    Rectangle r1;
    Rectangle r2;
    Rectangle r3;

    @Before
    public void setUp() throws Exception {
        r1 = new Rectangle(new Point(0, 1), new Point(1, 0));
        r2 = new Rectangle(new Point(0, 1), new Point(1, 0));
        r3 = new Rectangle(new Point(0, 2), new Point(2, 0));
    }

    @After
    public void tearDown() throws Exception {
        r1 = null;
        r2 = null;
        r3 = null;
        System.gc();
    }

    @Test
    public void testRectangle() {
        assert (true); // non testé ici
    }

    @Test
    public void testTranslate() {
        Point br = new Point(r1.getBotRight());
        Point tl = new Point(r1.getTopLeft());
        r1.translate(2, 3);
        assertTrue(r1.getTopLeft().x == tl.x + 2);
        assertTrue(r1.getTopLeft().y == tl.y + 3);
        assertTrue(r1.getBotRight().x == br.x + 2);
        assertTrue(r1.getBotRight().y == br.y + 3);
    }

    @Test
    public void testGetTopLeft() {
        assertEquals(true, r1.getTopLeft().equals(new Point(0, 1)));
    }

    @Test
    public void testGetBotRight() {
        assertTrue(r1.getBotRight().equals(new Point(1, 0)));
    }

    @Test
    public void testEqualsObject() {
        assertTrue(r1.equals(r2));
        assertFalse(r1.equals(r3));
    }

}