package minesweeper;

import static org.junit.Assert.*;
import java.util.Arrays;


import org.junit.Test;

public class BoardTest {

	@Test
	public void testInitBoard() {
		Board testboard = new Board(); //8x8
		
		//----TDD TESTS
		int[][] b = new int[8][8];
		int[][] c = new int[8][8];
		b[0][0] = testboard.Mine_value;
		b[1][1] = testboard.Mine_value;
		
		testboard.setBoard(b);
		testboard.initBoard();
		c = testboard.getBoard();
		
		assertEquals(c[0][1], 2);
		assertEquals(c[2][2], 1);
		assertEquals(c[5][5], 0);
		//TDD TESTS----
		
		
		//----Equivalence partitioning and limit values
		int lvl1_valid_dim = 8;
		Board testboardlvl1 = new Board(); //initBoard is called on the constructor
		int[][] testdimlvl1 = new int[8][8]; //matrix created in order to check the dimension of the generated by initBoard
												// it should be always 8x8

		assertEquals(testdimlvl1[0].length,testboardlvl1.num_rows);
		assertEquals(testdimlvl1[1].length,testboardlvl1.num_columns);
		int lvl1_invalid_superlower = -100;
		int lvl1_invalid_superhigher = 99;
		assertTrue("Dimension for lvl1 matrix should be 8x8 instead of having rows = " + testboardlvl1.num_rows, (testboardlvl1.num_rows > lvl1_invalid_superlower) || ( testboardlvl1.num_rows < lvl1_invalid_superhigher));

		int lvl1_invalid_lower = 7;
		int lvl1_invalid_higher = 9;
		
		assertTrue("Dimension for lvl1 matrix should be 8x8 instead of having rows = " + testboardlvl1.num_rows, (testboardlvl1.num_rows > lvl1_invalid_lower) || ( testboardlvl1.num_rows < lvl1_invalid_higher));
		assertTrue("Dimension for lvl1 matrix should be 8x8 instead of having columns =" + testboardlvl1.num_columns, (testboardlvl1.num_columns > lvl1_invalid_lower) || ( testboardlvl1.num_columns < lvl1_invalid_higher));
	
		//Equivalence partitioning and limit values----
	}
	
