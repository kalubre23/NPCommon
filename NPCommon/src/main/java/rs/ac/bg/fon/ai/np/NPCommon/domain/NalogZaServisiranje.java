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
 *
 * @author Asus
 */
public class NalogZaServisiranje extends DomenskiObjekat implements Serializable {

    private int nalogID;
    private LocalDate datum;
    private double cena;
    private UoceniKvar kvar;
    private Serviser serviser;

    public NalogZaServisiranje() {
    }

    public NalogZaServisiranje(int nalogID, LocalDate datum, 
         double cena, UoceniKvar kvar, Serviser serviser) {
        this.nalogID = nalogID;
        this.datum = datum;
        this.cena = cena;
        this.kvar = kvar;
        this.serviser = serviser;
    }

    public Serviser getServiser() {
        return serviser;
    }

    public void setServiser(Serviser serviser) {
    	if(serviser==null) {
    		throw new NullPointerException("Serviser ne moze biti null");
    	}
        this.serviser = serviser;
    }

    public UoceniKvar getKvar() {
        return kvar;
    }

    public void setKvar(UoceniKvar kvar) {
    	if(kvar == null)
    		throw new NullPointerException("Kvar kod naloga ne sme biti null!");
        this.kvar = kvar;
    }

    public int getNalogID() {
        return nalogID;
    }

    public void setNalogID(int nalogID) {
    	if(nalogID<0)
    		throw new IllegalArgumentException("NalogID ne sme biti < 0!");
        this.nalogID = nalogID;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
    	if(datum == null)
    		throw new NullPointerException("Datum naloga ne sme biti null!");
    	if(datum.isAfter(LocalDate.now()))
    		throw new IllegalArgumentException("Datum naloga ne sme da bude u buducnosti!");
        this.datum = datum;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
    	if(cena<0)
    		throw new IllegalArgumentException("Cena ne sme biti < 0!");
        this.cena = cena;
    }

    ////
    @Override
    public String toString() {
        return "Nalogid: " + nalogID + ", cena: " + cena;
    }
    ////

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
        return this.cena == 0 ? "nalog AS n"+
                                "INNER JOIN automobil AS a ON a.tablice=n.tablice"+
                                "INNER JOIN marka AS m ON a.markaid=m.markaid"+
                                "INNER JOIN uocenikvar AS uk ON n.kvarid=uk.kvarid"+
                                "INNER JOIN serviseri AS s ON n.serviserid=s.serviserid" : "nalog";
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
