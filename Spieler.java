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
 * @21.02.2020
 */
public class Spieler
{
    private int blickrichtung;
    private Inventar inventar;   
    private SpielGUI gui1;
    /**
     * Standard-Konstruktor für Objekte der Klasse Spieler
     */
    public Spieler(SpielGUI gui)
    {
        blickrichtung = 0;
        inventar=new Inventar();
        gui1=gui;
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
     * @param Die Flasche, die getrunken wird.          
     */
    public void trinke(Flasche flasche)
    {
        if(flasche.getInhalt()=="wein") {gui1.setMitte(new JLabel("Ihgitt! Alkohol ist auch in diesem Fall keine Lösung!", JLabel.CENTER));} //Wenn Wein getrunken wird
        if(flasche.getInhalt()=="gift") {gui1.setMitte(new JLabel("Oh, oh, das wars wohl...", JLabel.CENTER));} //Wenn Gift getrunken wird
        //else{gui1.setMitte(new JLabel("Ein fader Geschmack von Nichts...", JLabel.CENTER));} //Mehr als vorübergehende Ausweichoption
    }
}
