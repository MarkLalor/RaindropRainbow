package com.marklalor.simulation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import com.marklalor.javasim.simulation.Simulation;
import com.marklalor.javasim.simulation.SimulationInfo;

public class RaindropRainbow extends Simulation
{
	private Raindrop raindrop;
	private Map<Integer, List<Ray>> lightBundles;
	
	public RaindropRainbow(SimulationInfo info)
	{
		super(info);
	}

	@Override
	public void initialize()
	{
		getImage().setDraggable(true);
		getImage().setVisible(true);
		getImage().setSize(700, 700);
		getImage().setLocationRelativeTo(null);
		getImage().setExtendedState(getImage().getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	Point min, max;
	
	@Override
	public void reset(Graphics2D permanent)
	{
		//Draw white background.
		permanent.setColor(Color.WHITE);
		permanent.fillRect(0, 0, getWidth(), getHeight());
	
		//Transform to a typical Cartesian coordinate system.
		permanent.translate(Math.round(getWidth() * Raindrop.PERCENT_ORIGIN), Math.round((getHeight() * (1-Raindrop.PERCENT_ORIGIN)))-2);
		permanent.scale(1d, -1d);
		
		//Calculate the bounds of the coordinate system.
		min = new Point();
		min.x = (int) Math.round(-getWidth() * Raindrop.PERCENT_ORIGIN);
		min.y = (int) Math.round(-getHeight() * Raindrop.PERCENT_ORIGIN) - 1;
		
		max = new Point();
		max.x = min.x + getWidth() - 1;
		max.y = min.y + getHeight() - 1;
		
		//Create a raindrop object
		raindrop = new Raindrop(0, 0, getWidth(), getHeight());
		raindrop.draw(permanent);


		final int raysInBundle = 35;
		lightBundles = new HashMap<Integer, List<Ray>>();
		for (int i = raindrop.getOrigin().y - raindrop.getRadius(); i <= raindrop.getOrigin().y + raindrop.getRadius(); i++)
		{
			List<Ray> bundle = new ArrayList<Ray>(raysInBundle);
			for (int j = 0; j < raysInBundle; j++)
				bundle.add(new Ray((VisibleSpectrum.VISIBLE_RANGE/raysInBundle) * j + VisibleSpectrum.VISIBLE_MIN));
			lightBundles.put(i, bundle);
		}
		
		drawMainRays(permanent);
	}
	
	
	private void drawMainRays(Graphics2D permanent)
	{
		int rainbowMinY = Integer.MAX_VALUE, rainbowMaxY = Integer.MIN_VALUE;
		
		for (Integer y : lightBundles.keySet())
		{
			if (y > 40)
			{
				//Draw bundle
				permanent.setColor(new Color(0.1f, 0.1f, 0.1f, 0.09f));
				double x = Math.round(Math.sqrt(Math.pow(raindrop.getRadius(), 2) - Math.pow(y, 2)));
				permanent.drawLine(min.x, y, (int)-x, y);
				
				//Just avoid any division by 0…
				if (x == 0)
					continue;

				//Calculate angle of incidence using the location on the circle struck by the bundle of rays. 
				double i = Math.atan(((double)y)/x);
				
				//Go through each of the constituent rays.
				List<Ray> bundle = lightBundles.get(y);
				for (Ray ray : bundle)
				{
					double r = Math.asin((1d/ray.getRefractiveIndex()) * Math.sin(i));
					
					permanent.setColor(ray.getColor(0.04f));
					
					//Calculate angle on the circle after the first refraction event.
					double theta1 = 2*r - i; //solved for geometrically.
					Point2D.Double point1 = getPointOnCircle(theta1);
					permanent.drawLine((int) -x, y, (int)point1.x, (int)point1.y);
					
					//Calculate angle on the circle after the reflection event.
					double theta2 =  theta1 - (Math.PI - (2*r)); //solved for geometrically.
					Point2D.Double point2 = getPointOnCircle(theta2);
					permanent.drawLine((int)point1.x, (int)point1.y, (int)point2.x, (int)point2.y);
					
					
					//Calculate the final angle after the second refraction event.
					double theta3 = theta2 - (2*r); //solved for geometrically
					double m = Math.tan(theta3); //slope of the resulting line

					//Use the fact that tangent = dy/dx to calculate the endpoint.
					int dy = (int)(m * (point2.x - min.x));
					Point2D.Double point3 = new Point2D.Double(min.x, point2.y - dy);
					permanent.drawLine((int)point2.x, (int)point2.y, (int)point3.x, (int)point3.y);
					
					//Keep track of the highest and lowest beams.
					rainbowMinY = Math.min((int)point3.y, rainbowMinY);
					rainbowMaxY = Math.max((int)point3.y, rainbowMaxY);
				}
			}
		}
		
		//Rough utility to zoom in on the rainbow part: 
		final AffineTransform transform = permanent.getTransform();
		double percentToShow = 0.065;
		int numberToShow = (int) (percentToShow * Math.abs(rainbowMinY - rainbowMaxY));
		int count = 0;
		int height = (int) ((getHeight() * 0.5) / numberToShow);
		
		for (int y = rainbowMinY; y <= rainbowMaxY; y++)
		{
            Point2D screenPoint = transform.transform(new Point2D.Double(min.x, y), new Point2D.Double());
			Color color = new Color(getImage().getSimulation().getPermanentImage().getRGB((int)screenPoint.getX(), (int)screenPoint.getY()));
			permanent.setColor(color);
			int width = (int)(getWidth() * 0.2);
			permanent.fillRect(-width + raindrop.getRadius(), min.y + height*count, width, height);
			count++;
			if (count == numberToShow)
				break;
		}
	}

	private Point2D.Double getPointOnCircle(double theta)
	{
		double x = raindrop.getRadius() * Math.cos(theta);
		double y = raindrop.getRadius() * Math.sin(theta);
		return new Point2D.Double(x, y);
	}
	
	
	@Override
	public void draw(Graphics2D permanent, Graphics2D temporary)
	{
		
	}

	@Override
	public void click(Point point)
	{
		
	}
}