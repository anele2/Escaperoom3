import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
/**
 * Inventar Anzeige. Kann mit der Gui interagieren. 
 * 
 * @Tim Jascheck, Mina Granzin, Tjorven Bruns 
 * @21.02.2020
 */
public class InventarAnzeige extends JPanel
{
    /** Farben fuer die GUI. 3 Arten von Blau + Grau + Braun */
        Color hellBlau = new Color(225, 236, 255);
        Color blau = new Color(205, 224, 255);
        Color dunkelBlau = new Color(191, 215, 255);
        Color grau = new Color(180, 180, 180);
        Color braun = new Color(230, 176, 170);
        
    private SpielGUI gui;    
    private Inventar inventar;
    
    /**
     * Konstruktor fuer die Inventar-Anzeige
     * @param g Uebergebe die SpielGUI, die manipuliert werden soll 
     * @param inv Uebergebe das Inventar, mit dem die Anzeige verknüpft werden soll
     */
    public InventarAnzeige(SpielGUI g, Inventar inv)
    {
        gui = g;
        inventar = inv;        
        buttonInventar();    
    }

    /**
     * Die Gegenstandsbuttons werden erzeugt (entsprechent der Anzahl (mit den Namen der in ihnen gespeicherten Gegenstaenden))
     * 
     */
    public void buttonInventar()
    {    
        /**Das JPanel fuer die Buttons wird erzeugt*/
        JPanel inventarflaeche = new JPanel();
        FlowLayout inventarLayout = new FlowLayout();
        inventarflaeche.setLayout(inventarLayout);
        inventarflaeche.setBackground(braun);
        
        /**Die Buttons fuer die Gegenstaende werden erzeugt*/
            for(int i=0; i<inventar.getObjects().length; i++){
                try
                {
                    JButton gegenstandBtn = erstelleButton(inventar.getObjectAt(i));
                    inventarflaeche.add(gegenstandBtn);
                }
                catch(NullPointerException e)
                {
                }
                //Damit falls kein Hinweis im Array gespeichert ist, keine Fehlermeldung kommt
            }      
        
        /**Der Button um die Ansicht des Ausgewahlten Gegenstands zu schliessen; denkbare Erweiterung: Diesen Button nur Anzeigen, wenn zurzeit ein Gegensand angezeigt wird*/
        JButton quitInv = new JButton("Ansicht schliessen");
        quitInv.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) { 
                    gui.standardAnzeigen();
                }
            }     
            ); 
            inventarflaeche.add(quitInv);
            quitInv.setBackground(braun);
        
        /**Die Inventarflaeche wird dem Objekt-JPanel hinzugefuegt/eingesetzt*/    
        add(inventarflaeche);                
    }
    
    /**
     * Ein Gegenstandsbutton wird erzeugt, mit dem Namen dem in ihm gespeicherten Gegenstand 
     */
    private JButton erstelleButton(Gegenstand g) {
        JButton btn = new JButton(g.getName());
        btn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    gui.setMitte(g.getTextLabel());
                }
            }
            );
        btn.setBackground(braun);
        return btn;
    }
}

