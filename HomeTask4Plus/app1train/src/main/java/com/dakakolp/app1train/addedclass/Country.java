package com.dakakolp.app1train.addedclass;

public class Country {

    private String name;
    private String capital;
    private double population;
    private int flag;

    public Country(int flag, String name, String capital, double population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.flag = flag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
