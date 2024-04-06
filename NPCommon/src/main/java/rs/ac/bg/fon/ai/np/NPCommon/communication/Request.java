/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.Serializable;

/**
 * Predstavlja transfer objekat koji se salje od klijenta do servera kao zahtev.
 * 
 * Ima operaciju koju je potrebno izvrsiti i argument.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class Request implements Serializable{
	/**
	 * Operacija koju je potrebno izvrsiti na serverskoj strani kao enum Operation.
	 */
    private Operation operation;
    /**
     * Objekat koji se salje serveru tipa Object, nad kojim ce se izvrsiti operacija.
     * 
     * Moze da ostane null ukoliko je samo potrebno poslati operaciju do servera.
     */
    private Object argument;

    /**
     * Parametrizovani konstruktor pomocu koga se inicijalizuje objekat klase Request i dodeljuju vrednosti atributima.
     * @param operation - Operacija koju je potrebno izvrsiti
     * @param argument - Objekat nad kojim je potrebno izvrsiti operaciju
     */
    public Request(Operation operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    /**
     * Prazan konstruktor za kreiranje objekta klase Request sa podrazumevanim vrednostima za njene atribute.
     */
    public Request() {
    }

    /**
     * Vraca operaciju koju je potrebno izvrsiti.
     * @return operation koju je potrebno izvrsiti
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Postavlja novu vrednost operacije koju je potrebno izvrsiti.
     * @param operation nova vrednost operacije
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * Vraca argument tj objekat koji se salje serveru
     * @return argument objekat koji se salje serveru
     */
    public Object getArgument() {
        return argument;
    }

    /**
     * Postavlja novu vrednost argumenta tj objekta.
     * @param argument nova vrednost objekta
     */
    public void setArgument(Object argument) {
        this.argument = argument;
    }

    @Override
    public String toString() {
        return "Request{" + "operation=" + operation + ", argument=" + argument + '}';
    }

    
}
