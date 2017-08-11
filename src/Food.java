
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Food extends Point{
	//���Ƿ�Ե�ʳ��
	public boolean isEatBySnake(Snake snake){
		Point head=snake.getHead();
		if(this.equals(head))
			return true;
		return false;
	}
	//����ʳ��
	public void draw(Graphics g){
		g.setColor(Color.yellow);
		g.fill3DRect(x*Global.CELL_SIZE,y*Global.CELL_SIZE,Global.CELL_SIZE,Global.CELL_SIZE,true);
	}
	public void addfood(Point p){
		this.x=p.x;
		this.y=p.y;
	}
}
