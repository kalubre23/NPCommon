package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UoceniKvarTest {
	UoceniKvar uk;

	@BeforeEach
	void setUp() throws Exception {
		uk = new UoceniKvar();
	}

	@AfterEach
	void tearDown() throws Exception {
		uk = null;
	}

	@Test
	void testSetKvarIDManjiOdNula() {
		assertThrows(IllegalArgumentException.class, ()->uk.setKvarID(-1));
	}
	
	@Test
	void testSetKvarIDOk() {
		uk.setKvarID(1);
		assertEquals(1, uk.getKvarID());
	}
	
	@Test
	void testSetOpisNull() {
		assertThrows(NullPointerException.class, ()->uk.setOpis(null));
	}
	
	@Test
	void testSetOpisPrazan() {
		assertThrows(IllegalArgumentException.class, ()->uk.setOpis(""));
	}
	
	@Test
	void testSetOpisOk() {
		uk.setOpis("Kvar brisaca");
		assertEquals("Kvar brisaca", uk.getOpis());
	}
	
	@Test
	void testSetAutomobilNull() {
		assertThrows(NullPointerException.class, ()->uk.setAutomobil(null));
	}
	

	@Test
	void testSetAutomobilOk() {
		Automobil a = new Automobil();
		a.setTablice("BG123456");
		uk.setAutomobil(a);
		assertEquals(a, uk.getAutomobil());
	}
	
	@Test
	void testToString() {
		Automobil a = new Automobil();
		a.setTablice("BG123456");
		uk.setAutomobil(a);
		uk.setOpis("Kvar mjenjaca");
		assertTrue(uk.toString().toLowerCase().contains("bg123456"));
		assertTrue(uk.toString().toLowerCase().contains("kvar mjenjaca"));
	}
	
	@Test
	void testEqualsIstiAutoIKvarID() {
		Automobil a = new Automobil();
		a.setTablice("BG123456");
		uk.setAutomobil(a);
		uk.setKvarID(1);
		
		UoceniKvar uk2 = new UoceniKvar();
		uk2.setAutomobil(a);
		uk2.setKvarID(1);
		assertTrue(uk.equals(uk2));
	}
	
	@Test
	void testEqualsIstiAutoRazlicitKvarID() {
		Automobil a = new Automobil();
		a.setTablice("BG123456");
		uk.setAutomobil(a);
		uk.setKvarID(1);
		
		UoceniKvar uk2 = new UoceniKvar();
		uk2.setAutomobil(a);
		uk2.setKvarID(2);
		assertFalse(uk.equals(uk2));
	}
	
	@Test
	void testEqualsRazlicitAutoIstiKvarID() {
		Automobil a = new Automobil();
		a.setTablice("BG123456");
		uk.setAutomobil(a);
		uk.setKvarID(1);
		
		UoceniKvar uk2 = new UoceniKvar();
		Automobil a2 = new Automobil();
		a2.setTablice("BG654321");
		uk2.setAutomobil(a2);
		uk2.setKvarID(1);
		assertFalse(uk.equals(uk2));
	}
	
	@Test
	void testEqualsRazlicitAutoRazlicitKvarID() {
		Automobil a = new Automobil();
		a.setTablice("BG123456");
		uk.setAutomobil(a);
		uk.setKvarID(1);
		
		UoceniKvar uk2 = new UoceniKvar();
		Automobil a2 = new Automobil();
		a2.setTablice("BG654321");
		uk2.setAutomobil(a2);
		uk2.setKvarID(2);
		assertFalse(uk.equals(uk2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(uk.equals(null));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(uk.equals(new RuntimeException()));
	}
	
	@Test
	void testEqualsIsti() {
		Automobil a = new Automobil();
		a.setTablice("BG123123");
		uk.setAutomobil(a);
		uk.setKvarID(1);
		assertTrue(uk.equals(uk));
	}

}
