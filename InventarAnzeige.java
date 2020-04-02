import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
/**
 * Inventar Anzeige. Kann mit der Gui interagieren. 
 * 
 * @Tim Jascheck, Mina Granzin
 * @12.03.2020
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
    private JPanel inventarflaeche;
    private boolean gibtAnsichtSchliessen = false;
    private boolean[] gibtButton;

    
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
        gibtButton=new boolean[5];
        for(int i=0;i<gibtButton.length;i++) //klären, dass noch kein Button existiert
        gibtButton[i]=false;
        //ansichtSchliessen();
    }

    /**
     * Die Gegenstandsbuttons werden erzeugt (entsprechent der Anzahl (mit den Namen der in ihnen gespeicherten Gegenstaenden))
     * @Ergaenzungen von Tjorven Bruns mit Unterstützung von Jupp Bruns
     */
    public void buttonInventar()
    {    
        /**Das JPanel fuer die Buttons wird erzeugt*/
        JPanel inventarflaeche = new JPanel();
        FlowLayout inventarLayout = new FlowLayout();
        inventarflaeche.setLayout(inventarLayout);
        inventarflaeche.setBackground(braun);
        
        /**Die Buttons fuer die Gegenstaende werden erzeugt und dabei dafür gesorgt, dass sie nur einmal vorkommen*/
        
        for(int i=0; i<inventar.getGegenstaende().size(); i++){
                try
                {
                    if(!gibtButton[i]){
                        JButton gegenstandBtn = erstelleButton(inventar.getGegenstand(i)); //die Methode erstelleButton wird aufgerufen und der Gegenstand abgefragt
                        inventarflaeche.add(gegenstandBtn); //der Button wird der Inventarfläche hinzugefügt
                        gibtButton[i]=true; //dieser Button existiert jetzt
                    }
                }
                catch(NullPointerException e)
                {
                }
                //Damit falls kein Hinweis im Array gespeichert ist, keine Fehlermeldung kommt
            }   
        if(!gibtAnsichtSchliessen) //es wird sichergestellt dass nur einma "Ansicht schließen" erzeugt wird   
        {
            /**Der Button um die Ansicht des Ausgewahlten Gegenstands zu schliessen; denkbare Erweiterung: Diesen Button nur Anzeigen, wenn zurzeit ein Gegensand angezeigt wird*/
            JButton quitInv = new JButton("Ansicht schliessen");
            quitInv.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) { 
                    gui.standardAnzeigen(); //So kehren wir zu unserer derzeitigen Wand zurueck
                    gui.gegenstaendeSichtbarkeitAendern(gui.getSpieler().getBlickrichtung(), true); //Gegenstaende werden angezeigt
                }
            }     
            ); 
            inventarflaeche.add(quitInv);
            quitInv.setBackground(braun);
            gibtAnsichtSchliessen = true;
        }
        /**Die Inventarflaeche wird dem Objekt-JPanel hinzugefuegt/eingesetzt*/ 
        this.add(inventarflaeche); 
        
    }
    
    /**
     * Ein Gegenstandsbutton wird erzeugt, mit dem Namen des in ihm gespeicherten Gegenstands 
     */
    private JButton erstelleButton(Gegenstand g) {
        JButton btn = new JButton(g.getName());        
        btn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    gui.gegenstaendeSichtbarkeitAendern(gui.getSpieler().getBlickrichtung(), false); //Die Sichtbarkeit der Gegenstaende wird deaktiviert
                    gui.setMitte(g.getTextLabel());  //Der Name wird angezeigt                  
                }
            }
            );
        btn.setBackground(braun);
        return btn;
    }
}

