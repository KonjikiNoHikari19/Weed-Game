import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;



public class GameProgram extends JPanel implements KeyListener{
	
	int GameState=0;
	int Score = 0;
	int speed = 10;
    //Variables for the game objects.
    Catching player = new Catching();
    floor lapag = new floor();
   	ArrayList<fallingdebris> debris = new ArrayList<fallingdebris>();
	fallingdebris sample = new fallingdebris(0);
	
    boolean[] keys = new boolean[256];

    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()] = true;
       	//System.out.println(e.getKeyCode());
    }
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }
	
    public GameProgram(){
    	
 

        addKeyListener(this);
        setFocusable(true);
        Thread td = new Thread(new Runnable(){
           public void run(){
               setup();
               while(true){
                   try {
                       update();
                       render();
                       Thread.sleep(16);
                   } catch(Exception ex){

                   }
               }
           }
        });
        td.start();
    }

    void setup(){
        //Position player.
        player.bounds.x = getWidth() / 2 - 40;
        player.bounds.y = getHeight()-50;

    }
    
    //variables for generating debris
    int interval = 40;
    int step = 0;

	void Adddebris(){
        Random rd = new Random();
        int r = rd.nextInt(17);
        fallingdebris fd = new fallingdebris(r);
        //set debris to top
        fd.OffsetX = 0;
        debris.add(fd);
    }
	
    void update(){

        getInput();
        
        
 			if(step >= interval){
            Adddebris();
            step = 0;
 		}
 		
 		
          	if(GameState == 1) {
          		for(fallingdebris x : debris){
            	x.OffsetX += 5;
                x.UpdateWeed();
                
                if(Score >10)
                {
                	x.OffsetX ++;
                }
                if(Score >20)
                {
                	x.OffsetX ++;
                }
                if(Score >30)
                {
                	x.OffsetX ++;
                }
                if(Score >40)
                {
                	x.OffsetX ++;
                }
                if(Score >50)
                {
                	x.OffsetX ++;
                }
                if(Score >60)
                {
                	x.OffsetX ++;
                }
                if(Score >70)
                {
                	x.OffsetX ++;
                }
                if(Score >80)
                {
                	x.OffsetX ++;
                }
                if(Score >90)
                {
                	x.OffsetX ++;
                }
                if(Score >100)
                {
                	x.OffsetX ++;
                }
            }
            
            step++;
            //Render weeds
             if(keys[37]){	
        	player.bounds.x-=20;
        		}
        	else if(keys[39]){
        	player.bounds.x+=20;
        		}
        		
            }
            RemoveOffscreenDebris();
            
            
 		
 		if(player.bounds.x<0)
 			{
 				player.bounds.x=0;
 			}
		else if (player.bounds.x>getWidth()-80)
			{
 				player.bounds.x=getWidth()-80;
 			}
 			
            
            for(fallingdebris x : debris){
            if(x.floorcollide(lapag)){
				dies();
            }
        }
 			
    }
    
	
	  void dies(){
        GameState = 2;
        debris.clear();
    }

    boolean spacedown = false;
    
    void RemoveOffscreenDebris(){
        int toRemove = -1;
        for(fallingdebris x : debris){
            if(x.IsPlayerCollides(player)){
                toRemove = debris.indexOf(x);
                Score++;
            }
        }
        if(toRemove >-1) debris.remove(toRemove);
    }
    
    
    
    void getInput(){
    	if(keys[10])
        {

            if(GameState == 0) 
            {
                if(spacedown == false) GameState = 1;
            }
            else if(GameState == 2) 
            {
            	 spacedown = true;
                	player.bounds.x = getWidth() / 2 - 40;
        			player.bounds.y = getHeight()-60;
                	GameState = 0;
                	Score = 0 ;
            }
        } 
        	else if(keys[10] == false)
        {
            spacedown = false;
        }
        	
    }

    void render(){
        repaint();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        ImageIcon s = new ImageIcon("high.jpeg");
        Image img = s.getImage();
		g.drawImage(img, 0, 0,getWidth(),getHeight(),null);
        
		g.setColor(Color.BLACK);
        //Render player
        g.fillRect(player.bounds.x, player.bounds.y-10, player.bounds.width, player.bounds.height);
        ImageIcon i = new ImageIcon("snoop.gif");
        Image image = i.getImage();
        g.drawImage(image, 10, 522, 50,50,null);
        g.drawImage(image, 730, 522, 50,50,null);
		
		for(fallingdebris x : debris){
            x.RenderWeed(g);
        }
        
        if(GameState == 0){
            Font fnt = new Font("Arial Black", Font.BOLD, 20);
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("PRESS ENTER TO START", getWidth() / 2 - 135, getHeight() / 2);
        }
        
        if(GameState == 1 ){
            Font fnt = new Font("Arial", Font.BOLD, 20);
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("Score: "+Score , 10,20);
        }
        
        if(GameState == 2) {
            //Dim screen
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 0, getWidth(), getHeight());

            Font fnt = new Font("Arial", Font.BOLD, 20);
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", getWidth() / 2 - 60, getHeight() / 2);
            g.drawString("Your Score Is: "+Score, getWidth() / 2 - 75, getHeight() / 2+60);

        }


    }

    public static void main(String[] args){
        JFrame wnd =  new JFrame("Catch The Smoke Weed");
        wnd.setSize(800, 600);
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wnd.setContentPane(new GameProgram());
        wnd.setVisible(true);
        wnd.setResizable(false);
        wnd.setLocationRelativeTo(null);
    }


}
