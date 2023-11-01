package ru.great_larder.sportquiz.services;

import android.view.animation.Interpolator;

public class MyBounceInterpolator implements Interpolator {
    private double mAmplitude = 1;
    private double mFrequency = 10;
    public MyBounceInterpolator(double amplitude, double frequency) {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }
    @Override
    public float getInterpolation(float input) {
        return (float) (-1 * Math.pow(Math.E, -input/ mAmplitude) *
                Math.cos(mFrequency * input) + 1);
    }
}
