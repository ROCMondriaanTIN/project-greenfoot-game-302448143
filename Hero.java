
import greenfoot.*;
import java.util.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    public boolean key = false;
    public int x= 250;
    public int y= 1980;
    // 250, 1980
    
    private  GreenfootImage staand = new GreenfootImage("p1_walk01.png");
    private  GreenfootImage loop1 = new GreenfootImage("p1_walk02.png");
    private  GreenfootImage loop2 = new GreenfootImage("p1_walk03.png");
    private  GreenfootImage loop3 = new GreenfootImage("p1_walk04.png");
    private  GreenfootImage loop4 = new GreenfootImage("p1_walk05.png");
    private  GreenfootImage loop5 = new GreenfootImage("p1_walk06.png");
    private  GreenfootImage loop6 = new GreenfootImage("p1_walk07.png");
    private  GreenfootImage loop7 = new GreenfootImage("p1_walk08.png");
    private  GreenfootImage loop8 = new GreenfootImage("p1_walk09.png");
    private  GreenfootImage loop9 = new GreenfootImage("p1_walk10.png");
    private  GreenfootImage loop10 = new GreenfootImage("p1_walk01.png");
    private  GreenfootImage loop11 = new GreenfootImage("p1_walk01.png");
    private  GreenfootImage loop12 = new GreenfootImage("p1_walk01.png");
    
   
    
    private int speed = 3;
    public int frame;
    private boolean lopen;
    private boolean Kijkenrechts;
    private boolean isKeypressed;
    public int checkpoint = 0;
    private boolean Key = false;
    private boolean door = false;
    private boolean openDeur1 = false;
    private boolean touchDeur1 = false;
    public int wereldnummer = 1;
    
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
        /*
        setImage(staand);
        lopen = false;
        Kijkenrechts = true;
        */
        //staand.scale(70,100);
        //vraag nouvel
    }

    @Override
    public void act() {
        handleInput();
        checkpoint();
        exitSign();
        
       // positie();
       Doors();
       SpikeTile();
       onGround();
       getWorld().showText(getX() + "," + getY(),500,50);
       
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        eatKeys();
        removeLock();
        getWorld().showText(getX() + "," + getY(),500,50);
        
        List<Enemy> enemies = new ArrayList<>();
        //this.getIntersectionObjects(Door.class);
        
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
        for (Actor enemy : getIntersectingObjects(LavaTile.class)) {
            if (enemy != null) {
                //getWorld().removeObject(this);
                respawn();
                return;
            }
        }
        for (Actor enemy : getIntersectingObjects(water.class)) {
            if (enemy != null) {
                //getWorld().removeObject(this);
                respawn();
                return;
            }
        }
            
       for (Actor enemy : getIntersectingObjects(SpikeTile.class)) {
            if (enemy != null) {
                //getWorld().removeObject(this);
                respawn();
                return;
            }
        }
    }

    public String positie()
    {
    String a= "X"+getX()+"Y"+getY();    
    
    return a;
    }
    public void checkpoint()
    {
        if (isTouching(Checkpoint.class))
        {
            checkpoint = 1;
        }
        if (isTouching(Checkpoint2.class))
        {
            checkpoint = 2;
        }
        if (isTouching(Checkpoint3.class))
        {
            checkpoint = 3;
        }
        if (isTouching(Checkpoint4.class))
        {
            checkpoint = 4;
        }
    }
    public void handleInput() {
        if ((Greenfoot.isKeyDown("w") && onGround() == true) ||  (Greenfoot.isKeyDown("w") && isTouching(Ladder.class) || (Greenfoot.isKeyDown("w") && isTouching(Rope.class))))    {
            velocityY = -15.7;
            setImage("p1_jump.png");
        }

        if (Greenfoot.isKeyDown("a")) {
            animatieLeft();
            velocityX = -8;
        } else if (Greenfoot.isKeyDown("d")) {
            animatieRight();
            velocityX = 8;
        }
    }
    public void respawn()
{
    if ( wereldnummer == 1 && checkpoint == 1){
        
    setLocation(1839,2683);
    
    }
    
    else if (wereldnummer == 2 &&checkpoint == 2){
    setLocation(670, 2100);
    }
    else if (wereldnummer == 2 &&checkpoint == 3){
    setLocation(500, 500);
    }
    else if (wereldnummer == 2 &&checkpoint == 4){
    setLocation(500, 500);
    }
    else if (wereldnummer == 1)
    {
    setLocation(250,1982);
}
else if ( wereldnummer == 2 )
{
    setLocation(670, 2100);
}
}

    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getHeight()/2, Tile.class);
        Tile tile = (Tile) under;
        return tile != null && tile.isSolid == true;
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    public void animatieLeft()
    {
  
    
    if(frame ==1)
    {
        setImage(loop1);    
    }
    else if(frame ==2)
    {
        setImage(loop2);
    }
    else if(frame ==3)
    {
        setImage(loop3);
    }
    else if(frame ==4)
    {
        setImage(loop4);
    }
    else if(frame ==5)
    {
        setImage(loop5);
    }
    else if(frame ==6)
    {
        setImage(loop6);
    }
    else if(frame ==7)
    {
        setImage(loop7);
    }
    else if(frame ==8)
    {
        setImage(loop8);
    }
    else if(frame ==9)
    {
        setImage(loop9);
    }
    else if(frame ==10)
    {
        setImage(loop10);
    }
    else if(frame ==11)
    {
        setImage(loop11);
    }
    else if(frame ==12)
    {
        setImage(loop8);
        frame= 1;
        return ;
    }
    frame++;
}
    public void animatieRight()
    {
  
    
    if(frame ==1)
    {
        setImage(loop1);    
    }
    else if(frame ==2)
    {
        setImage(loop2);
    }
    else if(frame ==3)
    {
        setImage(loop3);
    }
    else if(frame ==4)
    {
        setImage(loop4);
    }
    else if(frame ==5)
    {
        setImage(loop5);
    }
    else if(frame ==6)
    {
        setImage(loop6);
    }
    else if(frame ==7)
    {
        setImage(loop7);
    }
    else if(frame ==8)
    {
        setImage(loop8);
    }
    else if(frame ==9)
    {
        setImage(loop9);
    }
    else if(frame ==10)
    {
        setImage(loop10);
    }
    else if(frame ==11)
    {
        setImage(loop11);
    }
    else if(frame ==12)
    {
        setImage(loop8);
        frame= 1;
        return ;
    }
    frame++;
}
    
    public void Doors()
    {
        if(/* key==false &&*/ isTouching(Door1.class))
        {
            setLocation(260, 2690);
        }
        //door2
        if(/*key==false &&*/ isTouching(Door2.class))
        {
            setLocation(322, 1143);
        }
        
    }
    public void SpikeTile()
    {
        if(isTouching(SpikeTile.class))
        {
            respawn();
        }
    }
    public void LavaTile()
    {
        if(isTouching(LavaTile.class))
        {
            respawn();
        }
    }
    public void water()
    {
        if(isTouching(water.class))
        {
            respawn();
        }
    }
    public void exitSign(){
    if(isTouching(ExitSign.class))
        {
            Greenfoot.setWorld(new Wereld2());
            wereldnummer = 2;
            setLocation (670, 2100);
        }
    }
    public boolean eatKeys()
    {
        Actor Key = getOneIntersectingObject(Key.class);
        if(isTouching(Key.class))
        {
            removeTouching(Key.class);
            key = true;
            
        }
           return key; 
    }
    
    
    public boolean removeLock()
    {
        Tile lock = (Tile) getOneIntersectingObject(Lock.class);
        if(key == true && lock != null)
        {
            lock.isSolid = false;
            lock.getImage().setTransparency(0);
            key = false;
        
        }
        return key;    
    }
    public void  checkpoint1()
    {
        setLocation(1839,2683);
        
    }
}
