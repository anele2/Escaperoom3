
import javax.swing.*;
/**
 * Write a description of class Flaschen here.
 *
 * @Elena Nehse
 * @28.02.2020
 */
public class Flasche extends Gegenstand
{
    private String inhalt;
    /**
     * Konstruktor fuer Objekte der Klasse Flasche
     * @param String bildDateipfad: Verweis auf das Bild, durch das die Flasche dargestellt werden soll
     * @param int ortX, int ortY geben den Ort an, an dem die Flasche sich im Raum befindet
     * @param int breite, int höhe bestimmen die Größe, in der die Flasche dargestellt werden soll
     */
    public Flasche(String fluessigkeit, String bildDateipfad, int ortX, int ortY, int breite, int höhe)
    {
        super(bildDateipfad,ortX,ortY, breite, höhe);//siehe Gegenstand
        inhalt=fluessigkeit;
    }

    /** folgende Methoden müssen noch implementiert werden, da abstrakt in der Oberklasse vorhanden
     * Änderung nötig!
     */
    public String getName(){return "falsch gelaufen";}
    public String getInhalt(){return inhalt;}    
    public JLabel getTextLabel(){return new JLabel("falsch gelaufen");}
    
    
}

