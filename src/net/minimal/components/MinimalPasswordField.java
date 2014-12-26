package net.minimal.components;

import java.awt.Font;

import javax.swing.JPasswordField;

import net.minimal.AbstractFieldController;
import net.minimal.MinimalUIManager;
import net.minimal.behaviour.FieldMouseBehaviour;

public class MinimalPasswordField extends JPasswordField implements AbstractFieldController
{
	public static final long serialVersionUID = -3650881951242903108L;
	
	private boolean activePlaceholder = false;

	public MinimalPasswordField(final int columns)
	{
		super(columns);
		setFont(MinimalUIManager.getInstance().getSystemFont());
		setBackground(MinimalUIManager.UI_TEXTFIELD_BACKGROUND_C);
		setForeground(MinimalUIManager.UI_TEXTFIELD_TEXT_C);
		addMouseListener(new FieldMouseBehaviour(this));
		MinimalUIManager.getInstance().registerTextField(this);
	}
	
	@Override
	public synchronized void setPlaceholder(final String text)
	{
		setFont(getFont().deriveFont(Font.ITALIC));
		setText(text);
		activePlaceholder = true;
		invalidate();
	}
	
	@Override
	public synchronized void onUserClick()
	{
		setFont(MinimalUIManager.getInstance().getSystemFont());
		setText("");
		activePlaceholder = false;
		invalidate();
	}
	
	@Override
	public synchronized boolean isPlaceholderActive()
	{
		return activePlaceholder;
	}
	
	@Override
	public void setEnabled(final boolean val)
	{
		super.setEnabled(val);
		if(!val)
			setBackground(MinimalUIManager.UI_TEXTFIELD_DISABLED_BACKGROUND_C);
		else
			setBackground(MinimalUIManager.UI_TEXTFIELD_BACKGROUND_C);
	}
}
