package nus.iss.ws22prac01.model;

import org.bson.Document;


import jakarta.json.Json;
import jakarta.json.JsonObject;

public class PersonalData {
    private int age;
    private String gender;
    private int weight;
    private int weight_goal;
    private int period_weeks;
    private int height;
    private String diet;
    private int workout_per_wk;
    private int duration;
    private String user_email;

    public static PersonalData fromMongoDocument(Document doc) {
        PersonalData pd = new PersonalData();
        pd.setAge(doc.getInteger("age"));
        pd.setGender(doc.getString("gender"));
        pd.setWeight(doc.getInteger("weight"));
        pd.setWeight_goal(doc.getInteger("weight_goal"));
        pd.setPeriod_weeks(doc.getInteger("period_weeks"));
        pd.setHeight(doc.getInteger("height"));
        pd.setDiet(doc.getString("diet"));
        pd.setWorkout_per_wk(doc.getInteger("workout_per_wk"));
        pd.setDuration(doc.getInteger("duration"));
        return pd;
    }

    public JsonObject toJsonLong() {
        return Json.createObjectBuilder()
                .add("age", this.getAge())
                .add("gender", this.getGender())
                .add("weight", this.getWeight())
                .add("weight_goal", this.getWeight_goal())
                .add("period_weeks", this.getPeriod_weeks())
                .add("height", this.getHeight())
                .add("diet", this.getDiet())
                .add("workout_per_wk", this.getWorkout_per_wk())
                .add("duration", this.getDuration())
                .build();
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight_goal() {
        return weight_goal;
    }
    public void setWeight_goal(int weight_goal) {
        this.weight_goal = weight_goal;
    }
    public int getPeriod_weeks() {
        return period_weeks;
    }
    public void setPeriod_weeks(int period_weeks) {
        this.period_weeks = period_weeks;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getDiet() {
        return diet;
    }
    public void setDiet(String diet) {
        this.diet = diet;
    }
    public int getWorkout_per_wk() {
        return workout_per_wk;
    }
    public void setWorkout_per_wk(int workout_per_wk) {
        this.workout_per_wk = workout_per_wk;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }   
 
}
