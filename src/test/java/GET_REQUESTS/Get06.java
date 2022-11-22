package GET_REQUESTS;

import BaseUrls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends HerOkuAppBaseUrl {

    /*
    Given
    https://restful-booker.herokuapp.com/booking/555
     WHEN
        user sends a GET request to the URL
        THEN
        HTTP Status code should be 200
        AND
        response content type  should be "aplication/json"
        and
        response body should be like;
        "firstname": "Sally",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23",
        },
        "additionalneeds": "Breakfast"
        }
 */
    @Test
    public void get01(){
        // 1.set the Url
        spec.pathParams("first","booking","second",555);

// 2.step set the expected data

// 3.step: send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
//4.step: Do assertion-bunun yerine daha once yaptigimiz gibi body olarak yaptigimizla da yapabiliriz.
      response.then().assertThat().statusCode(200).
              contentType(ContentType.JSON).
              body("firstname",equalTo("Brown"),
                      "totalprice",equalTo(11),
                      "depositpaid",equalTo(true),
                      "bookingdates.checkin",equalTo("2013-02-23"),
                      "bookingdates.checkout",equalTo("2014-10-23"),
                      "additionalneeds",equalTo("Breakfast"));
//2.WAY WE WILL USE JsonPath Class
        JsonPath json =response.jsonPath();// jsonPath is used for navigating into json format
        json.getString("firstname");// console:sally

        assertEquals("Sally",json.getString("firstname"));
        assertEquals("Brown",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertEquals("true",json.getBoolean("depositpaid"));
        assertEquals("bookingdates.checkin",json.getString("2013-02-23"));
        assertEquals("bookingdates.checkout",json.getString("2013-02-23"));

//3.WAY WE WILL USE soft assertion
        // to use soft assertion FOLLOW THIS 3 STEPS

        // I. CREATE SOFT ASSERT OBJECT
        SoftAssert softAssert = new SoftAssert();

        // II. Do Assertion
        softAssert.assertEquals(json.getString("firstname"),"Sally","First name did not match");
        softAssert.assertEquals(json.getString("lastname"),"Brown","last name did not match");
        softAssert.assertEquals(json.getInt("totalprice"),111,"totalprice did not match");
        softAssert.assertEquals(json.getBoolean("depositpaid"),"true","depositpaid did not match");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2013-02-23","checkin did not match");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2014-10-23","checkout did not match");
        softAssert.assertEquals(json.getString("additionalneeds"),"breakfast","additionalneeds did not match");

    // III. USE ASSERT ALL()method. if you do not use assertAll() method, you will get pass message every time even
        // if they do not pass
        softAssert.assertAll();






    }


}
