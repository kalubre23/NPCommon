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
 * Predstavlja apstraktnu klasu koja sadrzi metode koje ce vratiti ime tabele u bazi, nazive kolona za operacije dodavanja i prikazivanja, 
 * vrednosti atributa za operaciju dodavanja, nazive metoda koje ce posluziti u radu sa ResultSet-om, 
 * vrednosti atributa za operaciju izmene podataka u bazi, uslove koji ce se koristiti u operacijama brisanja i izmene podataka...
 * 
 * @author Luka Obrenic
 * @since 1.0.0
 * 
 */
public abstract class DomenskiObjekat {

    /**
     * Vraca naziv tabele u bazi.
     * @return naziv tabele kao string.
     */
    public abstract String vratiNazivTabele();
    /**
    * Vraca nazive kolona za operaciju INSERT u SQL upitu.
    * @return nazivi kolona kao string.
    */
    public abstract String getKoloneZaInsert();
    /**
     * Vraca vrednosti koje treba ubaciti u bazu (nakon VALUES klauzule u SQL upitu).
     * @return vrednosti koje treba ubaciti kao string.
     */
    public abstract String vratiVrednostiZaInsert();
    /**
     * Vraca nazive kolona za SELECT SQL upit koje treba prikazati.
     * @return nazivi kolona kao string.
     */
    public abstract String vratiVrednostiZaSelect();
    /**
     * Postavlja vrednosti koje treba ubaciti u INSERT SQL upit ukoliko se koristi PreparedStatement.
     * 
     * Alternativa je metoda vratiVrednostiZaInsert koja ne koristi preparedStatement vec preko
     * string-a direktno vraca vrednosti koje je potrebno ubaciti u bazu.
     * 
     * @param statement koji treba "popuniti"
     * @param domainObject kao nadklasa svih domenskih klasa pomocu koje se popunjava statement
     * @throws SQLException ako se javi greska koju generise PreparedStatement
     */
    public abstract void postaviVrednostiZaInsert(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException;
    /**
     * Postavlja vrednosti koje treba ubaciti u SELECT SQL upit ukoliko se koristi PreparedStatement.
     * 
     * Alternativa je metoda vratiVrednostiZaSelect koja ne koristi preparedStatement vec preko
     * string-a direktno vraca vrednosti koje je potrebno ubaciti u bazu.
     * 
     * @param statement koji treba "popuniti"
     * @param domainObject kao nadklasa svih domenskih klasa pomocu koje se popunjava statement
     * @throws SQLException ako se javi greska koju generise PreparedStatement
     */
    public abstract void postaviVrednostiZaSelect(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException;
    /**
     * Vraca da li izvedena domenska klasa sadrzi jedinstveni identifikator.
     * @return 
     * <ul>
	 * 		<li> true ako sadrzi jedinstveni identifikator</li>
	 * 		<li> false ako ne sadrzi jedinstveni identifikator</li>
	 * <ul>
     */
    public abstract boolean sadrziAutoIncrementPK();
    /**
     * Vrsi mapiranje redova iz baze, dobijenih preko ResultSet-a, u listu instanci domenske klase.
     * 
     * Izvuku se podaci iz ResultSet-a pomocu kojih se inicijalizuje objekat domenske klase.
     * Takav objekat se dodaje u listu. Ovo se ponavlja sve dok se ne prodju svi redovi u ResultSet-u.
     * Nakon ovoga se lista vraca kao povratna vrednost.
     * @param rs ResultSet tj pokazivac(kursor) na redove iz baze
     * @return lista inicijalizovanih objekata domenske klase
     */
    public abstract List<DomenskiObjekat> vratiListuSvih(ResultSet rs);
    /**
     * Vrsi mapranje samo jednog reda iz baze, dobijenog preko ResultSet-a, u objekat domenske klase.
     * 
     * Alternativa metodi vratiListuSvih ukoliko je potrebno izvuci 
     * jedan red iz baze preko jedinstvenog identifikatora.
     * @param rs ResultSet tj pokazivac(kursor) na redove iz baze
     * @param objekat domenske klase koji ce se inicijalizovati i vratiti
     * @return inicijalizovan objekat domenske klase
     */
    public abstract DomenskiObjekat vratiJednog(ResultSet rs, DomenskiObjekat objekat);
    /**
     * Vraca vrednosti sa kojima treba izvrsiti UPDATE SQL upit (nakon klauzule SET), kao string.
     * @return vrednosti koje treba zameniti kao string.
     */
    public abstract String vratiVrednostiZaUpdate();
    /**
     * Postavlja vrednosti koje treba ubaciti u UPDATE SQL upit ukoliko se koristi PreparedStatement.
     * 
     * Alternativa je metoda vratiVrednostiZaUpdate koja ne koristi preparedStatement vec preko
     * string-a direktno vraca vrednosti koje je potrebno izmeniti u bazi.
     * 
     * @param statement koji treba "popuniti"
     * @param domainObject kao nadklasa svih domenskih klasa pomocu koje se popunjava statement
     * @throws SQLException ako se javi greska koju generise PreparedStatement
     */
    public abstract void postaviVrednostiZaUpdate(PreparedStatement statement, DomenskiObjekat domainObject) throws SQLException;
    /**
     * Vraca uslov pomocu kojeg trazimo jedan red u bazi (nakon WHERE klauzule), kao string.
     * @return uslov kao string.
     */
    public abstract String vratiUslovZaJednog();
    /**
     * Vraca uslov pomocu kojeg trazimo vise redova u bazi (nakon WHERE klauzule), kao string.
     * @return uslov kao string.
     */
    public abstract String vratiUslovZaVise();
    /**
     * Vraca uslov pomocu kojeg se trazi red koji treba azurirati (SQL UPDATE upit), kao string.
     * @return uslov kao string.
     */
    public abstract String vratiUslovZaUpdate();
    /**
     * Dodeljuje vrednost primarnog kljuca reda dobijenog iz baze, atributu
     * koji je jedinstveni identifikator objekta domenske klase.
     * @param primaryKey vrednost koju treba dodeliti jedinstvenom identifikatoru objekta domenske klase.
     */
    public abstract void postaviAutoIncrementPrimaryKey(int primaryKey);
    /**
     * Vraca objekat domenske klase koji je vezan za objekat druge domenske klase u kojoj je implementirana
     * ova metoda.
     * @return objekat domenske klase.
     */
    public abstract DomenskiObjekat vratiVezaniObjekat();
    /**
     * Vraca uslov vezanog objekta koji treba da se vrati iz baze zajedno sa drugim objektom (nakon WHERE klauzule), kao string.
     * 
     * Ova metoda ce se koristiti ukoliko je potrebno vratiti objekat iz baze, a zatim takodje vratiti sve ostale objekte druge domenske klase
     * koji su vezani za njega. Na primer: vratiti sve uocene kvarove za odredjeni automobil.
     * @return uslov vezanog objekta kao string.
     */
    public abstract String vratiUslovZaVezani();
    /**
     * Puni listu objekata koji su vezani sa drugim objektom domenske klase iz koga se i poziva ova metoda.
     * 
     * Dobijeni redovi iz baze se koriste da se inicijalizuju vezani objekti i popuni lista takvih objekata.
     * Zatim se ta lista dodeli atributu koji predstavlja listu vezanih objekata.
     * @param rs ResultSet koji predstavlja redove dobijene iz baze
     */
    public abstract void napuni(ResultSet rs);
}
