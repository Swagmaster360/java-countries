package com.lambdaschool.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {

    private static final AtomicLong counter = new AtomicLong();

    private int id;
    private String name;
    private int population;
    private int size;
    private int medianAge;

    public Country(String name, int population, int size, int medianAge) {

        this.id = (int) counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.size = size;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

    @Override
    public String toString() {
        return "country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", size=" + size +
                ", medianAge=" + medianAge +
                '}';
    }
}
