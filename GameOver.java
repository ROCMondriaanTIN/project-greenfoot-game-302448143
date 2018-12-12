import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GameOver extends World
{

    
    public GameOver()
    {
        super(1000, 800, 1, false);
        this.setBackground("GameOver.png");

        prepare();
    }
    private void prepare()
    {
        PlayAgain playAgain = new PlayAgain();
        addObject (playAgain, 500, 600);
        GameOver1 gameOver1= new GameOver1();
        addObject (gameOver1, 500, 200);
    }
}