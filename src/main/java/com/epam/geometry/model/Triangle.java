package com.epam.geometry.model;

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


}
