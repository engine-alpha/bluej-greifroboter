
/**
 * Klasse FLiessband.
 * 
 * @author      mike_gans@yahoo.de 
 * 
 * @version     4.0 (2018-08-07)
 */
public class Fliessband
{
    private ea.edu.Rechteck fliessband_1;
    private ea.edu.Rechteck fliessband_2;
    

    /**
     * Konstruktor der Klasse Fliessband
     */
    public Fliessband()
    {
        this.fliessband_1 = new ea.edu.Rechteck( 500 , 10 );
        this.fliessband_1.setzeFarbe( "gelb" );
        this.fliessband_1.drehen( (float)Math.toRadians(-10) );
        this.fliessband_1.setzeMittelpunkt( -310, 207 );
        this.fliessband_1.setLayer( 1 );
        this.fliessband_1.machePassiv();
        this.fliessband_2 = new ea.edu.Rechteck( 10 , 40 );
        this.fliessband_2.drehen( (float)Math.toRadians(-10) );
        this.fliessband_2.setzeFarbe( "gelb" );
        this.fliessband_2.setzeMittelpunkt( -56 , 179 );
        this.fliessband_2.setLayer( 1 );
        this.fliessband_2.machePassiv();
    }

    
}
