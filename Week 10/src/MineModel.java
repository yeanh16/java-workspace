import java.util.Observable;
/**
 * model of MinsSweeper
 */
public class MineModel extends Observable
{
	private MineSweeper ms;
	
	/**
	 * 
	 * @param ms
	 */
	public MineModel (MineSweeper ms)
	{
		super();
		this.ms=ms;
	}
	
	/**
	 * turn
	 * @param i i coord of board
	 * @param j j coord of board
	 */
	public void turn(int i , int j)
	{
		ms.turn(i+1, j+1);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * get status of cell
	 * @param i i coord of board
	 * @param j j coord of board
	 * @return status of cell
	 */
	public int get(int i , int j)
	{
		return ms.get(i, j);
	}
	
	/**
	 * return number of bombs around a square
	 * @param i i coord of cell
	 * @param j i coord of cell
	 * @return number of bombs around a square
	 */
	public int numberofBombs(int i, int j)
	{
		return ms.numberofBombs(i, j);
	}
	
	/**
	 * reveals the board
	 */
	public void reveal()
	{
		ms.reveal();
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Set difficulty
	 * @param difficulty
	 */
	public void setDifficulty(String difficulty)
	{
		ms.setDifficulty(difficulty);
		setChanged();
		notifyObservers();

	}
	
	/**
	 * start a new game
	 */
	public void newGame()
	{
		ms.newGame();
		setChanged();
		notifyObservers();
	}
	
}
