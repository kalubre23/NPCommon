package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PokvareniDeoTest {
	PokvareniDeo pd;

	@BeforeEach
	void setUp() throws Exception {
		pd = new PokvareniDeo();
	}

	@AfterEach
	void tearDown() throws Exception {
		pd = null;
	}

	@Test
	void testSetUoceniKvarNull() {
		assertThrows(NullPointerException.class, ()->pd.setUoceniKvar(null));
	}
	

	@Test
	void testSetUoceniKvarOk() {
		Automobil a = new Automobil();
		a.setTablice("BG123456");
		UoceniKvar uk = new UoceniKvar();
		uk.setAutomobil(a);
		uk.setKvarID(5);
		
		pd.setUoceniKvar(uk);
		assertEquals(uk, pd.getUoceniKvar());
	}
	
	@Test
	void testSetDeoAutomobilaNull() {
		assertThrows(NullPointerException.class, ()->pd.setDeo(null));
	}
	

	@Test
	void testSetDeoAutomobilaOk() {
		DeoAutomobila deo = new DeoAutomobila();
		deo.setDeoID(7);
		
		pd.setDeo(deo);
		assertEquals(deo, pd.getDeo());
	}
	
	@Test
	void testSetCenaManjaOdNula() {
		assertThrows(IllegalArgumentException.class, ()->pd.setCena(-10));
	}
	
	@Test
	void testSetCenaOk() {
		pd.setCena(50.5);
		assertEquals(50.5, pd.getCena());
	}

	@Test
	void testToString() {
		UoceniKvar uk = new UoceniKvar();
		uk.setKvarID(2);
		pd.setUoceniKvar(uk);
		
		DeoAutomobila deo = new DeoAutomobila();
		deo.setDeoID(10);
		pd.setDeo(deo);
		
		assertTrue(pd.toString().toLowerCase().contains("2"));
		assertTrue(pd.toString().toLowerCase().contains("10"));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"4, 5, 4, 5, true",
		"4, 5, 9, 9, false",
		"4, 5, 4, 9, false",
		"4, 5, 9, 5, false",
	})
	void testEquals(int kvarid1, int deoid1, int kvarid2, int deoid2, boolean isti) {
		Automobil a = new Automobil();
		a.setTablice("BG123456");
		
		UoceniKvar uk = new UoceniKvar();
		uk.setAutomobil(a);
		uk.setKvarID(kvarid1);
		pd.setUoceniKvar(uk);
		
		DeoAutomobila deo = new DeoAutomobila();
		deo.setDeoID(deoid1);
		pd.setDeo(deo);
		
		PokvareniDeo pd2 = new PokvareniDeo();
		
		UoceniKvar uk1 = new UoceniKvar();
		uk1.setAutomobil(a);
		uk1.setKvarID(kvarid2);
		pd2.setUoceniKvar(uk1);
		
		DeoAutomobila deo2 = new DeoAutomobila();
		deo2.setDeoID(deoid2);
		pd2.setDeo(deo2);
		
		assertEquals(isti, pd.equals(pd2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(pd.equals(null));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(pd.equals(new RuntimeException()));
	}
	
	//testEqualsIsti je vec ispitana u prvom slucaju testEquals metode
}
