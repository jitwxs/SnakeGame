
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
public class Snake {
	//蛇身
	private LinkedList<Point> body=new LinkedList<Point>();
	public static final int UP=1;
	public static final int DOWN=-1;
	public static final int LEFT=2;
	public static final int RIGHT=-2;
	int x,y;
	private int oldDirection,newDirection;
	private Point tail;//吃掉食物后要加的尾巴
	public Snake() {
		init();
	}
	//初始化蛇身
	public void init(){
		x=Global.WIDTH/2;
		y=Global.HEIGHT/2;
		for(int i=0;i<3;i++)
			body.add(new Point(x-i,y));
		//初始化方向朝右
		this.oldDirection=this.newDirection=RIGHT;
	}
	//接收蛇监听器的成员
	private SnakeListener snakeListener;
	//获取蛇头
	public Point getHead(){
		return body.getFirst();
	}
	//蛇的移动
	public void move(){
		//去尾
		tail=body.removeLast();
		//加头(根据按下的方向来确定)
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
	//蛇吃食物
	public void eatFood(Food food){
		//将尾巴加上去
		body.addLast(tail);
	}
	//改变蛇的方向
	public void changeDirection(int direction){
		this.newDirection=direction;
	}
	//画出蛇
	public void draw(Graphics g){
		//遍历容器
		for(Point p:body)
			g.fill3DRect(p.x*Global.CELL_SIZE,p.y*Global.CELL_SIZE,Global.CELL_SIZE,Global.CELL_SIZE,true);
	}
	//蛇是否吃到自己
	public boolean eatSelf(){
		for(int i=1;i<body.size();i++)
			if(body.get(i).equals(getHead()))
				return true;
		return false;
	}
	//添加蛇监听器的方法
	public void addSnakeListener(SnakeListener snakeListener){
		this.snakeListener=snakeListener;
	}
	//启动蛇的移动
	public void start(){
		//启动线程
		new SnakeDriver().start();
	}
	//创建一个线程为了启动蛇的移动
	private class SnakeDriver extends Thread{
		public void run() {
			//死循环让蛇移动
			while(true){
				move();
				//监听蛇的移动
				snakeListener.snakeMoved(Snake.this);
				//设置蛇的移动间隔1s
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
