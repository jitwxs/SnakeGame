
import java.awt.Graphics;

import javax.swing.*;
public class GamePanel extends JPanel{
	private Snake snake;
	private Food food;
	private Ground ground;
	//��ʾ
	public void display(Snake snake,Food food,Ground ground){
		this.snake=snake;
		this.food=food;
		this.ground=ground;
		repaint();
	}
	//�ػ�ͼ��
	public void paint(Graphics g) {
		//����켣
		super.paint(g);
		snake.draw(g);
		food.draw(g);
		ground.draw(g);
	}
}
