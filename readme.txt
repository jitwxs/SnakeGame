̰����˵���ĵ�

  (1)����Ͷ���
     ��Snake����
     ��Foodʳ����
     ��Ground�ϰ�����
     ��GamePanel����࣬��ʾ�ߡ�ʳ��ϰ���
     ��Controller��������(��������snake,food,ground,gamePanel���ĸ�����)
     ��SnakeListener�����ߵ��ƶ�
     ��SnakeGameTest����Ϸ��װ����
     ��Global������

  (2)����ķ���
     ��Snake��     
	mouve()	�ƶ�
	eatFood(Food food)	��ʳ��
	changeDirection(int direction)	�ı䷽��
	draw(Graphics g)	����
	eatSelf()	�ж����Ƿ�Ե��Լ�
	addSnakeListener(SnakeListener snakeListener)	����ߵļ�����
	start()	�����ߵ��ƶ�
	SnakeDriver extends Thread	����һ���߳�Ϊ�������ߵ��ƶ�
	init()	��ʼ������
	getHead()	��ȡ��ͷ����
     ��Food��
	isEatBySnake(Snake snake)	�ж����Ƿ�Ե�ʳ��
	draw(Graphics g)	��ʳ��
	addFood(Point p)	����ʳ��
     ��Ground��
	isEatBySnake(Snake snake)	�ж����Ƿ������ϰ���
	draw(Graphics g)	���ϰ���
     ��GamePanel��
	display(Snake snake,Food food,Ground ground)	��ʾ�ߡ�ʳ��ϰ���
	paintComponents(Graphics g)	�ػ�ͼ��
     ��SnakeListener��
	snakeMoved(Snake snake)	�������Ƿ������Լ����ϰ��ʳ��
     ��Controller��
	keyPressed(KeyEvent e)	�����°���ʱ���ı��ߵķ���
	snakeMoved(Snake snake)	�ж����Ƿ������Լ����ϰ��ʳ��
	startGame()	������Ϸ��ʼ
	getPoint()	�õ�ʳ��ĵ��λ��

  (3)������Controller
     �ٿ�������Ҫ�ܹ������ߵ��ƶ���Ҫ�Ƿ���ĸı䣬�����ڲ���ʱ��ͨ�������¼������ƣ��������¼��ɼ��̼��������ƣ��������������ÿ������̳м��̼�����������дkeyPressed(KeyEvent e)������
     ����ÿ���ƶ�����Ӧ���ж����Ƿ������Լ����ϰ��ʳ����ǿ����Լ�дһ�����������������������¡�����дһ���ӿ�SnakeListener,Ȼ���߾���Ҫ���������������ķ�������������������ĳ�Ա��
     �ۿ�����ҲҪ���ߵļ��������ܹ��������Ƿ������Լ���ʳ��ϰ�������ÿ�����ʵ�ָýӿڡ�
  (4)��װ��ϷSnakeGameTest
     �ٴ���������Ķ���
     �ڿ�����ҲӦ�ÿ��Կ�����Ϸ�Ŀ�ʼ������ڿ����������startGame()������
     ���ڿ������������startGame()����,���൱������start����������������start()�����������ߵ��ƶ���
       start()������ʵ�־�������һ���̣߳����߲�ͣ���ƶ���
     ����Snake���д���һ���߳�SnakeDriver������д���е�run������
     �ݸ�����Ӽ��������������Ӽ����¼���������
     �޴������壬�����壬������Ϸ����ʾ���档
  (5)����ʵ��
     �ٲ���LinkedList���ݽṹ��ʹ��Point(���ε����Ͻ����꣬ÿ������Ŀ�ȡ��߶ȹ̶�)��
     ��̰������ɺ���������ɼ���������ɣ����ǿ���ֱ�Ӱ���廮�ֳ�X*Y��������ɡ����帨����Global��
     �۳�ʼ�����������м��������������Ϊ��ʼ����Ȼ�󻭳��������draw()������
     ������ߵ��ƶ�move������ʵ��ȥβ��ͷ�ķ�ʽ,ͬʱ���changeDirection����
     ���޸�������bug���߽�bug
     �����ʳ��Ĳ���
   a.ʳ�����һ�����ӣ����ӵĿ�Ⱥ͸߶����Ѿ�����õģ�����ֻ��Ҫ������Ͻ����ꡣ���Ͻ��������һ���㣬���ǿ�����ʳ����ֱ�Ӽ̳�Point��
   b.��ʳ����ǰ�ȥ����β�ͼӻ���������ͷ����ʳ��ʱ������β��
     ������ϰ���
