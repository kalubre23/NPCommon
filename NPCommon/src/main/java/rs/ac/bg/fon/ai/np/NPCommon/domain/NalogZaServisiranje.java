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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Predstavlja nalog za servisiranje automobila.
 * 
 * Nalog za servisiranje se odnosi na jedan uoceni kvar. Jedan uoceni kvar moze podrazumevati
 * vise pokvarenih delova. Npr: uoceni kvar: problemi sa motorom, pokvareni delovi: akumulator, svecice.
 * Ima jedinstven identifikator, datum servisiranja, cenu, podatak o tome na 
 * koji se kvar odnosi kao i koji serviser je zakljucio nalog.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class NalogZaServisiranje extends DomenskiObjekat implements Serializable {

	/**
	 * Jedinstven identifikator naloga za servisiranje kao int.
	 */
    private int nalogID;
    /**
     * Datum servisiranja automobila tipa LocalDate.
     */
    private LocalDate datum;
    /**
     * Cena servisa kao double.
     */
    private double cena;
    /**
     * Kvar na koji se odnosi nalog tipa UoceniKvar.
     */
    private UoceniKvar kvar;
    /**
     * Serviser koji je zakljucio nalog kao instanca klase Serviser.
     */
    private Serviser serviser;

    /**
     * Prazan konstruktor za kreiranje jedne instance naloga sa podrazumevanim vrednostima za njegove atribute.
     */
    public NalogZaServisiranje() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance naloga sa specificnim vrednostima za njegove atribute.
     * @param nalogID - Jedinstven identifikator koji se dodeljuje instanci naloga pri kreiranju.
     * @param datum - Datum servisiranja koji se dodeljuje instanci naloga pri kreiranju.
     * @param cena - Cena servisa koje se dodeljuje instanci naloga pri kreiranju.
     * @param kvar - Kvar na koji se odnosi servis, koji se dodeljuje instanci naloga pri kreiranju.
     * @param serviser - Serviser koji je zakljucio nalog, koji se dodeljuje instanci naloga pri kreiranju.
     */
    public NalogZaServisiranje(int nalogID, LocalDate datum, 
         double cena, UoceniKvar kvar, Serviser serviser) {
        this.nalogID = nalogID;
        this.datum = datum;
        this.cena = cena;
        this.kvar = kvar;
        this.serviser = serviser;
    }
    
    /**
     * Vraca servisera koji je zakljucio nalog.
     * @return serviser koji je zakljucio nalog tipa Serviser.
     */
    public Serviser getServiser() {
        return serviser;
    }

    /**
     * Postavlja novu vrednost za atribut serviser.
     * 
     * @param serviser kao nova vrednost atributa serviser.
     * @throws NullPointerException ako je uneta vrednost null.
     */
    public void setServiser(Serviser serviser) {
    	if(serviser==null) {
    		throw new NullPointerException("Serviser ne moze biti null");
    	}
        this.serviser = serviser;
    }

    /**
     * Vraca kvar automobila na koji se nalog odnosi.
     * @return kvar koji se odnosi na nalog tipa UoceniKvar.
     */
    public UoceniKvar getKvar() {
        return kvar;
    }

    /**
     * Postavlja novu vrednost za atribut kvar.
     * 
     * @param kvar kao nova vrednost atributa kvar.
     * @throws NullPointerException ako je uneta vrednost null.
     */
    public void setKvar(UoceniKvar kvar) {
    	if(kvar == null)
    		throw new NullPointerException("Kvar kod naloga ne sme biti null!");
        this.kvar = kvar;
    }

    /**
     * Vraca jedinstevni identifikator naloga za servisiranje.
     * @return nalogID identifikator tipa int.
     */
    public int getNalogID() {
        return nalogID;
    }

    /**
     * Postavlja novu vrednost za jedinstveni identifikator naloga za servisiranje.
     * 
     * @param nalogID kao nova vrednost jedinstvenog identifikatora nalogID.
     * 
     * @throws IllegalArgumentException ako je uneta vrednost manja od nule.
     */
    public void setNalogID(int nalogID) {
    	if(nalogID<0)
    		throw new IllegalArgumentException("NalogID ne sme biti < 0!");
        this.nalogID = nalogID;
    }

    /**
     * Vraca datum servisiranja tj datum kada je zakljucen(kreiran) nalog.
     * @return datum servisiranja tipa LocalDate.
     */
    public LocalDate getDatum() {
        return datum;
    }

    /**
     * Postavlja novu vrednost za datum servisiranja.
     * 
     * @param datum kao nova vrednost datuma.
     * 
     * @throws NullPointerException ako je uneta vrednost null.
     * @throws IllegalArgumentException ako se uneti datum odnosi na buducnost.
     */
    public void setDatum(LocalDate datum) {
    	if(datum == null)
    		throw new NullPointerException("Datum naloga ne sme biti null!");
    	if(datum.isAfter(LocalDate.now()))
    		throw new IllegalArgumentException("Datum naloga ne sme da bude u buducnosti!");
        this.datum = datum;
    }

    /**
     * Vraca cenu servisa.
     * @return cena servisa tipa kao double.
     */
    public double getCena() {
        return cena;
    }

    /**
     * Postavlja novu vrednost cene servisa.
     * 
     * @param cena kao nova vrednost cene.
     * 
     * @throws IllegalArgumentException ako je uneta vrednost manja od nule.
     */
    public void setCena(double cena) {
    	if(cena<0)
    		throw new IllegalArgumentException("Cena ne sme biti < 0!");
        this.cena = cena;
    }

    
    /**
     * Vraca string reprezentaciju naloga na osnovu jedinstvenog identifikatora i cene.
     * 
     * @return nalog kao string reprezentacija naloga u odgovarajucem formatu.
     */
    @Override
    public String toString() {
        return "Nalogid: " + nalogID + ", cena: " + cena;
    }
    ////

    /**
	 * Poredi dva naloga za servisiranje prema jedinstvenom identifikatoru.
	 * 
	 * @return
	 * <ul>
	 * 		<li> true ako su identifikatori naloga isti </li>
	 * 		<li> false ako je unet null, ako objekat nije klase NalogZaServisiranje ili ako su razliciti identifikatori </li>
	 * <ul>
	 */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof NalogZaServisiranje)) {
            return false;
        }

        return this.nalogID == ((NalogZaServisiranje) obj).getNalogID();
    }

    @Override
    public String vratiNazivTabele() {
        return this.cena == 0 ? "nalog AS n "+
                                "INNER JOIN automobil AS a ON a.tablice=n.tablice "+
                                "INNER JOIN marka AS m ON a.markaid=m.markaid "+
                                "INNER JOIN uocenikvar AS uk ON n.kvarid=uk.kvarid "+
                                "INNER JOIN serviseri AS s ON n.serviserid=s.serviserid " : "nalog ";
    }

    @Override
    public String getKoloneZaInsert() {
        return "datum, cena, tablice, kvarid, serviserid";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "?,?,?,?,?";
    }

    @Override
    public String vratiVrednostiZaSelect() {
        return "nalogid, datum, cena, n.tablice, a.vlasnik, a.godiste, a.markaid, m.naziv, n.kvarid, uk.opis, n.serviserid, s.ime, s.prezime, s.username";
    }

    @Override
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        statement.setDate(1, java.sql.Date.valueOf((LocalDate) ((NalogZaServisiranje) domainObject).getDatum()));
        statement.setDouble(2, ((NalogZaServisiranje) domainObject).getCena());
        statement.setString(3, ((NalogZaServisiranje) domainObject).getKvar().getAutomobil().getTablice());
        statement.setInt(4, ((NalogZaServisiranje) domainObject).getKvar().getKvarID());
        statement.setInt(5, ((NalogZaServisiranje) domainObject).getServiser().getServiserID());
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
                Marka marka = new Marka(rs.getInt("a.markaid"), rs.getString("m.naziv"));
                Automobil automobil = new Automobil(rs.getString("n.tablice"), rs.getString("a.vlasnik"), rs.getInt("a.godiste"), marka, null);
                UoceniKvar uk = new UoceniKvar(automobil, rs.getInt("n.kvarid"), rs.getString("uk.opis"));
                Serviser s = new Serviser(rs.getInt("n.serviserid"), rs.getString("s.ime"), rs.getString("s.prezime"), rs.getString("s.username"), null);
                NalogZaServisiranje nalog = new NalogZaServisiranje(rs.getInt("nalogid"), rs.getDate("datum").toLocalDate(), rs.getDouble("cena"), uk, s);
                lista.add(nalog);
                System.out.println(nalog);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("GRESKA u vratiListuSvih KOD nalogZaServisiranje");
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
        return "LOWER(n.tablice) LIKE '" + this.kvar.getAutomobil().getTablice() + "%'";
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "nalogid="+this.nalogID;
    }

    @Override
    public void postaviAutoIncrementPrimaryKey(int primaryKey) {
        this.nalogID = primaryKey;
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
