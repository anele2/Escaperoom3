import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
/**
 * Spieler-Klasse. Kann mit der Gui interagieren. 
 * 
 * @Tim Jascheck, Mina Granzin, Tjorven Bruns 
 * @21.02.2020
 */
public class Inventar
{
    /**Gegenstaende werden hier gespeichert*/
    private Zettel[] objects; //Array erzeugen
    private Zettel zettel1;
    private Zettel zettel2;
    private Zettel zettel3;
    private Zettel zettel4;
    private Zettel zettel5;
    
    Container inventarCont;
    /**
     * Konstruktor für Objekte der Klasse Inventar
     */
    public Inventar()
    {
        objects = new Zettel[5]; //Anzahl der "Plätze" im Array festlegen (5 für jeden Hinweis einen)
        inventarCont=new Container();
        //Vorerst noch hier erstellt; spaeter sollen die Gegenstaende per Parameteruebergabe dem Inventar hinzugefuegt werden
        //gegenstaende.add(new Zettel("Hier steht der Text des Zettels; also der Hinweis für das Snape-Raetsel"));
        zettel1 = new Zettel("Hier steht der Text des Zettels; also der Hinweis für das Snape-Raetsel"); //Die Zettel werden erzeugt
        zettel2 = new Zettel("Der zweite Zettel mit einem tollen Hinweis");
        zettel3 = new Zettel("Der dritte Zettel mit einem noch tolleren Hinweis");
        zettel4 = new Zettel("Der vierte Zettel, der Hinweis darauf ist wirklich unglaublich");
        zettel5 = new Zettel("Der fünfte Zettel; der Hinweis macht einen sprachlos");
    }   
    
    /** @ Tjorven Bruns 
     * Die Zettel werden per Mausklick ins Inventar aufgenommen
    */
    public void aufnehmen()
    {
        zettel1.getTextLabel().addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent e) {objects[0] = zettel1;}
            }     
            ); 
        zettel2.getTextLabel().addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent e) {objects[1] = zettel2;}
            }     
            ); 
        zettel3.getTextLabel().addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent e) {objects[2] = zettel3;}
            }     
            ); 
        zettel4.getTextLabel().addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent e) {objects[3] = zettel4;}
            }     
            ); 
        zettel5.getTextLabel().addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent e) {objects[4] = zettel5;}
            }     
            ); 
        //Der jeweilige Zettel wird per MouseListener auf das passende Objekt gespeichert
    }
    
    /**
     * @ Tjorven Bruns
     * Gibt das Objekt an der Stelle index-1 zurück 
     */
    public Zettel getObjectAt(int index)
    {
        if(index<5||index>=0)
        {
            return objects[index];
        }
        else
        {
            return null;
        }
    }
    
    public Zettel[] getObjects()
    {
        return objects;
    }

}
