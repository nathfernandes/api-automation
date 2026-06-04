package com.dog.api.config;

import com.dog.api.constants.ProjectConstants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfig {
    private static RequestSpecification requestSpec;

    public static void init() {
        RestAssured.baseURI = ProjectConstants.BASE_URL;

        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.requestSpecification = requestSpec;
    }

    public static RequestSpecification getRequestSpec() {
        return requestSpec;
    }
}
