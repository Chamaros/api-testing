package Post_Request;

import BaseUrls.JsonPlaceHolderBaseUrls;
import Test_data.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends JsonPlaceHolderBaseUrls {
    /*
    GIVEN
    https://jsonplaceholder.typicode.com/todos/23
    WHEN
    user sends a GET request to the URL
    THEN
    HTTP Status code should be 200
    AND
    response format  should be "aplication/json"
    AND
        "title" is "et itaque necessitatibus maxime molestiae qui quas velit"
    AND
        "completed" is false
    AND
       "userId" is 2
            */
  @Test
  public void post01(){
      // 1.step set the url
      spec.pathParam("first","todos");

      //2.step set the expected data (request body
      JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
      Map<String,Object> expectedData = obj.expectedDataWithAllKey(55,"Tidy your room",false);
      System.out.println(expectedData);

      //3. step send post request and get the response
      Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
      response.prettyPrint();

      //4.step DO ASSERTION
      Map<String,Object> actualdata = response.as(HashMap.class);
      assertEquals(expectedData.get("completed"),actualdata.get("completed"));
      assertEquals(expectedData.get("title"),actualdata.get("title"));
      assertEquals(expectedData.get("userId"),actualdata.get("userId"));

      assertEquals(201,response.getStatusCode());



  }












}
