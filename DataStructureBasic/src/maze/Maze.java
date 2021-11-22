package maze;

public class Maze {


	/*	建立二維迷宮
	 * 	0表示沒走過 1表示牆壁 2表示走過 3表示這是死路
	 * 	走法固定ex 上右下左
	 */
	public static void main(String[] args) {
			
		int[][] mazeArray = new int[8][7];

		// create 牆壁
		for(int i = 0; i < 7;i++) {
			mazeArray[0][i]=1;
			mazeArray[7][i]=1;
		}
		for(int i = 0; i<8;i++) {
			mazeArray[i][0]=1;
			mazeArray[i][6]=1;
		}
		
		mazeArray[3][1]=1;
		mazeArray[3][2]=1;
		//mazeArray[3][3]=1;
		mazeArray[3][4]=1;
		mazeArray[3][5]=1;
		
		mazeStart(1,5,mazeArray);
		
		for(int i = 0;i<8;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(mazeArray[i][j]+" ");
			}
			System.out.println("");
		}

	}
	/* 開始走迷宮
	 * i,j為目前在的位置
	 * maze為迷宮 如果可以走則return true
	 */
	public static boolean mazeStart(int i,int j,int[][] maze) {
		//走道最後的位置
		if(maze[6][5]==2) {
			return true;
			//如果這個位置沒走過
		}else if(maze[i][j]==0) {
			//直接當它可以走
			maze[i][j]=2;
			//然後開始上右下左的方式走
			if(mazeStart(i-1,j,maze)) {
				return true;
			}else if (mazeStart(i,j+1,maze)){
				return true;
			}else if (mazeStart(i+1,j,maze)){
				return true;
			}else if (mazeStart(i,j-1,maze)){
				return true;
			}else {
				maze[i][j]=3;
				return false;
			}
		}else {
			return false;
		}
		
	}

}
