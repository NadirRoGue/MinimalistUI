package net.minimal.effectengine.effects;

import java.awt.Color;

import net.minimal.ThreadPool;
import net.minimal.components.MinimalButton;
import net.minimal.effectengine.ButtonEffect;

/**
 * @author Nadir Román Guerrero
 */
public final class EffectButtonHighlight extends ButtonEffect
{
	public static final int CHANGE_STEPS = 20;
	
	private int backRStep, backGStep, backBStep;
	private int fontRStep, fontGStep, fontBStep;
	private long steps;
	private int iterationNum = 0;
	
	public EffectButtonHighlight(final MinimalButton srcButton) 
	{
		super(srcButton);
	}
	
	private int getFactor(int current, int target)
	{
		final double temp = (double)-(current - target) / CHANGE_STEPS;
		if(temp < 0.0)
			return (int)(Math.ceil(temp));
		return (int)(Math.floor(temp));
	}
	
	@Override
	public void prepareEffect()
	{
		iterationNum = 0;
		active = true;
		
		Color currentBack = button.getBackground();
		Color currentFont = button.getForeground();
		
		backRStep = getFactor(currentBack.getRed(), targetBack.getRed());
		backGStep = getFactor(currentBack.getGreen(), targetBack.getGreen());
		backBStep = getFactor(currentBack.getBlue(), targetBack.getBlue());
		
		fontRStep = getFactor(currentFont.getRed(), targetFont.getRed());
		fontGStep = getFactor(currentFont.getGreen(), targetFont.getGreen());
		fontBStep = getFactor(currentFont.getBlue(), targetFont.getBlue());
		
		steps = (long)(300L / CHANGE_STEPS);
	}
	
	@Override
	public void run()
	{
		Color currentBack = button.getBackground();
		Color currentFont = button.getForeground();
		
		if(iterationNum < CHANGE_STEPS && active)
		{
			button.setBackground(new Color(currentBack.getRed() + backRStep, currentBack.getGreen() + backGStep, currentBack.getBlue() + backBStep));
			button.setForeground(new Color(currentFont.getRed() + fontRStep, currentFont.getGreen() + fontGStep, currentFont.getBlue() + fontBStep));
			button.invalidate();
			iterationNum++;
			
			ThreadPool.getInstance().schedule(this, steps);
		}
		else
		{
			if(active)
			{
				button.setBackground(targetBack);
				button.setForeground(targetFont);
				button.invalidate();
			}
			
			active = false;
			iterationNum = 0;
		}
	}
}
