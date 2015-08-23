package com.marklalor.simulation;

import java.awt.Color;

public class VisibleSpectrum
{
	//Visible spectrum constants, in nanometers.
	public static final double VISIBLE_MIN = 390d;
	public static final double VISIBLE_MAX = 700d;
	public static final double VISIBLE_RANGE = VISIBLE_MAX - VISIBLE_MIN;
	
	//Constants 
	public static final double GAMMA = 0.80d;
	public static final double MAX = 255d;
	
	/**
	 * Taken from Earl F. Glynn's web page: <a href = "http://www.efg2.com/Lab/ScienceAndEngineering/Spectra.htm">Spectra Lab Report</a>
	 * <br/>
	 * Translated from Pascal by <a href = "http://stackoverflow.com/users/1254880/tarc">Tarc</a> on
	 * <a href = "http://stackoverflow.com/questions/1472514/convert-light-frequency-to-rgb">Stack Overflow</a>
	 * */
	public static Color colorFromWavelength(double wavelength)
	{
		double red, green, blue;
		
		if((wavelength >= 380) && (wavelength < 440))
		{
			red = -(wavelength - 440) / (440 - 380);
			green = 0.0;
			blue = 1.0;
		}
		else if((wavelength >= 440) && (wavelength < 490))
		{
			red = 0.0;
			green = (wavelength - 440) / (490 - 440);
			blue = 1.0;
		}
		else if((wavelength >= 490) && (wavelength < 510))
		{
			red = 0.0;
			green = 1.0;
			blue = -(wavelength - 510) / (510 - 490);
		}
		else if((wavelength >= 510) && (wavelength < 580))
		{
			red = (wavelength - 510) / (580 - 510);
			green = 1.0;
			blue = 0.0;
		}
		else if((wavelength >= 580) && (wavelength < 645))
		{
			red = 1.0;
			green = -(wavelength - 645) / (645 - 580);
			blue = 0.0;
		}
		else if((wavelength >= 645) && (wavelength < 781))
		{
			red = 1.0;
			green = 0.0;
			blue = 0.0;
		}
		else
		{
			red = 0.0;
			green = 0.0;
			blue = 0.0;
		}
		

		double factor;
		
		// Let the intensity fall off near the vision limits
		
		if((wavelength >= 380) && (wavelength < 420))
		{
			factor = 0.3 + 0.7 * (wavelength - 380) / (420 - 380);
		}
		else if((wavelength >= 420) && (wavelength < 701))
		{
			factor = 1.0;
		}
		else if((wavelength >= 701) && (wavelength < 781))
		{
			factor = 0.3 + 0.7 * (780 - wavelength) / (780 - 700);
		}
		else
		{
			factor = 0.0;
		}
		
		
		int[] rgb = new int[3];
		
		// Don't want 0^x = 1 for x <> 0
		rgb[0] = red == 0.0 ? 0 : (int) Math.round(MAX * Math.pow(red * factor, GAMMA));
		rgb[1] = green == 0.0 ? 0 : (int) Math.round(MAX * Math.pow(green * factor, GAMMA));
		rgb[2] = blue == 0.0 ? 0 : (int) Math.round(MAX * Math.pow(blue * factor, GAMMA));
		
		return new Color(rgb[0], rgb[1], rgb[2]);
	}
	
	//	To compare the Color.colorFromWavelength function with a standard HSB distribution.
	//	@Override
	//	public void draw(Graphics2D permanent, Graphics2D temporary)
	//	{
	//		double wavelength = LightColor.VISIBLE_MIN;
	//		for (int x = 0; x < getWidth(); x++)
	//		{
	//			permanent.setColor(getN() % 2 == 0 ? LightColor.colorFromWavelength(wavelength) : new Color(Color.HSBtoRGB(1f-((float)x/getWidth()), 1.0f, 0.8f)));
	//			permanent.drawLine(x, 0, x, getHeight());
	//			wavelength += LightColor.VISIBLE_RANGE / getWidth();
	//		}
	//	}
}
