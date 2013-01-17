package com.servisim.simulator.gui.view;

import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;

public abstract class AbstractViewPanel extends JPanel {
	/**
	 * Called by the controller when it needs to pass along a property change
	 * from a model.
	 * 
	 * @param evt
	 *            The property change event from the model
	 */

	public abstract void modelPropertyChange(PropertyChangeEvent evt);
}
