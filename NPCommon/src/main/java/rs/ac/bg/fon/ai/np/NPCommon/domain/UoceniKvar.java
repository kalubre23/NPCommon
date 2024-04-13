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

/**
 * Predstavlja uoceni kvar za automobil.
 * 
 * Ima tablice automobila na koji se odnosi, jedinstveni identifikator kvara i opis uocenog kvara.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class UoceniKvar extends DomenskiObjekat implements Serializable{
	/**
	 * Automobil na kome je uocen kvar tipa Automobil.
	 */
    private Automobil automobil;
    /**
     * Jedinstveni identifikator kvara.
     */
    private int kvarID;
    /**
     * Opis uocenog kvara kao string.
     */
    private String opis;

    /**
     * Prazan konstruktor za kreiranje jedne instance uocenog kvara sa podrazumevanim vrednostima za njegove atribute.
     */
    public UoceniKvar() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance uocenog kvara sa specificnim vrednostima za njegove atribute.
     * 
     * @param automobil - Automobil koji se dodeljuje instanci uocenog kvara pri kreiranju.
     * @param kvarID - Jedinstveni indentifikator koji se dodeljuje instanci uocenog kvara pri kreiranju.
     * @param opis - Opis kvara koji se dodeljuje instanci uocenog kvara pri kreiranju.
     */
    public UoceniKvar(Automobil automobil, int kvarID, String opis) {
        setAutomobil(automobil);
        setKvarID(kvarID);
        setOpis(opis);
    }

    /**
     * Vraca opis kvara.
     * 
     * @return opis kvara kao string.
     */
    public String getOpis() {
        return opis;
    }

    /**
	 * Postavlja novu vrednost atributa opis.
	 * 
	 * Opis ne sme biti null niti prazan string.
	 * 
	 * @param opis nova vrednost za opis kvara
	 * @throws NullPointerException ako se unese null vrednost
	 * @throws IllegalArgumentException ako se unese prazan string
	 */
    public void setOpis(String opis) {
    	if(opis == null)
    		throw new NullPointerException("Opis kvara ne sme biti null!");
    	if(opis.isEmpty())
    		throw new IllegalArgumentException("Opis kvara je prazan string!");
        this.opis = opis;
    }

    /**
     * Vraca automobil na kojem je uocen kvar.
     * @return automobil na kojem je uocen kvar tipa Automobil.
     */
    public Automobil getAutomobil() {
        return automobil;
    }

    /**
	 * Postavlja novu vrednost atributa automobil.
	 * 
	 * Automobil ne sme biti null.
	 * 
	 * @param automobil nova vrednost za automobil
	 * @throws NullPointerException ako se unese null vrednost
	 */
    public void setAutomobil(Automobil automobil) {
    	if(automobil==null)
    		throw new NullPointerException("Automobil kod uocenog kvara ne sme biti null!");
        this.automobil = automobil;
    }

    /**
     * Vraca jedinstveni identifikator uocenog kvara.
     * @return kvarID identifikator kao int.
     */
    public int getKvarID() {
        return kvarID;
    }

    /**
     * Postavlja novu vrednost za jedinstveni identifikator uocenog kvara.
     * 
     * Jedinstveni identifikator ne sme biti manji od nule.
     * 
     * @param kvarID kao nova vrednost identifikatora.
     * 
     * @throws IllegalArgumentException ako je uneta vrednost manja od nule.
     */
    public void setKvarID(int kvarID) {
    	if(kvarID<0)
    		throw new IllegalArgumentException("KvarID kod uocenog kvara ne sme biti < 0");
        this.kvarID = kvarID;
    }

    /**
     * Vraca string reprezentaciju uocenog kvara na osnovu tablica automobila i opisa kvara.
     * 
     * @return uoceni kvar kao string reprezentacija u odgovarajucem formatu.
     */
    @Override
    public String toString() {
        return "Automobil: "+automobil.getTablice()+", Opis kvara: "+opis;
    }

    /**
	 * Poredi dva uocena kvara prema automobilu i jedinstvenom identifikatoru kvara.
	 * 
	 * Poziva se equals metoda klase Automobil.
	 * 
	 * @return
	 * <ul>
	 * 		<li> true ako su automobil i jedinstveni identifikator kvara isti </li>
	 * 		<li> false ako je unet null, ako objekat nije klase UoceniKvar ili ako su razliciti automobil i/ili jedinstveni identifikator kvara</li>
	 * <ul>
	 */
    @Override
    public boolean equals(Object obj) {
    	if(obj == null)
    		return false;
        if(!(obj instanceof UoceniKvar))
            return false;
        UoceniKvar uk = (UoceniKvar)obj;
        
        return (uk.getAutomobil().equals(this.automobil) && uk.kvarID==this.kvarID);
    }

    @Override
    public String vratiNazivTabele() {
        return "uocenikvar";
    }

    @Override
    public String getKoloneZaInsert() {
        return "tablice, opis";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "?,?";
    }

    @Override
    public String vratiVrednostiZaSelect() {
        return "kvarid, opis";
    }

    @Override
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        statement.setString(1, ((UoceniKvar)domainObject).getAutomobil().getTablice());
        statement.setString(2, ((UoceniKvar)domainObject).getOpis());
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public String vratiUslovZaUpdate() {
        return "tablice='"+this.getAutomobil().getTablice()+"'";
    }

    @Override
    public void postaviAutoIncrementPrimaryKey(int primaryKey) {
        this.kvarID = primaryKey;
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaVise() {
        return null;
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
