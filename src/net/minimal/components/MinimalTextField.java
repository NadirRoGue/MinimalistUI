package net.minimal.components;

import java.awt.Font;

import javax.swing.JTextField;

import net.minimal.AbstractFieldController;
import net.minimal.MinimalUIManager;
import net.minimal.behaviour.FieldMouseBehaviour;

/**
 * @author Nadir Román Guerrero
 */
public class MinimalTextField extends JTextField implements AbstractFieldController {

	public static final long serialVersionUID = 4954490144185781835L;
	
	private boolean activePlaceholder = false;
	
	public MinimalTextField(final int len)
	{
		super(len);
		setBorder(null);
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
	public void setEnabled(final boolean enabled)
	{
		super.setEnabled(enabled);
		if(!enabled)
			setBackground(MinimalUIManager.UI_TEXTFIELD_DISABLED_BACKGROUND_C);
		else
			setBackground(MinimalUIManager.UI_TEXTFIELD_BACKGROUND_C);
	}
}
