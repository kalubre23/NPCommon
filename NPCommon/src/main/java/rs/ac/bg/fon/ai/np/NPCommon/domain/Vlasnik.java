/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Prestavlja vlasnik automobila.
 * 
 * Ime jedinstven identifikator, ime, prezime, email i telefon.
 * 
 * @author Luka Obrenic
 * @since 1.1.0
 */
public class Vlasnik extends DomenskiObjekat implements Serializable {

	/**
	 * Jedinstven idefntifikator vlasnika automobila kao int.
	 */
    private int vlasnikID;
    /**
     * Ime vlasnika kao string.
     */
    private String ime;
    /**
     * Prezime vlasnika kao string.
     */
    private String prezime;
    /**
     * Email vlasnika kao string.
     */
    private String email;
    /**
     * Telefon vlasnika kao string.
     */
    private String telefon;

    /**
     * Prazan konstruktor za kreiranje jedne instance vlasnika sa podrazumevanim vrednostima za njegove atribute.
     */
    public Vlasnik() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance vlasnika sa specificnim vrednostima za njegove atribute.
     * 
     * @param vlasnikID - Jedinstevni identifikator vlasnika koji se dodeljuje instanci automobila pri kreiranju.
     * @param ime - Ime vlasnika koje se dodeljuje instanci automobila pri kreiranju.
     * @param prezime - Prezime vlasnika koje se dodeljuje instanci automobila pri kreiranju.
     * @param email - Email vlasnika koji se dodeljuje instanci automobila pri kreiranju.
     * @param telefon - Telefon vlasnika koji se dodeljuje instanci automobila pri kreiranju.
     */
    public Vlasnik(int vlasnikID, String ime, String prezime, String email, String telefon) {
        setVlasnikID(vlasnikID);
        setIme(ime);
        setPrezime(prezime);
        setEmail(email);
        setTelefon(telefon);
    }

    /**
     * Vraca jedinstveni identifikator vlasnika.
     * @return vlasnikID kao int.
     */
    public int getVlasnikID() {
        return vlasnikID;
    }

    /**
     * Postavlja novu vrednost za jedinstveni indetifikator vlasnika.
     * 
     * Ne sme biti manja od nule.
     * 
     * @param vlasnikID kao nova vrednost za jedinstveni identifikator, kao int
     * @throws IllegalArgumentException ako je uneta vrednost manja od nule
     */
    public void setVlasnikID(int vlasnikID) {
        if (vlasnikID < 0) {
            throw new IllegalArgumentException("VlasnikID ne sme biti manji od 0!");
        }
        this.vlasnikID = vlasnikID;
    }

    /**
     * Vraca ime vlasnika.
     * @return ime vlasnika kao string.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja novu vrednost za ime vlasnika.
     * 
     * Ne sme biti null.
     * 
     * @param ime kao nova vrednost za ime vlasnika, kao string
     * @throws IllegalArgumentException ako je uneta vrednost null
     */
    public void setIme(String ime) {
        if (ime == null) {
            throw new NullPointerException("Ime ne sme biti null!");
        }
        this.ime = ime;
    }

    /**
     * Vraca prezime vlasnika.
     * @return prezime vlasnika kao string.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja novu vrednost za prezime vlasnika.
     * 
     * Ne sme biti null niti prazan string.
     * 
     * @param prezime kao nova vrednost za prezime vlasnika, kao string
     * @throws IllegalArgumentException ako je unet prazan string
     * @throws NullPointerException ako je uneta vrednost null
     */
    public void setPrezime(String prezime) {
        if (prezime == null) {
            throw new NullPointerException("Prezime ne sme biti null!");
        }
        if (prezime.isEmpty()) {
            throw new IllegalArgumentException("Prezime ne sme biti prazan string!");
        }
        this.prezime = prezime;
    }

