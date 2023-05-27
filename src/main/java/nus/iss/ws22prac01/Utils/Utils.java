package nus.iss.ws22prac01.Utils;

import java.io.StringReader;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import nus.iss.ws22prac01.model.PersonalData;

public class Utils {

    public static JsonObject toJson(String json) {
        JsonReader jsonReader = Json.createReader(new StringReader(json));
        JsonObject data = jsonReader.readObject();
        jsonReader.close();
        return data;
    }
    

    public static PersonalData toComment(Document doc) {
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

    public static JsonObject toJson(PersonalData pd) {
        return Json.createObjectBuilder()
                .add("age", pd.getAge())
                .add("gender", pd.getGender())
                .add("weight", pd.getWeight())
                .add("weight_goal", pd.getWeight_goal())
                .add("period_weeks", pd.getPeriod_weeks())
                .add("height", pd.getHeight())
                .add("diet", pd.getDiet())
                .add("workout_per_wk", pd.getWorkout_per_wk())
                .add("duration", pd.getDuration())
                .build();
    }

}
