package net.minimal.components;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.minimal.MinimalUIManager;
import net.minimal.behaviour.FrameMouseBehaviour;
import net.minimal.components.helperclasses.FrameCloseButton;
import net.minimal.components.helperclasses.FrameMinimizeButton;

/**
 * @author Nadir Román Guerrero
 */
public class MinimalFrame extends JFrame 
{
	public static final long serialVersionUID = -5632156546529602455L;
	
	private final JPanel upperPanel = new JPanel(null);
	private final JPanel statusBar = new JPanel(null);
	private final JPanel contentPane = new JPanel(null);

	public MinimalFrame(final String srcTitle, final int width, final int height) 
	{
		super(srcTitle);
		setBackground(MinimalUIManager.UI_FRAME_BACKGROUND_C);
		setForeground(MinimalUIManager.UI_FRAME_TEXT_C);
		setUndecorated(true);
		setFont(MinimalUIManager.getInstance().getSystemFont());
		
		setSize(width, height + getFont().getSize() + 10);
		setPreferredSize(getSize());
		
		statusBar.setSize(getWidth(), getFont().getSize() + 10);
		statusBar.setPreferredSize(statusBar.getSize());
		statusBar.setBounds(0, 0, getWidth(), getFont().getSize() + 10);
		statusBar.setBorder(BorderFactory.createLineBorder(getForeground()));
		statusBar.setBackground(MinimalUIManager.UI_TITLEBAR_BACKGROUND_C);
		statusBar.setOpaque(true);
		
		JLabel label = new JLabel(getTitle());
		label.setBackground(getBackground());
		label.setSize(SwingUtilities.computeStringWidth(getFontMetrics(getFont()), getTitle()), statusBar.getHeight() - 2);
		label.setBounds(3, (statusBar.getHeight() / 2) - (label.getHeight() / 2) + 2, label.getWidth(), label.getHeight() - 2);
		label.setFont(getFont());
		label.setForeground(MinimalUIManager.UI_TITLEBAR_TEXT_C);
		label.setBackground(MinimalUIManager.UI_TITLEBAR_BACKGROUND_C);
		label.setOpaque(true);
		
		statusBar.add(label);
		
		FrameMouseBehaviour behav = new FrameMouseBehaviour(this);
		statusBar.addMouseListener(behav);
		statusBar.addMouseMotionListener(behav);
		
		FrameCloseButton close = new FrameCloseButton(this);
		close.setBounds(getWidth() - close.getWidth() - 3, (statusBar.getHeight() / 2) - (close.getHeight() / 2), close.getWidth(), close.getHeight());
		statusBar.add(close);
		FrameMinimizeButton minimize = new FrameMinimizeButton(this);
		minimize.setBounds(getWidth() - close.getWidth() - 3 - minimize.getWidth() - 3, (statusBar.getHeight() / 2) - (minimize.getHeight() / 2), minimize.getWidth(), minimize.getHeight());
		statusBar.add(minimize);
		
		contentPane.setSize(getWidth(), height);
		contentPane.setPreferredSize(contentPane.getSize());
		contentPane.setBounds(0, getFont().getSize() + 10, getWidth(), height);
		contentPane.setBackground(getBackground());
		contentPane.setBorder(BorderFactory.createLineBorder(getForeground()));
		contentPane.setOpaque(true);
		
		upperPanel.setSize(getSize());
		upperPanel.setPreferredSize(getSize());
		upperPanel.setBounds(0, 0, getWidth(), getHeight());
		upperPanel.setBackground(getBackground());
		upperPanel.setOpaque(true);
		
		upperPanel.add(statusBar);
		upperPanel.add(contentPane);
		
		MinimalUIManager.getInstance().registerFrame(this);
		
		super.setContentPane(upperPanel);
	}
	
	@Override
	public final void setContentPane(Container content)
	{
		contentPane.removeAll();
		content.setSize(contentPane.getWidth() - 2, contentPane.getHeight() - 1);
		content.setBounds(1, 0, contentPane.getWidth() - 2, contentPane.getHeight() - 1);
		content.setBackground(getBackground());
		contentPane.add(content);
		invalidate();
	}
	
	@Override
	public final Container getContentPane()
	{
		return contentPane;
	}

	@Override
	public final void setFont(final Font font)
	{
		super.setFont(font);
		setSize(getWidth(), getHeight() + font.getSize() + 5);
	}
	
	@Override
	public final Dimension getPreferredSize()
	{
		return getSize();
	}
}
