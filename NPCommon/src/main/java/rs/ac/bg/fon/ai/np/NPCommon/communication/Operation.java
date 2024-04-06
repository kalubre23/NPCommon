/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package rs.ac.bg.fon.ai.np.NPCommon.communication;

/**
 * Predstavlja enumeraciju u kojoj su nabrojane sve sistemske operacije.
 *
 * @author Luka Obrenic
 * @since 1.0.0
 */
public enum Operation {
    LOGIN,
    UCITAJ_LISTU_MARKI,
    SACUVAJ_AUTOMOBIL,
    PRONADJI_AUTOMOBILE,
    IZMENI_AUTOMOBIL,
    OBRISI_AUTOMOBIL,
    VRATI_SVE_AUTOMOBILE,
    UCITAJ_LISTU_DELOVA_AUTOMOBILA,
    SACUVAJ_POKVAREN_DEO,
    VRATI_SVE_POKVARENE_DELOVE,
    PRONADJI_POKVARENE_DELOVE,
    OBRISI_POKVAREN_DEO,
    IZMENI_POKVAREN_DEO,
    SACUVAJ_NALOG_ZA_SERVISIRANJE,
    PRONADJI_NALOGE_ZA_SERVISIRANJE,
    VRATI_SVE_NALOGE_ZA_SERVISIRANJE,
    OBRISI_NALOG_ZA_SERVISIRANJE,
    LOGOUT,
}
