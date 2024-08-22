import java.awt.Color;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class Level3 implements Level {
    @Override
    public List<Obstacle> getObstacles() {
        List<Obstacle> obstacles = new ArrayList<>();
        int diff=2;
        for (int i = 0; i < 4; i++) {//4
            obstacles.add(new SinObstacle(75, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(100, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(125, 100+ i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(150, 100+ i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(175, 100+ i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(200, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(225, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(250, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(275, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(300, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(325, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(350, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(375, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(400, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(425, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(450, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));
            obstacles.add(new SinObstacle(475, 100 + i * 75, 8,(diff/2)+4.0,4.0, Color.BLUE,75,475));





        }
        return obstacles;
    }

    public List<Coin> getCoins() {
        List<Coin> coins = new ArrayList<>();
       
            coins.add(new Coin(510,137));
            coins.add(new Coin(510,187));
            coins.add(new Coin(510,237));
            coins.add(new Coin(510,287));

           
        
        return coins;
    }

	@Override
	public Shape getMapShape() {
		 Path2D polygon = new Path2D.Double();
         polygon.moveTo(75, 75);
         polygon.lineTo(75, 125);
         polygon.lineTo(50, 125);
         polygon.lineTo(50, 150);
         polygon.lineTo(75, 150);
         polygon.lineTo(75, 285);
         polygon.lineTo(50, 285);
         polygon.lineTo(50, 315);
         polygon.lineTo(75, 315);
         polygon.lineTo(75, 375);
         
         polygon.lineTo(475, 375);
         polygon.lineTo(475, 300);
         polygon.lineTo(525, 300);
         polygon.lineTo(525, 125);
         polygon.lineTo(475, 125);
         polygon.lineTo(475, 75);
         polygon.lineTo(75, 75);
         
         polygon.moveTo(475, 250);
         polygon.lineTo(500, 250);
         polygon.lineTo(500, 175);
         polygon.lineTo(475,175);
         polygon.lineTo(475,250);
         polygon.setWindingRule(Path2D.WIND_EVEN_ODD);
         return polygon;
	}

	@Override
	public Rectangle getSafeZone() {
		Rectangle safeZone= new Rectangle(50,285,25,30);
		return safeZone;
	}

	@Override
	public int getPlayerx() {
		return 61;
	}

	@Override
	public int getPlayery() {
		
		return 137;
	}

}

