package GET_REQUESTS;

import BaseUrls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
     /*
    Given
    https://restful-booker.herokuapp.com/booking/2461
     WHEN
        I send  GET request to the URL
        THEN

        response body should be like;
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01",
        },
        "additionalneeds": "Breakfast"
        }
 */
    @Test
    public void get01(){
        // 1.set the Url
        spec.pathParams("first","booking","second",2461);

        // 2.set the expected data
        // WE ARE GOING TO CREATE A NESTED MAP
        // EVERYTIME YOU MUST CREATE INNER MAP TO MAKE IT MORE CLEAR-FROM DEEPEST TO EXTERIOR ONE
        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin","2018-01-01");
        bookingdatesMap.put("checkout","2019-01-01");

        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname","James");
        expectedDataMap.put("lastname","Brown");
        expectedDataMap.put("totalprice",111);
        expectedDataMap.put("depositpaid",true);
        expectedDataMap.put("bookingdates",bookingdatesMap);
        expectedDataMap.put("additionalneeds","Breakfast");
        System.out.println("expectedData: "+ expectedDataMap);

        // 3.step :send the request get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // 4.step do assertion
        Map<String,Object> actualDataMap= response.as(HashMap.class);
        assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));

        assertEquals(bookingdatesMap.get("checkin"),((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map)actualDataMap.get("bookingdates")).get("checkout"));
    }











}
