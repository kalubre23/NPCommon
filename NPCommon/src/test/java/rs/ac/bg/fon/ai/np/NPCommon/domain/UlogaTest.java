/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Asus
 */
public class UlogaTest {
    
    Uloga u;
    
    @BeforeEach
    public void setUp() {
        u = new Uloga();
    }
    
    @AfterEach
    public void tearDown() {
        u = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    void testSetUlogaIdNije1ni2() {
        assertThrows(IllegalArgumentException.class, ()->u.setUlogaId(3));
    }
    
    @Test
    void testSetUlogaIdOk() {
        u.setUlogaId(1);
        assertEquals(1, u.getUlogaId());
        
        u.setUlogaId(2);
        assertEquals(2, u.getUlogaId());
    }
    
    @Test
    void testSetUlogaNull() {
        assertThrows(NullPointerException.class, ()->u.setUloga(null));
    }
    
    @Test
    void testSetUlogaNijeAdminNiServiser() {
        assertThrows(IllegalArgumentException.class, ()->u.setUloga(""));
        assertThrows(IllegalArgumentException.class, ()->u.setUloga("ADMIN"));
        assertThrows(IllegalArgumentException.class, ()->u.setUloga("drvoseca"));
    }
    
    @Test
    void testSetUlogaOk() {
        u.setUloga("admin");
        assertEquals("admin", u.getUloga());
        u.setUloga("serviser");
        assertEquals("serviser", u.getUloga());
    }
    
    @Test
    void testToString() {
        u.setUloga("serviser");
        assertTrue(u.toString().toLowerCase().contains("serviser"));
    }
    
    @ParameterizedTest
    @CsvSource ({
            "1, 1, true",
            "1, 2, false",
    })
    void testEquals(int id1, int id2,  boolean isti) {
        u.setUlogaId(id1);

        Uloga u2 = new Uloga();
        u2.setUlogaId(id2);

        assertEquals(isti, u.equals(u2));
    }

    @Test
    void testEqualsNull() {
        assertFalse(u.equals(null));
    }

    @Test
    void testEqualsDrugaKlasa() {
        assertFalse(u.equals(new RuntimeException()));
    }

    @Test
    void testEqualsIsti() {
        assertTrue(u.equals(u));
    }
    
}
