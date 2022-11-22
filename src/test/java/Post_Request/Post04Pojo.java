package Post_Request;

import BaseUrls.HerOkuAppBaseUrl;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post04Pojo extends HerOkuAppBaseUrl {
    /*
    Given
    https://restful-booker.herokuapp.com/booking/
    {
     "firstname": "Ali",
        "lastname": "Can",
        "totalprice":999,
        "depositpaid": true,
        "bookingdates": {
        "checkin": "2021-09-21",
        "checkout": "2021-12-21",
        },
        "additionalneeds": "Breakfast with white tea, Dragon juice"
        }
     WHEN
        user sends a POST request to the URL
        THEN
        HTTP Status code should be 200
        and
        response body should be like {
                                   "bookingid": 16; // POST REQUESTTEN DOLAYI BUNLAR GELIYOR. GET REQUESTTE YOK BUNLAR
                                     "booking": {    // POST REQUESTTEN DOLAYI BUNLAR GELIYOR  GET REQUESTTE YOK BUNLAR

                                     "firstname": "Ali",
                                       "lastname": "Can",
                                     "totalprice":999,
                                     "depositpaid": true,
                                  "bookingdates": {
                                     "checkin": "2021-09-21",
                                    "checkout": "2021-12-21",
                                       }
                              "additionalneeds": "Breakfast with white tea"
                               }

     */
@Test
    public void post01(){
    //1. SET THE URL
    spec.pathParam("first","booking");

    //2.STEP :SET THE EXPECTED DATA
    BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2021-09-21","2021-12-21");
    BookingPojo bookingPojo = new BookingPojo("Ali", "Can",999,true,bookingDatesPojo,"Breakfast with white tea");

    // 3.STEP :SEND THE POST REQUEST AND GET THE RESPONSE
    Response response = given().spec(spec).contentType(ContentType.JSON).body(bookingPojo).when().post("/{first}");
    response.prettyPrint();
    // 4.STEP :DO ASSERTION
    // BookingPojo actualPojo = response.as(BookingPojo.class);//ilk yaptigimiz
    BookingResponseBodyPojo actualPojo = response.as(BookingResponseBodyPojo.class);
   // assertEquals(bookingPojo.getFirstname(),actualPojo.getFirstname());// ilk yaptigimiz
    assertEquals(200,response.getStatusCode());
    assertEquals(bookingPojo.getFirstname(),actualPojo.getBooking().getFirstname());
    assertEquals(bookingPojo.getLastname(),actualPojo.getBooking().getLastname());
    assertEquals(bookingPojo.getTotalprice(),actualPojo.getBooking().getTotalprice());
    assertEquals(bookingPojo.getDepositpaid(),actualPojo.getBooking().getDepositpaid());
    assertEquals(bookingPojo.getAdditionalneeds(),actualPojo.getBooking().getAdditionalneeds());
    //1 WAY CAN BE USED
    assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBooking().getBookingdates().getCheckin());
    assertEquals(bookingPojo.getBookingdates().getCheckout(),actualPojo.getBooking().getBookingdates().getCheckout());
   // 2 WAY RECOMMENDED
    assertEquals(bookingDatesPojo.getCheckin(),actualPojo.getBooking().getBookingdates().getCheckin());
    assertEquals(bookingDatesPojo.getCheckout(),actualPojo.getBooking().getBookingdates().getCheckout());
}



















}
