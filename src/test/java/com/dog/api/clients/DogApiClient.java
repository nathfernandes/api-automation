package com.dog.api.clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DogApiClient {
    private static final String BREEDS = "/breeds/list/all";
    private static final String RANDOM_IMAGE = "/breeds/image/random";
    private static final String BREED_IMAGES = "/breed/%s/images";

    public Response getAllBreeds() {
        return given()
                .when()
                .get(BREEDS)
                .then()
                .extract()
                .response();
    }

    public Response getRandomImage() {
        return given()
                .when()
                .get(RANDOM_IMAGE)
                .then()
                .extract()
                .response();
    }

    public Response getBreedImages(String breed) {
        return given()
                .when()
                .get(String.format(BREED_IMAGES, breed))
                .then()
                .extract()
                .response();
    }
}
