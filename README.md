# Table of Contents
1. [Overview](#overview)
2. [Example](#example)
3. [Install](#install)
4. [Download](#download)

# Raindrop Rainbow

A [JavaSim](http://github.com/MarkLalor/JavaSim) simulation demonstrating how light is refracted and reflected by raindrops to form the optical phenomenon we all know and love: the [rainbow](https://en.wikipedia.org/wiki/Rainbow).

---------------------------------------

## Overview

When sunlight passes through raindrops, the total angle change after [refracting](https://en.wikipedia.org/wiki/Refraction), [reflecting](https://en.wikipedia.org/wiki/Specular_reflection), and [dispersing](https://en.wikipedia.org/wiki/Dispersion_(optics)) stops at a certain limit dependent on the wavelength of light.

For each ray of sunlight, it strikes the raindrop with an [angle of incidence](https://en.wikipedia.org/wiki/Angle_of_incidence), ![i](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation7.png).

According to [Snell's law](https://en.wikipedia.org/wiki/Snell%27s_law), when changing mediums from air to water or water to air, an angle of refraction ![r](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation8.png) can be calculated:

![Snell's Law](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation1.png)

where ![Refractive Index](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation2.png) is the [refractive index](https://en.wikipedia.org/wiki/Refractive_index), the ratio of the speed of light to the [phase velocity](https://en.wikipedia.org/wiki/Phase_velocity) of light in the medium.

Solving the geometry of the problem, we can see that the total deflection angle, ![Theta Total](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation3.png), can be represented as a function of ![i](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation7.png) and ![r](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation8.png):

![Equation 1](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation4.png)

or, solving for ![r](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation8.png), simply as a function of ![i](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation7.png):

![Equation 2](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation5.png)

For a certain refractive index ![r](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation8.png) (about 1.3 in this case), the [graph](http://www.wolframalpha.com/input/?i=180+%2B+2i+-+4+*+arcsin%28%281%2F1.3391552594844285%29+*+sin%28i%29%29+from+0+to+90+degrees&a=i_Variable) from angles 0&deg; to 90&deg; looks like so:

![Graph 1](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowGraph1.gif)

This angle where ![Theta = 0](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation6.png) varies slightly as ![Refractive Index](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation2.png) changes ([see this empirical data](http://refractiveindex.info/?shelf=main&book=H2O&page=Hale)), causing bundles of certain wavelengths to group up at certain angles, generating the rainbow as a result of [dispersion](https://en.wikipedia.org/wiki/Dispersion_(optics)).

## Example

The current output of the simulation:

![Example](https://github.com/MarkLalor/RaindropRainbow/blob/master/example.png?raw=true)

A zoomed in version of the bottom 6.5% of the outputted rays is visible in the bottom right.

## Install

RaindropRainbow is a [JavaSim](http://github.com/MarkLalor/JavaSim) simulation. After installing JavaSim, place [RaindropRainbow.jar](#download) into the JavaSim folder (located in your Documents folder by default).

## Download

### [Latest Release](http://marklalor.com/downloads/RaindropRainbow/RaindropRainbow.jar)

### [Latest Build](https://github.com/MarkLalor/RaindropRainbow/raw/master/dist/RaindropRainbow.jar)