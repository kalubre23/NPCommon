/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.RowSetReader;

/**
 * Predstavlja servisera koji radi u auto servisu.
 * 
 * Ima username i password pomocu kojih se loguje u sistem, ime, prezime kao i jedinstveni identifikator.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class Serviser extends DomenskiObjekat implements Serializable {

	/**
	 * Jedinstveni identifikator servisera kao int.
	 */
    private int serviserID;
    /**
     * Ime servisera kao string.
     */
    private String ime;
    /**
     * Prezime servisera kao string.
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
     * Prazan konstruktor za kreiranje jedne instance servisera sa podrazumevanim vrednostima za njegove atribute.
     */
    public Serviser() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance servisera sa specificnim vrednostima za sve njegove atribute.
     * 
     * @param serviserID - Jedinstveni identifikator koji se dodeljuje instanci servisera pri kreiranju.
     * @param ime - Ime koje se dodeljuje instanci servisera pri kreiranju.
     * @param prezime - Prezime koje se dodeljuje instanci servisera pri kreiranju.
     * @param username - Username koji se dodeljuje instanci servisera pri kreiranju.
     * @param password - Password koje se dodeljuje instanci servisera pri kreiranju.
     */
    public Serviser(int serviserID, String ime, String prezime,
         String username, String password) {
        setServiserID(serviserID);
        setIme(ime);
        setPrezime(prezime);
        setUsername(username);
        setPassword(password);
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance servisera sa specificnim vrednostima za atribute username i password.
     * 
     * @param username - Username koji se dodeljuje instanci servisera pri kreiranju.
     * @param password - Password koje se dodeljuje instanci servisera pri kreiranju.
     */
    public Serviser(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    /**
     * Vraca string reprezentaciju servisera.
     * 
     * Sastoji se od jedinstvenog identifikatora, imena, prezimena, username-a i sifre.
     * 
     * @return serviser kao string reprezentacija servisera u odgovarajucem formatu.
     */
    @Override
    public String toString() {
        return "Serviser{" + "serviserID: " + serviserID + ", ime: " + ime + ", prezime: " + prezime + ", username: " + username + ", password: " + password + '}';
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 23 * hash + Objects.hashCode(this.serviserID);
//        hash = 23 * hash + Objects.hashCode(this.ime);
//        hash = 23 * hash + Objects.hashCode(this.prezime);
//        hash = 23 * hash + Objects.hashCode(this.username);
//        hash = 23 * hash + Objects.hashCode(this.password);
//        return hash;
//    }
    
    /**
	 * Poredi dva servisera prema username-u i password-u.
	 * 
	 * 
	 * @return
	 * <ul>
	 * 		<li> true ako je unet isti objekat ili ako su username i password isti </li>
	 * 		<li> false ako je unet null, ako objekat nije klase Serviser ili ako su razliciti username i/ili password</li>
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
        final Serviser other = (Serviser) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    /**
     * Vraca jedinstveni identifikator servisera.
     * @return serviserID identifikator kao int.
     */
    public int getServiserID() {
        return serviserID;
    }

    /**
     * Postavlja novu vrednost za jedinstveni identifikator servisera.
     * 
     * Jedinstveni identifikator ne sme biti manji od nule.
     * 
     * @param serviserID kao nova vrednost identifikatora.
     * 
     * @throws IllegalArgumentException ako je uneta vrednost manja od nule.
     */
    public void setServiserID(int serviserID) {
    	if(serviserID<0) {
    		throw new IllegalArgumentException("serviserID ne sme biti < 0");
    	}
        this.serviserID = serviserID;
    }

    /**
     * Vraca ime servisera.
     * @return ime servisera kao string.
     */
    public String getIme() {
        return ime;
    }

    /**
	 * Postavlja novu vrednost atributa ime.
	 * 
	 * Ime ne sme biti null niti prazan string.
	 * 
	 * @param ime nova vrednost za ime servisera
	 * @throws NullPointerException ako se unese null vrednost
	 * @throws IllegalArgumentException ako se unese prazan string
	 */
    public void setIme(String ime) {
    	if(ime == null) 
    		throw new NullPointerException("Ime servisera ne sme biti null");
    	if(ime.isEmpty())
    		throw new IllegalArgumentException("Ime servisera ne sme biti prazan string!");
        this.ime = ime;
    }

    /**
     * Vraca prezime servisera.
     * @return prezime servisera kao string.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
	 * Postavlja novu vrednost atributa prezime.
	 * 
	 * Prezime ne sme biti null niti prazan string.
	 * 
	 * @param prezime nova vrednost za prezime servisera
	 * @throws NullPointerException ako se unese null vrednost
	 * @throws IllegalArgumentException ako se unese prazan string
	 */
    public void setPrezime(String prezime) {
    	if(prezime == null) 
    		throw new NullPointerException("Prezime servisera ne sme biti null");
    	if(prezime.isEmpty())
    		throw new IllegalArgumentException("Prezime servisera ne sme biti prazan string!");
        this.prezime = prezime;
    }

    /**
     * Vraca username za logovanje servisera.
     * @return username servisera kao string.
     */
    public String getUsername() {
        return username;
    }

    /**
	 * Postavlja novu vrednost atributa username.
	 * 
	 * Username ne sme biti null niti prazan string.
	 * 
	 * @param username nova vrednost za username servisera
	 * @throws NullPointerException ako se unese null vrednost
	 * @throws IllegalArgumentException ako se unese prazan string
	 */
    public void setUsername(String username) {
    	if(username== null) 
    		throw new NullPointerException("Username servisera ne sme biti null!");
    	if(username.isEmpty())
    		throw new IllegalArgumentException("Username servisera ne sme biti prazan string");
        this.username = username;
    }

    /**
     * Vraca password za logovanje servisera.
     * @return password servisera kao string.
     */
    public String getPassword() {
        return password;
    }

    /**
	 * Postavlja novu vrednost atributa password.
	 * 
	 * Password ne sme biti null niti prazan string.
	 * 
	 * @param password nova vrednost za password servisera
	 * @throws NullPointerException ako se unese null vrednost
	 * @throws IllegalArgumentException ako se unese prazan string
	 */
    public void setPassword(String password) {
    	if(password== null) 
    		throw new NullPointerException("Password servisera ne sme biti null!");
    	if(password.isEmpty())
    		throw new IllegalArgumentException("Password servisera ne sme biti prazan string");
        this.password = password;
    }

    @Override
    public String vratiNazivTabele() {
        return "serviseri";
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
        return "serviserid, ime, prezime, username, password";
    }

    @Override
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
    }

    @Override
    public List<DomenskiObjekat> vratiListuSvih(ResultSet rs) {
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
        statement.setString(1, ((Serviser) domainObject).getUsername());
        statement.setString(2, ((Serviser) domainObject).getPassword());
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs, DomenskiObjekat objekat) {
        try {
            if (rs.next()) {
                ((Serviser)objekat).setServiserID(rs.getInt("serviserid"));
                ((Serviser)objekat).setIme(rs.getString("ime"));
                ((Serviser)objekat).setPrezime(rs.getString("prezime"));
            } else {
                //ovde je pukao
                //nema takvog onda trebad a se baci exception mozda
                System.out.println("U serviseru je objekat=null");
                objekat = null;
            }
            
        } catch (SQLException ex) {
            System.out.println("vratiJednog kod Serviser pukla");
            Logger.getLogger(Serviser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objekat;
    }

    @Override
    public boolean sadrziAutoIncrementPK() {
        return true;
    }

    @Override
    public void postaviAutoIncrementPrimaryKey(int primaryKey) {
        this.serviserID = primaryKey;
    }

    @Override
    public String vratiUslovZaJednog() {
        return "username=? AND password=?";
    }

    @Override
    public String vratiUslovZaVise() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
