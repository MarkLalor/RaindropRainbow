package com.marklalor.simulation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;

public class Raindrop
{
	public static final Color COLOR_OUTLINE = new Color(200, 200, 225); 
	public static final Color COLOR_FILL_IN = new Color(240, 240, 250);
	public static final Color COLOR_FILL_OUT = new Color(230, 230, 250); 
	public static final Color COLOR_FILL_CENTER = new Color(220, 225, 240);
	
	public static final double PERCENT_SIZE = 0.25d; // percent of screen
	public static final double PERCENT_ORIGIN = 0.85d;
	
	private Point origin;
	private int radius;
	
	private Ellipse2D.Double circle;
	
	public Raindrop(int x, int y, int width, int height)
	{
		this.radius = (int) ((Math.min(width, height) * PERCENT_SIZE) / 2);
		this.origin = new Point(x, y);
		this.circle = new Ellipse2D.Double(origin.x - radius, origin.y - radius, radius * 2, radius * 2);
	}
	
	public void draw(Graphics2D permanent)
	{
		permanent.setPaint(new RadialGradientPaint(origin, radius, new float[]{0.2f, 0.8f}, new Color[]{COLOR_FILL_IN, COLOR_FILL_OUT}));
		permanent.fill(circle);
		permanent.setPaint(COLOR_OUTLINE);
		permanent.draw(circle);
		
		
//		permanent.setColor(COLOR_FILL_CENTER);
//		double centerCircleRadius = (int) (0.04 * radius);
//		permanent.fillOval((int)(origin.x - centerCircleRadius), (int)(origin.y - centerCircleRadius), (int)(centerCircleRadius * 2), (int)(centerCircleRadius * 2));
	}
	
	public Point getOrigin()
	{
		return origin;
	}
	
	public int getRadius()
	{
		return radius;
	}
}
