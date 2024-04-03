package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutomobilTest {
	Automobil a;

	@BeforeEach
	void setUp() throws Exception {
		a = new Automobil();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	void testSetTabliceNull() {
		assertThrows(NullPointerException.class, ()->a.setTablice(null));
	}
	
	@Test
	void testSetTabliceOk() {
		a.setTablice("BG555333");
		assertEquals("BG555333", a.getTablice());
	}
	
	@Test
	void testSetImePrezimeVlasnikaNull() {
		assertThrows(NullPointerException.class, ()->a.setImePrezimeVlasnika(null));
	}
	
	@Test
	void testSetImePrezimeVlasnikaOk() {
		a.setImePrezimeVlasnika("Marko Markovic");
		assertEquals("Marko Markovic", a.getImePrezimeVlasnika());
	}
	
	@Test
	void testSetGodisteManjeOd1900() {
		assertThrows(IllegalArgumentException.class, ()->a.setGodiste(1899));
	}
	
	@Test
	void testSetGodisteOk() {
		a.setGodiste(2001);
		assertEquals(2001, a.getGodiste());
	}
	
	@Test
	void testSetMarkaNull() {
		assertThrows(NullPointerException.class, ()->a.setMarka(null));
	}
	

	@Test
	void testSetMarkaOk() {
		Marka m = new Marka();
		m.setMarkaID(2);
		a.setMarka(m);
		
		assertEquals(m, a.getMarka());
	}
	
	@Test
	void testSetUoceniKvaroviNull() {
		assertThrows(NullPointerException.class, ()->a.setUoceniKvarovi(null));
	}
	

	@Test
	void testSetUoceniKvaroviOk() {
		UoceniKvar uk1 = new UoceniKvar();
		UoceniKvar uk2 = new UoceniKvar();
		UoceniKvar uk3 = new UoceniKvar();
		
		List<UoceniKvar> uoceniKvarovi = new ArrayList<>();
		uoceniKvarovi.add(uk1);
		uoceniKvarovi.add(uk2);
		uoceniKvarovi.add(uk3);
		
		a.setUoceniKvarovi(uoceniKvarovi);
		assertEquals(uoceniKvarovi, a.getUoceniKvarovi());
	}
	
	@Test
	void testToString() {
		a.setTablice("BG123123");
		a.setImePrezimeVlasnika("Marko Markovic");
		Marka m = new Marka();
		m.setNaziv("Opel");
		a.setMarka(m);
		
		assertTrue(a.toString().toLowerCase().contains("bg123123"));
		assertTrue(a.toString().toLowerCase().contains("marko markovic"));
		assertTrue(a.toString().toLowerCase().contains("opel"));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"BG123123, BG123123, true",
		"BG123123, PV999111, false",
	})
	void testEquals(String tablice1, String tablice2,  boolean isti) {
		a.setTablice(tablice1);
		
		Automobil a2 = new Automobil();
		a2.setTablice(tablice2);
		
		assertEquals(isti, a.equals(a2));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(a.equals(new RuntimeException()));
	}
	
	@Test
	void testEqualsIsti() {
		a.setTablice("BG123123");
		assertTrue(a.equals(a));
	}
	
	

}
