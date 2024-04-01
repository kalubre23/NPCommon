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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Marka extends DomenskiObjekat implements Serializable{
    private int markaID;
    private String naziv;

    public Marka() {
    }

    public Marka(int markaID, String naziv) {
        this.markaID = markaID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getMarkaID() {
        return markaID;
    }

    public void setMarkaID(int markaID) {
        this.markaID = markaID;
    }

    @Override
    public String toString() {
        return this.naziv;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Marka))
            return false;
       
        Marka other =(Marka)obj;
        return other.getMarkaID() == this.markaID;
        
    }
    
    

    @Override
    public String vratiNazivTabele() {
        return "marka";
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
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {}

    @Override
    public List<DomenskiObjekat> vratiListuSvih(ResultSet rs) {
        List<DomenskiObjekat> marke = new ArrayList<>();
        try {
            while(rs.next()){
                Marka m = new Marka();
                m.setMarkaID(rs.getInt(1));
                m.setNaziv(rs.getString(2));
                marke.add(m);
            }
            //mislim da ovde ne treba rs.close vec ce to u dbbr
            return marke;
        } catch (SQLException ex) {
            System.out.println("Nasledjena metoda vratiListuSvih(ResultSet rs) u klasi 'Marka' pukla!");
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
    public String vratiVrednostiZaSelect() {
        return "markaid, naziv";
    }

    @Override
    public void postaviVrednostiZaSelect(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs, DomenskiObjekat objekat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean sadrziAutoIncrementPK() {
        return true;
    }

    @Override
    public void postaviAutoIncrementPrimaryKey(int primaryKey) {
        this.markaID = primaryKey;
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
