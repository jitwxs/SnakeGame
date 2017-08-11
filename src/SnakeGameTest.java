import javax.swing.*;
public class SnakeGameTest {
	public static void main(String[] args) {
		//实体类对象的创建
		Snake snake=new Snake();
		Food food=new Food();
		Ground ground=new Ground();
		//OtherPanel otherPanel=new OtherPanel();
		//视图对象的创建
		GamePanel gamePanel=new GamePanel();
		//控制器的创建---->既是蛇的监听器，又是键盘的监听器
		Controller c=new Controller(snake, food, ground, gamePanel);
		//创建蛇的监听器
		snake.addSnakeListener(c);
		//创建面板的监听器
		gamePanel.addKeyListener(c);
		//创建窗体
		JFrame frame=new JFrame("贪吃蛇");
		frame.setSize(805,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//设置窗体显示在屏幕中间
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//让面板获得焦点
		gamePanel.setFocusable(true);
		frame.add(gamePanel);
		//启动游戏
		c.startGame();
	}

}
