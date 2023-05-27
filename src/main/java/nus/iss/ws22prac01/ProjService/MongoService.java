package nus.iss.ws22prac01.ProjService;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import nus.iss.ws22prac01.ProjRepo.MongoRepo;
import nus.iss.ws22prac01.Utils.Utils;
import nus.iss.ws22prac01.model.PersonalData;

@Service
public class MongoService {
    
    @Autowired
    MongoRepo mongoRepo;

    public void insertData(Document doc) {

        // mongoRepo.insertData(Utils.toDocument(pd));

        return;
    }
}
