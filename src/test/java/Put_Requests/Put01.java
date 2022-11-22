package Put_Requests;

import BaseUrls.JsonPlaceHolderBaseUrls;
import Test_data.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrls {

     /*
    GIVEN
    1)
     2) {
     "userId":21,
     "title": "Wash the dishes"
     "completed": false
     }
      WHEN
   I send the put request  to the Url  https://jsonplaceholder.typicode.com/todos/198

    THEN
    HTTP Status code should be 200
    AND
    response body is like { "userId":21,
                    "title": "Wash the dishes"
                     "completed": false
     }

    */
@Test
    public void put01(){
    //1.step :set the url
    spec.pathParams("first","todos","second",198);
    // 2.set the payload(set the expected data)
    JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
   Map<String,Object> expectedData =  obj.expectedDataWithAllKey(21,"Wash the dishes",false);
    System.out.println(expectedData);
    //3.step: Send the put request and get the response
    Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}/{second}");
    response.prettyPrint();
    // 4.step :DO ASSERTiON
   Map<String,Object> actualData = response.as(HashMap.class);

   assertEquals(expectedData.get("completed"),actualData.get("completed"));
   assertEquals(expectedData.get("title"),actualData.get("title"));
   assertEquals(expectedData.get("userId"),actualData.get("userId"));

   assertEquals(200,response.getStatusCode());





}





}
