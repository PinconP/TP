package pile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MaPileEntiersTest {
    private MaPileEntiers p1;
    private MaPileEntiers p2;

    @BeforeEach
    void setUp() throws Exception {
        p1 = new MaPileEntiers(10);
        p2 = new MaPileEntiers(9);
    }

    @AfterEach
    void tearDown() throws Exception {
        p1 = null;
        p2 = null;
        System.gc();
    }

//	/**
//	 * Test method for {@link piles.MaPileEntiers#hashCode()}.
//	 */
//	@Test
//	void testHashCode() {
//		Assertions.assertEquals("HashCode erreur", 0, p1.hashCode());
//	}

    /**
     * Test method for { piles.MaPileEntiers#MaPileEntiers(int)}.
     */
    @Test
    void testMaPileEntiers() {
        Assertions.assertTrue(p1.size() == 0 && p1.capacity() == 10, "constructeur erreur");
    }

    /**
     * Test method for { piles.MaPileEntiers#add(int)}.
     */
    @Test
    void testAdd() {
        p1.add(1);
        Assertions.assertEquals(1, p1.get(), "add erreur");
    }

    /**
     * Test method for { piles.MaPileEntiers#remove()}.
     */
    @Test
    void testRemove() {
        Assertions.assertFalse(p1.remove(), "add erreur");
        p1.remove();
        Assertions.assertEquals(0, p1.size(), "add erreur");

        p1.add(1);
        p1.add(2);
        p1.remove();
        Assertions.assertEquals(1, p1.size(), "add erreur");
    }

    /**
     * Test method for { piles.MaPileEntiers#get()}.
     */
    @Test
    void testGet() {
        p1.add(1);
        Assertions.assertEquals(1, p1.get(), "get erreur");
        try {
            int v = p1.get();
        } catch (Error e) {
            System.out.println("test de get d'une pile vide doit bien générer votre Assertions.assertion");
        }
    }

    /**
     * Test method for { piles.MaPileEntiers#size()}.
     */
    @Test
    void testSize() {
        Assertions.assertEquals(0, p1.size(), "size erreur");
        p1.add(1);
        Assertions.assertEquals(1, p1.size(), "size erreur");
    }

    /**
     * Test method for { piles.MaPileEntiers#capacity()}.
     */
    @Test
    void testCapacity() {
        if (p1.capacity() != 10) {
            Assertions.fail("capacity erreur" + " p1 : " + p1 + " capacity : " + p1.capacity());
        }
        for (int i = 0; i < 5; i++) {
            p1.add(i);
        }
        if (p1.capacity() != 10)
            Assertions.fail("capacity erreur" + " p1 : " + p1 + " capacity : " + p1.capacity());
    }

    /**
     * Test method for { piles.MaPileEntiers#isFull()}.
     */
    @Test
    void testIsFull() {
        int i = 0;
        Assertions.assertFalse(p1.isFull(), "erreur isFull");
        p1.add(i++);
        while (!p1.isFull())
            p1.add(i++);
        Assertions.assertTrue(p1.isFull(), "erreur isFull");
    }

    /**
     * Test method for { piles.MaPileEntiers#isEmpty()}.
     */
    @Test
    void testIsEmpty() {
        Assertions.assertTrue(p1.isEmpty(), "Erreur isEmpty");
        p1.add(0);
        Assertions.assertFalse(p1.isEmpty(), "Erreur isEmpty");
    }

    /**
     * Test method for { piles.MaPileEntiers#equals(java.lang.Object)}.
     */
    @Test
    void testEqualsObject() {
        if (!p1.equals(p2))
            Assertions.fail("equals erreur" + " p1 : " + p1 + " p2 : " + p2);

        for (int i = 1; i < 5; i++) {
            p1.add(i);
            p2.add(i);
        }
        if (!p1.equals(p2))
            Assertions.fail("equals erreur" + " p1 : " + p1 + " p2 : " + p2);
        p2.remove();
        if (p1.equals(p2))
            Assertions.fail("equals erreur" + " p1 : " + p1 + " p2 : " + p2);
        p2.add(-1);
        if (p1.equals(p2))
            Assertions.fail("equals erreur" + " p1 : " + p1 + " p2 : " + p2);
    }

    /**
     * Test method for { piles.MaPileEntiers#toString()}.
     */
    @Test
    void testToString() {
        Assertions.assertTrue(p1.toString().equals("[]"), "toString pile vide");
        p1.add(1);
        Assertions.assertTrue(p1.toString().equals("[1]"), "toString pile avec un élément");
        p1.add(2);
        Assertions.assertTrue(p1.toString().equals("[1, 2]"), "toString pile avec 2 éléments");
    }

}