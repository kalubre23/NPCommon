/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.Serializable;

/**
 * Predstavlja transfer objekat koji se salje od servera do klijenta kao odgovor.
 * 
 * Ima rezultat koji se vraca klijentu i izuzetak ukoliko je doslo do greske.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class Response implements Serializable{
	/**
	 * Rezultat koji se vraca klijentu, tipa Object.
	 */
    private Object result;
    /**
     * Izuzetak koji se vraca klijentu ukoliko se desila greska na serveru.
     */
    private Exception exception;

    /**
     * Prazan konstruktor za kreiranje objekta klase Response sa podrazumevanim vrednostima za njene atribute.
     */
    public Response() {
    }

    /**
     * Parametrizovani konstruktor pomocu koga se inicijalizuje objekat klase Response i dodeljuju vrednosti atributima.
     * @param result - Rezultat koji server vraca klijentu.
     * @param exception - Izuzetak ukoliko se desila greska na serveru
     */
    public Response(Object result, Exception exception) {
        this.result = result;
        this.exception = exception;
    }

    /**
     * Vraca vrednost rezultata servera tipa Object.
     * @return result vrednost rezultata tipa Object
     */
    public Object getResult() {
        return result;
    }

    /**
     * Postavlja novu vrednost rezultata.
     * @param result nova vrednost rezultata tipa Object
     */
    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * Vraca izuzetak kao Exception.
     * @return exception tipa Exception
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Postavlja novu vrednost izuzetka.
     * @param exception tipa Exception
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "Response{" + "result=" + result + ", exception=" + exception + '}';
    }
    
}
