package com.epam.geometry.model;

import java.util.Objects;

// TODO: This is a placeholder, name this class according to your task
public class Triangle {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public Triangle(double[] coordinates) {
        this.x1 = coordinates[0];
        this.y1 = coordinates[1];
        this.x2 = coordinates[2];
        this.y2 = coordinates[3];
        this.x3 = coordinates[4];
        this.y3 = coordinates[5];

    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;

        return Double.compare(triangle.getX1(), getX1()) == 0 &&
                Double.compare(triangle.getY1(), getY1()) == 0 &&
                Double.compare(triangle.getX2(), getX2()) == 0 &&
                Double.compare(triangle.getY2(), getY2()) == 0 &&
                Double.compare(triangle.getX3(), getX3()) == 0 &&
                Double.compare(triangle.getY3(), getY3()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX1(), getY1(), getX2(), getY2(), getX3(), getY3());
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                '}';
    }
}
