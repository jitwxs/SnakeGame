
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
public class Snake {
	//����
	private LinkedList<Point> body=new LinkedList<Point>();
	public static final int UP=1;
	public static final int DOWN=-1;
	public static final int LEFT=2;
	public static final int RIGHT=-2;
	int x,y;
	private int oldDirection,newDirection;
	private Point tail;//�Ե�ʳ���Ҫ�ӵ�β��
	public Snake() {
		init();
	}
	//��ʼ������
	public void init(){
		x=Global.WIDTH/2;
		y=Global.HEIGHT/2;
		for(int i=0;i<3;i++)
			body.add(new Point(x-i,y));
		//��ʼ��������
		this.oldDirection=this.newDirection=RIGHT;
	}
	//�����߼������ĳ�Ա
	private SnakeListener snakeListener;
	//��ȡ��ͷ
	public Point getHead(){
		return body.getFirst();
	}
	//�ߵ��ƶ�
	public void move(){
		//ȥβ
		tail=body.removeLast();
		//��ͷ(���ݰ��µķ�����ȷ��)
		if(this.oldDirection+this.newDirection!=0)
			this.oldDirection=this.newDirection;
		switch (oldDirection) {
		case UP:
			y--;
			if(y<0)y=Global.HEIGHT-1;
			break;
		case DOWN:
			y++;
			if(y>=Global.HEIGHT)y=0;
			break;
		case LEFT:
			x--;
			if(x<0)x=Global.WIDTH-1;
			break;
		case RIGHT:
			x++;
			if(x>=Global.WIDTH)x=0;
			break;
		}
		body.addFirst(new Point(x,y));
	}
	//�߳�ʳ��
	public void eatFood(Food food){
		//��β�ͼ���ȥ
		body.addLast(tail);
	}
	//�ı��ߵķ���
	public void changeDirection(int direction){
		this.newDirection=direction;
	}
	//������
	public void draw(Graphics g){
		//��������
		for(Point p:body)
			g.fill3DRect(p.x*Global.CELL_SIZE,p.y*Global.CELL_SIZE,Global.CELL_SIZE,Global.CELL_SIZE,true);
	}
	//���Ƿ�Ե��Լ�
	public boolean eatSelf(){
		for(int i=1;i<body.size();i++)
			if(body.get(i).equals(getHead()))
				return true;
		return false;
	}
	//����߼������ķ���
	public void addSnakeListener(SnakeListener snakeListener){
		this.snakeListener=snakeListener;
	}
	//�����ߵ��ƶ�
	public void start(){
		//�����߳�
		new SnakeDriver().start();
	}
	//����һ���߳�Ϊ�������ߵ��ƶ�
	private class SnakeDriver extends Thread{
		public void run() {
			//��ѭ�������ƶ�
			while(true){
				move();
				//�����ߵ��ƶ�
				snakeListener.snakeMoved(Snake.this);
				//�����ߵ��ƶ����1s
				try {
					Thread.sleep(100);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
