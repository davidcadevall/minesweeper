package minesweeper;

import java.util.Arrays;
import java.util.Random;
public class Board {
	

	
	
	
	private final int NUM_ROWS = 8;
	private final int NUM_COLUMNS = 8;

	private final int NUM_MINES = 10;
	
	private final int Empty_cell_value = 0;
	private final int Score_1_value = 1;
	private final int Score_2_value = 2;
	private final int Score_3_value = 3;
	
	private final int number_Score_1 = 16;
	private final int number_Score_2 = 12;
	private final int number_Score_3 = 8;
	
	private final int Mine_value = 5;
	
	private final int Flag_value = 4;
	
	public static int getRandomInteger(int min, int max) {
		
		Random ran = new Random();
		return ran.nextInt((max - min) + 1) + min;
		
	}
	
	public int[][] initBoard(int row, int col) {
		int Matrix_board[][] = new int[row][col];
		
	
		return Matrix_board;
	}
	
	public int[][] initScores(int numScores_1, int numScores_2, int numScores_3) {
		int Matrix_scores[][] = new int[NUM_ROWS][NUM_COLUMNS];
		
		
		return null;
		
	}
	
	public int[][] initMines(int numMines, int m[][]) {
		
		int Matrix_mines[][] = new int[NUM_ROWS][NUM_COLUMNS];
		Boolean doneMines = false;
		Matrix_mines= m;
		int number_Mines_left = numMines;
		int min_mine = 0;
		int max_mine = 3;
		
		int min_pos = 0;
		int max_pos = 7;
		int x=0;
		
		//Sacar valor 0-3 para poner X minas en esa fila y ir restando al maximo de minas
		//Podriamos por ejemplo saltarnos la 3 fila y la 6 o asi
		while(number_Mines_left > 0 || !doneMines) {//Crear funcion aparte

			//int y=0;
			int rand_mines = 0;
			
			
			rand_mines = getRandomInteger(min_mine, max_mine);
			if(rand_mines <= number_Mines_left) {
				for(int i=0; i < rand_mines; i++) {
					int rand_pos = 0;
					rand_pos = getRandomInteger(min_pos, max_pos);
					if(Matrix_mines[x][rand_pos] == 0) {
						Matrix_mines[x][rand_pos] = Mine_value;
					}else { i--; }
				}
				
				number_Mines_left = number_Mines_left - rand_mines;
				x++;
			}
			else {
				if(number_Mines_left == 2) {
					Matrix_mines[x][0] = Mine_value;
					Matrix_mines[x][7] = Mine_value;
				}else { 
					if(number_Mines_left == 1) {
						Matrix_mines[x][3] = Mine_value;
					}
				}
			}
			
			
			
			

		}
		
		//Posicion random 0-8 para colocar las minas en la fila X veces por el numero
		//de minas que vaya a a tener la fila
		
		
		return null;
		
	}


}
