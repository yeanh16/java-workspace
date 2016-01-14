import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;

public class MineSweeper 
{
	public static final int UNEXPLORED = 0;
	public static final int EXPLORED = 1;
	public static final int UNEXPLOREDBOMB = 2;
	public static final int EXPLOREDBOMB = 3;
	
	private int bombs;
	private int [][] board;
	private String difficulty = "easy";
	
	/**
	 * method that will generate winning message
	 * @param infoMessage the message needed
	 * @param titleBar the title of the messagebox
	 */
	 public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
	
	/**
	Create a new game with empty board 
	*/
	public MineSweeper()
	{
		board =new int [12][12];
		//////////generating bombs
		if (this.difficulty=="easy")
		{
			this.bombs = 10;
		}
		else if (this.difficulty=="medium")
		{
			this.bombs = 15;
		}
		else
		{
			this.bombs = 20;
		}
		//generate random list of integers up to 100
		 Integer[] arr = new Integer[99];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = i+1;
		    }
		    Collections.shuffle(Arrays.asList(arr));
		    
		 //use first x ammount to deternmine bomb positions
		    int bombNum;
		    int i;
		    int j;
		    for (int f =0 ; f<this.bombs;f++)
		    {
		    	bombNum=arr[f];
		    	//if bombNum is divisible by 10 then special case;
		    	if(bombNum % 10 == 0)
		    	{
		    		if (bombNum == 100)
		    		{
		    			i = 10;
		    			j = 10;
		    		}
		    		else
		    		{
		    		i = 10;
		    		j =  Character.getNumericValue((String.valueOf(Math.abs((long)bombNum)).charAt(0)));
		    		}
		    	}
		    	else if(bombNum < 10)
		    	{
		    		i = bombNum;
		    		j = 1;		
		    	}
		    	else
		    	{
		    		i = Character.getNumericValue((String.valueOf(Math.abs((long)bombNum)).charAt(1)));
		    		j = ( Character.getNumericValue((String.valueOf(Math.abs((long)bombNum)).charAt(0)))+1);
		    	}
		    	board[i][j] = UNEXPLOREDBOMB;
		    }
		    ///////////end of generating bombs
		    
