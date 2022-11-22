package Post_Request;

import BaseUrls.HerOkuAppBaseUrl;
import Test_data.HerOkuAppTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends HerOkuAppBaseUrl {
    // post request is for  CREATING A NEW DATA
    /*
    Given
    1) "https://restful-booker.herokuapp.com/booking
    2){
          "firstname": "John",
        "lastname": "Doe",
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
        "checkin": "2021-09-09",
        "checkout": "2021-09-21",
            }
        }
     WHEN
        I send a POST request to the URL
        THEN
         Status code is 200
        and
        response body should be like;{
                                          "bookingid":5315,
                                          "booking":{
                                          "firstname": "John",
                                            "lastname": "Doe",
                                              "totalprice": 11111,
                                                "depositpaid": true,
                                                "bookingdates": {
                                                     "checkin": "2021-09-09",
                                                     "checkout": "2021-09-21",   */
    @Test
    public void post01(){
       // 1.step: set the Url
       spec.pathParam("first","booking");

       //2.step set the expected data
        HerOkuAppTestData herOkuAppTestData = new HerOkuAppTestData();
      Map<String,String> bookingdatesMap = herOkuAppTestData.bookingdatesSetup("2021-09-09","2021-09-21");
      Map<String,Object> expectedData =  herOkuAppTestData.expectedDataSetup("John","Doe",11111,true,bookingdatesMap);
        System.out.println(expectedData);
        // 3.step Send the Post REQUEST AND GET THE RESPONSE
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //4.step DO ASSERTION
        // we will do deserialization
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);
        
        assertEquals(200,response.getStatusCode());

        assertEquals(expectedData.get("firstname"),((Map)actualData.get("booking")).get("firstname"));
        assertEquals(expectedData.get("lastname"),((Map)actualData.get("booking")).get("lastname"));
        assertEquals(expectedData.get("depositpaid"),((Map)actualData.get("booking")).get("depositpaid"));
        assertEquals(expectedData.get("totalprice"),((Map)actualData.get("booking")).get("totalprice "));

        assertEquals(bookingdatesMap.get("checkin"),((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));

    }









}
