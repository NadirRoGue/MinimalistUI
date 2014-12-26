package net.minimal.test;

import java.awt.Color;

import javax.swing.JFrame;

import net.minimal.MinimalUIManager;
import net.minimal.ThreadPool;
import net.minimal.components.MinimalButton;
import net.minimal.components.MinimalCheckBox;
import net.minimal.components.MinimalFrame;
import net.minimal.components.MinimalLabel;
import net.minimal.components.MinimalPanel;
import net.minimal.components.MinimalTextField;

/**
 * @author Nadir Román Guerrero
 */
public final class SimpleFrame {

	public static void main(String... args) {
		
		// Initializations
		MinimalUIManager.getInstance();
		ThreadPool.getInstance();
		
		// Code
		MinimalFrame frame = new MinimalFrame("Prueba v1.0", 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MinimalPanel panel = new MinimalPanel(null);
		panel.setSize(frame.getSize());

		MinimalButton button = new MinimalButton("This is a button");
		button.setBounds(5, 5, 200, 35);
		panel.add(button);
		
		MinimalButton button2 = new MinimalButton("This is a button");
		button2.setBounds(5, 45, 200, 35);
		panel.add(button2);
		MinimalButton button3 = new MinimalButton("This is a button");
		button3.setBounds(5, 85, 200, 35);
		panel.add(button3);
		MinimalButton button4 = new MinimalButton("This is a button");
		button4.setBounds(5, 125, 200, 35);
		panel.add(button4);
		MinimalButton button5 = new MinimalButton("This is a button");
		button5.setBounds(5, 165, 200, 35);
		
		button5.setAverageBackground(Color.RED);
		button5.setAverageForeground(Color.BLACK);
		button5.setActiveBackground(Color.BLUE);
		button5.setActiveForeground(Color.YELLOW);
		
		panel.add(button5);
		MinimalButton button6 = new MinimalButton("This is a button");
		button6.setBounds(5, 205, 200, 35);
		panel.add(button6);
		
		MinimalTextField field = new MinimalTextField(15);
		field.setToolTipText("This is a textfield");
		field.setBounds(5, 245, 200, 30);
		field.setPlaceholder("This is a field...");
		panel.add(field);
		
		MinimalLabel label = new MinimalLabel("This is a label");
		label.setBounds(5, 280, 200, 30);
		panel.add(label);
		
		MinimalCheckBox box = new MinimalCheckBox("Checkbox");
		//box.setSize(200, 20);
		box.setBounds(5, 315, 200, 20);
		panel.add(box);

		frame.setContentPane(panel);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
	}
}
