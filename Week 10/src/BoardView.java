import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardView extends JPanel implements Observer
{
	private MineModel model;
	private JButton[][] cell;
	/**
	 * Constructor of BoardView
	 * @param model model of minemodel
	 */
	public BoardView(MineModel model)
	{
		super();
		this.model=model;
		cell = new JButton [10][10];
		setLayout(new GridLayout(10,10));
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				cell[i][j] = new JButton(" ");
				final int x = i; 
				final int y = j;
				cell[i][j].addActionListener(e->model.turn(x, y));
				add(cell[i][j]);
			}
		}
	}
	
	/**
	 * update board
	 */
	public void update(Observable obs, Object obj)
	{
		for(int i=1; i < 11;i++)
		{
			for(int j=1;j<11;j++)
			{
				if(model.get(i,j) == MineSweeper.EXPLORED)
				{
					String no = Integer.toString(model.numberofBombs(i,j));
					cell[i-1][j-1].setText(no);
					cell[i-1][j-1].setEnabled(false);
				}
				else if(model.get(i,j) == MineSweeper.UNEXPLORED||model.get(i,j) == MineSweeper.UNEXPLOREDBOMB)
				{
					cell[i-1][j-1].setText("");
					cell[i-1][j-1].setEnabled(true);

				}
				else if(model.get(i,j) == MineSweeper.EXPLOREDBOMB)
				{
					cell[i-1][j-1].setText("X");
					cell[i-1][j-1].setEnabled(false);
				}

			}
		}
	}
}
