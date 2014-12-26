package net.minimal.behaviour;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import net.minimal.AbstractFieldController;

/**
 * @author Nadir Román Guerrero
 */
public final class FieldMouseBehaviour implements MouseListener
{
	private final AbstractFieldController field;
	
	public FieldMouseBehaviour(final AbstractFieldController srcField)
	{
		field = srcField;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(field.isPlaceholderActive())
			field.onUserClick();
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