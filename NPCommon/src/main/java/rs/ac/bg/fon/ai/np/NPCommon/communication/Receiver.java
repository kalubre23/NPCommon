/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Predstavlja primaoca podataka kroz socket.
 * 
 * Ima socket pomocu koga prima podatke i jednu metodu koja vraca objekat koji je primljen.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public class Receiver {
	/**
	 * Socket za komunikaciju kroz mrezu.
	 */
    private Socket socket;

    /**
     * Parametrizovani konstruktor pomocu koga ce se inicijalizovati socket.
     * @param socket koji ce se dodeliti atributu socket.
     */
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Vraca objekat tipa Object.
     * 
     * Objekat je primljen iz ulaznog toka objekta (pomocu readObject metode) koji je inicijalizovan ulaznim tokom socketa.
     * 
     * @return objekat koji je primljen.
     * @throws Exception greska koja se javlja prilikom primanja objekta
     */
    public Object receive() throws Exception{
        try {
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Error receiving object!\n"+ex.getMessage());
        }
    }
}
