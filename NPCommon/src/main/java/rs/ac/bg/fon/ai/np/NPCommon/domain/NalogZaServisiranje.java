/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.io.Serializable;
import java.sql.Date;
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
 * Ima jedinstven identifikator, datum servisiranja, datum izvrsavanja, status, cenu, podatak o tome na 
 * koji se kvar odnosi kao i kom serviseru se dodeljuje nalog.
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
     * Datum kreiranja naloga, tipa {@link LocalDate}.
     */
    private LocalDate datumKreiranja;
    /**
     * Datum izvrsenja naloga, tipa {@link LocalDate}.
     */
    private LocalDate datumIzvrsenja;
    /**
     * Stutus naloga, 0 ako je neizvrsen(default) i 1 ako je izvrsen kao short.
     */
    private short status = 0; // po default-u je 0
    /**
     * Cena servisa kao double.
     */
    private double cena;
    /**
     * Kvar na koji se odnosi nalog tipa {@link UoceniKvar}.
     */
    private UoceniKvar kvar;
    /**
     * Serviser kome se dodeljuje nalog kao instanca klase {@link Serviser}.
     */
    private Korisnik serviser;

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
     * @param serviser - Serviser koji izvrsava nalog, koji se dodeljuje instanci naloga pri kreiranju.
     */
    public NalogZaServisiranje(int nalogID, LocalDate datumKreiranja, 
         double cena, UoceniKvar kvar, Korisnik serviser) {
        setNalogID(nalogID);
        setDatumKreiranja(datumKreiranja);
        setCena(cena);
        setKvar(kvar);
        setServiser(serviser);
    }
    
    /**
     * Vraca servisera kojem je dodeljen nalog na izvrsavanje nalog.
     * @return serviser koji izvrsava nalog tipa {@link Korisnik}.
     */
    public Korisnik getServiser() {
        return serviser;
    }

    /**
     * Postavlja novu vrednost za atribut serviser.
     * 
     * @param serviser kao nova vrednost atributa serviser.
     * @throws NullPointerException ako je uneta vrednost null.
     */
    public void setServiser(Korisnik serviser) {
    	if(serviser==null) {
    		throw new NullPointerException("Serviser ne moze biti null");
    	}
        this.serviser = serviser;
    }

    /**
     * Vraca kvar automobila na koji se nalog odnosi.
     * @return kvar koji se odnosi na nalog tipa {@link UoceniKvar}.
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
     * Vraca datum izvrsavanja naloga.
     * @return datum izvrsavanja tipa {@link LocalDate}.
     */
    public LocalDate getDatumIzvrsenja() {
        return datumIzvrsenja;
    }
    
    /**
     * Postavlja novu vrednost za datum izvrsavanja naloga.
     * 
     * @param datum kao nova vrednost datuma izvrsavanja. Moze biti null ako nalog nije zavrsen.
     * 
     * @throws IllegalArgumentException ako se uneti datum odnosi na buducnost.
     */
    public void setDatumIzvrsenja(LocalDate datumIzvrsenja) {
        if(datumIzvrsenja==null){
            this.datumIzvrsenja = null;
            return;
        }
        if(datumIzvrsenja.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Datum izvrsavanja naloga ne sme da bude u buducnosti!");
        this.datumIzvrsenja = datumIzvrsenja;
    }

    /**
     * Vraca status naloga (0 ako je nezavrsen ili 1 ako je zavrsen).
     * @return status naloga, tipa {@link short}.
     */
    public short getStatus() {
        return status;
    }

    /**
     * Postavlja novu vrednost statusa.
     * 
     * Moze biti iskljucivo 0 ili 1.
     * 
     * @param status status naloga, tipa {@link short}
     * @throws IllegalArgumentException ako status nije 0 ni 1.
     */
    public void setStatus(short status) {
        if(status !=0 && status != 1)
            throw new IllegalArgumentException("Status naloga moze da bude samo 0 ili 1!");
        this.status = status;
    }
    

    /**
     * Vraca datum kreiranja naloga.
     * @return datum servisiranja tipa {@link LocalDate}.
     */
    public LocalDate getDatumKreiranja() {
        return datumKreiranja;
    }

    /**
     * Postavlja novu vrednost za datum kreiranja.
     * 
     * @param datum kao nova vrednost datuma.
     * 
     * @throws NullPointerException ako je uneta vrednost null.
     * @throws IllegalArgumentException ako se uneti datum odnosi na buducnost.
     */
    public void setDatumKreiranja(LocalDate datum) {
    	if(datum == null)
    		throw new NullPointerException("Datum kreiranja naloga ne sme biti null!");
    	if(datum.isAfter(LocalDate.now()))
    		throw new IllegalArgumentException("Datum kreiranja naloga ne sme da bude u buducnosti!");
        this.datumKreiranja = datum;
    }

    /**
     * Vraca cenu servisa.
     * @return cena servisa tipa {@link double}.
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
                                "INNER JOIN vlasnik AS v ON a.vlasnikid=v.vlasnikid "+
                                "INNER JOIN marka AS m ON a.markaid=m.markaid "+
                                "INNER JOIN uocenikvar AS uk ON n.kvarid=uk.kvarid "+
                                "INNER JOIN korisnici AS k ON n.serviserid=k.korisnik_id " : "nalog ";
    }

    @Override
    public String getKoloneZaInsert() {
        return "datum_kreiranja, cena, tablice, kvarid, serviserid, status";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "?,?,?,?,?,?";
    }

    @Override
    public String vratiVrednostiZaSelect() {
        return "nalogid, datum_kreiranja, datum_izvrsenja, cena, status, n.tablice, a.vlasnikid, v.ime, v.prezime, v.email, v.telefon, a.godiste, a.markaid, m.naziv, n.kvarid, uk.opis, n.serviserid, k.ime, k.prezime, k.username, k.email";
    }

    @Override
    public void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        statement.setDate(1, java.sql.Date.valueOf((LocalDate) ((NalogZaServisiranje) domainObject).getDatumKreiranja()));
        statement.setDouble(2, ((NalogZaServisiranje) domainObject).getCena());
        statement.setString(3, ((NalogZaServisiranje) domainObject).getKvar().getAutomobil().getTablice());
        statement.setInt(4, ((NalogZaServisiranje) domainObject).getKvar().getKvarID());
        statement.setInt(5, ((NalogZaServisiranje) domainObject).getServiser().getKorisnikId());
        statement.setInt(6, ((NalogZaServisiranje) domainObject).getStatus());
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
                Vlasnik vlasnik = new Vlasnik(rs.getInt("a.vlasnikid"), rs.getString("v.ime"), rs.getString("v.prezime"), rs.getString("v.email"), rs.getString("v.telefon"));
                Automobil automobil = new Automobil(rs.getString("n.tablice"), vlasnik, rs.getInt("a.godiste"), marka, new ArrayList<>());
                UoceniKvar uk = new UoceniKvar(automobil, rs.getInt("n.kvarid"), rs.getString("uk.opis"));
                Korisnik s = new Korisnik(rs.getInt("n.serviserid"), rs.getString("k.ime"), rs.getString("k.prezime"), rs.getString("k.username"), "not available", new Uloga(2, "serviser"), rs.getString("k.email"));
                NalogZaServisiranje nalog = new NalogZaServisiranje(rs.getInt("nalogid"), rs.getDate("datum_kreiranja").toLocalDate(), rs.getDouble("cena"), uk, s);
                Date datummIzvrsenja = rs.getDate("datum_izvrsenja");
                nalog.setStatus((short) rs.getInt("status"));
                if(datummIzvrsenja != null){
                    nalog.setDatumIzvrsenja(datummIzvrsenja.toLocalDate());
                } else {
                    nalog.setDatumIzvrsenja(null);
                }
                
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
        return "status=?, datum_izvrsenja=?";
    }

    @Override
    public void postaviVrednostiZaUpdate(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException {
        LocalDate datumIzvrsavanja = ((NalogZaServisiranje)domainObject).getDatumIzvrsenja();
        statement.setInt(1, ((NalogZaServisiranje)domainObject).getStatus());
        if(datumIzvrsavanja == null){
            statement.setDate(2, null);
        }else {
            statement.setDate(2, java.sql.Date.valueOf(datumIzvrsavanja));
        }
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaVise() {
        return this.serviser==null ? "LOWER(n.tablice) LIKE '" + this.kvar.getAutomobil().getTablice() + "%'" + " ORDER BY datum_kreiranja DESC"
             : "n.serviserid=" + this.serviser.getKorisnikId() + " ORDER BY datum_kreiranja DESC";
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
