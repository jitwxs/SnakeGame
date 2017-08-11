贪吃蛇说明文档

  (1)找类和对象
     ①Snake蛇类
     ②Food食物类
     ③Ground障碍物类
     ④GamePanel面板类，显示蛇、食物、障碍物
     ⑤Controller控制器类(用来控制snake,food,ground,gamePanel这四个对象)
     ⑥SnakeListener监听蛇的移动
     ⑦SnakeGameTest将游戏组装起来
     ⑧Global辅助类

  (2)找类的方法
     ①Snake类     
	mouve()	移动
	eatFood(Food food)	吃食物
	changeDirection(int direction)	改变方向
	draw(Graphics g)	画蛇
	eatSelf()	判断蛇是否吃到自己
	addSnakeListener(SnakeListener snakeListener)	添加蛇的监听器
	start()	启动蛇的移动
	SnakeDriver extends Thread	创建一个线程为了启动蛇的移动
	init()	初始化蛇身
	getHead()	获取蛇头坐标
     ②Food类
	isEatBySnake(Snake snake)	判断蛇是否吃到食物
	draw(Graphics g)	画食物
	addFood(Point p)	设置食物
     ③Ground类
	isEatBySnake(Snake snake)	判断蛇是否碰到障碍物
	draw(Graphics g)	画障碍物
     ④GamePanel类
	display(Snake snake,Food food,Ground ground)	显示蛇、食物、障碍物
	paintComponents(Graphics g)	重绘图形
     ⑤SnakeListener类
	snakeMoved(Snake snake)	监听蛇是否碰到自己、障碍物、食物
     ⑥Controller类
	keyPressed(KeyEvent e)	当按下按键时，改变蛇的方向
	snakeMoved(Snake snake)	判断蛇是否碰到自己、障碍物、食物
	startGame()	控制游戏开始
	getPoint()	得到食物的点的位置

  (3)控制器Controller
     ①控制器主要能够控制蛇的移动主要是方向的改变，我们在操作时是通过键盘事件来控制，而键盘事件由键盘监听器控制，所以我们首先让控制器继承键盘监听器，并重写keyPressed(KeyEvent e)方法。
     ②蛇每次移动，都应该判断蛇是否碰到自己、障碍物、食物。我们可以自己写一个监听器，来监听这三件事。所以写一个接口SnakeListener,然后蛇就需要有添加这个监听器的方法、接受这个监听器的成员。
     ③控制器也要是蛇的监听器，能够监听蛇是否碰到自己、食物、障碍物，所以让控制器实现该接口。
  (4)组装游戏SnakeGameTest
     ①创建所有类的对象。
     ②控制器也应该可以控制游戏的开始，因此在控制器中添加startGame()方法。
     ③在控制器中添加了startGame()方法,就相当于让蛇start，因此在蛇类中添加start()方法，启动蛇的移动。
       start()方法的实现就是启用一个线程，让蛇不停的移动。
     ④在Snake类中创建一个线程SnakeDriver，并重写其中的run方法。
     ⑤给蛇添加监听器，给面板添加键盘事件监听器。
     ⑥创建窗体，添加面板，启动游戏，显示界面。
  (5)具体实现
     ①采用LinkedList数据结构，使用Point(矩形的左上角坐标，每个方块的宽度、高度固定)。
     ②贪吃蛇完成后，蛇身就是由几个方块组成，我们可以直接把面板划分成X*Y的网格组成。定义辅助类Global。
     ③初始化蛇身。格子中间横向三个格子作为初始蛇身，然后画出蛇身，完成draw()方法。
     ④完成蛇的移动move方法，实现去尾加头的方式,同时完成changeDirection方法
     ⑤修复反方向bug、边界bug
     ⑥完成食物的操作
   a.食物就是一个格子，格子的宽度和高度是已经定义好的，我们只需要完成左上角坐标。左上角坐标就是一个点，我们可以让食物类直接继承Point类
   b.吃食物就是把去掉的尾巴加回来。当蛇头碰到食物时，加上尾巴
     ⑦完成障碍物
