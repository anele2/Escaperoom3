import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
/**
 * Superklasse von den Gegenstaenden.
 * 
 * @Tim Jascheck, @Elena Nehse
 * @21.02.2020
 */
public abstract class Gegenstand
{
    
    protected BildComponent aussehen;
    protected int xPosition;
    protected int yPosition;
    
    /**
     * Konstruktor für Objekte der Klasse Gegenstand
     * @param String bildDateipfad: Verweis auf das Bild für den Gegenstand
     * @param int ortX, int ortY geben den Ort an, an dem der Gegenstand sich im Raum befindet
     * @param int breite, int höhe bestimmen die Größe der Darstellung
     */
    public Gegenstand(String bildDateipfad, int ortX, int ortY, int breite, int höhe)
    {
        //übernommen von Jakob Kleine
        try {
            aussehen = new BildComponent(ImageIO.read(getClass().getResourceAsStream(bildDateipfad)));
        } catch (IOException e) {
            e.printStackTrace();
        } //bild für aussehen wird eingelesen
        xPosition = ortX; //Position wird vorerst nur gespeichert
        yPosition = ortY;
        aussehen.setSize(breite,höhe);//größe wird festgelegt
    }
    
    /**
     * @return ermöglicht Lesezugriff auf Attribut aussehen
     */
    public BildComponent getAussehen()
    {
        return aussehen;
    }
    
    /**
     * @return ermöglicht Lesezugriff auf Attribut xPosition
     */
    public int getXPosition()
    {
        return xPosition;
    }
    
    /**
     * @return ermöglicht Lesezugriff auf Attribut yPosition
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    public abstract String getName();
    
    /**
     * @return Liefert das Label vom Zettel zurueck. Wichtig für die Anzeige in der GUI.
     */
    public abstract JLabel getTextLabel();
}
