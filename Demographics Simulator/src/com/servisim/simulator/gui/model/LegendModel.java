package com.servisim.simulator.gui.model;

import java.awt.Color;

import com.servisim.simulator.gui.controller.DefaultController;

public class LegendModel extends AbstractModel {
	// Properties that this model represents
	private Color color;
	private Integer weight;

	// public LegendModel(DefaultController controller) {
	// controller.addModel(this);
	// }

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer newWeight) {
		Integer oldWeight = this.weight;
		this.weight = newWeight;
		firePropertyChange(DefaultController.ELEMENT_WEIGHT_PROPERTY,
				oldWeight, newWeight);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color newColor) {
		Color oldColor = this.color;
		this.color = newColor;
		firePropertyChange(DefaultController.ELEMENT_COLOR_PROPERTY, oldColor,
				newColor);
	}

}
