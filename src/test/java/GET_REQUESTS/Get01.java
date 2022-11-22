package GET_REQUESTS;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
public class Get01  {
// ILK BOYLE YAPTIK EN SONA GIVEN YAZDIK SONRA .* KOYDUK.HEPSI ICINimport static io.restassured.RestAssured.given;
// * YAPINCA HEPSINI IMPORT ETTI

 /*
1) postman is used for manual API testing
2) we use rest -assured Library for API Automation Testing
3) To type automation script follow the given steps
  a) Understand the requirements
  b) type test cases

   to type  test cases we use " GHERKIN LANGUAGE"
   The keywords are x) Given : it is for pre-requisities
                    y) When:   it is for actions
                    z) Then : it is for outputs
                    t) And   : it is used for multiple given, when or then
   c) Start to type the automation script
       i) set the URL
       ii) set the expected data (post-put-patch)
       iii) type code to send request
       iv) Do assertion
     */

    @Test
    public void get01() {


/*
        GIVEN
        https://restful-booker.herokuapp.com/booking/101
        WHEN
        user sends a GET request to the URL
        THEN
        HTTP Status code should be 200
        AND
        Content Type should be JSON
        AND
        Status line should be HTTP/1.1 200 OK
         */



        //   i) set the URL
        String url = " https://restful-booker.herokuapp.com/booking/101";
        //  ii) set the expected data (post-put-patch)

        // iii) type code to send request
        Response response= given().when().get(url);
        response.prettyPrint();

        //  iv) Do assertion
response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
          // HOW TO PRINT STATUS CODE
        System.out.println("Status Code: "+ response.getStatusCode());

        // HOW TO PRINT CONTENT TYPE
        System.out.println("Content Type: "+response.getContentType());

        // HOW TO PRINT STATUS LINE
        System.out.println("Status Line: "+ response.getStatusLine());

        //HOW TO PRINT HEADER ON THE CONSOLE
        System.out.println(response.getHeader("user-Agent"));
        System.out.println(response.getHeader("Connection"));
        //HOW TO PRINT HEADERs ON THE CONSOLE
        System.out.println(response.getHeaders());

        //HOW TO PRINT TIME ON THE CONSOLE
        System.out.println(response.getTime());

    }




}
