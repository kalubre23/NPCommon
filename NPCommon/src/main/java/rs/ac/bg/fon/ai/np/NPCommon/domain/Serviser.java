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

/**
 *
 * @author Cartman
 */
public class Serviser extends DomenskiObjekat implements Serializable {

    private int serviserID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Serviser() {
    }

    public Serviser(int serviserID, String ime, String prezime,
         String username, String password) {
        this.serviserID = serviserID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public Serviser(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    public int getServiserID() {
        return serviserID;
    }

    public void setServiserID(int serviserID) {
    	if(serviserID<0) {
    		throw new IllegalArgumentException("serviserID ne sme biti < 0");
    	}
        this.serviserID = serviserID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
    	if(ime == null) 
    		throw new NullPointerException("Ime servisera ne sme biti null");
    	if(ime.isEmpty())
    		throw new IllegalArgumentException("Ime servisera ne sme biti prazan string!");
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
    	if(prezime == null) 
    		throw new NullPointerException("Prezime servisera ne sme biti null");
    	if(prezime.isEmpty())
    		throw new IllegalArgumentException("Prezime servisera ne sme biti prazan string!");
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
    	if(username== null) 
    		throw new NullPointerException("Username servisera ne sme biti null!");
    	if(username.isEmpty())
    		throw new IllegalArgumentException("Username servisera ne sme biti prazan string");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

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
