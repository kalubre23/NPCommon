package rs.ac.bg.fon.ai.np.NPCommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NalogZaServisiranjeTest {
	NalogZaServisiranje n;

	@BeforeEach
	void setUp() throws Exception {
		n = new NalogZaServisiranje();
	}

	@AfterEach
	void tearDown() throws Exception {
		n=null;
	}

	@Test
	void testSetServiserNull() {
		assertThrows(NullPointerException.class, ()->n.setServiser(null));
	}
	

	@Test
	void testSetServiserOk() {
		Korisnik s = new Korisnik();
		s.setUsername("luka123");
		s.setPassword("Luka12345.");
		n.setServiser(s);
		assertEquals(s, n.getServiser());
	}
	
	@Test
	void testSetKvarNull() {
		assertThrows(NullPointerException.class, ()->n.setKvar(null));
	}
	

	@Test
	void testSetKvarOk() {
		UoceniKvar uk = new UoceniKvar();
		Automobil a = new Automobil();
		a.setTablice("BG123456");
		uk.setAutomobil(a);
		uk.setKvarID(1);
		
		n.setKvar(uk);
		assertEquals(uk, n.getKvar());
	}
	
	@Test
	void testSetNalogIDManjiOdNula() {
		assertThrows(IllegalArgumentException.class, ()->n.setNalogID(-1));
	}
	
	@Test
	void testSetNalogIDOk() {
		n.setNalogID(1);
		assertEquals(1, n.getNalogID());
	}
	
	@Test
	void testSetDatumKreiranjaNull() {
		assertThrows(NullPointerException.class, ()->n.setDatumKreiranja(null));
	}
	
	@Test
	@DisplayName ("Testira da li je uneseni datum kreiranja u buducnosti")
	void testSetDatumKreiranjaBuducnost() {
		assertThrows(IllegalArgumentException.class, ()->n.setDatumKreiranja(LocalDate.of(2033, 6, 27)));
	}
        
        @Test
	void testSetDatumKreiranjaOk() {
            n.setDatumKreiranja(LocalDate.of(2024, 2, 2));
            assertEquals(LocalDate.of(2024, 2, 2), n.getDatumKreiranja());

	}
        
        @Test
	@DisplayName ("Testira da li je uneseni datum izvrsenja u buducnosti")
	void testSetDatumIzvrsenjaBuducnost() {
            assertThrows(IllegalArgumentException.class, ()->n.setDatumIzvrsenja(LocalDate.of(2033, 6, 27)));
	}
        
        @Test
	void testSetDatumIzvrsenjaOk() {
            n.setDatumIzvrsenja(LocalDate.of(2024, 3, 2));
            assertEquals(LocalDate.of(2024, 3, 2), n.getDatumIzvrsenja());

	}
	
	@Test
	void testSetCenaManjaOdNula() {
		assertThrows(IllegalArgumentException.class, ()->n.setCena(-10));
	}
        
        @Test
        void testStatusNije1ni0(){
            assertThrows(IllegalArgumentException.class, ()->n.setStatus((short)5));
        }
        
        @Test
        void testStatusOk1(){
            n.setStatus((short)1);
            assertEquals((short)1, n.getStatus());
        }
        
        @Test
        void testStatusOk0(){
            n.setStatus((short)0);
            assertEquals((short)0, n.getStatus());
        }
	
	@Test
	void testSetCenaOk() {
		n.setCena(50.5);
		assertEquals(50.5, n.getCena());
	}
	
	@Test
	void testToString() {
		n.setNalogID(1);
		n.setCena(420);
		assertTrue(n.toString().toLowerCase().contains("1"));
		assertTrue(n.toString().toLowerCase().contains("420"));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"1, 1, true",
		"1, 2, false",
	})
	void testEquals(int id1, int id2,  boolean isti) {
		n.setNalogID(id1);
		
		NalogZaServisiranje n2 = new NalogZaServisiranje();
		n2.setNalogID(id2);
		
		assertEquals(isti, n.equals(n2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(n.equals(null));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(n.equals(new RuntimeException()));
	}
	
	@Test
	void testEqualsIsti() {
		n.setNalogID(1);
		assertTrue(n.equals(n));
	}

}
