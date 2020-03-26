import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
/**
 * SpielGUI bring die einzelnen ELemente des Spieles durch die beutzung der GUI fÃ¼r den Spieler zusammen.
 * 
 * @Tim Jascheck; Mina Granzin; Elena Nehse; Paula Seidler; Tjorven Bruns (wenn bei einer Methode/Code-Abschnitt kein Autor explizit erwaehnt ist, waren alle Klassen-Autoren beteiligt)
 * @11.02.2020
 */
public class SpielGUI
{
    /**
     * Blickrichtungen: Fuer Blickrichtungen werden in Zukunft diese Zahlen als Synonyme verwendet.
     *
        Norden = 0;
        Osten = 1;
        Sueden= 2;
        Westen = 3;
     */ 
  
    /**Der Spieler*/
    private Spieler spieler;
    
    /** Die Raeume des Spiels */  
    private Raum raumEins; //Vorerst gibt es nur einen Raum im Spiel
    
    /** Hier spielt die Musik */
    private JFrame fenster;
    /**Die Hoehe und Laenge des Fensters*/
    private int length = 1600;
    private int height = 1000;
    
    /** Aktuelle Wand. */ 
    private Container aktuelleWand;
    
    /** Ebenen der Wand*/
    private JLayeredPane manager;
    
    /** Darstellung des Inventars */    
    private InventarAnzeige inventarAnz;
    
    /** Inventar mit GUI bekannt machen*/
    private Inventar inventar;
        
    /** Farben fuer die GUI. 3 Arten von Blau + Grau + Braun */
        Color hellBlau = new Color(225, 236, 255);
        Color blau = new Color(205, 224, 255);
        Color dunkelBlau = new Color(191, 215, 255);
        Color grau = new Color(180, 180, 180);
        Color braun = new Color(230, 176, 170);
    
    
        
    public static void main(String[] args) {
        new SpielGUI();
    }
        
    /**
     * Konstruktor fuer die Spiel-GUI
     */
    public SpielGUI()
    {        
        raumEins = new Raum(); //Vorerst nur ein Raum
        spieler = new Spieler(); //Hier wird der Spieler gespeichert
        fensterErzeugen();        
    }

