
/**
 * Klasse Greifarm.
 * 
 * @author      mike_gans@yahoo.de
 * 
 * @version     v4.0 (2018-08-7)
 */
public class Greifarm
{
    private DREIECK stativ;
    private KREIS drehpunkt;
    private RECHTECK arm;
    private Kugel gegriffeneKugel;
    private int winkel;
    
    private java.util.LinkedList<Kugel> kugeln;
    
    private boolean hatKugel;
    
    private Eimer rechts;
    private Eimer links;
    

    /**
     * Konstruktor der Klasse Greifarm
     */
    public Greifarm()
    {
        this.stativ = new DREIECK( -50,-300 , 50,-300 , 0,-100 );
        this.stativ.setzeFarbe( "grau" );
        this.stativ.setzeEbene( 5 );
        
        this.drehpunkt = new KREIS( 15 );
        this.drehpunkt.setzeFarbe( "grau" );
        this.drehpunkt.setzeMittelpunkt( 0 , -100 );
        this.drehpunkt.setzeEbene( 5 );
        
        this.arm = new RECHTECK( 300 , 10 );
        this.arm.setzeFarbe( "grau" );
        this.arm.setzeMittelpunkt( 150 , -100 );
        
        this.gegriffeneKugel = new Kugel( 0, 0 );
        this.gegriffeneKugel.setzeSichtbar( false );
        this.gegriffeneKugel.macheNeutral();
        
        this.winkel = 0;
        
        this.hatKugel = false;
    }

    
    /**
     * Dreht den Greifarm um den angegebenen Winkel. 
     * Gegen den Uhrzeigersinn = positive Winkel ; Mit dem Uhrzeigersinn = negativer Winkel 
     *
     * @param   winkel      Der Winkel, um den gedreht werden soll
     */
    public void drehenUm( int winkel )
    {
        this.winkel += winkel;
        this.winkel %= 360;
        this.arm.drehenUm( winkel );
        this.arm.setzeMittelpunkt( (float)(150*Math.cos(Math.toRadians(this.winkel)))  , (float)(150*Math.sin(Math.toRadians(this.winkel))-100) );
        if ( this.hatKugel )
        {
            this.gegriffeneKugel.setzeMittelpunkt( (float)(315*Math.cos(Math.toRadians(this.winkel)))  , (float)(315*Math.sin(Math.toRadians(this.winkel))-100) );
        }
    }
    
    
    public void greifen()
    {
        if ( !this.hatKugel )
        {
            if ( this.arm.beruehrt( this.kugeln.peekFirst() ) )
            {
                this.gegriffeneKugel = this.kugeln.removeFirst();
                this.gegriffeneKugel.macheNeutral();
                this.gegriffeneKugel.setzeMittelpunkt( (float)(315*Math.cos(Math.toRadians(this.winkel)))  , (float)(315*Math.sin(Math.toRadians(this.winkel))-100) );
                
                this.kugeln.addLast( new Kugel( -380 , 380 ) );
            }
        }
        this.hatKugel = true;
    }
    
    
    /**
     * Lässt die gegriffene Kugel los. 
     * Tut nichts, wenn gerade keine Kugel gegriffen wird.
     *
     */
    public void loslassen()
    {
        if ( this.hatKugel )
        {
            this.gegriffeneKugel.macheAktiv();
        }
        this.hatKugel = false;
    }
    
    
    /**
     * Nennt die Farbe der aktuell gegriffenen Kugel. 
     * Wird gerade keine Kugel gegriffen, so wird "keine Kugel" gemeldet.
     *
     * @return      Die Farbe der aktuell gegriffenen Kugel
     */
    public String nenneFarbe()
    {
        String farbe = "keine Kugel";
        if ( this.gegriffeneKugel != null )
        {
            farbe = this.gegriffeneKugel.nenneFarbe();
        }
        return farbe;
    }
    
    
    /**
     * Nennt den aktuellen Drehwinkel des Greifarms. 
     *
     * @return      Der aktuelle Drehwinkel des Greifarms
     */
    public int nenneWinkel()
    {
        return this.winkel;
    }
    
    
    /**
     * Mit dieser Methode kann der Greifarm eine Referenz auf die Kugeln erhalten. 
     *
     * @param   kugeln      Referenz auf die LinkedList von Kugeln der Klasse Greifi
     */
    public void nimmReferenzAufKugeln( java.util.LinkedList<Kugel> kugeln )
    {
        this.kugeln = kugeln;
    }
    
    
    /**
     * Mit dier Methode kann der Greifarm eine Referenz auf seine Eimer erhalten. 
     *
     * @param   links       Referenz auf linken Eimer
     * @param   rechts      Referenz auf rechen Eimer
     */
    public void nimmReferenzAufEimer( Eimer links , Eimer rechts )
    {
        this.links = links;
        this.rechts = rechts;
    }
    
    
    /**
     * Gibt an, ob der Greifarm gerade eine Kugel hat oder leer ist. 
     *
     * @return      'true' = hat Kugel ; 'false' = ist leer
     */
    public boolean hatKugel()
    {
        return this.hatKugel;
    }
    
    
    
    // Ticker, der in Greifi angemeldet wurde
    public void tick()
    {
        if ( this.gegriffeneKugel != null )
        {
            if ( this.gegriffeneKugel.nenneMy() < -250 )
            {
                if ( this.gegriffeneKugel.nenneMx() > 222  &&  this.gegriffeneKugel.nenneMx() < 333 )
                {
                    this.rechts.erhoeheNummer();
                }
                else if ( this.gegriffeneKugel.nenneMx() < -222  &&  this.gegriffeneKugel.nenneMx() > -333 )
                {
                    this.links.erhoeheNummer();
                }
            }
        }
    }
}
