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
 *
 * @author Asus
 */
public class Vlasnik extends DomenskiObjekat implements Serializable {

    private int vlasnikID;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;

    public Vlasnik() {
    }

    public Vlasnik(int vlasnikID, String ime, String prezime, String email, String telefon) {
        this.vlasnikID = vlasnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
    }

    public int getVlasnikID() {
        return vlasnikID;
    }

    public void setVlasnikID(int vlasnikID) {
        if (vlasnikID < 0) {
            throw new IllegalArgumentException("VlasnikID ne sme biti manji od 0!");
        }
        this.vlasnikID = vlasnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        if (ime == null) {
            throw new NullPointerException("Ime ne sme biti null!");
        }
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        if (prezime == null) {
            throw new NullPointerException("Prezime ne sme biti null!");
        }
        if (prezime.isEmpty()) {
            throw new IllegalArgumentException("Prezime ne sme biti prazan string!");
        }
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        if (telefon == null) {
            throw new NullPointerException("Telefon ne sme biti null!");
        }
        if (telefon.isEmpty()) {
            throw new IllegalArgumentException("Telefon ne sme biti prazan string!");
        }
        
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return this.ime + " " + this.prezime + ", " + this.email;
    }

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
