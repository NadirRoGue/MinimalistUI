package net.minimal.components.helperclasses;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.minimal.MinimalUIManager;
import net.minimal.components.MinimalFrame;

public final class FrameMinimizeButton extends JButton implements ActionListener
{
	public static final long serialVersionUID = 7970304862194516698L;
	
	private final MinimalFrame parent;

	public FrameMinimizeButton(final MinimalFrame frame)
	{
		super();
		parent = frame;
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
		
		graphics2D.setColor(getForeground());
		graphics2D.fillRect(0, 13, getWidth(), 2);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		parent.setState(JFrame.ICONIFIED);
	}
}
