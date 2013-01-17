package com.servisim.simulator.gui.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.servisim.simulator.gui.model.AbstractModel;
import com.servisim.simulator.gui.view.AbstractViewPanel;

public abstract class AbstractController implements PropertyChangeListener {
	private ArrayList<AbstractViewPanel> registeredViews = new ArrayList<AbstractViewPanel>();
	private ArrayList<AbstractModel> registeredModels = new ArrayList<AbstractModel>();

	public AbstractController() {
	}

	public void addModel(AbstractModel model) {
		registeredModels.add(model);
		model.addPropertyChangeListener(this);
	}

	public void removeModel(AbstractModel model) {
		registeredModels.remove(model);
		model.removePropertyChangeListener(this);
	}

	public void addView(AbstractViewPanel view) {
		registeredViews.add(view);
	}

	public void removeView(AbstractViewPanel view) {
		registeredViews.remove(view);
	}

	// Use this to observe property changes from registered models
	// and propagate them on to all the views.

	public void propertyChange(PropertyChangeEvent evt) {

		for (AbstractViewPanel view : registeredViews) {
			view.modelPropertyChange(evt);
		}
	}

	/**
	 * This is a convenience method that subclasses can call upon to fire
	 * property changes back to the models. This method uses reflection to
	 * inspect each of the model classes to determine whether it is the owner of
	 * the property in question. If it isn't, a NoSuchMethodException is thrown,
	 * which the method ignores.
	 * 
	 * @param propertyName
	 *            = The name of the property.
	 * @param newValue
	 *            = An object that represents the new value of the property.
	 */
	protected void setModelProperty(String propertyName, Object newValue) {

		for (AbstractModel model : registeredModels) {
			try {

				Method method = model.getClass().getMethod(
						"set" + propertyName,
						new Class[] { newValue.getClass() }

				);
				method.invoke(model, newValue);

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
