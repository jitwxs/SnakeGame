
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
public class Controller extends KeyAdapter implements SnakeListener{
	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamePanel;
	//��������
	public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel){
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}
	//�����¼�����һ����ʱ���ı䷽��
	public void keyPressed(KeyEvent e) {
		//��ȡ���µļ�
		int keyCode=e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			snake.changeDirection(snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(snake.RIGHT);
			break;
		}
	}
	//�ж����Ƿ������Լ����ϰ��ʳ��
	public void snakeMoved(Snake snake) {
		if(food.isEatBySnake(snake)){
			snake.eatFood(food);
			food.addfood(ground.getPoint());	
			}
		if(ground.isEatBySnake(snake)||snake.eatSelf()){
			JOptionPane.showMessageDialog(null, "ʧ�ܣ������ԣ�", "Game Over", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		gamePanel.display(snake, food, ground);
		
	}
	//��Ϸ��ʼ
	public void startGame(){
		snake.start();
		food.addfood(ground.getPoint());
	}
}
