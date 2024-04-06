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
    /**
     * Ime i prezime vlasnika kao string.
     */
    private String imePrezimeVlasnika;
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
    public Automobil(String tablice, String imePrezimeVlasnika, int godiste, Marka marka, List<UoceniKvar> uoceniKvarovi) {
        this.tablice = tablice;
        this.imePrezimeVlasnika = imePrezimeVlasnika;
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

    /**
     * Vraca ime i prezime vlasnika automobila.
     * @return imePrezimeVlasnika automobila kao string.
     */
    public String getImePrezimeVlasnika() {
        return imePrezimeVlasnika;
    }
    
    /**
     * Postavlja novu vrednost za ime i prezime vlasnika.
     * 
     * @param imePrezimeVlasnika kao nova vrednost atributa imePrezimeVlasnika.
     * @throws NullPointerException ako je uneta vrednost null.
     */
    public void setImePrezimeVlasnika(String imePrezimeVlasnika) {
    	if(imePrezimeVlasnika==null) {
    		throw new NullPointerException("Ime i prezime ne mogu biti null");
    	}
    	
        this.imePrezimeVlasnika = imePrezimeVlasnika;
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
        return "[Tablice: "+tablice+", Vlasnik: "+imePrezimeVlasnika+", Marka: "+marka+"]";
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
          return this.tablice == null ? "automobil INNER JOIN marka ON automobil.markaid = marka.markaid" : "automobil";
    }

    @Override
    public String getKoloneZaInsert() {
        return "tablice, vlasnik, godiste, markaid";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "?,?,?,?";
    }

    @Override
    public String vratiVrednostiZaSelect() {
        return "tablice, vlasnik, godiste, automobil.markaid, marka.naziv";
    }

    @Override
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        statement.setString(1, ((Automobil)domainObject).getTablice());
        statement.setString(2, ((Automobil)domainObject).getImePrezimeVlasnika());
        statement.setInt(3, ((Automobil)domainObject).getGodiste());
        statement.setInt(4, ((Automobil)domainObject).getMarka().getMarkaID());
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
                auto.setImePrezimeVlasnika(rs.getString(2));
                auto.setGodiste(rs.getInt(3));
                auto.setMarka(new Marka(rs.getInt(4), rs.getString(5)));
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
        return " vlasnik='" + this.imePrezimeVlasnika +"', godiste=" +this.godiste+ ", markaid=" +this.marka.getMarkaID();
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
        String uslov = "LOWER(vlasnik) LIKE '" + this.getImePrezimeVlasnika() + "%'";
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
