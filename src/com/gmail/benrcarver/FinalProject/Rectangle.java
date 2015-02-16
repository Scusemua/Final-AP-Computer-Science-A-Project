package com.gmail.benrcarver.FinalProject;

/*
 * author: Ben Carver
 * period 5 AP Computer Science
 */

import java.awt.*;

public class Rectangle extends Shape {
	
	public Rectangle(Color c, int x, int y, int w, int h, boolean b, BasicStroke stroke) {
		super(c, x, y, w, h, b, stroke);
	}
	
	public Rectangle() {
		
	}

	public void draw(Graphics2D g) {
		super.draw();
		System.out.println("Width: " + getWidth());
		if(!super.verify()) return;
		g.setStroke(getStroke());
		g.setColor(getColor());
		g.drawRect(getXCord(), getYCord(), super.getWidth(), super.getHeight());
		if(getFilled()) {
			g.fillRect(getXCord(), getYCord(), super.getWidth(), super.getHeight());	
		}
	}
}
