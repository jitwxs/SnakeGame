
//蛇的监听器，只要监听蛇的移动
public interface SnakeListener {
	//该方法去监听蛇是否碰到了食物、障碍物、自己。
	public void snakeMoved(Snake snake);
}
