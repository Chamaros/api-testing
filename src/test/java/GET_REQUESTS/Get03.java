package GET_REQUESTS;

import BaseUrls.JsonPlaceHolderBaseUrls;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
NOTE 1: when you execute assertion, java stops execution after the first failure.
 it means assertion after the failure were not executed
 But the assertion before failure were passed, because assertions before the failure were executed.
 NOTE 2:If you type your code as execution will stop in the first failure , it is called "HARD ASSERTION"
 NOTE 3:If you type your code as execution will NOT stop in  any failure it is called "SOFT ASSERTION"
 NOTE 4:If you use multiple "body()" method it will work like "HARD ASSERTION", if you use just a single "body()" method
  with multiple assertions in it, it will work like "SOFT ASSERTION"
 */

public class Get03 extends JsonPlaceHolderBaseUrls {
    /*
        GIVEN
        https://jsonplaceholder.typicode.com/todos/23
        WHEN
        user sends a GET request to the URL
        THEN
        HTTP Status code should be 200
         AND
        response format  should be "aplication/json"
        AND
        "title" is "et itaque necessitatibus maxime molestiae qui quas velit"
         AND
        "completed" is false
       AND
       "userId" is 2
         */
    @Test
    public void get01() {
//        i) set the URL
        spec.pathParams("first","todos","second",23);

//        ii) set the expected data (post-put-patch)

//        iii) send the request and get response
            Response response = given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

//        iv) Do assertion
        //FIRST WAY// HARD ASSERTION
        response.then().
                assertThat().statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
               body("id",equalTo(23)).
                body("userId",equalTo(2));
        //SECOND WAY//  SOFT ASSERTION
        response.then().
                assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),"id",equalTo(23),
                        "userId",equalTo(2));



        // how to assert response body
        // assertTrue(x) passes if x is true


        // how to assert if response body does not have a specific text
        // ONCE BOYLE YAPTIK  assertFalse(response.asString().contains("Not Found"));

        // HOW TO FIND SERVER NAME

    }




}
