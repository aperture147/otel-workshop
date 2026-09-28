package org.acme.people.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import org.acme.people.service.GreetingService;
import jakarta.ws.rs.PathParam;

import org.acme.people.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.smallrye.common.annotation.NonBlocking;

@Path("/hello")
public class GreetingResource {

    public static final Logger log = LoggerFactory.getLogger(GreetingResource.class);

    @Inject
    GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    @NonBlocking
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @NonBlocking
    public String hello() {
        return "Hello from Quarkus REST";
    }
}