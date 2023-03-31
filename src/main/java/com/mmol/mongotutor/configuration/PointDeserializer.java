package com.mmol.mongotutor.configuration;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import java.io.IOException;


public class PointDeserializer extends JsonDeserializer<Point> {

    @Override
    public Point deserialize(JsonParser jsonParser, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        JsonNode coordinatesNode = node.get("coordinates");
        double longitude = coordinatesNode.get(0).asDouble();
        double latitude = coordinatesNode.get(1).asDouble();
        Position position = new Position(longitude, latitude);
        return new Point(position);
    }

//    @Override
//    public Point deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
//        // Get the array of coordinates from the JSON
//        double[] coordinates = jsonParser.getCodec().readValue(jsonParser, double[].class);
//
//        // Create and return a new Point object with the coordinates
//        return new Point(new Position(coordinates[0], coordinates[1]));
//    }
}
