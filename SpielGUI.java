import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
//import java.awt.Point;
/**
 * SpielGUI bring die einzelnen ELemente des Spieles durch die beutzung der GUI fÃ¼r den Spieler zusammen.
 * 
 * @Tim Jascheck; Mina Granzin; Elena Nehse; Paula Seidler (wenn bei einer Methode/Code-Abschnitt kein Autor explizit erwaehnt ist, waren alle Klassen-Autoren beteiligt)
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
    
    private Gegenstand gegenstand;
    
    
    /**Der Spieler*/
    private Spieler spieler;
    
    /** Die Raeume des Spiels */  
    private Raum raumEins;
    
    /** Hier spielt die Musik */
    private JFrame fenster;
    
    /** Aktuelle Wand. */ 
    private Container aktuelleWand;
    
    /** Ebenen der Wand*/
    private JLayeredPane manager;
    
    /** Darstellung des Inventars */    
    private InventarAnzeige inventarAnz;
    
    /** Inventar mit GUI bekannt machen*/
    private Inventar inventar;
    
    private JPopupMenu menue;
    
    /** Farben fuer die GUI. 3 Arten von Blau + Grau + Braun */
        Color hellBlau = new Color(225, 236, 255);
        Color blau = new Color(205, 224, 255);
        Color dunkelBlau = new Color(191, 215, 255);
        Color grau = new Color(180, 180, 180);
        Color braun = new Color(230, 176, 170);
    
    private int length = 1600;
    private int height = 1000;
        
    public static void main(String[] args) {
        new SpielGUI();
    }
        
    /**
     * Konstruktor fuer die Spiel-GUI
     */
    public SpielGUI()
    {        
        raumEins = new Raum(); //Vorerst nur ein Raum
        spieler = new Spieler(this); //Hier wird der Spieler gespeichert
        fensterErzeugen();        
    }

    /**
     * Erzeugt die GUI.
     */
    public void fensterErzeugen()
    {
        fenster = new JFrame("Escape-Room"); 
        
        //Container contentPane = fenster.getContentPane();
        
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
        //test();
        
        /** Aufbau abgeschlossen - Komponenten arrangieren lassen */
        fenster.setSize(length, height); //An den Zahlen kann nochmal gefeilt werden
        fenster.setVisible(true);
        fenster.setResizable(true);
    }
    /**
     * @author Tim Jascheck
     * Die Idee dieser nicht Verwendeten Altnernativ-Version ist, ein Menue für jeden einzelnen Gegenstand zu verwenden, anstand immer das gleiche zu wervewnden, um da 
     */
    private JPopupMenu popUp(Gegenstand gegenstand) 
    {
        JPopupMenu menue = new JPopupMenu();
        if(gegenstand instanceof Flasche)
        {          
            Flasche flasche = (Flasche)gegenstand;
            JMenuItem eintragTrinken = new JMenuItem("trinken");;
            eintragTrinken.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) {spieler.trinke(flasche);}
                }
                );            
            menue.add(eintragTrinken);
        }
        if(gegenstand instanceof Zettel)
        {
            JMenuItem eintragTrinken = new JMenuItem("lesen");;
            eintragTrinken.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) {//spieler.zettelAufnehmen();
                    } 
                }
                );            
            menue.add(eintragTrinken);
        }
        return menue;
    }
    
    /**
     * Ebenen werden eingefügt
     * Wand wird eingefügt
     * darüber werden eventuelle Hinweise gelegt
     * @author Elena Nehse, Paula Seidler
     */
    private void erzeugeWandanzeige()
    {
        manager = fenster.getLayeredPane();//Container mit mehreren Ebenen
        gegenstaendeHinzufügen();
        gegenstaendeSichtbarkeitAendern(0,true);
    }
    
    /**
     * @author Elena Nehse, Paula Seidler
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
                manager.setLayer(aktuellerGegenstand.getAussehen(), 100);
                aktuellerGegenstand.getAussehen().setVisible(false);
                aktuellerGegenstand.getAussehen().setLocation(aktuellerGegenstand.getXPosition(),aktuellerGegenstand.getYPosition());
                aktuellerGegenstand.getAussehen().addMouseListener(new MouseListener() 
                    {
                        public void mouseClicked(MouseEvent e) {popUp(aktuellerGegenstand).show(e.getComponent(),e.getX(), e.getY());}
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
        int anzahlGegenstaende = raumEins.getWand(wand).getGegenstaende().size();
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
     * @param himmelsrichtung Gebe die Himmelsrichtung an, dessen Wand betrachtet wird. (0-3 = Norden-Westen)
     */
    public void wandWechsel(int neueHimmelsrichtung, int alteHimmelsrichtung)
    {
        //Zugriff Ã¼ber den Raum auf die Wand. SpÃ¤ter muss noch ein "aktueller Raum" als Attribut hinzugefuegt werden
        setMitte(raumEins.getWand(neueHimmelsrichtung).getWandCon());
        
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
