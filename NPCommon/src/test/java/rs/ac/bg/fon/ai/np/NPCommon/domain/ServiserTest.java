package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class ServiserTest {
	Korisnik s;

	@BeforeEach
	void setUp() throws Exception {
		s = new Korisnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	@Test
	void testSetServiserIDManjiOdNula() {
		assertThrows(IllegalArgumentException.class, ()->s.setServiserID(-1));
	}
	
	@Test
	void testSetMarkaIDOk() {
		s.setServiserID(1);
		assertEquals(1, s.getServiserID());
	}
	
	@Test
	void testSetImeNull() {
		assertThrows(NullPointerException.class, ()->s.setIme(null));
	}
	
	@Test
	void testSetImePrazan() {
		assertThrows(IllegalArgumentException.class, ()->s.setIme(""));
	}
	
	@Test
	void testSetImeOk() {
		s.setIme("Marko");
		assertEquals("Marko", s.getIme());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(NullPointerException.class, ()->s.setPrezime(null));
	}
	
	@Test
	void testSetPrezimePrazan() {
		assertThrows(IllegalArgumentException.class, ()->s.setPrezime(""));
	}
	
	@Test
	void testSetPrezimeOk() {
		s.setPrezime("Markovic");
		assertEquals("Markovic", s.getPrezime());
	}
	
	@Test
	void testSetUsernameNull() {
		assertThrows(NullPointerException.class, ()->s.setUsername(null));
	}
	
	@Test
	void testSetUsernamePrazan() {
		assertThrows(IllegalArgumentException.class, ()->s.setUsername(""));
	}
	
	@Test
	void testSetUsernameOk() {
		s.setUsername("marko123");
		assertEquals("marko123", s.getUsername());
	}
	
	@Test
	void testSetPasswordNull() {
		assertThrows(NullPointerException.class, ()->s.setPassword(null));
	}
	
	@Test
	void testSetPasswordPrazan() {
		assertThrows(IllegalArgumentException.class, ()->s.setPassword(""));
	}
	
	@Test
	void testSetPasswordOk() {
		s.setPassword("Password123.");
		assertEquals("Password123.", s.getPassword());
	}
	
	
	@Test
	void testToString() {
		s.setUsername("luka123");
		s.setPassword("Luka12345@");
		s.setIme("Luka");
		s.setPrezime("Lukic");
		String toStr = s.toString();
		assertTrue(toStr.contains("luka123"));
		assertTrue(toStr.contains("Luka12345@"));
		assertTrue(toStr.contains("Luka"));
		assertTrue(toStr.contains("Lukic"));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"luka123, luka12345, luka123, luka12345, true",
		"luka123, luka12345, marko123, marko12345, false",
		"luka123, luka12345, luka123, marko12345, false",
		"luka123, luka12345, marko123, luka12345, false",
	})
	void testEquals(String username1, String pass1, String username2, String pass2, boolean isti) {
		s.setUsername(username1);
		s.setPassword(pass1);
		
		Korisnik s2 = new Korisnik();
		s2.setUsername(username2);
		s2.setPassword(pass2);
		
		assertEquals(isti, s.equals(s2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(s.equals(null));
	}
	
	@Test
	void testEqualsIsti() {
		assertTrue(s.equals(s));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(s.equals(new RuntimeException()));
	}
	
}
