
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Ground {
	int gr[][]=new int[Global.WIDTH][Global.HEIGHT];
	public Ground() {
		Random random=new Random();
		for(int k=0;k<20;k++){
			int i=random.nextInt(Global.WIDTH);
			int j=random.nextInt(Global.HEIGHT);
			gr[i][j]=1;
		}
	}
	//蛇是否碰到障碍物
	public boolean isEatBySnake(Snake snake){
		Point head=snake.getHead();
		for(int i=0;i<Global.WIDTH;i++)
			for(int j=0;j<Global.HEIGHT;j++)
				if(gr[i][j]==1&&head.x==i&&head.y==j)
					return true;
		return false;
	}
	//画出障碍物
	public void draw(Graphics g){
		g.setColor(Color.GRAY);
		for(int i=0;i<Global.WIDTH;i++)
			for(int j=0;j<Global.HEIGHT;j++)
				if(gr[i][j]==1)
					g.fill3DRect(i*Global.CELL_SIZE,j*Global.CELL_SIZE,Global.CELL_SIZE,Global.CELL_SIZE,true);
	}
	//设置食物不出现在障碍物上
	public Point getPoint(){
		int x,y;
		do{
		x=new Random().nextInt(Global.WIDTH);
		y=new Random().nextInt(Global.HEIGHT);
		}while(gr[x][y]==1);
		return new Point(x,y);
	}

}
