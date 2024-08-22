import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class Level1 implements Level {
    @Override
    public List<Obstacle> getObstacles() {
        List<Obstacle> obstacles = new ArrayList<>();
        int diff=2;
        
        for (int i = 0; i <13; i++) { //13
            obstacles.add(new CircularObstacle(275, 225, 8, Color.BLUE, 50, i * 75,(-0.025*diff)-0.05));
            obstacles.add(new CircularObstacle(275,225, 8, Color.BLUE, 100, i * 75,(0.025*diff)+0.07));
        }  
       for(int i=0; i<40;i++) {  //40
            obstacles.add(new CircularObstacle(275,225, 8, Color.BLUE,150, i * 25,(0.025*diff)+0.03));
            obstacles.add(new CircularObstacle(275,225, 8, Color.BLUE, 170, i * -25,(-0.025*diff)-0.03));
        }
       
          
        return obstacles;
        }
    public List<Coin> getCoins() {
        List<Coin> coins = new ArrayList<>();
            coins.add(new Coin(87,87));
            coins.add(new Coin(87,362));
            
        
        return coins;
    }

	@Override
	public Shape getMapShape() {
		Path2D polygon = new Path2D.Double();
         polygon.moveTo(75, 75);
         polygon.lineTo(475, 75);
         polygon.lineTo(475, 175);
         polygon.lineTo(550, 175);
         polygon.lineTo(550, 275);
         polygon.lineTo(475, 275);
         polygon.lineTo(475, 375);
         polygon.lineTo(75, 375);
         polygon.closePath();
         
         return polygon;
		
		
	}

	@Override
	public Rectangle getSafeZone() {
		Rectangle safeZone= new Rectangle(500,175, 50,100);
		return safeZone;
	}

	@Override
	public int getPlayerx() {
		return 275;
	}

	@Override
	public int getPlayery() {
		return 225;
	}
    
    
}
    





