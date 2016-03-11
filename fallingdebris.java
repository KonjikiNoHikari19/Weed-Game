import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class fallingdebris{

    public int OffsetX = 0;
    int type = 0;

    Rectangle p1 = new Rectangle(0, 0, 0, 0);
    Rectangle p2 = new Rectangle(0, 0, 0, 0);

    public fallingdebris(int t){
        type = t;
    }

    public void RenderWeed(Graphics g){
        g.setColor(Color.GREEN);
        ImageIcon i = new ImageIcon("smoke.png");
        Image image = i.getImage();
        g.drawImage(image, p1.x, p1.y, 50,50,null);
        g.drawImage(image, p1.x, p1.y, 50,50,null);


    }

    public boolean IsPlayerCollides(Catching fd){
        {
            return true;
        }
        return false;
    }
    
    public boolean floorcollide(floor fd){
        if(fd.lapag.intersects(p1) || fd.lapag.intersects(p2)){
            return true;
        }
        return false;
    }
	
	
	
    public void UpdateWeed(){
        if(type == 0){
            p1 = new Rectangle(500, OffsetX, 50, 50);
        } 
        else if(type == 1){
            p1 = new Rectangle(450, OffsetX, 50, 50);
        } 
        else if(type == 2){
            p1 = new Rectangle(400, OffsetX,50, 50);
        }
        else if(type == 3){
            p1 = new Rectangle(350, OffsetX, 50, 50);
        }
        else if(type ==4){
            p1 = new Rectangle(300, OffsetX, 50, 50);
        }
        else if(type == 5){
            p1 = new Rectangle(250, OffsetX, 50, 50);
        }
         else if(type == 6){
            p1 = new Rectangle(200, OffsetX, 50, 50);
        }
         else if(type == 7){
            p1 = new Rectangle(150, OffsetX, 50, 50);
        }
         else if(type == 8){
            p1 = new Rectangle(100, OffsetX, 50, 50);
        }
         else if(type == 9){
            p1 = new Rectangle(50, OffsetX, 50, 50);
        }
         else if(type == 10){
            p1 = new Rectangle(0, OffsetX, 50, 50);
        }
        else if(type == 11){
            p1 = new Rectangle(550, OffsetX, 50, 50);
        }
        else if(type == 12){
            p1 = new Rectangle(600, OffsetX, 50, 50);
        }
        else if(type == 13){
            p1 = new Rectangle(650, OffsetX, 50, 50);
        }
        else if(type == 14){
            p1 = new Rectangle(700, OffsetX, 50, 50);
        }
        else if(type == 15){
            p1 = new Rectangle(750, OffsetX, 50, 50);
        }
        else if(type == 16){
            p1 = new Rectangle(800, OffsetX, 50, 50);
        }
    }


}