		for(int x = 0; x < 12; x++)
		{
			for(int y = 0; y < 12; y++)
			{
				if (board[x][y] != UNEXPLOREDBOMB)
				{
				board[x][y] = UNEXPLORED;
				}
			}
		}
	}
	
	/**
	 * Calculates the ammount of bombs around a square
	 * @param i i coord of board
	 * @param j j coord of board
	 * @return the number of bombs around a square
	 */
	public int numberofBombs(int i, int j)
	{
		int counter=0;
		if(board[i+1][j]==UNEXPLOREDBOMB||board[i+1][j]==EXPLOREDBOMB)
		{
			counter++;
		}
		if(board[i+1][j+1]==UNEXPLOREDBOMB||board[i+1][j+1]==EXPLOREDBOMB)
		{
			counter++;
		}
		if(board[i][j+1]==UNEXPLOREDBOMB||board[i][j+1]==EXPLOREDBOMB)
		{
			counter++;
		}
		if(board[i-1][j+1]==UNEXPLOREDBOMB||board[i-1][j+1]==EXPLOREDBOMB)
		{
			counter++;
		}
		if(board[i-1][j]==UNEXPLOREDBOMB||board[i-1][j]==EXPLOREDBOMB)
		{
			counter++;
		}
		if(board[i-1][j-1]==UNEXPLOREDBOMB||board[i-1][j-1]==EXPLOREDBOMB)
		{
			counter++;
		}
		if(board[i][j-1]==UNEXPLOREDBOMB||board[i][j-1]==EXPLOREDBOMB)
		{
			counter++;
		}
		if(board[i+1][j-1]==UNEXPLOREDBOMB||board[i+1][j-1]==EXPLOREDBOMB)
		{
			counter++;
		}
		return counter;
	}
	
	/**
	 * the method that will be used after each turn
	 * @param i the i coord of the board's move
	 * @param j the j coord of the board's move
	 */
	public void turn(int i, int j)
	{
		if(board[i][j]==UNEXPLOREDBOMB)
		{
			board[i][j]=EXPLOREDBOMB;
			reveal();
		}
		if(board[i][j]==UNEXPLORED)
		{
			board[i][j]=EXPLORED;
		}
		//check if they have won or not						
		int counter;
		if(this.difficulty == "easy")
		{
			counter=0;
			for(int x = 0; x < 12; x++)
			{
				for(int y = 0; y < 12; y++)
				{
					if(board[x][y]==EXPLORED)
					{
						counter++;
					}
				}
			}
			if( counter == 90)
			{
				MineSweeper.infoBox("You've Won!", "Congratulations!");
				reveal();
			}
		}
		if(this.difficulty == "medium")
		{
			counter=0;
			for(int x = 0; x < 12; x++)
			{
				for(int y = 0; y < 12; y++)
				{
					if(board[x][y]==EXPLORED)
					{
						counter++;
					}
				}
			}
			if( counter == 85)
			{
				MineSweeper.infoBox("You've Won!", "Congratulations!");
				reveal();
			}
		}
		if(this.difficulty == "hard")
		{
			counter=0;
			for(int x = 0; x < 12; x++)
			{
				for(int y = 0; y < 12; y++)
				{
					if(board[x][y]==EXPLORED)
					{
						counter++;
					}
				}
			}
			if( counter == 80)
			{
				MineSweeper.infoBox("You've Won!", "Congratulations!");
				reveal();
			}
		}
	}
	
	/**
	 * gets the cell's status
	 * @param i i coord of board
	 * @param j j coord of board
	 * @return the status of a cell
	 */
	public int get(int i, int j)
	{
		return board[i][j];
	}
	
	/**
	 * gets the difficulty of the game
	 * @return difficulty
	 */
	public String getDifficulty()
	{
		return this.difficulty;
	}
	
	/**
	 * sets difficulty of the game
	 * @param difficulty the new difficulty of the game
	 */
	public void setDifficulty(String difficulty)
	{
		this.difficulty = difficulty;
	}
	
	
	/**
	 * reveals the board once the game is over or when the button is clicked
	 */
	public void reveal()
	{
		for(int x = 0; x < 12; x++)
		{
			for(int y = 0; y < 12; y++)
			{
				if (board[x][y] == UNEXPLOREDBOMB)
				{
				board[x][y] = EXPLOREDBOMB;
				}
				else if( board[x][y]==UNEXPLORED)
				{
				board[x][y]=EXPLORED;
				}
			}
		}
	}
	
	/**
	 * sets up a new game
	 */
	public void newGame()
	{
		board =new int [12][12];
		//////////generating bombs
		if (this.difficulty=="easy")
		{
			this.bombs = 10;
		}
		else if (this.difficulty=="medium")
		{
			this.bombs = 15;
		}
		else
		{
			this.bombs = 20;
		}
		//generate random list of integers up to 100
		 Integer[] arr = new Integer[99];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = i+1;
		    }
		    Collections.shuffle(Arrays.asList(arr));
		    
		 //use first x ammount to deternmine bomb positions
		    int bombNum;
		    int i;
		    int j;
		    for (int f =0 ; f<this.bombs;f++)
		    {
		    	bombNum=arr[f];
		    	//if bombNum is divisible by 10 then special case;
		    	if(bombNum % 10 == 0)
		    	{
		    		if (bombNum == 100)
		    		{
		    			i = 10;
		    			j = 10;
		    		}
		    		else
		    		{
		    		i = 10;
		    		j =  Character.getNumericValue((String.valueOf(Math.abs((long)bombNum)).charAt(0)));
		    		}
		    	}
		    	else if(bombNum < 10)
		    	{
		    		i = bombNum;
		    		j = 1;		
		    	}
		    	else
		    	{
		    		i = Character.getNumericValue((String.valueOf(Math.abs((long)bombNum)).charAt(1)));
		    		j = ( Character.getNumericValue((String.valueOf(Math.abs((long)bombNum)).charAt(0)))+1);
		    	}
		    	board[i][j] = UNEXPLOREDBOMB;
		    }
		    ///////////end of generating bombs
		    
		for(int x = 0; x < 12; x++)
		{
			for(int y = 0; y < 12; y++)
			{
				if (board[x][y] != UNEXPLOREDBOMB)
				{
				board[x][y] = UNEXPLORED;
				}
			}
		}
	}
}
