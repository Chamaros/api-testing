package GET_REQUESTS;

import BaseUrls.JsonPlaceHolderBaseUrls;
import Test_data.JsonPlaceHolderTestData;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrls {
    /*
    SERIALIZATION: to convert java object to json data
    DE-SERIALIZATION :to convert json data to java object
    to do SERIALIZATION and DE-SERIALIZATION we can use
    1) Gson: Google created
    2) Object Mapper:more popular
     */


     /*
        GIVEN
        https://jsonplaceholder.typicode.com/todos/2
        WHEN
        user sends a GET request to the URL
        THEN
       Status code should be 200
       AND  "completed " is false
       AND "userId " is 1
       AND  "title" is "quis ut nam facilis et officia qui"
       and header "Via" is "1.1 vegur"
       and header "server" is "cloudflare"
       {
       "userId":1,
       "id":2,
       "title" : "quis ut nam facilis et officia qui",
       "completed":false
       }
         */
    @Test
    public void get01() {

        // 1. step set the url

        spec.pathParams("first","todos","second",2);

        //2. step :set the expected data
        // DESERILIZATION TAKE THE DATA FROM API.IT WILL BE IN JSON FORMAT AND CONVERT IT TO JAVA FORMAT(CONVERT TO MAP)
        Map<String,Object> expectedData = new HashMap<>(); // data type object yaptik. cunku farkli data typelari ayni anda kullanmak icin
        expectedData.put("userId",1);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",true); //WE SHOULD NOT USE THE TEST DATA IN TEST BODY. HE USED IT TO SHOW US THE LOGIC
        expectedData.put("StatusCode",200); //MY TEST DATA MUST BE IN ANOTHER CLASS
        expectedData.put("Via","1.1 vegur");
        expectedData.put("Server","cloudflare");
        System.out.println("expectedData: "+ expectedData);
        // we created expected data above
        // 3.step :send the request and get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String,Object> actualData = response.as(HashMap.class);//DESERILIZATION-WE CONVERTED JASON TO JAVA
        System.out.println("actualData: "+ actualData);


     // 4.Do Assertion
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
assertEquals(expectedData.get("completed"),actualData.get("completed"));
assertEquals(expectedData.get("StatusCode"),response.getStatusCode());
assertEquals(expectedData.get("Via"),response.getHeader("Via"));
        assertEquals(expectedData.get("Server"),response.getHeader("Server"));


    }
   @Test
    public void get02(){
        // 1.step:set the URL
       spec.pathParams("first","todos","second",2);

       //2. step :set the expected data
       JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();
     Map<String,Object> expectedDataMap = expectedData.expectedDataWithAllKey(1,"quis ut nam facilis et officia qui",false);
     expectedDataMap.put("StatusCode",200);
     expectedDataMap.put("Via","1.1 vegur");
     expectedDataMap.put("Server","cloudflare");
       System.out.println("expectedDataMap: "+expectedDataMap);


       //// 3.step :send the request and get the Response
     Response response = given().spec(spec).when().get("/{first}/{second}");
     response.prettyPrint();

       // 4.Do Assertion
       Map<String,Object> actualDataMap = response.as(HashMap.class);
       System.out.println("actualData: "+ actualDataMap);

       assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
       assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
       assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
       assertEquals(expectedDataMap.get("StatusCode"),response.getStatusCode());
       assertEquals(expectedDataMap.get("Via"),response.getHeader("Via"));
       assertEquals(expectedDataMap.get("Server"),response.getHeader("Server"));


   }





}
