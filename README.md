# Table of Contents
1. [Overview](#overview)
2. [Example](#example)
3. [Download](#download)

# Raindrop Rainbow

A [JavaSim](http://github.com/MarkLalor/JavaSim) simulation demonstrating how light is refracted and reflected by raindrops to form the optical phenomenon we all know and love: the rainbow.

---------------------------------------

## Overview

When sunlight passes through raindrops, the total angle change after entering, deflecting, and then leaving stops at a certain limit dependant on the wavelength of light.

For each ray of sunlight, it strikes the raindrop with an angle of incidence, _i_.

According to Snells law, when changing mediums from air to water or water to air, an angle of refraction _r_ can be calculated using Snell's law:

![Snell's Law](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation1.png)

where ![Refractive Index](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation2.png) is the [refractive index](https://en.wikipedia.org/wiki/Refractive_index), the ratio of the speed of light to the [phase velocity](https://en.wikipedia.org/wiki/Phase_velocity) of light in the medium.

Solving the geometry of the problem, we can see that the total deflection angle, ![Theta Total](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation3.png), can be represented as a function of _i_ and _r_:

![Equation 1](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation4.png)

or, solving for _r_, simply as a function of _i_:

![Equation 2](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation5.png)

For a certain refractive index (~4/3 in this case), the [graph](http://www.wolframalpha.com/input/?i=180+%2B+2i+-+4+*+arcsin%28%281%2F1.3391552594844285%29+*+sin%28i%29%29+from+0+to+90+degrees&a=i_Variable) from angles 0 to 90 degrees looks like so:

![Graph 1](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowGraph1.gif)

This angle where ![Theta = 0](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation6.png) varies slightly ([see this empirical data](http://refractiveindex.info/?shelf=main&book=H2O&page=Hale)) as ![Refractive Index](http://marklalor.com/wp-content/uploads/2015/08/RaindropRainbowEquation2.png) changes, causing bundles of certain wavelengths to group up at certain angles, generating the rainbow.


## Example

The current output of the simulation:

![Example](https://github.com/MarkLalor/RaindropRainbow/blob/master/example.png?raw=true)

A zoomed in version of the bottom 6.5% of the outputted rays is visible in the bottom left.

## Download

### [Latest Release](http://marklalor.com/downloads/RaindropRainbow/RaindropRainbow.jar)

### [Latest Build](https://github.com/MarkLalor/RaindropRainbow/raw/master/dist/RaindropRainbow.jar)