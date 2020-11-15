package minesweeper;


// this mock simulates outputs from the function initMines() with hardcoded cases to simulate random mines placement
public class MockBoard extends Board {
	
	public int[][] initMines(int mockSelection) {
		
		switch(mockSelection) {
		
			case 1:
				return new int[][] {{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9},
	        	  					{9, 9, 9, 9, 9, 9, 9, 9}};
				
			case 2:
				return new int[][] {{9, 0, 0, 0, 0, 0, 0, 9},
					  			    {0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{9, 0, 0, 0, 0, 0, 0, 9}};

			case 3:
				return new int[][] {{0, 9, 0, 0, 0, 0, 9, 0},
					  			    {9, 9, 0, 0, 0, 0, 9, 9},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{9, 9, 0, 0, 0, 0, 9, 9},
					  				{0, 9, 0, 0, 0, 0, 9, 0}};
				
			case 4:
				return new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 9, 9, 9, 9, 9, 9, 0},
					  				{0, 9, 0, 0, 0, 0, 9, 0},
					  				{0, 9, 0, 0, 0, 0, 9, 0},
					  				{0, 9, 0, 0, 0, 0, 9, 0},
					  				{0, 9, 0, 0, 0, 0, 9, 0},
					  				{0, 9, 9, 9, 9, 9, 9, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0}};
				
			case 5:
				return new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 9, 9, 9, 0, 0, 0, 0},
					  				{0, 9, 0, 9, 0, 0, 0, 0},
					  				{0, 9, 9, 9, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 9, 9, 9, 0},
					  				{0, 0, 0, 0, 9, 0, 9, 0},
					  				{0, 0, 0, 0, 9, 9, 9, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0}};
				
			default:
				return new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0},
					  				{0, 0, 0, 0, 0, 0, 0, 0}};
											
		}
	}
}