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
public class PokvareniDeo extends DomenskiObjekat implements Serializable {

    private UoceniKvar uoceniKvar;
    private DeoAutomobila deo;
    private double cena;


    public PokvareniDeo() {
    }

    public PokvareniDeo(UoceniKvar uoceniKvar, DeoAutomobila deo, double cena) {
        this.uoceniKvar = uoceniKvar;
        this.deo = deo;
        this.cena = cena;
    }

    private String usloviZaUpdate;
    public void setUsloviZaUpdate(String tbl, int kid,int did) {
        usloviZaUpdate = "tablice='" + tbl + "' AND kvarid="+kid+" AND deoid="+did;
    }
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
    	if(cena<0)
    		throw new IllegalArgumentException("Cena pokvarenog dela ne sme biti < 0");
        this.cena = cena;
    }

    public UoceniKvar getUoceniKvar() {
        return uoceniKvar;
    }

    public void setUoceniKvar(UoceniKvar uoceniKvar) {
    	if(uoceniKvar == null)
    		throw new NullPointerException("Uoceni kvar za pokvareni deo ne sme biti null!");
    	
        this.uoceniKvar = uoceniKvar;
    }

    public DeoAutomobila getDeo() {
        return deo;
    }

    public void setDeo(DeoAutomobila deo) {
    	if(deo == null)
    		throw new NullPointerException("Deo automobila kod pokvarenog dela ne sme biti null!");
        this.deo = deo;
    }

    @Override
    public String toString() {
        return "kvarid: " +uoceniKvar.getKvarID()+", deoid: "+deo.getDeoID()+", cena: "+cena;
    }
    
    

    @Override
    public boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
        if (!(obj instanceof PokvareniDeo)) {
            return false;
        }
        PokvareniDeo pd = ((PokvareniDeo) obj);

        return (pd.getUoceniKvar().equals(this.uoceniKvar) && pd.getDeo().equals(this.deo));
    }

    @Override
    public String vratiNazivTabele() {
        return this.cena == 0 ? "pokvarendeo AS pd\n"
                + "INNER JOIN automobil AS a ON a.tablice=pd.tablice\n"
                + "INNER JOIN marka AS m ON m.markaid=a.markaid\n"
                + "INNER JOIN uocenikvar AS uk ON uk.kvarid=pd.kvarid\n"
                + "INNER JOIN deoautomobila AS d ON d.deoid=pd.deoid " : "pokvarendeo";
    }

    @Override
    public String getKoloneZaInsert() {
        return "tablice, kvarid, deoid, cena";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "?,?,?,?";
    }

    @Override
    public String vratiVrednostiZaSelect() {
        return "a.tablice, a.vlasnik, a.godiste, a.markaid, m.naziv, pd.kvarid, uk.opis, pd.deoid, d.naziv, cena";
    }

    @Override
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        statement.setString(1, ((PokvareniDeo) domainObject).getUoceniKvar().getAutomobil().getTablice());
        statement.setInt(2, ((PokvareniDeo) domainObject).getUoceniKvar().getKvarID());
        statement.setInt(3, ((PokvareniDeo) domainObject).getDeo().getDeoID());
        statement.setDouble(4, ((PokvareniDeo) domainObject).getCena());
    }

    @Override
    public void postaviVrednostiZaSelect(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean sadrziAutoIncrementPK() {
        return false;
    }

    @Override
    public List<DomenskiObjekat> vratiListuSvih(ResultSet rs) {
        List<DomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                System.out.println("Usao je u while petlju!");
                Marka marka = new Marka(rs.getInt("a.markaid"), rs.getString("m.naziv"));
                Automobil automobil = new Automobil(rs.getString("a.tablice"), rs.getString("a.vlasnik"), rs.getInt("a.godiste"), marka, null);
                UoceniKvar uk = new UoceniKvar(automobil, rs.getInt("pd.kvarid"), rs.getString("uk.opis"));
                DeoAutomobila deoAutomobila = new DeoAutomobila(rs.getInt("pd.deoid"), rs.getString("d.naziv"));
                PokvareniDeo pd = new PokvareniDeo(uk, deoAutomobila, rs.getDouble("cena"));
                lista.add(pd);
                System.out.println(pd);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(PokvareniDeo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DomenskiObjekat vratiJednog(ResultSet rs, DomenskiObjekat objekat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "tablice=?, kvarid=?, deoid=?, cena=?";
    }

    @Override
    public void postaviVrednostiZaUpdate(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        statement.setString(1, ((PokvareniDeo)domainObject).getUoceniKvar().getAutomobil().getTablice());
        statement.setInt(2, ((PokvareniDeo)domainObject).getUoceniKvar().getKvarID());
        statement.setInt(3, ((PokvareniDeo)domainObject).getDeo().getDeoID());
        statement.setDouble(4, ((PokvareniDeo)domainObject).getCena());
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaVise() {
        return "LOWER(a.tablice) LIKE '" + this.uoceniKvar.getAutomobil().getTablice() + "%'";
    }

    @Override
    public String vratiUslovZaUpdate() {
        return this.usloviZaUpdate;
//        return "tablice='" + this.uoceniKvar.getAutomobil().getTablice() + "' AND kvarid="+this.uoceniKvar.getKvarID()+" AND deoid="+this.getDeo().getDeoID();
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
