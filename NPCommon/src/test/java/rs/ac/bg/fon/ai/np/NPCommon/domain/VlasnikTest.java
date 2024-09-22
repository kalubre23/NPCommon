package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class VlasnikTest {
//	
//	Vlasnik v;
//
//	@BeforeEach
//	void setUp() throws Exception {
//		v = new Vlasnik();
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		v = null;
//	}
//
//	@Test
//	void testSetVlasnikIDManjiOd0() {
//		assertThrows(IllegalArgumentException.class, ()->v.setVlasnikID(-1));
//	}
//	
//	@Test
//	void testSetVlasnikSveOk() {
//		v.setVlasnikID(4);
//		assertEquals(4, v.getVlasnikID());
//	}
//	
//	@Test
//	void testSetImeNull() {
//		assertThrows(NullPointerException.class, ()->v.setIme(null));
//	}
//	
//	
//	@Test
//	void testSetImeOk() {
//		v.setIme("Marko");
//		assertEquals("Marko", v.getIme());
//	}
//	
//	@Test
//	void testSetPrezimeNull() {
//		assertThrows(NullPointerException.class, ()->v.setPrezime(null));
//	}
//	
//	@Test
//	void testSetPrezimePrazan() {
//		assertThrows(IllegalArgumentException.class, ()->v.setPrezime(""));
//	}
//	
//	@Test
//	void testSetPrezimeOk() {
//		v.setPrezime("Markovic");
//		assertEquals("Markovic", v.getPrezime());
//	}
//	
//	void testSetEmailNull() {
//		assertThrows(NullPointerException.class, ()->v.setEmail(null));
//	}
//	
//	@Test
//	void testSetEmailPrazan() {
//		assertThrows(IllegalArgumentException.class, ()->v.setEmail(""));
//	}
//	
//	@DisplayName ("Ovaj test proverava da li email sadrzi znakove @ i .")
//	@Test
//	void testSetEmailSpecijalniZnaci() {
//		assertThrows(IllegalArgumentException.class, ()->v.setEmail("marko@gmailcom"));
//		assertThrows(IllegalArgumentException.class, ()->v.setEmail("markogmail.com"));
//		assertThrows(IllegalArgumentException.class, ()->v.setEmail("markogmailcom"));
//	}
//	
//	@Test
//	void testSetEmailOk() {
//		v.setEmail("marko@gmail.com");
//		assertEquals("marko@gmail.com", v.getEmail());
//	}
//	
//	@Test
//	void testSetTelefonNull() {
//		assertThrows(NullPointerException.class, ()->v.setTelefon(null));
//	}
//	
//	@Test
//	void testSetTelefonPrazan() {
//		assertThrows(IllegalArgumentException.class, ()->v.setTelefon(""));
//	}
//	
//	@Test
//	void testSetTelefonOk() {
//		v.setTelefon("068543345");
//		assertEquals("068543345", v.getTelefon());
//	}
//	
//	@Test
//	void testToString() {
//		v.setIme("Ksenija");
//		v.setPrezime("Kandic");
//		v.setEmail("kena@gmail.com");
//		String toStr = v.toString();
//		assertTrue(toStr.contains("Ksenija"));
//		assertTrue(toStr.contains("Kandic"));
//		assertTrue(toStr.contains("kena@gmail.com"));
//	}
//	
//	@ParameterizedTest
//	@CsvSource ({
//		"1, 1, true",
//		"1, 2, false",
//	})
//	void testEquals(int id1, int id2,  boolean isti) {
//		v.setVlasnikID(id1);
//		
//		Vlasnik v2= new Vlasnik();
//		v2.setVlasnikID(id2);
//		
//		assertEquals(isti, v.equals(v2));
//	}
//	
//	@Test
//	void testEqualsNull() {
//		assertFalse(v.equals(null));
//	}
//	
//	@Test
//	void testEqualsIsti() {
//		assertTrue(v.equals(v));
//	}
//	
//	@Test
//	void testEqualsDrugaKlasa() {
//		assertFalse(v.equals(new RuntimeException()));
//	}

}
