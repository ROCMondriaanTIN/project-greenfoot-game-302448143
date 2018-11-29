
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
    /*
    private final Greenfootimage staand = new GreenfootImage("p1_walk01.png");
    private final Greenfootimage loop1 = new GreenfootImage("p1_walk02.png");
    private final Greenfootimage loop2 = new GreenfootImage("p1_walk03.png");
    private final Greenfootimage loop3 = new GreenfootImage("p1_walk04.png");
    private final Greenfootimage loop4 = new GreenfootImage("p1_walk05.png");
    private final Greenfootimage loop5 = new GreenfootImage("p1_walk06.png");
    private final Greenfootimage loop6 = new GreenfootImage("p1_walk07.png");
    private final Greenfootimage loop7 = new GreenfootImage("p1_walk08.png");
    private final Greenfootimage loop8 = new GreenfootImage("p1_walk09.png");
    private final Greenfootimage loop9 = new GreenfootImage("p1_walk10.png");
    private final Greenfootimage loop10 = new GreenfootImage("p1_walk01.png");
    private final Greenfootimage loop11 = new GreenfootImage("p1_walk01.png");
    private final Greenfootimage loop12 = new GreenfootImage("p1_walk01.png");
    
    private final Greenfootimage staandinv = new GreenfootImage("");
    private final Greenfootimage loop1inv = new GreenfootImage("");
    private final Greenfootimage loop2inv = new GreenfootImage("");
    private final Greenfootimage loop3inv = new GreenfootImage("");
    private final Greenfootimage loop4inv = new GreenfootImage("");
    private final Greenfootimage loop5inv = new GreenfootImage("");
    private final Greenfootimage loop6inv = new GreenfootImage("");
    private final Greenfootimage loop7inv = new GreenfootImage("");
    private final Greenfootimage loop8inv = new GreenfootImage("");
    private final Greenfootimage loop9inv = new GreenfootImage("");
    private final Greenfootimage loop10inv = new GreenfootImage("");
    private final Greenfootimage loop11inv = new GreenfootImage("");
    private final Greenfootimage loop12inv = new GreenfootImage("");
    
    private int speed = 3;
    private int frame;
    private boolean lopen;
    private boolean Kijkenrechts;
    private boolean isKeypressed;
    
    private boolean key = false;
    private boolean door = false;
    private boolean openDeur1 = false;
    private boolean touchDeur1 = false;
    */
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
       // positie();
       Doors();
       SpikeTile();
       onGround();
       
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        eatKeys();
        removeLock();
        
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
                setLocation(x, y);
                return;
            }
        }
        for (Actor enemy : getIntersectingObjects(water.class)) {
            if (enemy != null) {
                //getWorld().removeObject(this);
                setLocation(x, y);
                return;
            }
        }
            
       for (Actor enemy : getIntersectingObjects(SpikeTile.class)) {
            if (enemy != null) {
                //getWorld().removeObject(this);
                setLocation(x, y);
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
        x=getX();
        y=getY();
        }
    }
    public void handleInput() {
        if ((Greenfoot.isKeyDown("w") && onGround() == true) || (Greenfoot.isKeyDown("w") && isTouching(Ladder.class)))    {
            velocityY = -15.7;
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -8;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 8;
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
            checkpoint();
        }
    }
    public void LavaTile()
    {
        if(isTouching(LavaTile.class))
        {
            checkpoint();
        }
    }
    public void water()
    {
        if(isTouching(water.class))
        {
            checkpoint();
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
