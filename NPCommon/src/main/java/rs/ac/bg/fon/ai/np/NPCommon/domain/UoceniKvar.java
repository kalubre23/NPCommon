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
 *
 * @author Asus
 */
public class UoceniKvar extends DomenskiObjekat implements Serializable{
    private Automobil automobil;
    private int kvarID;
    private String opis;

    public UoceniKvar() {
    }

    public UoceniKvar(Automobil automobil, int kvarID, String opis) {
        this.automobil = automobil;
        this.kvarID = kvarID;
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
    	if(opis == null)
    		throw new NullPointerException("Opis kvara ne sme biti null!");
    	if(opis.isEmpty())
    		throw new IllegalArgumentException("Opis kvara je prazan string!");
        this.opis = opis;
    }

    public Automobil getAutomobil() {
        return automobil;
    }

    public void setAutomobil(Automobil automobil) {
    	if(automobil==null)
    		throw new NullPointerException("Automobil kod uocenog kvara ne sme biti null!");
        this.automobil = automobil;
    }

    public int getKvarID() {
        return kvarID;
    }

    public void setKvarID(int kvarID) {
    	if(kvarID<0)
    		throw new IllegalArgumentException("KvarID kod uocenog kvara ne sme biti < 0");
        this.kvarID = kvarID;
    }

    @Override
    public String toString() {
        return "Automobil: "+automobil.getTablice()+", Opis kvara: "+opis;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof UoceniKvar))
            return false;
        if(obj == null)
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
