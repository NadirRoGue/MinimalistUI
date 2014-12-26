package net.minimal.behaviour;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import net.minimal.components.MinimalCheckBox;

/**
 * @author Nadir Román Guerrero
 */
public final class ComboBoxBehaviour implements MouseListener
{
	private final MinimalCheckBox box;
	
	public ComboBoxBehaviour(final MinimalCheckBox srcBox)
	{
		box = srcBox;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		synchronized(this)
		{
			box.setSelected(!box.isSelected());
		}
		box.repaint();	
	}

	@Override
	public void mousePressed(MouseEvent e)
	{		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}
}