package net.minimal.components;

import java.awt.LayoutManager;

import javax.swing.JPanel;

import net.minimal.MinimalUIManager;

/**
 * @author Nadir Román Guerrero
 */
public class MinimalPanel extends JPanel {

	public static final long serialVersionUID = 6949675351996052380L;
	
	public MinimalPanel(final LayoutManager layout) 
	{
		super(layout);
		setOpaque(true);
		setBorder(null);
		setFont(MinimalUIManager.getInstance().getSystemFont());
		setBackground(MinimalUIManager.UI_FRAME_BACKGROUND_C);
		setForeground(MinimalUIManager.UI_FRAME_TEXT_C);
		MinimalUIManager.getInstance().registerPanel(this);
	}
}
