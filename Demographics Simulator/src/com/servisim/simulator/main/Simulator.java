package com.servisim.simulator.main;

import javax.swing.JComponent;
import javax.swing.JFrame;
import com.servisim.simulator.gui.GridMap;

public class Simulator {
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Demographics Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add the ubiquitous "Hello World" label.
        JComponent component = new GridMap();
        frame.getContentPane().add(component);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
