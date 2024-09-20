/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.domain;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Uloga implements Serializable{
    private int ulogaId;
    private String uloga;

    public Uloga() {
    }

    public Uloga(int ulogaId, String uloga) {
        this.ulogaId = ulogaId;
        this.uloga = uloga;
    }

    public int getUlogaId() {
        return ulogaId;
    }

    public void setUlogaId(int ulogaId) {
        this.ulogaId = ulogaId;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    @Override
    public String toString() {
        return this.uloga;
    }
    
    
    
    
}
