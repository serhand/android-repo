package com.servisim.simulator.gui.utilities;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.RepaintManager;

public class SelectableLegendImage extends JComponent implements MouseListener,
		MouseMotionListener {
	private BufferedImage legendImage = null;
	private Point selectionDiagonals[] = { new Point(), new Point() };

	public SelectableLegendImage() {
		try {
			legendImage = ImageIO.read(new File(
					"resources/ist_population_density_legend.bmp"));
		} catch (IOException e) {
			System.out.println("Error reading legend : " + e.getMessage());
		}
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(legendImage.getWidth(), legendImage.getHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (legendImage != null) {
			Rectangle clipRect = g.getClipBounds();
			final int x1 = clipRect.x;
			final int y1 = clipRect.y;
			final int x2 = x1 + clipRect.width;
			final int y2 = y1 + clipRect.height;
			g.drawImage(legendImage, x1, y1, x2, y2, x1, y1, x2, y2, null);
			if (!selectionDiagonals[0].equals(selectionDiagonals[1])) {
				Rectangle selection = new Rectangle();
				selection.setFrameFromDiagonal(selectionDiagonals[0],
						selectionDiagonals[1]);
				g.drawRect(selection.x, selection.y, selection.width,
						selection.height);
			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Rectangle old = new Rectangle();
		old.setFrameFromDiagonal(selectionDiagonals[0], selectionDiagonals[1]);
		RepaintManager.currentManager(this).addDirtyRegion(this, old.x, old.y,
				old.width + 1, old.height + 1);
		selectionDiagonals[0].x = e.getX();
		selectionDiagonals[0].y = e.getY();
		selectionDiagonals[1].x = selectionDiagonals[0].x;
		selectionDiagonals[1].y = selectionDiagonals[0].y;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Rectangle clip = new Rectangle();
		clip.setFrameFromDiagonal(selectionDiagonals[0], selectionDiagonals[1]);
		RepaintManager.currentManager(this).addDirtyRegion(this, clip.x,
				clip.y, clip.width + 1, clip.height + 1);
		selectionDiagonals[1].x = e.getX();
		selectionDiagonals[1].y = e.getY();
		clip.setFrameFromDiagonal(selectionDiagonals[0], selectionDiagonals[1]);
		RepaintManager.currentManager(this).addDirtyRegion(this, clip.x,
				clip.y, clip.width + 1, clip.height + 1);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
