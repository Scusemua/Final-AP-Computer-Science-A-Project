package com.gmail.benrcarver.FinalProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Lansana extends Stamp {
	BufferedImage image;
	
	public Lansana() {
		try {
			image = ImageIO.read(new File("resources\\lans.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(int x, int y, Graphics g) {
		System.out.println("Lansana Draw Method!");
		Graphics gg = image.getGraphics();
		gg.drawImage(image, x, y, null);
		gg.finalize();
	}
	
}
