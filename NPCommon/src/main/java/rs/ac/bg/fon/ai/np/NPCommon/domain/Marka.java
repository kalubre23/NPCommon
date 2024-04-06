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
 * Predstavlja marku automobila.
 * 
 * Ima jedinstven identifikator i naziv.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class Marka extends DomenskiObjekat implements Serializable{
	/**
	 * Jedinstven identifikator marke automobila kao int.
	 */
    private int markaID;
    /**
     * Naziv marke automobila kao string.
     */
    private String naziv;

    /**
     * Prazan konstruktor za kreiranje jedne instance marke automobila sa podrazumevanim vrednostima za njegove atribute.
     */
    public Marka() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance marke automobila sa specificnim vrednostima za njegove atribute.
     * 
     * @param markaID - Jedinstven identifikator koji se dodeljuje instanci marke automobila pri kreiranju.
     * @param naziv - Naziv marke koji se dodeljuje instanci marke automobila pri kreiranju.
     */
    public Marka(int markaID, String naziv) {
        this.markaID = markaID;
        this.naziv = naziv;
    }

    /**
     * Vraca naziv marke automobila.
     * @return naziv marke automobila kao string.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja novu vrednost za naziv marke automobila.
     * 
     * @param naziv kao nova vrednost atributa naziv.
     * @throws NullPointerException ako je uneta vrednost null.
     * @throws IllegalArgumentException ako je uneta vrednost prazan string.
     */
    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv marke ne moze biti null");
    	}
    	if(naziv.isEmpty()) {
    		throw new IllegalArgumentException("Naziv marke ne moze biti prazan string");
    	}
        this.naziv = naziv;
    }

    /**
     * Vraca jedinstven identifikator marke automobila.
     * @return markaID kao jednistveni identifikator marke automobila kao int.
     */
    public int getMarkaID() {
        return markaID;
    }

    /**
     * Postavlja novu vrednost za jedinstveni identifikator marke automobila.
     * 
     * @param markaID kao nova vrednost atributa markaID.
     * 
     * @throws IllegalArgumentException ako je uneta vrednost manja od nule.
     */
    public void setMarkaID(int markaID) {
    	if(markaID<0)
    		throw new IllegalArgumentException("MarkaID ne sme biti null");
        this.markaID = markaID;
    }

    /**
     * Vraca string reprezentaciju marke automobila na osnovu atributa naziv.
     * 
     * @return naziv kao string reprezentacija marke automobila.
     */
    @Override
    public String toString() {
        return this.naziv;
    }

    /**
	 * Poredi dve marke automobila prema jedinstvenom identifikatoru.
	 * 
	 * @return
	 * <ul>
	 * 		<li> true ako su jedinstveni identifikatori isti </li>
	 * 		<li> false ako je unet null, ako objekat nije klase Marka ili ako su razliciti identifikatori </li>
	 * <ul>
	 */
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
