
/**
 * Beschreiben Sie hier die Klasse Kugel.
 * 
 * @author      mike_gans@yahoo.de
 * 
 * @version     4.0 (2018-08-07)
 */
public class Kugel 
extends KREIS
{
    
    
    /**
     * Konstruktor der Klasse Kugel
     */
    public Kugel( int x , int y )
    {
        super( 25 );
        super.setzeMittelpunkt( x , y );
        super.setzeEbene( 1 );
        super.macheAktiv();
        
        int zufallszahl = SPIEL.zufallszahlVonBis( 1 , 5 );
        switch (zufallszahl)
        {
            case 1: super.setzeFarbe( "rot" ); 
                    break;
            case 2: super.setzeFarbe( "gelb" ); 
                    break;
            case 3: super.setzeFarbe( "gruen" ); 
                    break;
            case 4: super.setzeFarbe( "blau" ); 
                    break;
            case 5: super.setzeFarbe( "lila" ); 
                    break;
        }
    }

    
}