    /**
     * Vraca email vlasnika.
     * @return email vlasnika kao string.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja novu vrednost za email vlasnika.
     * 
     * Ne sme biti null, prazan string i mora sadrzati znakove '@' i '.'.
     * 
     * @param email kao nova vrednost za email vlasnika, kao string
     * @throws IllegalArgumentException ako je unet prazan string ili email ne sadrzi znakove '@' i '.'
     * @throws NullPointerException ako je uneta vrednost null
     * 
     */
    public void setEmail(String email) {
        if (email == null) {
            throw new NullPointerException("Email ne sme biti null!");
        }
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email sme biti prazan string!");
        }
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email mora da sadrzi @ i tacku");
        }
        this.email = email;
    }

    /**
     * Vraca telefon vlasnika.
     * @return telefon vlasnika kao string.
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Postavlja novu vrednost za telefon vlasnika.
     * 
     * Ne sme biti null niti prazan string.
     * 
     * @param telefon kao nova vrednost za telefon vlasnika, kao string
     * @throws IllegalArgumentException ako je unet prazan string
     * @throws NullPointerException ako je uneta vrednost null
     */
    public void setTelefon(String telefon) {
        if (telefon == null) {
            throw new NullPointerException("Telefon ne sme biti null!");
        }
        if (telefon.isEmpty()) {
            throw new IllegalArgumentException("Telefon ne sme biti prazan string!");
        }
        
        this.telefon = telefon;
    }

    /**
     * Vraca string reprezentaciju vlasnika na osnovu imena, prezimena i email-a.
     * 
     * @return vlasnik kao string reprezentacija vlasnika u odgovarajucem formatu.
     */
    @Override
    public String toString() {
        return this.ime + " " + this.prezime + ", " + this.email;
    }

    /**
	 * Poredi dva vlasnika prema jedinstvenom identifikatoru.
	 * 
	 * 
	 * @return
	 * <ul>
	 * 		<li> true ako je unet isti objekat ili ako je jedinstveni identifikator isti </li>
	 * 		<li> false ako je unet null, ako objekat nije klase Vlasnik ili ako su razliciti jedinstveni identifikatori</li>
	 * <ul>
	 */
    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        
        return ((Vlasnik)obj).getVlasnikID() == this.vlasnikID;
    }

    @Override
    public String vratiNazivTabele() {
        return "vlasnik ";
    }

    @Override
    public String getKoloneZaInsert() {
        return "ime, prezime, email, telefon";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "?,?,?,?";
    }

    @Override
    public String vratiVrednostiZaSelect() {
        return "vlasnikid, ime, prezime, email, telefon";
    }

    @Override
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        statement.setString(1, ((Vlasnik) domainObject).getIme());
        statement.setString(2, ((Vlasnik) domainObject).getPrezime());
        statement.setString(3, ((Vlasnik) domainObject).getEmail());
        statement.setString(4, ((Vlasnik) domainObject).getTelefon());
    }

    @Override
    public void postaviVrednostiZaSelect(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean sadrziAutoIncrementPK() {
        return true;
    }

    @Override
    public List<DomenskiObjekat> vratiListuSvih(ResultSet rs) {
        List<DomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                System.out.println("Usao je u while petlju!");
                Vlasnik vlasnik = new Vlasnik(rs.getInt("vlasnikid"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("telefon"));
                lista.add(vlasnik);
                System.out.println(vlasnik);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("GRESKA u vratiListuSvih KOD Vlasnika");
        }
        return null;
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs, DomenskiObjekat objekat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "ime=?, prezime=?, email=?, telefon=?";
    }

    @Override
    public void postaviVrednostiZaUpdate(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        statement.setString(1, ((Vlasnik)domainObject).getIme());
        statement.setString(2, ((Vlasnik)domainObject).getPrezime());
        statement.setString(3, ((Vlasnik)domainObject).getEmail());
        statement.setString(4, ((Vlasnik)domainObject).getTelefon());
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaVise() {
        return "LOWER(ime) LIKE '" + this.ime + "%'";
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "vlasnikid="+this.vlasnikID;
    }

    @Override
    public void postaviAutoIncrementPrimaryKey(int primaryKey) {
        this.vlasnikID = primaryKey;
    }

    @Override
    public DomenskiObjekat vratiVezaniObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaVezani() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void napuni(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
