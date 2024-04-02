package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DeoAutomobilaTest {
	
	DeoAutomobila deo;

	@BeforeEach
	void setUp() throws Exception {
		deo = new DeoAutomobila();
	}

	@AfterEach
	void tearDown() throws Exception {
		deo = null;
	}

	@Test
	void testSetNazivNull() {
		assertThrows(NullPointerException.class, ()->deo.setNaziv(null));
	}
	
	@Test
	void testSetNazivPrazan() {
		assertThrows(IllegalArgumentException.class, ()->deo.setNaziv(""));
	}
	
	@Test
	void testSetNazivOk() {
		deo.setNaziv("Sofersajbna");
		assertEquals("Sofersajbna", deo.getNaziv());
	}
	
	@Test
	void testSetDeoIDManjiOdNula() {
		assertThrows(IllegalArgumentException.class, ()->deo.setDeoID(-1));
	}
	
	@Test
	void testSetDeoIDOk() {
		deo.setDeoID(1);
		assertEquals(1, deo.getDeoID());
	}
	
	@Test
	void testToString() {
		deo.setNaziv("Kvacilo");
		assertTrue(deo.toString().toLowerCase().contains("kvacilo"));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"1, 1, true",
		"1, 2, false",
	})
	void testEquals(int id1, int id2,  boolean isti) {
		deo.setDeoID(id1);
		
		DeoAutomobila deo2 = new DeoAutomobila();
		deo2.setDeoID(id2);
		
		assertEquals(isti, deo.equals(deo2));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(deo.equals(new RuntimeException()));
	}
	
	@Test
	void testEqualsIsti() {
		assertTrue(deo.equals(deo));
	}

}
