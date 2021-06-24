package com.tl.maze;

public class Maze {
	
	
	/*	�إߤG���g�c
	 * 	0��ܨS���L 1������ 2��ܨ��L 3��ܳo�O����
	 * 	���k�T�wex �W�k�U��
	 */
	public static void main(String[] args) {
			
		int[][] mazeArray = new int[8][7];
		
		// create ���
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
	/* �}�l���g�c
	 * i,j���ثe�b����m
	 * maze���g�c �p�G�i�H���hreturn true
	 */
	public static boolean mazeStart(int i,int j,int[][] maze) {
		//���D�̫᪺��m
		if(maze[6][5]==2) {
			return true;
		//�p�G�o�Ӧ�m�S���L
		}else if(maze[i][j]==0) {
			//�������i�H��
			maze[i][j]=2;
			//�M��}�l�W�k�U�����覡��
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
