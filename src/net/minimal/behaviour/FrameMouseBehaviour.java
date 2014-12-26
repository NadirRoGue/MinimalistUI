package net.minimal.behaviour;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import net.minimal.components.MinimalFrame;

public final class FrameMouseBehaviour implements MouseInputListener
{
	private final MinimalFrame frame;
	private boolean isMoving = false;
	
	private int curX, curY;
	private int dstX, dstY;
	
	public FrameMouseBehaviour(final MinimalFrame srcFrame)
	{
		frame = srcFrame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		synchronized(this)
		{
			isMoving = true;
			dstX = e.getX();
			dstY = e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		synchronized(this)
		{
			isMoving = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{	
	}

	@Override
	public void mouseExited(MouseEvent e)
	{		
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		if(isMoving)
		{
			 curX = frame.getX();
			 curY = frame.getY();
		     int x = curX - dstX + e.getX();
		     int y = curY - dstY + e.getY();
		     frame.setLocation(x, y);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		
	}
}
