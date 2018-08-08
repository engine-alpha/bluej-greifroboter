
/**
 * Klasse Greifi stellt einen einfachen Greifroboter dar.
 * 
 * @author      mike_gans@yahoo.de
 * 
 * @version     4.0 (2018-08-07)
 */
public class Steuerung 
extends SPIEL
{
    private Eimer eimer_links;
    private Eimer eimer_rechts;
    
    private Fliessband fliessband;
    
    private java.util.LinkedList<Kugel> kugeln;
    
    private Greifarm greifarm;
    
    private int nummer;
    private TEXT nummernAnzeige;
    
    private Kugel losgelasseneKugel;
    

    /**
     * Konstruktor der Klasse Greifi
     */
    public Steuerung()
    {
        // SPIEL.zeigeKoordinatensystem( true );
        this.eimer_links = new Eimer( -280 , -220 , "rot" );
        this.eimer_rechts = new Eimer( 280 , -220 , "blau" );
        
        this.fliessband = new Fliessband();
        
        this.kugeln = new java.util.LinkedList<Kugel>();
        for ( int i=1 ; i<=7 ; i++ )
        {
            this.kugeln.addLast( new Kugel( -100-45*i , 310+10*i) );
        }
        
        this.greifarm = new Greifarm();
        this.greifarm.nimmReferenzAufKugeln( this.kugeln );
        this.greifarm.nimmReferenzAufEimer( this.eimer_links , this.eimer_rechts );
        
        this.nummer = 0;
        this.nummernAnzeige = new TEXT( 0 , 270 , this.nummer );
        this.nummernAnzeige.setzeGroesse( 30 );
        this.nummernAnzeige.setzeFarbe( "lila" );
        
        this.losgelasseneKugel = new Kugel( 0 , -450 );
        
        super.tickerAnmelden( this.greifarm , 50 );
    }

    
    /**
     * Erhoeht oben mittig angezeigte Nummer um Eins. 
     *
     */
    private void erhoeheNummer()
    {
        if ( this.greifarm.nenneWinkel() > 102  &&  this.greifarm.nenneWinkel() < 108 )
        {
            this.nummer += 1;
            this.nummernAnzeige.setzeInhalt( ""+(int)this.nummer );
        }
    }
    
    
    
    /**
     * Greift die naechste Kugel vom Fliessband, falls der Greifarm dort ist. 
     * Tut nichts, wenn der Greifarm nicht genau am Fliessband ist. 
     *
     */
    public void  greifen()
    {
        this.erhoeheNummer();
        this.greifarm.greifen();
    }
    
    
    /**
     * Der Greifarm laesst seine Kugel los, falls er eine hat. 
     * Tut nichts, wenn der Greifarm gerade keine Kugel hat. 
     *
     */
    public void loslassen()
    {
        // this.losgelasseneKugel = this.greifarm.gibKugelReferenz();
        this.greifarm.loslassen();
    }
    
    
    /**
     * Dreht den Greifarm um einen bestimmten Winkel. 
     *
     * @param   grad    Grösse des Winkels ( Uhrzeigersinn = negative Zahl , gegen Uhrzeigersinn = positive Zahl
     */
    public void drehenUm( int grad )
    {
        this.greifarm.drehenUm( grad );
    }
    
    
    /**
     * Nennt die Farbe der Kugel, falls der Greifarm gerade eine Kugel hat. 
     * Gibt "keine Kugel" zurueck, wenn der Greifarm gerade leer ist. 
     *
     * @return      Farbe der Kugel oder "keine Kugel"
     */
    public String nenneKugelfarbe()
    {
        return this.greifarm.nenneFarbe();
    }
    
    
    /**
     * Die gegriffenen Kugeln werden mit 1 beginnend durchgezaehlt. 
     * Nennt die Nummer der Kugel, wenn der Greifarm gerade eine Kugel hat, sonst -1.
     *
     * @return      Nummer der gerade gehaltenen Kugel oder -1
     */
    public int nenneKugelNummer()
    {
        int nummer = -1;
        if ( this.greifarm.hatKugel() )
        {
           return this.nummer ;
        }
        return nummer;
    }
    
    
    /**
     * Nennt den Winkel des Greifarms im Koordinatensystem. 
     * Blick Richtung x-Achse entspricht Null Grad. 
     * positiver Drehsinn = gegen den Uhrzeigersinn
     *
     * @return      Ein Winkel zwischen 0 und 360 Grad
     */
    public int nenneWinkel()
    {
        return this.greifarm.nenneWinkel();
    }
    
    
     
}
