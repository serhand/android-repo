package com.servisim.simulator.main;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;

import com.servisim.simulator.gui.utilities.GridMap;
import com.servisim.simulator.gui.utilities.SelectableLegendImage;
import com.servisim.simulator.gui.view.LegendMapViewPanel;
import com.servisim.simulator.gui.view.LegendSelectionViewPanel;

public class Simulator {
	
	JFrame frame = new JFrame("Demographics Simulator");
	
	public Simulator() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mapPane = new JPanel(new BorderLayout());
		mapPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Demographics Simulator"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
		final GridMap gridMap = new GridMap();
		gridMap.setGrid(new Dimension(10,10));
        JPanel cellSizePane = new JPanel(new BorderLayout());
        cellSizePane.setBorder(BorderFactory.createTitledBorder("Cell width in pixels"));
        
        JSlider cellSizer = new JSlider(10, 100, 10);
        //cellSizer.setSnapToTicks(true);
        cellSizer.setMajorTickSpacing(10);
        cellSizer.setPaintTicks(true);
        cellSizer.setPaintLabels(true);
        cellSizer.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int size = ((JSlider)e.getSource()).getValue();
				gridMap.setGrid(new Dimension(size,size));
				
			}
		});

        cellSizePane.add(cellSizer);

        mapPane.add(new LegendMapViewPanel(),BorderLayout.PAGE_START);
        mapPane.add(new LegendSelectionViewPanel(),BorderLayout.BEFORE_FIRST_LINE);
        mapPane.add(cellSizePane,BorderLayout.SOUTH);
        mapPane.add(gridMap,BorderLayout.CENTER);
 
        frame.getContentPane().add(mapPane);
        frame.pack();
        frame.setVisible(true);
	}

}
