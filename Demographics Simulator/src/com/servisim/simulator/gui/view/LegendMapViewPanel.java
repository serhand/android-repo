package com.servisim.simulator.gui.view;

import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;

import com.servisim.simulator.gui.utilities.SelectableLegendImage;

public class LegendMapViewPanel extends AbstractViewPanel {
	public LegendMapViewPanel(){
		setBorder(BorderFactory.createTitledBorder("Legend Identification"));
		add(new SelectableLegendImage());
	}
	@Override
	public void modelPropertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

}
