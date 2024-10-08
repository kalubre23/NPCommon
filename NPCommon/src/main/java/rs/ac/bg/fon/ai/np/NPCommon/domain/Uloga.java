/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.io.Serializable;

/**
 * Pomocna klasa koja oznacava ulogu korisnika. Postoje samo 2 uloge: serviser i admin.
 * 
 * @author Luka Obrenic
 */
public class Uloga implements Serializable{
    /**
     * Jedinstveni identifikator uloge (1 ako je admin ili 2 ako je serviser).
     */
    private int ulogaId;
    /**
     * Naziv uloge (serviser ili admin).
     */
    private String uloga;

    /**
     * Prazan konstruktor za kreiranje objekta.
     */
    public Uloga() {
    }

    /**
     * Parametrizovan konstruktor za kreiranje objekta.
     * 
     * @param ulogaId jedinstveni indentifikator uloge (1 ili 0)
     * @param uloga naziv uloge
     */
    public Uloga(int ulogaId, String uloga) {
        this.ulogaId = ulogaId;
        this.uloga = uloga;
    }

    /**
     * Vraca ID uloge, kao int.
     * 
     * @return ID uloge.
     */
    public int getUlogaId() {
        return ulogaId;
    }

    /**
     * Postavlja novu vrednost uloge korisnika.
     * 
     * Moze biti samo 1(admin) ili 2(serviser).
     * 
     * @param ulogaId novi ID uloge, tipa int.
     * @throws IllegalArgumentException ako nije uneta 1 ili 2.
     */
    public void setUlogaId(int ulogaId) {
        if(ulogaId!=1 && ulogaId!=2)
            throw new IllegalArgumentException("ID uloge moze biti samo 1 ili 2!");
        this.ulogaId = ulogaId;
    }

    /**
     * Vraca naziv uloge, kao string.
     * @return uloga kao naziv uloge.
     */
    public String getUloga() {
        return uloga;
    }

    /**
     * Postavlja naziv uloge.
     * 
     * Ne sme biti prazan string niti null. Moze biti samo "admin" ili "serviser".
     * 
     * @param uloga novi naziv uloge.
     * @throws IllegalArgumentException ako je unet prazan string, ili uloga nije ni "admin" niti "serviser".
     * @throws NullPointerException ako je uneta null vrednost kao parametar.
     */
    public void setUloga(String uloga) {
        if(uloga==null)
            throw new NullPointerException("Naziv uloge ne sme biti null!");
        if(!(uloga.equals("admin") || uloga.equals("serviser")))
            throw new IllegalArgumentException("Naziv uloge mora biti 'admin' ili 'seviser'!");
        this.uloga = uloga;
    }

    /**
    * Vraca string reprezentaciju uloge na osnovu atributa uloga koji predstavlja naziv uloge.
    * 
    * @return uloga naziv uloge.
    */
    @Override
    public String toString() {
        return this.uloga;
    }

    /**
    * Poredi dve uloge prema jedinstvenom identifikatoru.
    * 
    * @return
    * <ul>
    * 		<li> true ako su jedinstveni identifikatori isti </li>
    * 		<li> false ako je unet null, ako objekat nije klase Uloga ili ako su razliciti identifikatori </li>
    * <ul>
    */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Uloga))
            return false;
       
        Uloga other =(Uloga)obj;
        return other.getUlogaId()== this.ulogaId;
    }
    
    
    
}
