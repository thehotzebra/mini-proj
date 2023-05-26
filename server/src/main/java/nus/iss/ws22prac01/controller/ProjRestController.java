package nus.iss.ws22prac01.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import nus.iss.ws22prac01.model.Items;
import nus.iss.ws22prac01.model.Summary;
import nus.iss.ws22prac01.model.View1;
import nus.iss.ws22prac01.ProjRepo.ProjRepo;
import nus.iss.ws22prac01.model.Entry;

@RestController
@RequestMapping("/api")
public class ProjRestController {
    
    @Autowired
    ProjRepo ProjRepo;

    @GetMapping("/items")
    public ResponseEntity<String> getItems(@RequestParam String start_date, String end_date, String user_email,
                                            @RequestParam(defaultValue="20") Integer limit,
                                            @RequestParam(defaultValue="0") Integer offset) {

        List<View1> items = ProjRepo.getAllItems(start_date, end_date, user_email, limit, offset);
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
    
        for (View1 item : items) {
            arrBuilder.add(item.toJsonObject());
        }

    return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(arrBuilder.build().toString());

    }

    @GetMapping("/itemsum")
    public ResponseEntity<String> getItemsum(@RequestParam String start_date,@RequestParam String end_date,@RequestParam String user_email) {


        String paywave_total = ProjRepo.getSum(start_date, end_date, user_email);
        System.out.println(paywave_total);
    return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(paywave_total);

    }

    @PostMapping(path="/new02", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createEntry(@RequestBody Entry entry) {
        // Process the payment object and save it to the database
        
        try {
            ProjRepo.saveEntry(entry);
            System.out.println("entry >>>>" + entry);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save entry.");
            }
    }

    @DeleteMapping(path="/delete/{user_email}/{idx}")
    public ResponseEntity<String> deleteItem(@PathVariable String user_email, @PathVariable Long idx) {

        System.out.println("HELLO>>>" + idx + user_email);
        ProjRepo.deleteItem(user_email, idx);

        return new ResponseEntity<String>("Expense is deleted successfully.!", HttpStatus.OK);
    }

    // @PostMapping(path="/delete", consumes=MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<String> deleteItem1(@RequestParam String user_email, @RequestParam Long idx) {

    //     System.out.println("HELLO>>>" + idx + user_email);
    //     ProjRepo.deleteItem(user_email, idx);

    //     return new ResponseEntity<String>("Expense is deleted successfully.!", HttpStatus.OK);
    // }

}

