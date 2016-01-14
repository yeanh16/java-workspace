import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MineComponent extends JPanel
{
	public MineComponent(MineSweeper game)
	{
		super();
		MineModel model = new MineModel(game);
		
		BoardView board = new BoardView(model);
		ControlPanel controls = new ControlPanel(model);
		
		model.addObserver(board);
		
		setLayout(new BorderLayout());
		
		add(board,BorderLayout.CENTER);
		add(controls, BorderLayout.SOUTH);
	}
}
