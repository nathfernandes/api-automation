package com.dog.api.tests;

import com.dog.api.base.BaseApiTest;
import com.dog.api.clients.DogApiClient;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Dog API")
@Feature("Breed Images")
@DisplayName("Breed Images API Tests")
public class BreedImagesTest extends BaseApiTest {
    private final DogApiClient dogApiClient = new DogApiClient();

    @Test
    @Story("Get breed images")
    @DisplayName("Should return all images for a valid breed")
    void shouldReturnBreedImagesSuccessfully() {
        Response response = dogApiClient.getBreedImages("hound");

        response.then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath(
                        "schemas/breed-images-schema.json"));

        assertThat(response.jsonPath().getString("status"))
                .isEqualTo("success");
    }

    @Test
    @Story("Invalid breed")
    @DisplayName("Should return an error when breed does not exist")
    void shouldReturnErrorForInvalidBreed() {
        Response response =
                dogApiClient.getBreedImages("invalid-breed");

        assertThat(response.statusCode()).isEqualTo(404);

        assertThat(response.jsonPath().getString("status"))
                .isEqualTo("error");

        assertThat(response.jsonPath().getString("message"))
                .contains("Breed not found");
    }
}
