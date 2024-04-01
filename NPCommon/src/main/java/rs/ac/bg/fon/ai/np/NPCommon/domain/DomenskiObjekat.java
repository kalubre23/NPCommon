/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author student2
 */
public abstract class DomenskiObjekat {

    public abstract String vratiNazivTabele();
    public abstract String getKoloneZaInsert();
    public abstract String vratiVrednostiZaInsert();
    public abstract String vratiVrednostiZaSelect();
    public abstract void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException;
    public abstract void postaviVrednostiZaSelect(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException;
    public abstract boolean sadrziAutoIncrementPK();
    public abstract List<DomenskiObjekat> vratiListuSvih(ResultSet rs);
    public abstract DomenskiObjekat vratiJednog(ResultSet rs, DomenskiObjekat objekat);
    public abstract String vratiVrednostiZaUpdate();
    public abstract void postaviVrednostiZaUpdate(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException;
    public abstract String vratiUslovZaJednog();
    public abstract String vratiUslovZaVise();
    public abstract String vratiUslovZaUpdate();
    public abstract void postaviAutoIncrementPrimaryKey(int primaryKey);
    public abstract DomenskiObjekat vratiVezaniObjekat();
    public abstract String vratiUslovZaVezani();
    public abstract void napuni(ResultSet rs);
}
