
/**
 * Klasse FLiessband.
 * 
 * @author      mike_gans@yahoo.de 
 * 
 * @version     4.0 (2018-08-07)
 */
public class Fliessband
{
    private RECHTECK fliessband_1;
    private RECHTECK fliessband_2;
    

    /**
     * Konstruktor der Klasse Fliessband
     */
    public Fliessband()
    {
        this.fliessband_1 = new RECHTECK( 500 , 10 );
        this.fliessband_1.setzeMittelpunkt( -310, 207 );
        this.fliessband_1.setzeFarbe( "gelb" );
        this.fliessband_1.setzeDrehwinkel( -10 );
        this.fliessband_1.setzeEbene( 1 );
        this.fliessband_1.machePassiv();
        this.fliessband_2 = new RECHTECK( 10 , 40 );
        this.fliessband_2.setzeMittelpunkt( -56 , 179 );
        this.fliessband_2.setzeDrehwinkel( -10 );
        this.fliessband_2.setzeFarbe( "gelb" );
        this.fliessband_2.setzeEbene( 1 );
        this.fliessband_2.machePassiv();
    }

    
}
