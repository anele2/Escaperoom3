/**
 * Ein Raum des Spieles. Besitzt 4 Räume und ist quadratisch. 
 * 
 * @Tim Jascheck
 * @11.02.2020
 */
public class Raum
{
    //Vier Variablen für die 4 Wände des quadratischen Raumes
    protected Wand wandN;
    protected Wand wandO;
    protected Wand wandS;
    protected Wand wandW;
    private Zettel zettel1;
    private Zettel zettel2;
    private Zettel zettel3;
    private Zettel zettel4;
    private Zettel zettel5;
    //Damit Probleme in dem Code leichter verortet werden können
    private Wand error = new Wand("Norden","src/wandRot.jpg");
    /**
     * Konstruktor für Objekte der Klasse Raum
     * @ein paar kleine Verbesserungen von Tjorven Bruns
     * Zeichnungen/Bilder allesamt von Mina Grazin
     */
    public Raum()
    {
        //Erstellt vier Wände mit den dementsprechent benannten JLabels
        wandN=new Wand("Norden","src/wandMinaBlau.jpg");
        wandN.addGegenstand(new Flasche("gift","src/flasche.png",590,450,50,100));
        wandN.addGegenstand(new Flasche("wein","src/flasche2.png",650,450,50,100));
        wandN.addGegenstand(new Flasche("vorwaerts","src/flasche3kleiner.png",710,490,50,60));
        wandN.addGegenstand(new Flasche("gift","src/flasche4.png",770,450,50,100));
        wandN.addGegenstand(new Flasche("gift","src/flasche5.png",830,450,50,100));
        wandN.addGegenstand(new Flasche("wein","src/flasche6groesser.png",890,420,90,130));
        wandN.addGegenstand(new Flasche("zurueck","src/flasche7.png",990,450,50,100));
        //wandN.addGegenstand(new Zettel("src/Brief.jpg",950,450,50,100));
        zettel1 = new Zettel("Ich weiß nicht",600,200,30,20); 
        wandN.addGegenstand(zettel1);
      
        wandO=new Wand("Osten","src/WandmitBildernNeu.jpg");
        zettel2 = new Zettel("was hier rein soll.",500,360,20,20);
        wandO.addGegenstand(zettel2);
        
        wandS=new Wand("Sueden","src/WandmitBildernNeu.jpg");
        zettel3 = new Zettel("Daher",1300,140,20,20);
        wandS.addGegenstand(zettel3);
        zettel4 = new Zettel("Ich mache auch mit",600,140,20,20);
        wandS.addGegenstand(zettel4);
        
        wandW=new Wand("Westen","src/WandmitBildernNeu.jpg");
        zettel5 = new Zettel("erstmal irgendwas",300,250,20,20);
        wandW.addGegenstand(zettel5);
    }

    /**
     * Zum Wände-Benuzten
     * @param  himmelsrichtung gibt die Himmelsrichtung (und damit die Wand) an, die abgefragt wird. Zahlen von 0-3, zuordnung siehe Dokumentation "SpielGUI"
     * @return liefert die abgefragte Wand
     */
    public Wand getWand(int himmelsrichtung)
    {
        if(himmelsrichtung == 0){return wandN;}
        if(himmelsrichtung == 1){return wandO;}
        if(himmelsrichtung == 2){return wandS;}
        if(himmelsrichtung == 3){return wandW;}
        else{return error;}      
    }
}
