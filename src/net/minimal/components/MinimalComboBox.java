package net.minimal.components;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import net.minimal.MinimalUIManager;

/**
 * @author Nadir Román Guerrero
 */
public final class MinimalComboBox<T extends Object> extends JComboBox<T>
{
	public static final long serialVersionUID = -4314652386781044755L;
	
	MinimalComboBox(final ComboBoxModel<T> model)
	{
		super(model);
		setFont(MinimalUIManager.getInstance().getSystemFont());
		setBackground(MinimalUIManager.UI_COMBOBOX_BACKGROUND_C);
		setForeground(MinimalUIManager.UI_COMBOBOX_TEXT_C);
		MinimalUIManager.getInstance().registerComboBox(this);
	}
}
