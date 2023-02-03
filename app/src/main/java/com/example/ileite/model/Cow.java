package com.example.ileite.model;

import java.time.LocalDate;

public class Cow {

    private long id;
    private String name;
    private int isHeifer;
    private int age;
    private double amountMilk;
    private double weight;
    private LocalDate registerDate;

    public Cow(String name, int isHeifer, int age, double amountMilk, double weight, LocalDate registerDate) {
        this.name = name;
        this.isHeifer = isHeifer;
        this.age = age;
        this.amountMilk = amountMilk;
        this.weight = weight;
        this.registerDate = registerDate;
    }

    public Cow(Long id, String name, int isHeifer, int age, double amountMilk, double weight, LocalDate registerDate) {
        this.id = id;
        this.name = name;
        this.isHeifer = isHeifer;
        this.age = age;
        this.amountMilk = amountMilk;
        this.weight = weight;
        this.registerDate = registerDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsHeifer() {
        return isHeifer;
    }

    public void setIsHeifer(int isHeifer) {
        this.isHeifer = isHeifer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAmountMilk() {
        return amountMilk;
    }

    public void setAmountMilk(double amountMilk) {
        this.amountMilk = amountMilk;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }
}
