package com.servisim.simulator.gui.controller;

import java.awt.Color;

public class DefaultController extends AbstractController {
	// Properties this controller expects to be stored in one or more registered
	// models
	public static final String ELEMENT_WIDTH_PROPERTY = "Width";
	public static final String ELEMENT_HEIGHT_PROPERTY = "Height";
	public static final String ELEMENT_WEIGHT_PROPERTY = "Weight";
	public static final String ELEMENT_COLOR_PROPERTY = "Color";
	public static final String ELEMENT_TEXT_PROPERTY = "Text";
	public static final String ELEMENT_X_PROPERTY = "X";
	public static final String ELEMENT_Y_PROPERTY = "Y";

	/**
	 * Used by View(s) to change the element width in the model
	 * 
	 * @param newWidth
	 *            The new element width
	 */
	public void changeElementWidth(int newWidth) {
		setModelProperty(ELEMENT_WIDTH_PROPERTY, newWidth);
	}

	/**
	 * Used by View(s) to change the element height in the model
	 * 
	 * @param newHeight
	 *            The new element height
	 */
	public void changeElementHeight(int newHeight) {
		setModelProperty(ELEMENT_HEIGHT_PROPERTY, newHeight);
	}

	/**
	 * Used by View(s) to change the element string in the model
	 * 
	 * @param newText
	 *            The new element string
	 */
	public void changeElementText(String newText) {
		setModelProperty(ELEMENT_TEXT_PROPERTY, newText);
	}

	/**
	 * Used by View(s) to change the element X position value in the model
	 * 
	 * @param newX
	 *            The new element X position
	 */
	public void changeElementXPosition(int newX) {
		setModelProperty(ELEMENT_X_PROPERTY, newX);
	}

	/**
	 * Used by View(s) to change the element Y position value in the model
	 * 
	 * @param newY
	 *            The new element Y position
	 */
	public void changeElementYPosition(int newY) {
		setModelProperty(ELEMENT_Y_PROPERTY, newY);
	}

	/**
	 * Used by View(s) to change the element weight value in the model
	 * 
	 * @param newWeight
	 *            The new element weight value
	 */
	public void changeElementWeight(Integer newWeight) {
		setModelProperty(ELEMENT_WEIGHT_PROPERTY, newWeight);
	}

	/**
	 * Used by View(s) to change the element color value in the model
	 * 
	 * @param newColor
	 *            The new element color value
	 */
	public void changeElementColor(Color newColor) {
		setModelProperty(ELEMENT_COLOR_PROPERTY, newColor);
	}

}
