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
    private Zettel zettel1;
    private Zettel zettel2;
    private Zettel zettel3;
    private Zettel zettel4;
    private Zettel zettel5;
    /**
     * Konstruktor für Objekte der Klasse Inventar
     * @Mina Grazin und Tjorven Bruns sowie einen kleinen Teil von Tim Jascheck
     */
    public Inventar()
    {
        gegenstaende = new ArrayList<Gegenstand>();
        /**Vorerst noch hier erstellt; spaeter sollen die Gegenstaende per Parameteruebergabe dem Inventar hinzugefuegt werden*/
        zettel1 = new Zettel("<html><body> <p align='center'>Die Gefahr liegt vor euch, die Rettung zurück, <br> Zwei von uns helfen, bei denen habt ihr Glück, <br> Eine von uns sieben, die bringt euch von dannen, <br> Eine andere führt den Trinker zurück durch die Flammen, <br> Zwei von uns enthalten nur guten Nesselwein, <br> Drei von uns sind Mörder, warten auf eure Pein. <br> Wählet eine, wenn ihr weiterwollt und nicht zerstäuben hier. <br> Euch sollen vier Hinweise helfen:</p></body></html>",500,200,200,200);
        zettel2 = new Zettel("<html><body> <p align='center'>Erstens: so schlau das Gift versteckt mag sein,<br> `s steht immer zur Linken vom guten Nesselwein; </p></body></html> ",500,200,200,200);
        zettel3 = new Zettel("<html><body> <p align='center'>Zweitens: die beiden an den Enden sind ganz verschied`ne Leut,<br> doch wenn wollt weitergehen, so ist keine davon euer Freund; </p></body></html> ",500,200,200,200);
        zettel4 = new Zettel("<html><body> <p align='center'>Drittens: wie ihr deutlich seht, sind alle verschieden groß,<br> Doch Zwerg noch der Riese enthalten euren Tod. </p></body></html> ",500,200,200,200);
        zettel5 = new Zettel("<html><body> <p align='center'>Viertens: die zweite von links und die zweite von rechts werden gleichen Geschmack haben,<br> so verschiedene Gestalt sie auf den ersten Blick auch haben. </p></body></html>",500,200,200,200);
        //JLabel kann html lesen, somit konnte Mina Zeilenumbrüche erzeugen und den Text centern
    }
    
    /** @Tjorven Bruns 
     * Hier werden Zettel der ArrayList hinzugefügt
    */
    public void addZettel(int zettelzahl)
    {
        if(zettelzahl == 1){gegenstaende.add(zettel1);}//Zettel der ArrayList hinzufügen 
        if(zettelzahl == 2){gegenstaende.add(zettel2);}
        if(zettelzahl == 3){gegenstaende.add(zettel3);}
        if(zettelzahl == 4){gegenstaende.add(zettel4);}
        if(zettelzahl == 5){gegenstaende.add(zettel5);}
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
    public Gegenstand getGegenstand(int name)
    {
        return gegenstaende.get(name);
    }
    
}