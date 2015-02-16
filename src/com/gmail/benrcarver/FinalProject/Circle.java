package com.gmail.benrcarver.FinalProject;

/*
 * author: Ben Carver
 * period 5 AP Computer Science
 */

import java.awt.*;

public class Circle extends Shape {
	
	public Circle(Color c, int x, int y, int w, int h, boolean b, BasicStroke stroke) {
		super(c, x, y, w, h, b, stroke);
	}

	public void draw(Graphics2D g) {
		super.draw();
		System.out.println("Width: " + getWidth());
		if(!super.verify()) return;
		g.setStroke(getStroke());
		g.setColor(getColor());
		g.drawOval(getXCord(), getYCord(), super.getWidth(), super.getHeight());
		if(getFilled()) {
			g.fillOval(getXCord(), getYCord(), super.getWidth(), super.getHeight());	
		}
	}
}
