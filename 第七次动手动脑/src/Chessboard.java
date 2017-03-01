import java.util.Scanner;
public class Chessboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Chessboard chess = new Chessboard();
		int i,j;
		
		do{
			chess.print();
			System.out.println("请输入位置：(1-9)");
			i = input.nextInt();
			j = input.nextInt();
			if(!chess.setChess('○', i, j)){
				System.out.println("该位置已经有子！");
			}
			chess.print();
		}while(i>-1 && i < 10 && j>-1 && j<10);
		
		//input.close();
	}
	private char[][] board = new char[10][10];
	public Chessboard(){
		for(short i = 0; i < 10; i++)
			for(short j = 0; j < 10; j++){
				if(i==0)
					board[i][j] = (char)(j+48);
				else if(j==0)
					board[i][j] = (char)(i+48);
				else
					board[i][j] = '+';
			}
	}
	public boolean setChess(char a,int i,int j){
		if(board[i][j] == '+'){
			board[i][j] = a;
			return true;
		}else
			return false;
	}
	public void print(){
		for(int i = 0; i < 10; i++){
			for(int j=0;j < 10; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}
}
