package GET_REQUESTS;

import BaseUrls.HerOkuAppBaseUrl;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12Pojo extends HerOkuAppBaseUrl {
    // NIYE POJO ILE YAPIYORUZ. CUNKU BU RECOMMENDED WAY
    // WE ARE DOING IN INCAPSULATION
    // YOUR CODE WILL BE FASTER
    // FOR THE SECURITY IT WILL BE BETTER
    // IT WILL HAVE MORE FLEXIBILTY
    // WHENEVER YOU WANT YOU CAN CHANGE BODY OR FORM ITH THE POJO CLASS
     /*
    Given
    https://restful-booker.herokuapp.com/booking/55
     WHEN
        user sends a GET request to the URL
        THEN
        HTTP Status code should be 200
        AND

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
         // BU ORNEKTE SADECE BOOKINGDATESPOJO VE BOOKINGPOJO CLASSLARINI KULLANCAGIZ
    @Test
    public void get01Pojo(){
      // 1.step SET THE URL
      spec.pathParams("first","booking","second",55);
      // 2.STEP : SET THE EXPECTED DATA
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2013-02-23","2014-10-23");
        BookingPojo expectedData = new BookingPojo("Sally","Brown",111,true,bookingDatesPojo,"Breakfast");
        System.out.println(expectedData);
      // 3. STEP SEND THE GET REQUEST AND GET THE RESPONSE
      Response response = given().spec(spec).when().get("/{first}/{second}");
      response.prettyPrint();
      // WE DO  NOT HAVE BODY. NO NEED TO  PUT BODY FOR THE GET REQUEST .WE ARE JUST READING DATA WE ARE NOT SENDING OR CREATING DATA. WE ARE JUST READING DATA.

        //4.STEP DO ASSERTION
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println("actualData: "+ actualData);

        assertEquals(200,response.getStatusCode());

        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getTotalprice(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());

        // 1 WAY
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());

        //2.WAY RECOMMENDED
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());



    }







}
