/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Predstavlja posiljaoca podataka kroz socket.
 * 
 * Ima socket pomocu koga salje podatke i jednu metodu koja salje objekat.
 *
 * @author Luka Obrenic
 */
public class Sender {
	/**
	 * Socket za komunikaciju kroz mrezu.
	 */
    private Socket socket;

    /**
     * Parametrizovani konstruktor pomocu koga ce se inicijalizovati socket.
     * @param socket koji ce se dodeliti atributu socket.
     */
    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Salje objekat tipa Object.
     * 
     * Objekat dobijen preko parametra salje u ulazni tok objekta. Ulazni tok objekta je inicijalizovan
     * preko ulaznog toka socket-a.
     * @param object koji treba poslati.
     * @throws Exception greska koja se javlja prilikom slanja objekta.
     */
    public void send(Object object) throws Exception{
        try {
            ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Error sending object: \n"+ex.getMessage());
        }
        
    }
}
