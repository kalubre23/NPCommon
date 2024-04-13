/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.io.Serializable;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Predstavlja deo automobila.
 * 
 * Ima jedinstven identifikator i naziv.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class DeoAutomobila extends DomenskiObjekat implements Serializable{
	/**
	 * Jedinstven identifikator dela automobila kao int.
	 */
    private int deoID;
    /**
     * Naziv dela automobila kao string.
     */
    private String naziv;

    /**
     * Prazan konstruktor za kreiranje jedne instance dela automobila sa podrazumevanim vrednostima za njegove atribute.
     */
    public DeoAutomobila() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance dela automobila sa specificnim vrednostima za njegove atribute.
     * 
     * @param deoID - Jedinstven identifikator koji se dodeljuje instanci dela automobila pri kreiranju.
     * @param naziv - Naziv dela koji se dodeljuje instanci dela automobila pri kreiranju.
     */
    public DeoAutomobila(int deoID, String naziv) {
        this.deoID = deoID;
        this.naziv = naziv;
    }

    /**
     * Vraca naziv dela automobila.
     * @return naziv dela automobila kao string.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja novu vrednost za naziv dela automobila.
     * 
     * @param naziv kao nova vrednost atributa naziv.
     * @throws NullPointerException ako je uneta vrednost null.
     * @throws IllegalArgumentException ako je uneta vrednost prazan string.
     */
    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv dela ne moze biti null");
    	}
    	if(naziv.isEmpty()) {
    		throw new IllegalArgumentException("Naziv dela ne moze biti prazan string");
    	}
        this.naziv = naziv;
    }

    /**
     * Vraca jedinstven identifikator dela automobila.
     * @return deoID kao jednistveni identifikator dela automobila kao int.
     */
    public int getDeoID() {
        return deoID;
    }

    /**
     * Postavlja novu vrednost za jedinstveni identifikator dela automobila.
     * 
     * @param deoID kao nova vrednost atributa deoID.
     * 
     * @throws IllegalArgumentException ako je uneta vrednost manja od nule.
     */
    public void setDeoID(int deoID) {
    	if(deoID < 0)
    		throw new IllegalArgumentException("DeoID ne sme biti < 0");
        this.deoID = deoID;
    }

    /**
     * Vraca string reprezentaciju dela automobila na osnovu atributa naziv.
     * 
     * @return naziv kao string reprezentacija dela automobila.
     */
    @Override
    public String toString() {
        return this.naziv;
    }

    /**
	 * Poredi dva dela automobila prema jedinstvenom identifikatoru.
	 * 
	 * @return
	 * <ul>
	 * 		<li> true ako su jedinstveni identifikatori isti </li>
	 * 		<li> false ako je unet null, ako objekat nije klase DeoAutomobila ili ako su razliciti identifikatori </li>
	 * <ul>
	 */
    @Override
    public boolean equals(Object obj) {
    	if(obj == null)
    		return false;
        if(!(obj instanceof DeoAutomobila))
            return false;
        
        return (((DeoAutomobila)obj).getDeoID() == this.deoID);
    }

    @Override
    public String vratiNazivTabele() {
        return "deoautomobila";
    }

    @Override
    public String getKoloneZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaSelect() {
        return "deoid, naziv";
    }

    @Override
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void postaviVrednostiZaSelect(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean sadrziAutoIncrementPK() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomenskiObjekat> vratiListuSvih(ResultSet rs) {
        List<DomenskiObjekat> delovi = new ArrayList<>();
        try {
            while(rs.next()){
                DeoAutomobila d = new DeoAutomobila();
                d.setDeoID(rs.getInt(1));
                d.setNaziv(rs.getString(2));
                delovi.add(d);
            }
            return delovi;
        } catch (SQLException ex) {
            System.out.println("Nasledjena metoda vratiListuSvih(ResultSet rs) u klasi 'DeoAutomobila' pukla!");
        }
        return null;
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs, DomenskiObjekat objekat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void postaviVrednostiZaUpdate(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public String vratiUslovZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void postaviAutoIncrementPrimaryKey(int primaryKey) {
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
