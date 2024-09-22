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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Predstavlja korisnika aplikacije.
 * 
 * Ima username i password pomocu kojih se loguje u sistem, ime, prezime kao i jedinstveni identifikator.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class Korisnik extends DomenskiObjekat implements Serializable {

    /**
     * Jedinstveni identifikator korisnika kao int.
     */
    private int korisnikId;
    /**
     * Ime korisnika kao string.
     */
    private String ime;
    /**
     * Prezime korisnika kao string.
     */
    private String prezime;
    /**
     * Username za login kao string.
     */
    private String username;
    /**
     * Password za login kao string.
     */
    private String password;
    /**
     * Uloga korisnika, tipa Uloga.
     * @see Uloga
     */
    private Uloga uloga;

    /**
     * Vraca ulogu korisnika.
     * @return uloga korisnika, tipa Uloga.
     * @see Uloga
     */
    public Uloga getUloga() {
        return uloga;
    }

    /**
    * Postavlja novu ulogu korisnika.
    * 
    * Uloga ne sme biti null.
    * 
    * @param uloga nova vrednost za ulogu korisnika
    * @throws NullPointerException ako se unese null vrednost
    */
    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    /**
     * Prazan konstruktor za kreiranje jedne instance korisnika sa podrazumevanim vrednostima za njegove atribute.
     */
    public Korisnik() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance korisnika sa specificnim vrednostima za sve njegove atribute.
     * 
     * @param korisnikId - Jedinstveni identifikator koji se dodeljuje instanci korisnika pri kreiranju.
     * @param ime - Ime koje se dodeljuje instanci korisnika pri kreiranju.
     * @param prezime - Prezime koje se dodeljuje instanci korisnika pri kreiranju.
     * @param username - Username koji se dodeljuje instanci korisnika pri kreiranju.
     * @param password - Password koje se dodeljuje instanci korisnika pri kreiranju.
     */
    public Korisnik(int korisnikId, String ime, String prezime,
         String username, String password, Uloga uloga) {
        setKorisnikID(korisnikId);
        setIme(ime);
        setPrezime(prezime);
        setUsername(username);
        setPassword(password);
        setUloga(uloga);
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance korisnika sa specificnim vrednostima za atribute username i password.
     * 
     * @param username - Username koji se dodeljuje instanci korisnika pri kreiranju.
     * @param password - Password koje se dodeljuje instanci korisnika pri kreiranju.
     */
    public Korisnik(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    /**
     * Vraca string reprezentaciju korisnika.
     * 
     * Sastoji se od imena i prezimena..
     * 
     * @return korisnik kao string reprezentacija korisnika u odgovarajucem formatu.
     */
    @Override
    public String toString() {
        return this.ime + " " + this.prezime;
    }

    
    /**
    * Poredi dva korisnika prema username-u i password-u.
    * 
    * 
    * @return
    * <ul>
    * 		<li> true ako je unet isti objekat ili ako su username i password isti </li>
    * 		<li> false ako je unet null, ako objekat nije klase Korisnik ili ako su razliciti username i/ili password</li>
    * <ul>
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    /**
     * Vraca jedinstveni identifikator korisnika.
     * @return korisnikId identifikator kao int.
     */
    public int getKorisnikId() {    
        return korisnikId;
    }

    /**
     * Postavlja novu vrednost za jedinstveni identifikator korisnika.
     * 
     * Jedinstveni identifikator ne sme biti manji od nule.
     * 
     * @param korisnikID kao nova vrednost identifikatora.
     * 
     * @throws IllegalArgumentException ako je uneta vrednost manja od nule.
     */
    public void setKorisnikID(int korisnikID) {
        if(korisnikID<0) {
            throw new IllegalArgumentException("korisnikID ne sme biti < 0");
        }
        this.korisnikId = korisnikID;
    }

    /**
     * Vraca ime korisnika.
     * @return ime korisnika kao string.
     */
    public String getIme() {
        return ime;
    }

    /**
    * Postavlja novu vrednost atributa ime.
    * 
    * Ime ne sme biti null niti prazan string.
    * 
    * @param ime nova vrednost za ime korisnika
    * @throws NullPointerException ako se unese null vrednost
    * @throws IllegalArgumentException ako se unese prazan string
    */
    public void setIme(String ime) {
    	if(ime == null) 
    		throw new NullPointerException("Ime korisnika ne sme biti null");
    	if(ime.isEmpty())
    		throw new IllegalArgumentException("Ime korisnika ne sme biti prazan string!");
        this.ime = ime;
    }

    /**
     * Vraca prezime korisnika.
     * @return prezime korisnika kao string.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
    * Postavlja novu vrednost atributa prezime.
    * 
    * Prezime ne sme biti null niti prazan string.
    * 
    * @param prezime nova vrednost za prezime korisnika
    * @throws NullPointerException ako se unese null vrednost
    * @throws IllegalArgumentException ako se unese prazan string
    */
    public void setPrezime(String prezime) {
    	if(prezime == null) 
    		throw new NullPointerException("Prezime korisnika ne sme biti null");
    	if(prezime.isEmpty())
    		throw new IllegalArgumentException("Prezime korisnika ne sme biti prazan string!");
        this.prezime = prezime;
    }

    /**
     * Vraca username za logovanje korisnika.
     * @return username korisnika kao string.
     */
    public String getUsername() {
        return username;
    }

    /**
    * Postavlja novu vrednost atributa username.
    * 
    * Username ne sme biti null niti prazan string.
    * 
    * @param username nova vrednost za username korisnika
    * @throws NullPointerException ako se unese null vrednost
    * @throws IllegalArgumentException ako se unese prazan string
    */
    public void setUsername(String username) {
    	if(username== null) 
    		throw new NullPointerException("Username korisnika ne sme biti null!");
    	if(username.isEmpty())
    		throw new IllegalArgumentException("Username korisnika ne sme biti prazan string");
        this.username = username;
    }

    /**
     * Vraca password za logovanje korisnika.
     * @return password korisnika kao string.
     */
    public String getPassword() {
        return password;
    }

    /**
    * Postavlja novu vrednost atributa password.
    * 
    * Password ne sme biti null niti prazan string.
    * 
    * @param password nova vrednost za password korisnika
    * @throws NullPointerException ako se unese null vrednost
    * @throws IllegalArgumentException ako se unese prazan string
    */
    public void setPassword(String password) {
    	if(password== null) 
    		throw new NullPointerException("Password korisnika ne sme biti null!");
    	if(password.isEmpty())
    		throw new IllegalArgumentException("Password korisnika ne sme biti prazan string");
        this.password = password;
    }

    @Override
    public String vratiNazivTabele() {
        return "korisnici INNER JOIN uloge ON uloge.uloga_id = korisnici.uloga_id";
    }

    @Override
    public String getKoloneZaInsert() {
        return null;
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return null;
    }

    @Override
    public String vratiVrednostiZaSelect() {
        return "korisnik_id, ime, prezime, username, uloge.uloga_id, uloge.naziv";
    }

    @Override
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
    }

    @Override
    public List<DomenskiObjekat> vratiListuSvih(ResultSet rs) {
        List<DomenskiObjekat> serviseri = new ArrayList<>();
        try {
            while(rs.next()){
                Korisnik k = new Korisnik();
                k.setKorisnikID(rs.getInt(1));
                k.setIme(rs.getString(2));
                k.setPrezime(rs.getString(3));
                k.setUsername(rs.getString(4));
                Uloga u = new Uloga(rs.getInt(5), rs.getString(6));
                k.setUloga(u);
                serviseri.add(k);
            }
            return serviseri;
        } catch (SQLException ex) {
            System.out.println("Nasledjena metoda vratiListuSvih(ResultSet rs) u klasi 'Korisnik' pukla!");
            Logger.getLogger(Marka.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return null;
    }

    @Override
    public void postaviVrednostiZaUpdate(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
    }

    

    @Override
    public String vratiUslovZaUpdate() {
        return null;
    }

    @Override
    public void postaviVrednostiZaSelect(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        statement.setString(1, ((Korisnik) domainObject).getUsername());
        statement.setString(2, ((Korisnik) domainObject).getPassword());
        statement.setString(3, ((Korisnik) domainObject).getUloga().getUloga());
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs, DomenskiObjekat objekat) {
        try {
            if (rs.next()) {
                ((Korisnik)objekat).setKorisnikID(rs.getInt("korisnik_id"));
                ((Korisnik)objekat).setIme(rs.getString("ime"));
                ((Korisnik)objekat).setPrezime(rs.getString("prezime"));

            } else {
                //ovde je pukao
                //nema takvog onda trebad a se baci exception mozda
                System.out.println("U korisniku je objekat=null");
                objekat = null;
            }
            
        } catch (SQLException ex) {
            System.out.println("vratiJednog kod Korisnik pukla");
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objekat;
    }

    @Override
    public boolean sadrziAutoIncrementPK() {
        return true;
    }

    @Override
    public void postaviAutoIncrementPrimaryKey(int primaryKey) {
        this.korisnikId = primaryKey;
    }

    @Override
    public String vratiUslovZaJednog() {
        return "username=? AND password=? AND uloge.naziv=?";
    }

    @Override
    public String vratiUslovZaVise() {
        return "uloge.naziv='serviser'";
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
