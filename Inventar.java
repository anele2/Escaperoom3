import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
/**
 * Spieler-Klasse. Kann mit der Gui interagieren. 
 * 
 * @Tim Jascheck, Mina Granzin 
 * @21.02.2020
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
        gegenstaende.add(new Zettel("Hier steht der Text des Zettels; also der Hinweis für das Snape-Raetsel"));
        gegenstaende.add(new Zettel("Der zweite Zettel mit einem tollen Hinweis"));
    }
    
    /**
     * @return Liefert die Array Liste der Gegenstaende zurueck
     */
    public ArrayList<Gegenstand> getGegenstaende()
    {
        return gegenstaende;
    }
}
