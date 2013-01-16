package com.servisim.simulator.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class GridMap extends JComponent {
	Image i = null;
	Dimension grid = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 5004568091337606248L;

	public GridMap() {
		try {
			i = ImageIO.read(new File("resources/ist_population_density.bmp"));
		} catch (IOException e) {
			System.out.println("Error reading image : " + e.getMessage());
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(500, 300);
	}

	public void setGrid(Dimension d) {
		if (grid == null || (grid != null && !grid.equals(d))) {
			grid = d;
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (i != null)
			g.drawImage(i, 0, 0, null);
		if (grid != null) {
			final int height = getHeight();
			final int width = getWidth();
			for (int i = 0; i <= height; i += grid.height)
				g.drawLine(0, i, width, i);
			for (int i = 0; i <= width; i += grid.width)
				g.drawLine(i, 0, i, height);
		}
	}

}
