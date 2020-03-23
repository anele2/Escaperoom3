import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
/**
 * Spieler-Klasse. Kann mit der Gui interagieren. 
 * 
 * @Tjorven Bruns, (ueberarbeitung Array->ArrayList: Tim Jascheck, Mina Granzin)
 * @12.03.2020
 */
public class Inventar
{
    /**Gegenstaende werden hier gespeichert*/
    private ArrayList<Gegenstand> gegenstaende;
    /**
     * Konstruktor für Objekte der Klasse Inventar
     */
    public Inventar()
    {
        gegenstaende = new ArrayList<Gegenstand>();
        /**Vorerst noch hier erstellt; spaeter sollen die Gegenstaende per Parameteruebergabe dem Inventar hinzugefuegt werden*/
        gegenstaende.add(new Zettel("Die Gefahr liegt"+ "\n" +" vor Euch, Die Rettung zurück, zwei von uns helfen, bei denen habt ihr Glück. Eine von uns sieben die bringt Euch von dannen, Eine andere führt den Trinker zurück durch die Flammen. Zwei von uns bergen nur guten Nesselwein. Drei von uns sind Mörder, warten auf Eure Pein. Wählet die rechten, wollt Ruhm ihr gewinnen, Wählet die falschen, Bleibt ihr hier drinnen. Euch sollen vier Hinweise helfen:"));
        gegenstaende.add(new Zettel("1.	So schlau das Gute auch versteckt sein mag, es steht immer zur Linken vom Nesselwein "));
        gegenstaende.add(new Zettel("2.	Die Beiden an den Enden sind ganz verschiedene Leut, doch wenn ihr eine weitergeht, ist keiner euer Freund! "));
        gegenstaende.add(new Zettel("3.	Wie ihr deutlich seht, sind alle verschieden groß, doch Zwerg und Riese enthalten euren Tod "));
        gegenstaende.add(new Zettel("4.	Die zweite von links und die zweite von rechts werden Zwillinge sein, so verschieden sie auch schauen auf den ersten Blick drein. "));
    }
    
    /**
     * @return Liefert die Array Liste der Gegenstaende zurueck
     */
    public ArrayList<Gegenstand> getGegenstaende()
    {
        return gegenstaende;
    }
    
    /**
     * @param nummer Die Stelle der Liste
     * @return Liefert den Gegenstand an einer bestimmten Stelle der Liste
     */
    public Gegenstand getGegenstand(int nummer)
    {
        return gegenstaende.get(nummer);
    }
}