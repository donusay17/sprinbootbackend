package com.example.sprinbootbackend.model;



import javax.persistence.*;

import static com.example.sprinbootbackend.constants.Constants.*;
import static com.example.sprinbootbackend.constants.Constants.BMI_OBESITY_CLASS_THREE;

@Entity
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;


    @Column(name="height")
    private double height;


    @Column(name= "weight")
    private double weight;



    @Column(name = "bmi")
    private double bmi;

    public Tutorial() {

    }

    public Tutorial(String title, String description, boolean published,double weight, double height) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.weight= weight;
        this.height= height;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getBmi() {
        double bmi = this.weight / Math.pow((this.height / 100), 2);

        return Math.round(bmi * 10) / 10.0;

    }

    public String calculateBmi(double bmi) {

        if (this.bmi < 19) {
            return BMI_UNDERWEIGHT;
        }

        if (this.bmi >= 19 && this.bmi < 25) {
            return BMI_NORMAL;
        }

        if (this.bmi >= 25 && this.bmi < 30) {
            return BMI_OVERWEIGHT;
        }

        if (this.bmi >= 30 && this.bmi < 35) {
            return BMI_OBESITY_CLASS_ONE;
        }

        if (this.bmi >= 35 && this.bmi < 40) {
            return BMI_OBESITY_CLASS_TWO;
        }

        return BMI_OBESITY_CLASS_THREE;
    }


    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + ",height="+ height + ",weight=" + weight + ",bmi=" + bmi+  "]";
    }

}