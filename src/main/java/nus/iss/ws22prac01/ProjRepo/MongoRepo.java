package nus.iss.ws22prac01.ProjRepo;


import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.UpdateResult;

import jakarta.json.JsonObject;
import jakarta.transaction.Transactional;
import nus.iss.ws22prac01.Utils.Utils;
import nus.iss.ws22prac01.model.PersonalData;

@Repository
@Transactional
public class MongoRepo {
    
    @Autowired
    MongoTemplate mongoTemplate;

    public void upsertData(Document doc) {

        Criteria criteria = Criteria.where("user_email").is(doc.getString("user_email"));
        
        Query query = Query.query(criteria);
            
        Update updateOps = new Update()
        .set("age", doc.getInteger("age"))
        .set("gender", doc.getString("gender"))
        .set("weight", doc.getInteger("weight"))
        .set("weight_goal", doc.getInteger("weight_goal"))
        .set("period_weeks", doc.getInteger("period_weeks"))
        .set("height", doc.getInteger("height"))
        .set("diet",doc.getString("diet"))
        .set("workout_per_wk", doc.getInteger("workout_per_wk"))
        .set("duration", doc.getInteger("duration"));

        UpdateResult updateResult = mongoTemplate.upsert(query, updateOps, "data");

        System.out.println("document updated: " + updateResult.getModifiedCount());

    }

    public JsonObject getData(String user_email) {
        // db.comments.find({id: '12345678'}).sort({timestamp: -1}).limit(10);

        Criteria criteria = Criteria.where("user_email").is(user_email);

        Query query = Query.query(criteria);

        Document docs = mongoTemplate.findOne(query, Document.class, "data");

        PersonalData data = PersonalData.fromMongoDocument(docs);
        JsonObject json = data.toJsonLong();

        // List<PersonalData> data = docs.stream().map(x -> Utils.toComment(x)).toList();

        System.out.println("data>>>>>>>>>" + data);
        return json;
    }
}
