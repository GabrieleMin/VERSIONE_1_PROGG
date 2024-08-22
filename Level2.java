import java.awt.Color;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class Level2 implements Level {
    @Override
    public List<Obstacle> getObstacles() {
        List<Obstacle> obstacles = new ArrayList<>();
        int diff=2;
        for (int i = 0; i <6; i++) { //6
            obstacles.add(new StraightObstacle( 150 + i * 50,75, 8, Color.BLUE,(2*diff)+6,"orizzontale",100,500));
            obstacles.add(new StraightObstacle( 150 + i * 50,125,8, Color.BLUE, (2*diff)+6,"orizzontale",100,500));
            obstacles.add(new StraightObstacle( 150 + i * 50,175, 8, Color.BLUE, (2*diff)+6,"orizzontale",100,500));
            obstacles.add(new StraightObstacle( 150 + i * 50,225,8, Color.BLUE, (2*diff)+6,"orizzontale",100,500));
            obstacles.add(new StraightObstacle( 150 + i * 50,275,8, Color.BLUE, (2*diff)+6,"orizzontale",100,500));
            obstacles.add(new StraightObstacle( 150 + i * 50,325,8, Color.BLUE, (2*diff)+6,"orizzontale",100,500));
            obstacles.add(new StraightObstacle( 150 + i * 50,375,8, Color.BLUE, (2*diff)+6,"orizzontale",100,500));
            obstacles.add(new StraightObstacle( 125, 25+i*50 ,8, Color.BLUE, (2*diff)+6,"verticale",25,425));
            obstacles.add(new StraightObstacle( 225, 25+i*50 ,8, Color.BLUE, (2*diff)+6,"verticale",25,425));
            obstacles.add(new StraightObstacle( 375, 25+i*50 ,8, Color.BLUE, (2*diff)+6,"verticale",25,425));
            obstacles.add(new StraightObstacle( 475, 25+i*50,8, Color.BLUE, (2*diff)+6,"verticale",25,425));




            
         }
        return obstacles;
    }

    public List<Coin> getCoins() {
        List<Coin> coins = new ArrayList<>();
        for (int i = 0; i <7; i++) { //7
            coins.add(new Coin(150, 75+i*50));
            coins.add(new Coin(200, 75+i*50));
            coins.add(new Coin(400, 75+i*50));
            coins.add(new Coin(450, 75+i*50));
        }
        return coins;
    }

	@Override
	public Shape getMapShape() {
		 Path2D polygon = new Path2D.Double();
        polygon.moveTo(100, 25);
        polygon.lineTo(100, 425);
        polygon.lineTo(500, 425);
        polygon.lineTo(500, 25);
        polygon.lineTo(350, 25);
        polygon.lineTo(350, 225);
        polygon.lineTo(250, 225);
        polygon.lineTo(250, 25);
        polygon.closePath();
        
        return polygon;
	}

	@Override
	public Rectangle getSafeZone() {
		Rectangle safeZone= new Rectangle(350,25, 150,50);
		return safeZone;
	}

	@Override
	public int getPlayerx() {
		return 175;
	}

	@Override
	public int getPlayery() {
		return 50;
	}

}

