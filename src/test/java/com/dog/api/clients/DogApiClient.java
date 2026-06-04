package com.dog.api.clients;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;

import static io.restassured.RestAssured.given;

public class DogApiClient {
    private static final String BREEDS = "/breeds/list/all";
    private static final String RANDOM_IMAGE = "/breeds/image/random";
    private static final String BREED_IMAGES = "/breed/%s/images";

    @DisplayName("Get all available breeds")
    public Response getAllBreeds() {
        return given()
                .when()
                .get(BREEDS)
                .then()
                .extract()
                .response();
    }

    @DisplayName("Get random dog image")
    public Response getRandomImage() {
        return given()
                .when()
                .get(RANDOM_IMAGE)
                .then()
                .extract()
                .response();
    }

    @DisplayName("Get images for breed: {breed}")
    public Response getBreedImages(String breed) {
        return given()
                .when()
                .get(String.format(BREED_IMAGES, breed))
                .then()
                .extract()
                .response();
    }
}
