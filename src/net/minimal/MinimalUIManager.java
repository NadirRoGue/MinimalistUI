package net.minimal;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JTextField;

import net.minimal.components.MinimalButton;
import net.minimal.components.MinimalCheckBox;
import net.minimal.components.MinimalComboBox;
import net.minimal.components.MinimalFrame;
import net.minimal.components.MinimalLabel;
import net.minimal.components.MinimalPanel;

/**
 * @author Nadir Román Guerrero
 */
public final class MinimalUIManager 
{
	private static final class Singleton 
	{
		static final MinimalUIManager INSTANCE = new MinimalUIManager();
	}

	public static MinimalUIManager getInstance() 
	{
		return Singleton.INSTANCE;
	}

	public static Color UI_BUTTON_BACKGROUND_C 				= new Color(255, 255, 255); // White
	public static Color UI_BUTTON_TEXT_C 					= new Color(0, 128, 255); 	// Deep cyan
	public static Color UI_BUTTON_ACTIVE_BACKGROUND_C 		= new Color(0, 128, 255);	// Deep cyan
	public static Color UI_BUTTON_ACTIVE_TEXT_C 			= new Color(255, 255, 255);	// White
	public static Color UI_BUTTON_DISABLED_BACKGROUND_C 	= new Color(192, 192, 192); // Light grey
	public static Color UI_BUTTON_DISABLED_TEXT_C			= new Color(255, 255, 255); // White
	public static Color UI_TEXTFIELD_BACKGROUND_C			= new Color(0, 128, 255);	// Deep cyan
	public static Color UI_TEXTFIELD_TEXT_C					= new Color(255, 255, 255);	// White
	public static Color UI_TEXTFIELD_DISABLED_BACKGROUND_C 	= new Color(192, 192, 192); // Light grey
	public static Color UI_FRAME_BACKGROUND_C				= new Color(255, 255, 255); // White
	public static Color UI_FRAME_TEXT_C						= new Color(0, 128, 255);	// Deep cyan
	public static Color UI_FRAME_STATUSBAR_ACTIONS_C		= new Color(255, 255, 255); // White
	public static Color UI_PANEL_BACKGROUND_C				= new Color(255, 255, 255); // White
	public static Color UI_CHECKBOX_BACKGROUND_C			= new Color(255, 255, 255);	// White
	public static Color UI_CHECKBOX_TEXT_C					= new Color(0, 128, 255);	// Deep cyan
	public static Color UI_COMBOBOX_BACKGROUND_C			= new Color(255, 255, 255);	// White
	public static Color UI_COMBOBOX_TEXT_C					= new Color(0, 128, 255);	// Deep cyan
	public static Color UI_TITLEBAR_BACKGROUND_C			= new Color(0, 128, 255); 	// Deep cyan
	public static Color UI_TITLEBAR_TEXT_C					= new Color(255, 255, 255); // White

	private LinkedList<MinimalButton> buttonList = new LinkedList<MinimalButton>();
	private LinkedList<JTextField> textfieldList = new LinkedList<JTextField>();
	private LinkedList<MinimalLabel> labelList = new LinkedList<MinimalLabel>();
	private LinkedList<MinimalPanel> panelList = new LinkedList<MinimalPanel>();
	private LinkedList<MinimalFrame> frameList = new LinkedList<MinimalFrame>();
	private LinkedList<MinimalCheckBox> checkBoxList = new LinkedList<MinimalCheckBox>();
	private LinkedList<MinimalComboBox<? extends Object>> comboBoxList = new LinkedList<MinimalComboBox<? extends Object>>();
	private boolean enableUIEffects;
	private Font systemFont;

