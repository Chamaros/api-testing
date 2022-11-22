package GET_REQUESTS;

import BaseUrls.HerOkuAppBaseUrl;
import pojos.BookingPojo;
import Utils.JsonUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15ObjectMapper extends HerOkuAppBaseUrl {
     /*
    Given
    https://restful-booker.herokuapp.com/booking/11
     WHEN
        user sends a GET request to the URL
        THEN
        HTTP Status code should be 200
        and
        response body should be like;
      {
    "firstname": "Dane",
    "lastname": "Bonfanti",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}

      */
    @Test
    public void get01(){
        // 1.step:Set the Url
        spec.pathParams("first","booking","second",11);
        // 2.set the expected data
        String expectedData =" {\n" +
                "    \"firstname\": \"Dane\",\n" +
                "    \"lastname\": \"Bonfanti\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";
       BookingPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, BookingPojo.class);

       // 3. STEP Send the request and get the respence
      //  given().spec(spec).when().get("/{first}/{second}").prettyPrint(); //PRETTY PRINT BU SEKILDE DE YAPABILIYORUZ
        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        // 4.STEP DO ASSERTION
        BookingPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(),BookingPojo.class);
        // HARD ASSERTION
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataPojo.getFirstname(),actualDataPojo.getFirstname());
        assertEquals(expectedDataPojo.getLastname(),actualDataPojo.getLastname());
        assertEquals(expectedDataPojo.getTotalprice(),actualDataPojo.getTotalprice());
        assertEquals(expectedDataPojo.getDepositpaid(),actualDataPojo.getDepositpaid());
        assertEquals(expectedDataPojo.getBookingdates().getCheckin(),actualDataPojo.getBookingdates().getCheckin());
        assertEquals(expectedDataPojo.getBookingdates().getCheckout(),actualDataPojo.getBookingdates().getCheckout());
        assertEquals(expectedDataPojo.getAdditionalneeds(),actualDataPojo.getAdditionalneeds());
        // SOFT ASSERTION
        //1) CREATE SOFTASSERT OBJECT;
        SoftAssert softAssert = new SoftAssert();
        //2) DO ASSERTION
        softAssert.assertEquals(actualDataPojo.getFirstname(),expectedDataPojo.getFirstname(),"firstname did not match");
        softAssert.assertEquals(actualDataPojo.getLastname(),expectedDataPojo.getLastname(),"lastname did not match");
        softAssert.assertEquals(actualDataPojo.getTotalprice(),expectedDataPojo.getTotalprice(),"Total price did not match");
        softAssert.assertEquals(actualDataPojo.getDepositpaid(),expectedDataPojo.getDepositpaid(),"deposit paid did not match");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckin(),expectedDataPojo.getBookingdates().getCheckin(),"check in did not match");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckout(),expectedDataPojo.getBookingdates().getCheckout(),"check out  did not match");


        //3) USE ASSERT ALL
        softAssert.assertAll();
    }











}
