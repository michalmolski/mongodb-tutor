package com.mmol.mongotutor.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoConfig {

    private String host;
    private int port;
    private String database;
    private String authenticationDatabase;
    private String username;
    private String password;

    @Bean
    public MongoClient mongoClient() {
        String connectionString = "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + database + "?authSource=" + authenticationDatabase;
        return MongoClients.create(connectionString);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), database);
    }

}