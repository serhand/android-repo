package com.servisim.simulator.gui.utilities;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

public class SelectableLegendImage extends JComponent implements MouseListener {
	private BufferedImage legendImage = null;

	public SelectableLegendImage() {
		try {
			legendImage = ImageIO.read(new File(
					"resources/ist_population_density_legend.bmp"));
		} catch (IOException e) {
			System.out.println("Error reading legend : " + e.getMessage());
		}
		addMouseListener(this);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(legendImage.getWidth(), legendImage.getHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (legendImage != null)
			g.drawImage(legendImage, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("released");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		System.out.println("entered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		System.out.println("exited");
	}
}