    /**
     * Erzeugt die GUI.
     */
    public void fensterErzeugen()
    {
        fenster = new JFrame("Escape-Room"); ;
        
        /** Ein Border-Layout schien als Grundbaustein des Spieles sinnvoll*/
        BorderLayout mainLayout = new BorderLayout();
        fenster.setLayout(mainLayout);

        /** Hinweisebene und Wand wird eingefügt*/
        aktuelleWand = raumEins.getWand(0).getWandCon();
        erzeugeWandanzeige(); //@Elena Nehse//kurz geworden. Doch direkt hier?
        fenster.add(aktuelleWand, BorderLayout.CENTER);
        
        /** Erstellen die Buttons, mit denen man sich im Raum bewegen kann. */
        nachRechtsButton();
        nachLinksButton();
        
        /** Erstellt eine Inventar-Anzeige, die wiederum ein Inventar-Objekt erzeugt*/
        erzeugeInv();
        
        /** Aufbau abgeschlossen - Komponenten arrangieren lassen */
        fenster.setSize(length, height); //An den Zahlen kann nochmal gefeilt werden
        fenster.setVisible(true);
        fenster.setResizable(true);
    }
    /**
     * @author Tjorven Bruns, Tim Jascheck
     * Hier werden die PopUp Menues für die Gegenstaende erzeugt
     * @param gegenstand Der Gegenstand, der ein Pop-Up-Menue bekommt
     * @return Das Pop-Up Menue fuer den Gegenstand
     */
    private JPopupMenu popUp(Gegenstand gegenstand) 
    {
        JPopupMenu menue = new JPopupMenu();
        if(gegenstand instanceof Flasche) //Ein Pop-Up für Flasche
        {          
            Flasche flasche = (Flasche)gegenstand; //Gegenstand wird als Flasche zwischengespeichtert
            JMenuItem eintragTrinken = new JMenuItem("trinken");
            eintragTrinken.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) {if(flasche.getFuelle() == true){spieler.trinke(flasche); reaktion();}
                                                                else{setMitte(new JLabel("Der letzte Tropfen ist verronnen... Diese Flasche ist bereits leer.", JLabel.CENTER));}} //Die Flasche wird getrunken
                }
                );            
            menue.add(eintragTrinken);
        }
        if(gegenstand instanceof Zettel) //Ein Pop-Up für Zettel, unvollstaendig, noch koennen die Zettel nicht aufgenommmen werden
        {
            JMenuItem eintragTrinken = new JMenuItem("einsammeln");
            eintragTrinken.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) {//spieler.zettelAufnehmen();, noch nicht implementiert
                    } 
                }
                );            
            menue.add(eintragTrinken);
        }
        return menue;
    }
    
    /**
     * @author Elena Nehse
     * Verändert die GUI (,zeigt ein Textlabel an,) um die Auswirkungen einer Handlung darzustellen.
     * genutzt für FlascheTrinken
     */
    public void reaktion()
    {
        String auslöser = spieler.getVerfassung();
        if(auslöser == "angetrunken"){setMitte(new JLabel("Ihgitt! Alkohol ist auch in diesem Fall keine Lösung!", JLabel.CENTER));}
        if(auslöser == "tot"){setMitte(new JLabel("Oh, oh, das wars wohl...", JLabel.CENTER));}
        if(auslöser == "bereit"){setMitte(new JLabel("Herzlichen Gl\u00FCckwunsch! Du hast das R\u00E4tsel erfolgreich gel\u00F6st", JLabel.CENTER));}
    }
    
    /**
     * @return Den Spieler der GUI
     * @author Tim Jascheck
     */
    public Spieler getSpieler()
    {
        return spieler;
    }
    
    /**
     * Als extramethode überhaupt nötig?
     * Ebenen werden eingefügt
     * Wand wird eingefügt
     * darüber werden eventuelle Hinweise gelegt
     * @author Elena Nehse, Paula Seidler
     */
    private void erzeugeWandanzeige()
    {
        manager = fenster.getLayeredPane();//Container mit mehreren Ebenen
        gegenstaendeHinzufügen(); //Die Gegenstaende werden unsichtbar hinzugefuegt
        gegenstaendeSichtbarkeitAendern(0,true); //Die Gegenstaende werden angezeigt
    }
    
    /**
     * @author Elena Nehse, Paula Seidler, Tim Jascheck, Tjorven Bruns
     * alle Gegenstände des Raumes werden dem Fenster hinzugefügt, sind allerdings nicht sichtbar
     */   
    private void gegenstaendeHinzufügen()
    {
        int platzImManager = 1;
        for(int w=0; w<4; w++)//geht alle Wände des Raumes durch
        {
            int anzahlGegenstaende = raumEins.getWand(w).getGegenstaende().size();
            for(int i=0; i<anzahlGegenstaende; i++)//geht alle Gegenstände der Wand durch
            {
                //Abbild des Gegenstandes wird eingefügt, an die richtige Stelle verschoben und unsichtbar gemacht
                Gegenstand aktuellerGegenstand = raumEins.getWand(w).getGegenstaende().get(i);//zwischenspeicher
                manager.add(aktuellerGegenstand.getAussehen(),new Integer(platzImManager)); 
                platzImManager++; 
                aktuellerGegenstand.getAussehen().setVisible(false); 
                aktuellerGegenstand.getAussehen().setLocation(aktuellerGegenstand.getXPosition(),aktuellerGegenstand.getYPosition());
                aktuellerGegenstand.getAussehen().addMouseListener(new MouseListener() 
                    {
                        public void mouseClicked(MouseEvent e) {popUp(aktuellerGegenstand).show(e.getComponent(),e.getX(), e.getY());} //Hier wird dem Gegenstand eine Pop-UIp Menue hinzugefuegt
                        public void mouseEntered(MouseEvent e) {}
                        public void mouseExited(MouseEvent e) {}
                        public void mousePressed(MouseEvent e) {}
                        public void mouseReleased(MouseEvent e) {}
                    }     
                    ); //Gegenstand kann auf Mauszustände reagieren
                                
            }
        }
        
    }
    
    /**
     * Erstellen die Buttons, mit denen man sich im Raum bewegen kann/umschauen kann. 
     * @Mina Granzin, Tim Jascheck 
     */
    public void nachRechtsButton()
    {
        JButton nachRechts = new JButton("->");  //Vielleicht kann man sich hier spÃ¤ter etwas schÃ¶neres Ã¼berlegen
            nachRechts.setFont(new Font("Serif", Font.BOLD, 16));  //Schriftanpassung
            nachRechts.setBackground(grau); //Farbanpassung 
            fenster.add(nachRechts, BorderLayout.EAST);                      
            nachRechts.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) { int alteBlick = spieler.getBlickrichtung(); spieler.nachRechtsKucken(); wandWechsel(spieler.getBlickrichtung(),alteBlick);}
                }     
                );             
    }    
    public void nachLinksButton()
    {
        JButton nachLinks = new JButton("<-");  //Vielleicht kann man sich hier spÃ¤ter etwas schÃ¶neres Ã¼berlegen
            nachLinks.setFont(new Font("Serif", Font.BOLD, 16));  //Schriftanpassung
            fenster.add(nachLinks, BorderLayout.WEST);                    
                nachLinks.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) { int alteBlick = spieler.getBlickrichtung(); spieler.nachLinksKucken(); wandWechsel(spieler.getBlickrichtung(),alteBlick);}
                }     
                ); 
                nachLinks.setBackground(grau); //Farbanpassung
    }
      
    /**
     * Ändert die Sichtbarkeit aller Gegenstände einer Wand
     * @param int wand, verweis auf Hinweise einer Wand
     * @param boolean sichtbar, übergibt gewünschten Zustand
     * @author Elena Nehse
     */    
    public void gegenstaendeSichtbarkeitAendern(int wand, boolean sichtbar)
    {
        int anzahlGegenstaende = raumEins.getWand(wand).getGegenstaende().size(); //Die Anzahl der Gegenstaende wird gespeichert
            for(int i=0; i<anzahlGegenstaende; i++)
            {
                raumEins.getWand(wand).getGegenstaende().get(i).getAussehen().setVisible(sichtbar);
                //ändert die Sichtbarkeit in übergebenen Zustand
            }
    }
            
    /**
     * Zeige eine bestimmte Wand
     * @param himmelsrichtung Gebe die Himmelsrichtung an, dessen Wand betrachtet wird. (0-3 = Norden-Westen)
     * @author Tim Jascheck, Mina Granzin
     */
    public void setMitte(Container wand)
    {
        fenster.remove(aktuelleWand); //Zunaechst wird die alte Wand entfernt
        aktuelleWand = wand;
        fenster.add(aktuelleWand, BorderLayout.CENTER);
        fenster.pack(); //Kriege noch nicht hin, das Fenster verlaesslich zu updaten, ohne es zu "packen"
        fenster.setSize(length, height); //Hier gibt es bestimmt eine schoenere Loesung 
    }    
    
    /**
     * Zeige eine bestimmte Wand
     * @param alteHimmelsrichtung Gebe die Himmelsrichtung an, dessen Wand zurzeit betrachtet wird. (0-3 = Norden-Westen)
     * @param neueHimmelsrichtung Gebe die Himmelsrichtung der neuen Wand an
     */
    public void wandWechsel(int neueHimmelsrichtung, int alteHimmelsrichtung)
    {
        //Zugriff Ã¼ber den Raum auf die Wand. 
        setMitte(raumEins.getWand(neueHimmelsrichtung).getWandCon());
        
        //Die Sichtbarkeit der Gegenstaende wird demenstprechend angepasst
        gegenstaendeSichtbarkeitAendern(alteHimmelsrichtung, false);
        gegenstaendeSichtbarkeitAendern(neueHimmelsrichtung, true);
        
    }
    
    /**
     * Erzeuge eine Inventar-Anzeige
     * @author Tim Jascheck, Mina Granzin
     */
    public void erzeugeInv()
    {        
        inventarAnz = new InventarAnzeige(this, spieler.getInventar());
        fenster.add(inventarAnz, BorderLayout.SOUTH);
    }
    
    public void standardAnzeigen() 
    {
        wandWechsel(spieler.getBlickrichtung(),0);
    }
} 
