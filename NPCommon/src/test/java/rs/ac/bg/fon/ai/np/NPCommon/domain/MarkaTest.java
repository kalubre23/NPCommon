package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class MarkaTest {
	
	Marka m;

	@BeforeEach
	void setUp() throws Exception {
		m = new Marka();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSetNazivNull() {
		assertThrows(NullPointerException.class, ()->m.setNaziv(null));
	}
	
	@Test
	void testSetNazivPrazan() {
		assertThrows(IllegalArgumentException.class, ()->m.setNaziv(""));
	}
	
	@Test
	void testSetNazivOk() {
		m.setNaziv("Audi");
		assertEquals("Audi", m.getNaziv());
	}
	
	@Test
	void testSetMarkaIDManjiOdNula() {
		assertThrows(IllegalArgumentException.class, ()->m.setMarkaID(-1));
	}
	
	@Test
	void testSetMarkaIDOk() {
		m.setMarkaID(1);
		assertEquals(1, m.getMarkaID());
	}
	
	@Test
	void testToString() {
		m.setNaziv("Opel");
		assertTrue(m.toString().toLowerCase().contains("opel"));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"1, 1, true",
		"1, 2, false",
	})
	void testEquals(int id1, int id2,  boolean isti) {
		m.setMarkaID(id1);
		
		Marka m2 = new Marka();
		m2.setMarkaID(id2);
		
		assertEquals(isti, m.equals(m2));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(m.equals(new RuntimeException()));
	}
	
	@Test
	void testEqualsIsti() {
		assertTrue(m.equals(m));
	}

}
