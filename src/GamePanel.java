
import java.awt.Graphics;

import javax.swing.*;
public class GamePanel extends JPanel{
	private Snake snake;
	private Food food;
	private Ground ground;
	//显示
	public void display(Snake snake,Food food,Ground ground){
		this.snake=snake;
		this.food=food;
		this.ground=ground;
		repaint();
	}
	//重绘图形
	public void paint(Graphics g) {
		//清除轨迹
		super.paint(g);
		snake.draw(g);
		food.draw(g);
		ground.draw(g);
	}
}