	@Test
	public void testInitBoard2() { //STATEMENT COVERAGE, LIMIT VALUES, EQUIVALENCE PARTITIONING
		Board testboard = new Board();
		MockBoard mockboard = new MockBoard(); //to simulate random bomb placement (initMines Mock)
		//With this test we check initBoard and getAdjacents, as one is part of the other
		
		//Test1:
		//In order to check limit values, we use the mock initMines to init the board without mines
		//The expected out has to be the board without changes, as there is no bomb has to do nothing
		testboard.setBoard(mockboard.initMines(0));
		testboard.initBoard();
		int [][] expectedOut1 = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0}};
		assertArrayEquals(testboard.getBoard(), expectedOut1);
		
		//Test2:
		//With the mock of initMines we generate a board filled only with mines
		//The expected output has to be expectedOut2 because we can't place any numbers
		//because there's no empty spots between mines
		testboard.setBoard(mockboard.initMines(1));
		testboard.initBoard();
		int [][] expectedOut2 = new int[][] {{9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9}};
		assertArrayEquals(testboard.getBoard(), expectedOut2);  	
      	 
		//Test3:
		//In this test we check if initBoard can calculate properly the values next to the limit of the board
		//placing mines (with the mock initMines) into the corners (limits) of the board
		testboard.setBoard(mockboard.initMines(2));
		testboard.initBoard();
		int [][] expectedOut3 = new int[][] {{9, 1, 0, 0, 0, 0, 1, 9},
											 {1, 1, 0, 0, 0, 0, 1, 1},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {1, 1, 0, 0, 0, 0, 1, 1},
											 {9, 1, 0, 0, 0, 0, 1, 9}};
		assertArrayEquals(testboard.getBoard(), expectedOut3);	
		
		//Test4:
		//With this test we check the limit of the board, using the mock initMines to place mines around the corners
		//of the board. This is useful to check if the method is calculating properly what positions has to check
		//to don't try to check a position out of the matrix and is also useful to check the statement coverage
		testboard.setBoard(mockboard.initMines(3));
		testboard.initBoard();
		int [][] expectedOut4 = new int[][] {{3, 9, 2, 0, 0, 2, 9, 3},
			 								 {9, 9, 2, 0, 0, 2, 9, 9},
			 								 {2, 2, 1, 0, 0, 1, 2, 2},
			 								 {0, 0, 0, 0, 0, 0, 0, 0},
			 								 {0, 0, 0, 0, 0, 0, 0, 0},
			 								 {2, 2, 1, 0, 0, 1, 2, 2},
			 								 {9, 9, 2, 0, 0, 2, 9, 9},
			 								 {3, 9, 2, 0, 0, 2, 9, 3}};			 
		assertArrayEquals(testboard.getBoard(), expectedOut4);
		
		//Test5:
		//In this test case, using the mock of initMines we want to check again the limits of the board,
		//in this case checking the first and last rows and columns. We want to checking again if the algorithm
		//is working fine and don't try to check on positions outside the matrix
		testboard.setBoard(mockboard.initMines(4));
		testboard.initBoard();
		int [][] expectedOut5 = new int[][] {{1, 2, 3, 3, 3, 3, 2, 1},
											 {2, 9, 9, 9, 9, 9, 9, 2},
											 {3, 9, 5, 3, 3, 5, 9, 3},
											 {3, 9, 3, 0, 0, 3, 9, 3},
											 {3, 9, 3, 0, 0, 3, 9, 3},
											 {3, 9, 5, 3, 3, 5, 9, 3},
											 {2, 9, 9, 9, 9, 9, 9, 2},
											 {1, 2, 3, 3, 3, 3, 2, 1}};
		assertArrayEquals(testboard.getBoard(), expectedOut5);
		
		//Test6:
		//Here we wan to check the maximum value that a cell can achieve. For that, we set mines all around
		//two cells with the mock of initMines and check if the method fill the center cell with an 8 (max value)
		testboard.setBoard(mockboard.initMines(5));
		testboard.initBoard();
		int [][] expectedOut6 = new int[][] {{1, 2, 3, 2, 1, 0, 0, 0},
											 {2, 9, 9, 9, 2, 0, 0, 0},
											 {3, 9, 8, 9, 3, 0, 0, 0},
											 {2, 9, 9, 9, 4, 3, 2, 1},
											 {1, 2, 3, 4, 9, 9, 9, 2},
											 {0, 0, 0, 3, 9, 8, 9, 3},
											 {0, 0, 0, 2, 9, 9, 9, 2},
											 {0, 0, 0, 1, 2, 3, 2, 1}};
		assertArrayEquals(testboard.getBoard(), expectedOut6);
		
		//Test7:
		//Here we fill some cells with invalid values (using initMines mock) to see if our algorithm is working
		//properly in case of invalid values. We also put a mine in the position 4,1. What the algorithm should do
		//is converting the invalid values (example: -1000) into a 0, and fill the cells around the mine with a 1.
		testboard.setBoard(mockboard.initMines(6));
		testboard.initBoard();
		int [][] expectedOut7 = new int [][] {{0, 0, 0, 0, 0, 0, 0, 0},
											  {0, 0, 0, 0, 0, 0, 0, 0},
											  {0, 0, 0, 0, 0, 0, 0, 0},
											  {1, 1, 1, 0, 0, 0, 0, 0},
											  {1, 9, 1, 0, 0, 0, 0, 0},
											  {1, 1, 1, 0, 0, 0, 0, 0},
											  {0, 0, 0, 0, 0, 0, 0, 0},
											  {0, 0, 0, 0, 0, 0, 0, 0}};
		assertArrayEquals(testboard.getBoard(), expectedOut7);
	}
	
	@Test
	public void testCheckMines() {
		//testing checkRightMines, checkLeftMines, checkTopMines, checkBottomMines, 
		//checkTopRightMines, checkTopLeftMines, checkBottomRightMines, checkBottomLeftMines
		
		//this functions will only return a 1 if there is a mine on the position it's checking
		//for example, checkRight will return a 1 if there is a mine right to the cell or a 0 if not
				
		int [][] inputTest = new int[][] {{9, 9, 9, 0, 0, 0, 0, 0}, // we will use the position 1,1 to check when THERE IS a mine
										  {9, 0, 9, 0, 0, 0, 0, 0},
										  {9, 9, 9, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0}, // we will use the position 6,6 to check when THERE ISN'T a mine
										  {0, 0, 0, 0, 0, 0, 0, 0}};
										  
		Board testBoard = new Board();
		testBoard.setBoard(inputTest);
										  			
		//To test if there is a mine, we compare the output of each function checking 1,1 with 1
		assertEquals(testBoard.checkTopMines(1, 1), 1);
		assertEquals(testBoard.checkTopRightMines(1, 1), 1);
		assertEquals(testBoard.checkRightMines(1, 1), 1);
		assertEquals(testBoard.checkBottomRightMines(1, 1), 1);
		assertEquals(testBoard.checkBottomMines(1, 1), 1);
		assertEquals(testBoard.checkBottomLeftMines(1, 1), 1);
		assertEquals(testBoard.checkLeftMines(1, 1), 1);
		assertEquals(testBoard.checkTopLeftMines(1, 1), 1);
		
		//To test if there isn't a mine, we compare the output of each function checking 6,6 with 0
		assertEquals(testBoard.checkTopMines(6, 6), 0);
		assertEquals(testBoard.checkTopRightMines(6, 6), 0);
		assertEquals(testBoard.checkRightMines(6, 6), 0);
		assertEquals(testBoard.checkBottomRightMines(6, 6), 0);
		assertEquals(testBoard.checkBottomMines(6, 6), 0);
		assertEquals(testBoard.checkBottomLeftMines(6, 6), 0);
		assertEquals(testBoard.checkLeftMines(6, 6), 0);
		assertEquals(testBoard.checkTopLeftMines(6, 6), 0);
		
		//Check if all of them combined work (getAdjacent)
		assertEquals((testBoard.getAdjacent(1, 1)), 8);
		assertEquals((testBoard.getAdjacent(6, 6)), 0);
	}
	
	@Test
	public void testInitMines() {
		//----TDD TESTS
		Board testboard1 = new Board();
		int m1[][] = testboard1.getBoard();
		int mines1=0;
		
		//Search for 10 mines
		for(int i=0; i < 8; i++)
		{
			for(int j=0; j < 8; j++) {
				if(m1[i][j]==9) {
					mines1 = mines1+1;
				}
			}
		}
		assertEquals(mines1,10);
		
		
		//TDD TESTS----
		
		//----Equivalence partitioning and limit values
		//Already tested for the valid values on TDD tested
		
		int lvl1_invalid_superlower = 0;
		int lvl1_invalid_superhigher = 100;
		assertTrue("Mines for lvl 1 should be 10 instead of " + mines1, (mines1 >= lvl1_invalid_superlower) || (mines1 <= lvl1_invalid_superhigher));

		int lvl1_invalid_lower = 9;
		int lvl1_invalid_higher = 11;
		assertTrue("Mines for lvl 1 should be 10 instead of " + mines1, (mines1 >= lvl1_invalid_lower) || (mines1 <= lvl1_invalid_higher));
		
		//Equivalence partitioning and limit values----
	}
	
	@Test
	public void testGetRandomInteger() {
		Board testboard = new Board();
		
		//between 0,5
		assertTrue(Board.getRandomInteger(0,5) >= 0 && Board.getRandomInteger(0,5) <= 5);
		//between 0,1
		assertTrue(Board.getRandomInteger(0,1) >= 0 && Board.getRandomInteger(0,1) <= 1);
		//between 0,0
		assertTrue(Board.getRandomInteger(0,0) >= 0 && Board.getRandomInteger(0,0) <= 0);
		//between 5,0
		assertTrue(Board.getRandomInteger(5,0) >= 5 && Board.getRandomInteger(5,0) <= 0);
	}
	
	@Test
	public void testopenCell() {
		//TDD
		Board testboard10 = new Board();
		int [][] input = new int[][] {{3, 9, 2, 0, 0, 2, 9, 3},
									 {9, 9, 2, 0, 0, 2, 9, 9},
									 {2, 2, 1, 0, 0, 1, 2, 2},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {2, 2, 1, 0, 0, 1, 2, 2},
									 {9, 9, 2, 0, 0, 2, 9, 9},
									 {3, 9, 2, 0, 0, 2, 9, 3}};
			 
		
		 
		 //Selecting any middle cell with value 0 should output the following matrix
		 int [][] expectedOu = new int[][] {{-1, -1, 2, 0, 0, 2, -1, -1},
										   {-1, -1, 2, 0, 0, 2, -1, -1},
										   {2, 2, 1, 0, 0, 1, 2, 2},
										   {0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0},
										   {2, 2, 1, 0, 0, 1, 2, 2},
										   {-1, -1, 2, 0, 0, 2, -1, -1},
										   {-1, -1, 2, 0, 0, 2, -1, -1}};
		testboard10.setBoard(input);								   
	    testboard10.openCell(0, 3);									   
		int [][]p = new int[8][8];
		p = testboard10.getBoardUser();
		assertArrayEquals(expectedOu, p);
										   
		int [][] expectedOu1 = new int[][] {{3, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1}};
										   
	    Board testboard11 = new Board();
		testboard11.setBoard(input);
		int [][]v = new int[8][8];
		testboard11.openCell(0, 0);	
		
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu1, v); 
										   
	   int [][] expectedOu2  = new int[][] {{3, 9, -1, -1, -1, -1, 9, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, 9, -1, -1, -1, -1, 9, -1}};

	    //----TDD for opening a mine and losing
		testboard11.openCell(0, 1);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
											
		int [][] expectedOu3= new int[][] {{3, 9, -1, -1, -1, -1, 9, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, 9, -1, -1, -1, -1, 9, 3}};
	   								   

		//----Equivalence partitioning and Limit values
		//We already tested for a valid inputs
		//Now we are going to test invalid inputs
		//we should get the same out as the last one due to not opnening invalid values
		testboard11.openCell(-1, -1);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(-100, -100);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(100, 100);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(3, -1);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(-1, 3);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(8, 8);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(0, 8);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(7,7);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu3,v);
		
		//---Statement coverage
		int [][] input1 = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0}};
		 int [][] ExpectedO3 = new int[][]  {{0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0}};								 
									 
	    Board testboard12 = new Board();
		testboard12.setBoard(input1);	
	    testboard12.openCell(0, 0);
	    testboard12.openCell(0, 7);	
	    testboard12.openCell(7, 0);	
	    testboard12.openCell(7, 7);	
		int [][]z = new int[8][8];
		z = testboard12.getBoardUser();
		assertArrayEquals(ExpectedO3, z);								 

	
	}


}
