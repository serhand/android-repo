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

public class SelectableLegendImage extends JComponent implements MouseListener, MouseMotionListener {
	private BufferedImage legendImage = null;
	private Rectangle selectionRect = new Rectangle();
	private Point pointOfClick = new Point();
	private Point pointOfDrag = new Point();

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
		if (legendImage != null){
			Rectangle clipRect = g.getClipBounds();
			final int x1 = clipRect.x;
			final int y1 = clipRect.y;
			final int x2 = x1 + clipRect.width;
			final int y2 = y1 + clipRect.height;
			g.drawImage(legendImage,x1,y1,x2,y2,x1,y1,x2,y2,null);
			Rectangle selection = new Rectangle(pointOfClick);
			selection.add(pointOfDrag);
			g.drawRect(selection.x, selection.y, selection.width, selection.height);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pointOfClick.x = e.getX();
		pointOfClick.y = e.getY();
		System.out.println("clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("released");
		pointOfDrag.x = e.getX();
		pointOfDrag.y = e.getY();
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

	@Override
	public void mouseDragged(MouseEvent e) {
		pointOfDrag.x = e.getX();
		pointOfDrag.y = e.getY();
		Rectangle clip = new Rectangle(pointOfClick);
		clip.add(pointOfDrag);
		repaint();
		//RepaintManager.currentManager(this).addDirtyRegion(this, clip.x, clip.y, clip.width, clip.height);
		System.out.println("dragged " + e.getX() + " " + e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
}
