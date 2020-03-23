import javax.swing.*;
/**
 * Write a description of class Flaschen here.
 *
 * @Elena Nehse, Tim Jascheck
 * @12.03.2020
 */
public class Flasche extends Gegenstand
{
    private String inhalt; //Welcher Trank in der Flasche ist
    private boolean voll; //Speichert, ob aus der Flasche bereits getrunken wurde, noch keine Funktionalitaet, aber evtl. fuer erweiterungen nuetzlich
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

    /** 
     * Basis-Methoden
     */
    public String getName(){return "Flasche";}
    public String getInhalt(){return inhalt;}        
    public void setVoll(boolean voll1){voll=voll1;}
    /**Voerst noch unfunktional*/
    public JLabel getTextLabel(){return new JLabel("falsch gelaufen");}
}

