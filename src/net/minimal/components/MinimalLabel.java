package net.minimal.components;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;

import net.minimal.MinimalUIManager;

/**
 * @author Nadir Román Guerrero
 */
public class MinimalLabel extends JLabel {

	public static final long serialVersionUID = 4356326208840998813L;
	
	public MinimalLabel(final String text)
	{
		super(text);
		setOpaque(true);
		setFont(MinimalUIManager.getInstance().getSystemFont());
		setBackground(MinimalUIManager.UI_FRAME_BACKGROUND_C);
		setForeground(MinimalUIManager.UI_FRAME_TEXT_C);
		MinimalUIManager.getInstance().registerLabel(this);
	}
	
	private void changeStyle(final int style, final boolean choice)
	{
		if(choice)
			setFont(getFont().deriveFont(getFont().getStyle() | style));
		else
			setFont(getFont().deriveFont(getFont().getStyle() & ~style));
	}
	
	public void setBoldText(final boolean choice)
	{
		changeStyle(Font.BOLD, choice);
	}
	
	public void setItalicText(final boolean choice)
	{
		changeStyle(Font.ITALIC, choice);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setUnderlinedText(final boolean choice)
	{
		Font font = getFont();
		Map attributes = font.getAttributes();
		if(choice)
			attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		else
			attributes.remove(TextAttribute.UNDERLINE);
		setFont(font.deriveFont(attributes));
	}
}
