package net.minimal.effectengine.effects;

import net.minimal.components.MinimalButton;
import net.minimal.effectengine.ButtonEffect;

/**
 * @author Nadir Román Guerrero
 */
public final class EffectButtonSwitchColor extends ButtonEffect
{
	public EffectButtonSwitchColor(MinimalButton srcButton)
	{
		super(srcButton);
	}

	@Override
	public void run()
	{
		active = true;
		button.setBackground(targetBack);
		button.setForeground(targetFont);
		button.invalidate();
		active = false;
	}
}
