package DeleteRequest;

import BaseUrls.JsonPlaceHolderBaseUrls;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01 extends JsonPlaceHolderBaseUrls {
    /*
    INTERVIEW QUESTION
    HOW TO AUTOMATE DELETE REQUEST IN API TESTING
    1) CREATE NEW DATA BY USING "POST REQUEST''
    2) USE "DELETE REQUEST TO DELETE NEW DATA
    NOTE: DO NOT USE "DELETE REQUEST FOR THE EXISTING DATA,IT MEANS CREATE YOUR OW DATA ,THEN DELETE IT
     */


    /*
    given
    https://jsonplaceholder.typicode.com/todos/198
    When
    I send DELETE Request to the Url
    Then
    Status code is 200
    and response body is {}
    */
    @Test
    public void delete01(){
        //1.step set the url
    spec.pathParams("first","todos", "second",198);

    //2.step set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        System.out.println("expectedData: "+expectedData);
        //3.step send the delete request and get the response
       Response response = given().spec(spec).when().delete("/{first}/{second}");// GET VE DELETE ICIN BODY KOYMUYORUZ-BECAUSE WE ARE NOT SENDING ANY DATA
       response.prettyPrint();
        //  POST OR PUT REQUEST WE SHOULD PUT BODY REQUEST

//4. STEP DO ASSERTION
        //1.WAY
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData: "+actualData);
        response.then().assertThat().statusCode(200);
        assertEquals(expectedData,actualData);
    // second way
        response.then().assertThat().statusCode(200);
        assertTrue(actualData.size()==0) ;
        assertTrue(actualData.isEmpty());
       // System.out.println(actualData.isEmpty()); //true YAZDIGINI gostermek icin yazdi
      //  System.out.println(actualData.size()==0); //true YAZDIGINI gostermek icin yazdi




    }




















}
