
/**
 * Klasse Eimer.
 * 
 * @author      mike_gans@yahoo.de
 * 
 * @version     4.0 (2018-08-11)
 */
public class Eimer 
implements ea.edu.EduActor
{
    private FIGUR unten;
    private FIGUR oben;
    private TEXT beschriftung;
    private int zaehler;
    private KREIS detektor;
    

    /**
     * Konstruktor der Klasse Eimer
     */
    public Eimer( int x , int y , String farbe )
    {
        
        if ( farbe.equals("rot") )
        {
            this.oben = new FIGUR( "standard" , "Eimer_rot_oben.png" , 1, 1 );
            this.oben.setzeMittelpunkt( x , y+78 );
            this.oben.setzeEbene( 0 );
            this.unten = new FIGUR( "standard" , "Eimer_rot_unten.png" , 1 , 1 );
            this.unten.setzeMittelpunkt( x , y );
            this.unten.setzeEbene( 2 );
            this.beschriftung = new TEXT( x , y , 0 );
            this.beschriftung.setzeGroesse( 30 );
            this.beschriftung.setzeFarbe( "blau" );
            this.beschriftung.setzeEbene( 3 );
        }
        else 
        {
            this.oben = new FIGUR( "standard" , "Eimer_blau_oben.png" , 1, 1 );
            this.oben.setzeMittelpunkt( x , y+78 );
            this.oben.setzeEbene( 0 );
            this.unten = new FIGUR( "standard" , "Eimer_blau_unten.png" , 1 , 1 );
            this.unten.setzeMittelpunkt( x , y );
            this.unten.setzeEbene( 2 );
            this.beschriftung = new TEXT( x , y , 0 );
            this.beschriftung.setzeGroesse( 30 );
            this.beschriftung.setzeFarbe( "gelb" );
            this.beschriftung.setzeEbene( 3 );
        }
        
        this.detektor = new KREIS( 25 );
        this.detektor.setzeMittelpunkt( x , y-25 );
        this.detektor.setzeEbene( 1 );
        
        this.zaehler = 0;
        inEngineCollisionDetection();
    }

    
    /**
     * erhoeht die Nummer auf diesem Eimer um Eins. 
     *
     */
    public void erhoeheNummer()
    {
        this.zaehler += 1;
        this.beschriftung.setzeInhalt( ""+(int)this.zaehler );
    }
    
    
    
    // public void inEngineCollisionDetection() {
        // unten.addCollisionListener(new ea.collision.CollisionListener<ea.actor.Actor>() {
            // public void onCollision(ea.collision.CollisionEvent e) {
                // ea.actor.Actor o = e.getColliding();
                // if(o instanceof ea.actor.Circle) {
                    // erhoeheNummer();
                // }
            // }
            
        // });
    // }
    
    
    
    public void inEngineCollisionDetection() {
        detektor.getActor().addCollisionListener(new ea.collision.CollisionListener<ea.actor.Actor>() {
            public void onCollision(ea.collision.CollisionEvent e) {
                ea.actor.Actor o = e.getColliding();
                if(o instanceof ea.actor.Circle) {
                    erhoeheNummer();
                }
            }
            
        });
    }
    
    
    /**
     * Setzt die Nummer dieses Eimers auf einen bestimmten Wert.
     *
     * @param   nummer      neue Nummer des Eimers
     */
    public void setzeNummer( int nummer )
    {
        this.zaehler = nummer;
        this.beschriftung.setzeInhalt( nummer );
    }
    
    
    @Override
    /**
     * Methode des Interfaces 'GrafikObjekt'
     */
    public ea.actor.Actor getActor() {
        return this.unten;
    }
}
