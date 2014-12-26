package net.minimal.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import net.minimal.MinimalUIManager;
import net.minimal.behaviour.ComboBoxBehaviour;

public final class MinimalCheckBox extends JComponent
{
	public static final long serialVersionUID = -7124405981594714836L;
	
	private final String boxText;
	private boolean isSelected = false;

	public MinimalCheckBox(final String text)
	{
		super();
		setBorder(null);
		addMouseListener(new ComboBoxBehaviour(this));
		setFont(MinimalUIManager.getInstance().getSystemFont());
		setBackground(MinimalUIManager.UI_COMBOBOX_BACKGROUND_C);
		setForeground(MinimalUIManager.UI_COMBOBOX_TEXT_C);
		boxText = text;
		MinimalUIManager.getInstance().registerCheckBox(this);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		final Graphics2D graphics2D = (Graphics2D)g;
		
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(Color.BLACK);
		final int dim = getHeight() - 2;
		g.drawRect(1, 1, dim, dim);
		
		if(isSelected)
		{
			g.drawLine(1, 1, dim, dim);
			g.drawLine(1, dim, dim, 1);
		}
		
		g.setColor(getForeground());
		g.drawString(boxText, 1 + dim + 3, (getHeight() / 2) + (getFont().getSize() / 2));
	}
	
	public boolean isSelected()
	{
		return isSelected;
	}
	
	public void setSelected(final boolean val)
	{
		isSelected = val;
	}

}
