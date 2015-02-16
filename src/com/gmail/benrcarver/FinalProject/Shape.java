package com.gmail.benrcarver.FinalProject;

/*
 * author: Ben Carver
 * period 5 AP Computer Science
 */

import java.awt.*;
import java.util.ArrayList;

public abstract class Shape {
	private Color color;
	
	private static final int MAX_X = 745;
	private static final int MIN_X = 17;
	private static final int MAX_Y = 725;
	private static final int MIN_Y = 58;
	
	//I made shapes static so I can do shapes.add(this) in the constructor
	
	private int xCord;
	private int yCord;
	private int width;
	private int height;
	
	private BasicStroke stroke;
	
	private boolean filled;
	
	public Shape() {
		color = Color.BLACK;
		xCord = 0;
		yCord = 0;
	}

	public Shape(Color c, int x, int y, int w, int h, boolean b, BasicStroke stroke) {
		color = c;
		xCord = x;
		yCord = y;
		width = w;
		height = h;
		filled = b;
		this.stroke = stroke;
		Canvas.getShapes().add(this);
	}
	public Color getColor() {
		return color;
	}

	public void setColor(Color c) {
		color = c;
	}
	
	public int getXCord() {
		return xCord;
	}
	
	public int getYCord() {
		return yCord;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public boolean getFilled() {
		return filled;
	}
	
	public BasicStroke getStroke() {
		return stroke;
	}
	
	public void draw() {
		truncateShape();
	}
	
	public boolean verify() {
		if(xCord <= MIN_X || xCord >= MAX_X) {
			return false;
		}
		if(yCord <= MIN_Y || yCord >= MAX_Y) {
			return false;
		}
		return true;
	}
	
	public void truncateShape() {
		if(xCord + width > MAX_X) {
			System.out.println("***\n");
			System.out.println(xCord + " + " + width + " = " + (xCord + width));
			int difference = (xCord + width) - MAX_X;
			width -= difference;
			System.out.println("Difference: " + difference + ", New width: " + width);
			System.out.println("***\n");
		}
		if(yCord + height > MAX_Y) {
			int difference = (yCord + height) - MAX_Y;
			height -= difference;
		}
	}
}
