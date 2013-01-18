package com.servisim.simulator.gui.view;

import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;

public class LegendSelectionViewPanel extends AbstractViewPanel {
	
	public LegendSelectionViewPanel(){
		setBorder(BorderFactory.createTitledBorder("Legends Identified"));
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

}