	MinimalUIManager() 
	{
		enableUIEffects = true;
		try
		{
			//new java.io.File("fonts/timeburner_regular.ttf")
			//getClass().getResourceAsStream("/fonts/timeburner_regular.ttf")
			systemFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/timeburner_regular.ttf")).deriveFont(17.0f);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(systemFont);
		} 
		catch (FontFormatException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void setEnabledEffects(final boolean choice)
	{
		enableUIEffects = choice;
	}
	
	public boolean effectsEnabled()
	{
		return enableUIEffects;
	}
	
	public Font getSystemFont()
	{
		return systemFont;
	}

	public void setUIFont(final Font font) 
	{
		setUIFont(font, false);
	}

	public void setUIFont(final Font font, final boolean update) 
	{
		systemFont = font.deriveFont(font.getSize2D());
		GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(systemFont);
		if (update) 
		{
			synchronized (this) 
			{
				for (MinimalButton min : buttonList) 
				{
					if (min != null) 
					{
						min.setFont(systemFont);
						min.invalidate();
					}
				}

				for (JTextField min : textfieldList) 
				{
					if (min != null) 
					{
						min.setFont(systemFont);
						min.invalidate();
					}
				}

				for (MinimalLabel min : labelList) 
				{
					if (min != null) 
					{
						min.setFont(systemFont);
						min.invalidate();
					}
				}

				for (MinimalPanel min : panelList) 
				{
					if (min != null) 
					{
						min.setFont(systemFont);
						min.invalidate();
					}
				}
				
				for(MinimalCheckBox box : checkBoxList)
				{
					if(box != null)
					{
						box.setFont(systemFont);
						box.invalidate();
					}
				}
				
				for(MinimalComboBox<? extends Object> box : comboBoxList)
				{
					box.setFont(systemFont);
					box.invalidate();
				}

				for (MinimalFrame min : frameList) 
				{
					if (min != null) 
					{
						min.setFont(systemFont);
						min.invalidate();
					}
				}
			}
		}
	}

	public void registerButton(final MinimalButton button)
	{
		buttonList.add(button);
	}
	
	public void registerCheckBox(final MinimalCheckBox box)
	{
		checkBoxList.add(box);
	}
	
	public void registerComboBox(final MinimalComboBox<? extends Object> box)
	{
		comboBoxList.add(box);
	}
	
	public void registerFrame(final MinimalFrame frame)
	{
		frameList.add(frame);
	}
	
	public void registerLabel(final MinimalLabel label)
	{
		labelList.add(label);
	}
	
	public void registerPanel(final MinimalPanel panel)
	{
		panelList.add(panel);
	}
	
	public void registerTextField(final JTextField field)
	{
		textfieldList.add(field);
	}

	public void setUIButtonBackgroundColor(final Color c) 
	{
		UI_BUTTON_BACKGROUND_C = new Color(c.getRGB());
		synchronized (buttonList) 
		{
			for (MinimalButton min : buttonList) 
			{
				if (min != null)
					min.setBackground(UI_BUTTON_BACKGROUND_C);
				else
					buttonList.remove(min);
			}
		}
	}

	public void setUIButtonTextColor(final Color c) 
	{
		UI_BUTTON_TEXT_C = new Color(c.getRGB());
		synchronized (buttonList) {
			for (MinimalButton min : buttonList) 
			{
				if (min != null)
					min.setForeground(UI_BUTTON_TEXT_C);
				else
					buttonList.remove(min);
			}
		}
	}

	public void setTextfieldBackgroundColor(final Color c)
	{
		UI_TEXTFIELD_BACKGROUND_C = new Color(c.getRGB());
		synchronized (textfieldList) 
		{
			for (JTextField min : textfieldList) 
			{
				if (min != null)
					min.setBackground(UI_TEXTFIELD_BACKGROUND_C);
				else
					textfieldList.remove(min);
			}
		}
	}

	public void setFrameBackgroundColor(final Color c) 
	{
		UI_FRAME_BACKGROUND_C = new Color(c.getRGB());
		synchronized (frameList) 
		{
			for (MinimalFrame min : frameList) 
			{
				if (min != null)
					min.setBackground(UI_FRAME_BACKGROUND_C);
				else
					frameList.remove(min);
			}
		}
	}
	
	public void setFrameTextColor(final Color c) 
	{
		UI_FRAME_TEXT_C = new Color(c.getRGB());
		synchronized (frameList) 
		{
			for (MinimalFrame min : frameList) 
			{
				if (min != null)
					min.setBackground(UI_FRAME_TEXT_C);
				else
					frameList.remove(min);
			}
		}
	}

	public void setFrameStatusBarActionsColor(final Color c) 
	{
		UI_FRAME_STATUSBAR_ACTIONS_C = new Color(c.getRGB());
		synchronized (frameList) 
		{
			for (MinimalFrame min : frameList) 
			{
				if (min != null)
					min.setBackground(UI_FRAME_STATUSBAR_ACTIONS_C);
				else
					frameList.remove(min);
			}
		}
	}

	public void setPanelBackgroundColor(final Color c) 
	{
		UI_PANEL_BACKGROUND_C = new Color(c.getRGB());
		synchronized (panelList) 
		{
			for (MinimalPanel min : panelList) 
			{
				if (min != null)
					min.setBackground(UI_PANEL_BACKGROUND_C);
				else
					panelList.remove(min);
			}
		}
	}
	
	public synchronized void closeApp()
	{
		System.exit(0);
	}
}
