package GET_REQUESTS;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get02 {

    /*
        GIVEN
        https://restful-booker.herokuapp.com/booking/1
        WHEN
        user sends a GET request to the URL
        THEN
        HTTP Status code should be 404
         AND
        Status line should be HTTP/1.1 404 Not Found
        AND
        Response body contains " Not Found"
         AND
        Response body does not contain " TechProEd"
       AND
       Server is "Cowboy"
         */
    @Test
    public void get01() {
//        i) set the URL
        String url ="https://restful-booker.herokuapp.com/booking/1";

//        ii) set the expected data (post-put-patch)

//        iii) type code to send request
        Response response = given().when().get(url);
        response.prettyPrint();

//        iv) Do assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        // how to assert response body
        // assertTrue(x) passes if x is true
       assertTrue(response.asString().contains("Not Found"));

        // how to assert if response body does not have a specific text
       // ONCE BOYLE YAPTIK  assertFalse(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));

        // HOW TO FIND SERVER NAME
        System.out.println(response.header("Server"));
        // assertEquals(x,y) method passes if y equals x
        assertEquals("Cowboy",response.header("Server"));
    }

}
