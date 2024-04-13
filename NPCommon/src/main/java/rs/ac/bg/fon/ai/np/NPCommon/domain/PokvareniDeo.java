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
 * Predstavlja pokvareni deo automobila.
 * 
 * Sastoji se od jednog uocenog kvara za automobil i dela automobila kome je potreban servis. 
 * Takodje sadrzi cenu popravke.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class PokvareniDeo extends DomenskiObjekat implements Serializable {

	/**
	 * Uoceni kvar automobila tipa UoceniKvar.
	 */
    private UoceniKvar uoceniKvar;
    /**
     * Deo automobila tipa DeoAutomobila.
     */
    private DeoAutomobila deo;
    /**
     * Cena popravke kao double.
     */
    private double cena;


    /**
     * Prazan konstruktor za kreiranje jedne instance pokvarei deo sa podrazumevanim vrednostima za njegove atribute.
     */
    public PokvareniDeo() {
    }

    /**
     * Parametrizovani konstruktor koji sluzi za kreiranje instance pokvarenog dela sa specificnim vrednostima za njegove atribute.
     * 
     * @param uoceniKvar - Uoceni kvar automobila koji se dodeljuje instanci pokvarenog dela pri kreiranju.
     * @param deo - Deo automobila koji se dodeljuje instanci pokvarenog dela pri kreiranju.
     * @param cena - Cena popravke koja se dodeljuje instanci pokvarenog dela pri kreiranju.
     */
    public PokvareniDeo(UoceniKvar uoceniKvar, DeoAutomobila deo, double cena) {
        setUoceniKvar(uoceniKvar);
        setDeo(deo);
        setCena(cena);
    }

    /**
     * Specifican atribut za ovu klasu. 
     * 
     * Predstavlja uslov za update u sql upitu nakon WHERE klauzule u string formatu.
     */
    private String usloviZaUpdate;
    /**
     * Postavlja uslove za update u sql upitu nakon WHERE klauzule.
     * 
     * Ova tri atributa predstavljaju primarni kljuc u tabeli.
     * 
     * @param tbl - broj tablice automobila
     * @param kid - jedinstveni identifikator kvara
     * @param did - jedinstveni identifikator dela automobila
     */
    public void setUsloviZaUpdate(String tbl, int kid,int did) {
        usloviZaUpdate = "tablice='" + tbl + "' AND kvarid="+kid+" AND deoid="+did;
    }
    
    /**
     * Vraca cenu popravke.
     * 
     * @return cena popravke kao double.
     */
    public double getCena() {
        return cena;
    }

    /**
     * Postavlja novu vrednost cene popravke.
     * 
     * @param cena kao nova vrednost cene popravke.
     * @throws IllegalArgumentException ako je uneta cena manja od nule.
     */
    public void setCena(double cena) {
    	if(cena<0)
    		throw new IllegalArgumentException("Cena pokvarenog dela ne sme biti < 0");
        this.cena = cena;
    }

    /**
     * Vraca kvar automobila na koji se odnosi pokvareni deo.
     * @return uoceniKvar na koji se odnosi pokvaren deo tipa UoceniKvar.
     */
    public UoceniKvar getUoceniKvar() {
        return uoceniKvar;
    }

    /**
     * Postavlja novu vrednost za atribut uoceniKvar.
     * 
     * @param kvar kao nova vrednost uocenog kvara.
     * @throws NullPointerException ako je uneta vrednost null.
     */
    public void setUoceniKvar(UoceniKvar uoceniKvar) {
    	if(uoceniKvar == null)
    		throw new NullPointerException("Uoceni kvar za pokvareni deo ne sme biti null!");
    	
        this.uoceniKvar = uoceniKvar;
    }

    /**
     * Vraca deo automobila na koji se odnosi pokvareni deo.
     * @return deo na koji se odnosi pokvaren deo tipa DeoAutomobila.
     */
    public DeoAutomobila getDeo() {
        return deo;
    }

    /**
     * Postavlja novu vrednost za atribut deo.
     * 
     * @param deo kao nova vrednost dela automobila.
     * @throws NullPointerException ako je uneta vrednost null.
     */
    public void setDeo(DeoAutomobila deo) {
    	if(deo == null)
    		throw new NullPointerException("Deo automobila kod pokvarenog dela ne sme biti null!");
        this.deo = deo;
    }

    /**
     * Vraca string reprezentaciju pokvarenog dela.
     * 
     * Sastoji se od jedinstvenog identifikatora uocenog kvara, dela automobila i cene popravke.
     * 
     * @return pokvareni deo kao string reprezentacija naloga u odgovarajucem formatu.
     */
    @Override
    public String toString() {
        return "kvarid: " +uoceniKvar.getKvarID()+", deoid: "+deo.getDeoID()+", cena: "+cena;
    }
    
    

    /**
	 * Poredi dva pokvarena dela prema uocenom kvaru i delu automobila.
	 * 
	 * Pozivaju se equals metode klase UoceniKvar i DeoAutomobila.
	 * 
	 * @return
	 * <ul>
	 * 		<li> true ako su uoceni kvar i deo automobila isti </li>
	 * 		<li> false ako je unet null, ako objekat nije klase NalogZaServisiranje ili ako su razliciti uoceni kvar i/ili deo automobila</li>
	 * <ul>
	 */
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
                + "INNER JOIN vlasnik AS v ON v.vlasnikid=a.vlasnikid\n"
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
        return "a.tablice, a.godiste, a.markaid, m.naziv, a.vlasnikid, v.ime, v.prezime, v.email, v.telefon, pd.kvarid, uk.opis, pd.deoid, d.naziv, cena";
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
                Vlasnik vlasnik = new Vlasnik(rs.getInt("a.vlasnikid"),rs.getString("v.ime"),rs.getString("v.prezime"),rs.getString("v.email"),rs.getString("v.telefon"));
                Automobil automobil = new Automobil(rs.getString("a.tablice"), vlasnik, rs.getInt("a.godiste"), marka, new ArrayList<>());
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
