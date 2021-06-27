package com.epam.geometry.logic;

import com.epam.geometry.model.Triangle;

// TODO: make this name more specific (according to your task)
public class Logic {
    private static final double DELTA = 1e-15;

    double calculateSquare(Triangle triangle) {
        return (triangle.getX1() * (triangle.getY2() - triangle.getY3()) + triangle.getX2() * (triangle.getY3() - triangle.getY1()) +
                triangle.getX3() * (triangle.getY1() - triangle.getY2())) / 2;
    }

    boolean checkRight(Triangle triangle) {
        double a1 = (triangle.getX1() - triangle.getX2()) * (triangle.getX1() - triangle.getX2()) +
                (triangle.getY1() - triangle.getY2()) * (triangle.getY1() - triangle.getY2());
        double a2 = (triangle.getX3() - triangle.getX2()) * (triangle.getX3() - triangle.getX2()) +
                (triangle.getY3() - triangle.getY2()) * (triangle.getY3() - triangle.getY2());
        double a3 = (triangle.getX1() - triangle.getX3()) * (triangle.getX1() - triangle.getX3()) +
                (triangle.getY1() - triangle.getY3()) * (triangle.getY1() - triangle.getY3());

        if ((Math.abs(a1 + a2 - a3) < DELTA) || (Math.abs(a2 + a3 - a1) < DELTA) || (Math.abs(a1 + a3 - a2) < DELTA)) {
            return true;
        }
        return false;
    }
}