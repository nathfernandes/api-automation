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
@Feature("Breeds")
@DisplayName("Breeds API Tests")
public class BreedListAllTest extends BaseApiTest {
    private final DogApiClient dogApiClient = new DogApiClient();

    @Test
    @Story("Get all breeds")
    @DisplayName("Should return all available dog breeds")
    void shouldReturnAllBreedsSuccessfully() {
        Response response = dogApiClient.getAllBreeds();

        response.then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath(
                        "schemas/breeds-list-all-schema.json"));

        assertThat(response.jsonPath().getString("status"))
                .isEqualTo("success");
    }
}
