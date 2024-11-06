package se.stefan.adventure.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityMethodsTest {

    Burglar burglar= new Burglar("Tjuv", 10, 5);
    Resident resident = new Resident("Tobbe", 10, 2);


    @Test
    void testPunch() {

        resident.punch(burglar);
        Assertions.assertEquals(8, burglar.getHealth());
    }


    @Test
    void testTakeHit() {

        burglar.takeHit(8);
        Assertions.assertEquals(2, burglar.getHealth());

    }

    @Test
    void testIsConciousTrue() {

        resident = new Resident("Tobbe", 10, 8);

        Assertions.assertTrue(resident.isConscious());
    }

    @Test
    void testIsConciousFalse() {

        resident = new Resident("Tobbe", 0, 8);

        Assertions.assertFalse(resident.isConscious());
    }




}
