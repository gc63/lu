public class Nqueenproblem {
	static final int size=8;
	static int[][] board=new int[size][size];
	
	static void print() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==1) {
					System.out.print("Q ");
				}else {
					System.out.print(". ");
				}
			}System.out.println();

			
		}System.out.println();
	}


static boolean issafe(int row,int col) {
	for(int i=0; i<col;i++) {
		if(board[row][i]==1) return false;
	}
	
	for(int i=row,j=col;i>=0 && j>=0; i--,j--) {
		if(board[i][j]==1) return false;
	}
	
	for(int i=row,j=col;i<size && j>=0; i++,j--) {
		if(board[i][j]==1) return false;
	}
	return true;
}

static boolean placequeen(int col) {
	if(col>=size) return true;
	
	for (int row=0; row<size; row++) {
		if(issafe(row,col)) {
			board[row][col]=1;
			
			if(placequeen(col+1))return true;
			board[row][col]=0;
		}
	}
	return false;
}

public static void main(String [] args) {
	board[0][0]=1;
	
	if(placequeen(1)) {
		System.out.println("Solution for : ");
		
		print();
		
	}else {
		System.out.println("no:");
	}
	
}
}

