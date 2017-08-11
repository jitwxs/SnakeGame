
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
public class Controller extends KeyAdapter implements SnakeListener{
	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamePanel;
	//控制器类
	public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel){
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}
	//当按下键盘上一个键时，改变方向
	public void keyPressed(KeyEvent e) {
		//获取按下的键
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
	//判断蛇是否碰到自己，障碍物，食物
	public void snakeMoved(Snake snake) {
		if(food.isEatBySnake(snake)){
			snake.eatFood(food);
			food.addfood(ground.getPoint());	
			}
		if(ground.isEatBySnake(snake)||snake.eatSelf()){
			JOptionPane.showMessageDialog(null, "失败，请重试！", "Game Over", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		gamePanel.display(snake, food, ground);
		
	}
	//游戏开始
	public void startGame(){
		snake.start();
		food.addfood(ground.getPoint());
	}
}
