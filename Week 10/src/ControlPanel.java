import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ControlPanel extends JPanel
{
	public ControlPanel (MineModel model)
	{
		super();
		
		JRadioButton easy = new JRadioButton("easy");
		easy.addActionListener(e -> model.setDifficulty("easy"));
		easy.setSelected(true);
		JRadioButton medium = new JRadioButton("medium");
		medium.addActionListener(e -> model.setDifficulty("medium"));
		JRadioButton hard = new JRadioButton("hard");
		hard.addActionListener(e -> model.setDifficulty("hard"));
		ButtonGroup group = new ButtonGroup();
		group.add(easy);
		group.add(medium);
		group.add(hard);


		JButton reset = new JButton("New Game");
		reset.addActionListener(e -> model.newGame());
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(e -> System.exit(0));
		
		JButton reveal = new JButton("Reveal");
		reveal.addActionListener(e -> model.reveal());

		
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(easy);
		radioPanel.add(medium);
		radioPanel.add(hard);
		add(radioPanel,BorderLayout.LINE_START);
		add(reset);
		add(exit);
		add(reveal);
	}
}
