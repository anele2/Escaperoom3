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
    //Damit Probleme in dem Code leichter verortet werden können
    private Wand error = new Wand("Norden","src/wandRot.jpg");
    /**
     * Konstruktor für Objekte der Klasse Raum
     */
    public Raum()
    {
        //Erstellt vier Wände mit den dementsprechent benannten JLabels
        wandN=new Wand("Norden","src/wandMinaBlau.jpg");
        wandN.addGegenstand(new Flasche("wein","src/flblau.jpg",590,450,50,100));
        wandN.addGegenstand(new Flasche("wein","src/flbraun.jpg",650,450,50,100));
        wandN.addGegenstand(new Flasche("wein","src/flbunt.jpg",710,450,50,100));
        wandN.addGegenstand(new Flasche("gift","src/fldurchs.jpg",770,450,50,100));
        wandN.addGegenstand(new Flasche("gift","src/flgruen.jpg",830,450,50,100));
        wandN.addGegenstand(new Flasche("gift","src/flroterdeckel.jpg",890,450,50,100));
        wandN.addGegenstand(new Flasche("weiter","src/flweiss.jpg",950,450,50,100));
        //wandN.addGegenstand(new Zettel("src/Brief.jpg",950,450,50,100));
        wandN.addGegenstand(new Zettel("Ich weiß nicht"));
        wandO=new Wand("Osten","src/wändevorlagekleiner.jpg");
        wandO.addGegenstand(new Zettel("was hier rein soll."));
        wandS=new Wand("Sueden","src/wändevorlagekleiner.jpg");
        wandS.addGegenstand(new Zettel("Daher"));
        wandW=new Wand("Westen","src/wändevorlagekleiner.jpg");
        wandW.addGegenstand(new Zettel("erstmal irgendwas"));
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
