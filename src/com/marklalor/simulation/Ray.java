package com.marklalor.simulation;

public class Ray
{
	private double wavelength;

	public Ray(double wavelength)
	{
		this.wavelength = wavelength;
	}
	
	public double getWavelength()
	{
		return wavelength;
	}
	
	public double getRefractiveIndex()
	{
		return refractiveIndexFromWavelength(wavelength);
	}
	
	public java.awt.Color getColor()
	{
		return VisibleSpectrum.colorFromWavelength(wavelength);
	}
	
	public java.awt.Color getColor(float alpha)
	{
		java.awt.Color color = getColor();
		return new java.awt.Color(color.getRed()/255f, color.getGreen()/255f, color.getBlue()/255f, alpha);
	}
	
	/**
	 * Estimates the refractive index of light in water for a varaible wavelength using
	 * a quadratic-fit equation:
	 * <br/>
	 * <code><b>n = 0.0000000813186813λ^2 - 0.0001175714286λ + 1.373375275</b></code>
	 * <br/>
	 * <br/>
	 * Data source: <a href = "http://refractiveindex.info/?shelf=main&book=H2O&page=Hale">http://refractiveindex.info/?shelf=main&book=H2O&page=Hale</a>
	 * 
	 * @param nanometers Wavelength in nanometers to approximate the refractive index of in water.
	 * @return The unitless, refractive index constant for the specified wavelength.
	 */
	public static double refractiveIndexFromWavelength(double wavelength)
	{
		return 0.0000000813186813*Math.pow(wavelength, 2d) - 0.0001175714286*wavelength + 1.373375275;
	}
}
