package nus.iss.ws22prac01.Configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

    // Inject the mongo connection string
		// @Value assigns the string to mongoUrl

    @Value("${spring.data.mongodb.url}")
    private String mongoUrl;

		@Value("${spring.data.mongodb.database}")
		private String dbName;

    // Create and initialize MongoTemplate
    @Bean
    public MongoTemplate createMongoTemplate() {
        // Create a MongoClient with the mongo connection string
        MongoClient client = MongoClients.create(mongoUrl);
        return new MongoTemplate(client, dbName);
    }
}