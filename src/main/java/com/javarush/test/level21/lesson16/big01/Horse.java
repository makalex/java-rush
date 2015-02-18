package com.javarush.test.level21.lesson16.big01;

/**
 * Created by MakarytskyiO on 18.02.2015.
 */
public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (int)distance; i++) {
            sb.append(".");
        }
        sb.append(name);
        System.out.println(sb.toString());
    }

}
