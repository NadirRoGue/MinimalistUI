package net.minimal.effectengine;

import java.awt.Color;

import net.minimal.components.MinimalButton;

public abstract class ButtonEffect implements Runnable
{
	protected final MinimalButton button;
	protected Color targetBack;
	protected Color targetFont;
	
	protected boolean active = false;
	
	protected ButtonEffect(final MinimalButton srcButton) 
	{
		button = srcButton;
	}
	
	public void initialize(final Color back, final Color font)
	{
		targetBack = back;
		targetFont = font;
	}
	
	public final synchronized boolean active()
	{
		return active;
	}
	
	public final void stopEffect()
	{
		active = false;
	}
	
	public void prepareEffect()
	{
	}
}
