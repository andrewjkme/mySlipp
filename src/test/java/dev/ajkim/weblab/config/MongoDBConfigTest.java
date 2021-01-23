package dev.ajkim.weblab.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MongoDBConfigTest {
    @Value("${spring.mongodb.uri}")
    String mongoUri;

    @Value("${spring.mongodb.database}")
    String databaseName;

    @Test
    public void findCollectionsTest(){
        MongoClient mc = MongoClients.create(mongoUri);
        List<String> collectionsNames = Arrays.asList("users");

        int found = 0;
        for (String colName: mc.getDatabase(databaseName).listCollectionNames()){
            if(collectionsNames.contains(colName)){
                found++;
            }
        }

        Assertions.assertEquals(found, collectionsNames.size());
    }


}