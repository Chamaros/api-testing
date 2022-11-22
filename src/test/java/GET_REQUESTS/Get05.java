package GET_REQUESTS;

import BaseUrls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
/*
    Given
    https://restful-booker.herokuapp.com/booking
     WHEN
        user sends a GET request to the URL
        THEN
        HTTP Status code should be 200
        AND
        among the data there should be someone whose firstname is Johhny and lastname is Dear

 */
    @Test
    public void get01(){
        // 1.set the Url
spec.pathParam("first","booking").
        queryParams("firstname","Johhny","lastname","Dear");
// 2.step set the expected data

// 3.step: send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
//4.step: Do assertion-bunun yerine daha once yaptigimiz gibi body olarak yaptigimizla da yapabiliriz.
 assertEquals(200,response.getStatusCode());

assertTrue(response.asString().contains("booking"));


    }





}
