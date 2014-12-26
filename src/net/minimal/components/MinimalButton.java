package net.minimal.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import net.minimal.MinimalUIManager;
import net.minimal.behaviour.ButtonMouseBehaviour;

/**
 * @author Nadir Román Guerrero
 */
public class MinimalButton extends JButton 
{
	public static final long serialVersionUID = 1L;
	
	private Color activeBack, activeFore;
	private Color nonActiveBack, nonActiveFore;

	public MinimalButton(String text) 
	{
		super(text);
		setFont(MinimalUIManager.getInstance().getSystemFont());
		setBackground((nonActiveBack = MinimalUIManager.UI_BUTTON_BACKGROUND_C));
		setForeground((nonActiveFore = MinimalUIManager.UI_BUTTON_TEXT_C));
		activeBack = MinimalUIManager.UI_BUTTON_ACTIVE_BACKGROUND_C;
		activeFore = MinimalUIManager.UI_BUTTON_ACTIVE_TEXT_C;
		addMouseListener(new ButtonMouseBehaviour(this));
		MinimalUIManager.getInstance().registerButton(this);
	}
	
	public final Color getAverageBackground()
	{
		return nonActiveBack;
	}
	
	public final Color getAverageForeground()
	{
		return nonActiveFore;
	}
	
	public final Color getActiveBackground()
	{
		return activeBack;
	}
	
	public final Color getActiveForeground()
	{
		return activeFore;
	}
	
	public void setAverageBackground(final Color color)
	{
		nonActiveBack = color;
		setBackground(color);
	}
	
	public void setAverageForeground(final Color color)
	{
		nonActiveFore = color;
		setForeground(color);
	}
	
	public void setActiveBackground(final Color color)
	{
		activeBack = color;
	}
	
	public void setActiveForeground(final Color color)
	{
		activeFore = color;
	}

	@Override
	public void paintComponent(Graphics g) 
	{
		final Graphics2D graphics2D = (Graphics2D)g;
		
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		graphics2D.setColor(getBackground());
		graphics2D.fillRect(0, 0, getWidth(), getHeight());
		graphics2D.setColor(getForeground());

		final String text = getText();
		final int textWidth = SwingUtilities.computeStringWidth(graphics2D.getFontMetrics(), text);
		final int fontSize = this.getFont().getSize();
		final int xPos = (getWidth() / 2) - (textWidth / 2);
		final int yPos = (getHeight() / 2) + (fontSize / 2);
		graphics2D.drawString(text, xPos, yPos);
	}
}
