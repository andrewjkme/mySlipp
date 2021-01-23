package dev.ajkim.weblab.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Configuration
@Service
public class MongoDBConfig {

    @Bean
    @Scope("singleton")
    public MongoClient mongoClient(@Value("${spring.mongodb.uri}") String connectionString){
        ConnectionString connString = new ConnectionString(connectionString);

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .writeConcern(new WriteConcern("majority").withWTimeout(2500, TimeUnit.MILLISECONDS))
                .build();
        MongoClient mongoClient = MongoClients.create(settings);

        return mongoClient;
    }
}
