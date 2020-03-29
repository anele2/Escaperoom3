import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
/**
 * Spieler-Klasse. Kann mit der Gui interagieren. 
 * 
 * @author Mina Granzin, Tim Jascheck  
 * @12.03.2020
 */
public class Spieler
{
    private int blickrichtung;
    private Inventar inventar;
    private String verfassung; //wohlbefinden, kann durch Interaktion mit Gegenständen beeinflusst werden
    /**
     * Standard-Konstruktor für Objekte der Klasse Spieler
     */
    public Spieler()
    {
        blickrichtung = 0;
        inventar=new Inventar();
    }

    /**
     * Nach Links schauen.
     */
    public void nachLinksKucken()
    {
        setBlickrichtung((blickrichtung+3)%4); //Damit der Wert der Blickrichtung nicht Ã¼ber 3 steigt wird der Operator % (Rest) verwedet
    }
    
    /**
     * Nach Rechts schauen.
     */
    public void nachRechtsKucken()    
    {            
        setBlickrichtung((blickrichtung+1)%4); //Damit der Wert der Blickrichtung nicht Ã¼ber 3 steigt wird der Operator % (Rest) verwedet 
    }  
    
    /**
     * @param Setze den Wert der aktuellen Blickrichtung des Spielers.
     */
    private void setBlickrichtung(int neueBlickrichtung)
    {
        blickrichtung = neueBlickrichtung;
    }
    
    /**
     * @return Liefere den Wert der aktuellen Blickrichtung des Spielers.
     */
    public int getBlickrichtung()
    {
        return blickrichtung;
    }
    
    /**
     * @return Liefere eine Referenz auf das Inventar des Spielers.
     */
    public Inventar getInventar()
    {
        return inventar;
    }
    
    /**
     * @return gibt den Zustand des Spielers zurück
     */
    public String getVerfassung()
    {
        return verfassung;
    }
    
    /**
     * @param Die Flasche, die getrunken wird.
     * @ein paar kleine Aenderungen von Tjorven Bruns
     */
    public void trinke(Flasche flasche)
    {
        if(flasche.getInhalt()=="wein") {verfassung = "angetrunken";} //Wenn Wein getrunken wird
        if(flasche.getInhalt()=="gift") {verfassung = "tot";} //Wenn Gift getrunken wird
        if(flasche.getInhalt()=="vorwaerts"||flasche.getInhalt()=="zurueck") {verfassung = "bereit";} //Wenn der richtige Trank getrunken wird
        //Hier kommen spaeter noch mehr Optionen hin, fuer die anderen Traenke
        flasche.setVoll(false);
    }
}
