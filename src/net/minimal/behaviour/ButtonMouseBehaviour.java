package net.minimal.behaviour;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import net.minimal.MinimalUIManager;
import net.minimal.ThreadPool;
import net.minimal.components.MinimalButton;
import net.minimal.effectengine.ButtonEffect;
import net.minimal.effectengine.effects.EffectButtonHighlight;
import net.minimal.effectengine.effects.EffectButtonSwitchColor;

/**
 * @author Nadir Román Guerrero
 */
public final class ButtonMouseBehaviour implements MouseListener
{
	private final MinimalButton button;
	private final ButtonEffect enterEffect;
	private final ButtonEffect exitEffect;
	
	public ButtonMouseBehaviour(final MinimalButton srcButton) 
	{
		button = srcButton;
		if(MinimalUIManager.getInstance().effectsEnabled())
		{
			enterEffect = new EffectButtonHighlight(button);
			exitEffect = new EffectButtonHighlight(button);	
		}
		else
		{
			enterEffect = new EffectButtonSwitchColor(button);
			exitEffect = new EffectButtonSwitchColor(button);
		}
		
		enterEffect.initialize(button.getActiveBackground(), button.getActiveForeground());
		exitEffect.initialize(button.getAverageBackground(), button.getAverageForeground());
	}

	@Override
	public synchronized void mouseEntered(MouseEvent e) 
	{
		exitEffect.stopEffect();
		
		if(button.isEnabled())
		{
			enterEffect.initialize(button.getActiveBackground(), button.getActiveForeground());
		}
		else
		{
			enterEffect.initialize(MinimalUIManager.UI_BUTTON_DISABLED_BACKGROUND_C, MinimalUIManager.UI_BUTTON_DISABLED_TEXT_C);
		}
		
		enterEffect.prepareEffect();
		ThreadPool.getInstance().executeEffect(enterEffect);
	}

	@Override
	public synchronized void mouseExited(MouseEvent e)
	{
		enterEffect.stopEffect();
		exitEffect.initialize(button.getAverageBackground(), button.getAverageForeground());
		exitEffect.prepareEffect();
		ThreadPool.getInstance().executeEffect(exitEffect);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
	}
}