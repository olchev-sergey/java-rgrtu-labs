package com.arianit.restapp;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestappApplicationTests {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    // Testing the body response type of endpoint getting people data
    @Test
    public void testGetPeopleEndpointContentType() {
        given().when().get("/api/people/").then()
                .assertThat()
                .statusCode(200)
            .and()
                .contentType(ContentType.JSON);
    }

    // Testing the value of key name of Person with id one
    @Test
    public void testGetPersonByIdEndpoint() {
        given().when().get("api/people/1").then().statusCode(200).assertThat()
                .body("name", equalTo("Keeley Bosco"));
    }

    // Testing the length of JSON objects in response of getting people data
    @Test
    public void testSizeOfPeopleResponse() {
        given().when().get("api/people/").then().assertThat()
                .body("size()", is(50));
    }

}
