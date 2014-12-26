package net.minimal.components.helperclasses;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import net.minimal.MinimalUIManager;
import net.minimal.components.MinimalFrame;

/**
 * @author Nadir Román Guerrero
 */
public final class FrameCloseButton extends JButton implements ActionListener
{
	public static final long serialVersionUID = 7938716782096665695L;

	private final MinimalFrame frame;
	
	public FrameCloseButton(final MinimalFrame f)
	{
		super();
		frame = f;
		addActionListener(this);
		setSize(15, 15);
		setPreferredSize(getSize());
		setBackground(MinimalUIManager.UI_TITLEBAR_BACKGROUND_C);
		setForeground(MinimalUIManager.UI_FRAME_STATUSBAR_ACTIONS_C);
		setBorder(null);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D graphics2D = (Graphics2D)g;
		
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2D.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		graphics2D.setColor(getForeground());
		graphics2D.drawLine(1, 1, getWidth()-1, getHeight()-1);
		graphics2D.drawLine(getWidth() - 1, 1, 1, getHeight() - 1);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(frame.getDefaultCloseOperation())
		{
			case MinimalFrame.DISPOSE_ON_CLOSE:
				frame.dispose();
				break;
			case MinimalFrame.HIDE_ON_CLOSE:
				frame.setVisible(false);
				break;
			case MinimalFrame.EXIT_ON_CLOSE:
				MinimalUIManager.getInstance().closeApp();
				break;
		}
	}
}
