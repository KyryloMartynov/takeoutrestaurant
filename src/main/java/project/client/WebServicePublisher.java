package project.client;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {
    public static void main(String... args) {
        Endpoint.publish("http://localhost:9090/restaurant", new RestaurantServiceImpl());
    }
}

