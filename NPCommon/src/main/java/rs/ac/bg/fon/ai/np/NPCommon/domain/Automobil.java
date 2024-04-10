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
 * Predstavlja automobil.
 * 
 * Automobil ima broj registarskih tablica, ime i prezime vlasnika, 
 * godiste, marku i listu uocenih kvarova za taj automobil.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class Automobil extends DomenskiObjekat implements Serializable{
	/**
	 * Tablice automobila kao string.
	 */
    private String tablice;
    
    private Vlasnik vlasnik;
    /**
     * Godiste automobila kao int.
     */
    private int godiste;
    /**
     * Marka automobila tipa Marka.
     */
    private Marka marka;
    /**
     * Lista uocenih kvarova vezanih za jedan automobil.
     */
    private List<UoceniKvar> uoceniKvarovi;

    /**
     * Prazan konstruktor za kreiranje jedne instance automobila sa podrazumevanim vrednostima za njegove atribute.
     */
    public Automobil() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance automobila sa specificnim vrednostima za njegove atribute.
     * @param tablice - Broj tablica koji se dodeljuje instanci automobila pri kreiranju.
     * @param imePrezimeVlasnika - Ime i prezime vlasnika koji se dodeljuje instanci automobila pri kreiranju.
     * @param godiste - Godiste automobila koje se dodeljuje instanci automobila pri kreiranju.
     * @param marka - Marka automobila koja se dodeljuje instanci automobila pri kreiranju.
     * @param uoceniKvarovi - Lista uocenih kvarova automobila koja se dodeljuje instanci automobila pri kreiranju.
     */
    public Automobil(String tablice, Vlasnik vlasnik, int godiste, Marka marka, List<UoceniKvar> uoceniKvarovi) {
        this.tablice = tablice;
        this.vlasnik = vlasnik;
        this.godiste = godiste;
        this.marka = marka;
        this.uoceniKvarovi = uoceniKvarovi;
    }

    /**
     * Vraca marku automobila.
     * @return marka automobila tipa Marka.
     */
    public Marka getMarka() {
        return marka;
    }

    /**
     * Postavlja novu vrednost za marku.
     * 
     * @param marka kao nova vrednost atributa marka.
     * @throws NullPointerException ako je uneta vrednost null.
     */
    public void setMarka(Marka marka) {
    	if(marka==null)
    		throw new NullPointerException("Marka ne moze biti null!");
        this.marka = marka;
    }

    /**
     * Vraca tablice automobila.
     * @return tablice automobila kao string.
     */
    public String getTablice() {
        return tablice;
    }

    /**
     * Postavlja novu vrednost za tablice automobila.
     * 
     * @param tablice kao nova vrednost atributa tablice.
     * @throws NullPointerException ako je uneta vrednost null.
     */
    public void setTablice(String tablice) {
    	if(tablice==null) {
    		throw new NullPointerException("Tablice ne mogu biti null");
    	}
    	
        this.tablice = tablice;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        if(vlasnik==null)
            throw new NullPointerException("Vlasnik automobila ne moze biti null");
        if(!(vlasnik instanceof Vlasnik))
            throw new IllegalArgumentException("Vlasnik mora instanca klase Vlasnik");
        this.vlasnik = vlasnik;
    }
   
    /**
     * Vraca godiste automobila.
     * @return godiste automobila kao int.
     */
    public int getGodiste() {
        return godiste;
    }

    /**
     * Postavlja novu vrednost za godiste automobila.
     * 
     * Automobil ne moze biti star preko 120+ godina.
     * 
     * @param godiste kao nova vrednost atributa godiste.
     * @throws IllegalArgumentException ako je uneta vrednost manja od 1900.
     */
    public void setGodiste(int godiste) {
    	if(godiste < 1900) {
    		throw new IllegalArgumentException("Godiste ne sme biti manje od 1900");
    	}
        this.godiste = godiste;
    }

    /**
     * Vraca listu uocenih kvarova automobila.
     * @return uoceniKvarovi automobila kao tipizirana lista klase UoceniKvar.
     */
    public List<UoceniKvar> getUoceniKvarovi() {
        return uoceniKvarovi;
    }

    /**
     * Postavlja novu vrednost za listu uocenik kvarova automobila.
     * 
     * @param uoceniKvarovi kao nova vrednost atributa uoceniKvarovi.
     * @throws NullPointerException ako je uneta vrednost null.
     */
    public void setUoceniKvarovi(List<UoceniKvar> uoceniKvarovi) {
    	if(uoceniKvarovi==null)
    		throw new NullPointerException("Uoceni kvarovi za automobil ne mogu biti null");
        this.uoceniKvarovi = uoceniKvarovi;
    }

    /**
     * Vraca string reprezentaciju automobila na osnovu svih atributa osim liste uocenih kvarova.
     * 
     * @return automobil kao string reprezentacija automobila u odgovarajucem formatu.
     */
    @Override
    public String toString() {
        return "[Tablice: "+tablice+", Vlasnik: "+vlasnik.getIme() + " " + vlasnik.getPrezime()+", Marka: "+marka+"]";
    }

    /**
	 * Poredi dva automobila prema tablicama.
	 * 
	 * @return
	 * <ul>
	 * 		<li> true ako su tablice automobila iste </li>
	 * 		<li> false ako je unet null, ako objekat nije klase Automobil ili ako su razlicite tablice </li>
	 * <ul>
	 */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Automobil))
            return false;
        if(obj == null)
            return false;
        return (((Automobil)obj).getTablice().equals(this.tablice));
    }

    @Override
    public String vratiNazivTabele() {
          return this.marka == null ? "automobil INNER JOIN marka ON automobil.markaid = marka.markaid INNER JOIN vlasnik ON automobil.vlasnikid = vlasnik.vlasnikid" : "automobil";
    }

    @Override
    public String getKoloneZaInsert() {
        return "tablice, godiste, markaid, vlasnikid";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "?,?,?,?";
    }

    @Override
    public String vratiVrednostiZaSelect() {
        return "tablice, godiste, automobil.markaid, marka.naziv, automobil.vlasnikid, vlasnik.ime, vlasnik.prezime, vlasnik.email, vlasnik.telefon";
    }

    @Override
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        statement.setString(1, ((Automobil)domainObject).getTablice());
        statement.setInt(2, ((Automobil)domainObject).getGodiste());
        statement.setInt(3, ((Automobil)domainObject).getMarka().getMarkaID());
        statement.setInt(4, ((Automobil)domainObject).getVlasnik().getVlasnikID());
    }

    @Override
    public void postaviVrednostiZaSelect(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
    }

    @Override
    public List<DomenskiObjekat> vratiListuSvih(ResultSet rs) {
        try {
            List<DomenskiObjekat> automobili = new ArrayList<>();
            while (rs.next()){
                Automobil auto = new Automobil();
                System.out.println("a");
                auto.setTablice(rs.getString(1));
                auto.setGodiste(rs.getInt(2));
                auto.setMarka(new Marka(rs.getInt(3), rs.getString(4)));
                auto.setVlasnik(new Vlasnik(rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
                auto.setUoceniKvarovi(new ArrayList<>());
                automobili.add(auto);
                System.out.println(auto.toString());
            }
            System.out.println("Duzia liste: "+automobili.size());
            for(DomenskiObjekat a: automobili){
                System.out.println(a);
            }
            return automobili;
        } catch (SQLException ex) {
            System.out.println("U klasi automobil u metodi vratiListuSvih je uhvacen izuzetak!");
            ex.printStackTrace();
        }
        System.out.println("Ovo se izvrsilo nakon toga");
        return null;
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs, DomenskiObjekat objekat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "godiste=" +this.godiste+ ", markaid=" +this.marka.getMarkaID()+", vlasnikid=" +this.getVlasnik().getVlasnikID();
    }

    @Override
    public void postaviVrednostiZaUpdate(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "tablice='"+this.tablice+"'";
    }

    @Override
    public boolean sadrziAutoIncrementPK() {
        return false;
    }

    @Override
    public void postaviAutoIncrementPrimaryKey(int primaryKey) {
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaVise() {
        //ovde treba da vratim taj uslov sa like
        String uslov = "LOWER(tablice) LIKE '" + this.getTablice() + "%'";
        return uslov;
    }

    @Override
    public DomenskiObjekat vratiVezaniObjekat() {
        return new UoceniKvar();
    }

    @Override
    public String vratiUslovZaVezani() {
        return "tablice='"+tablice+"'";
    }

    @Override
    public void napuni(ResultSet rs) {
        try {
            //ovde treba da napunim listu kvarova i da je dodelim this listakvarova
            List<UoceniKvar> listaKvarova = new ArrayList<>();
            while(rs.next()){
                UoceniKvar uk = new UoceniKvar();
                uk.setAutomobil(this);
                uk.setKvarID(rs.getInt(1));
                uk.setOpis(rs.getString(2));
                listaKvarova.add(uk);
            }
           this.uoceniKvarovi= listaKvarova; 
        } catch (SQLException ex) {
            Logger.getLogger(Automobil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
