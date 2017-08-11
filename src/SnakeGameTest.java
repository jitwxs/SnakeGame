import javax.swing.*;
public class SnakeGameTest {
	public static void main(String[] args) {
		//ʵ�������Ĵ���
		Snake snake=new Snake();
		Food food=new Food();
		Ground ground=new Ground();
		//OtherPanel otherPanel=new OtherPanel();
		//��ͼ����Ĵ���
		GamePanel gamePanel=new GamePanel();
		//�������Ĵ���---->�����ߵļ����������Ǽ��̵ļ�����
		Controller c=new Controller(snake, food, ground, gamePanel);
		//�����ߵļ�����
		snake.addSnakeListener(c);
		//�������ļ�����
		gamePanel.addKeyListener(c);
		//��������
		JFrame frame=new JFrame("̰����");
		frame.setSize(805,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//���ô�����ʾ����Ļ�м�
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//������ý���
		gamePanel.setFocusable(true);
		frame.add(gamePanel);
		//������Ϸ
		c.startGame();
	}

}
