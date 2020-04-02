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
     * @Tjorven Bruns
    */
    public void zettelAufnehmen(Zettel zettel)
    {
        if(zettel.getText()=="Ich weiß nicht"){inventar.addZettel(1);}
        if(zettel.getText()=="was hier rein soll."){inventar.addZettel(2);}
        if(zettel.getText()=="Daher"){inventar.addZettel(3);}
        if(zettel.getText()=="Ich mache auch mit"){inventar.addZettel(4);}
        if(zettel.getText()=="erstmal irgendwas"){inventar.addZettel(5);}
        //identifizieren des Zettels und übergeben ans Inventar
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
     * @ein, zwei kleine Aenderungen von Tjorven Bruns, um das Rätsel zu berichtigen
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
