package GET_REQUESTS;

import BaseUrls.JsonPlaceHolderBaseUrls;
import pojos.JsonPlaceHolderPojo;
import Test_data.JsonPlaceHolderTestData;
import Utils.JsonUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static Utils.JsonUtil.convertJsonToJavaObject;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper extends JsonPlaceHolderBaseUrls {

     /*
        GIVEN
        https://jsonplaceholder.typicode.com/todos/198
        WHEN
        I send a GET request to the URL

        THEN
        HTTP Status code should be 200
         AND
        response body is like  {
                                "userId": 10;
                                "id": 198,
                                "title":"quis eius est sint explicabo",
                                "completed": true
                                }
         */
    @Test
    public void get01ObjectMapper(){
        // 1.STEP: SET THE URL
        spec.pathParams("first","todos","second",198);

        //2.STEP : SET THE EXPECTED DATA
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
       String expectedData = jsonPlaceHolderTestData.expectedDataInString(10,"quis eius est sint explicabo",true);
        // IT WILL BE CONVERTED DIRECTLY BY THE HELP OF MAPPER
        Map<String,Object> expectedDataMap = convertJsonToJavaObject(expectedData, HashMap.class); // we converted the string container to hashmap
        System.out.println("expectedDataMap: "+ expectedDataMap);
        // if you type here the class name you can reach the static things in that class

        //3.STEP: send the GET request and get response
        Response response =  given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

       //4.STEP:Do assertion
        //FIRST WAY
        Map<String,Object> actualDataMap = convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println("actualDataMap: "+ actualDataMap);

        assertEquals(200,response.getStatusCode());

        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
    }
  @Test
    public void get02ObjectMapper(){

      // 1.STEP: SET THE URL
      spec.pathParams("first","todos","second",198);

      //2.STEP : SET THE EXPECTED DATA
      JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
      String expectedData = jsonPlaceHolderTestData.expectedDataInString(10,"quis eius est sint explicabo",true);
      //YUKARIDAKI SATIR: JSON DATA IN STRING CONTAINER
      JsonPlaceHolderPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, JsonPlaceHolderPojo.class);
      System.out.println(expectedDataPojo);

      //3.STEP: send the GET request and get response
      Response response =  given().spec(spec).when().get("/{first}/{second}");
      response.prettyPrint();

      //4.STEP:Do assertion
      //TO DO ASSERTION : EXPECTED DATA AND ACTUALDATA MUST BE IN THE SAME DATA TYPE .WE MADE BOTH JSON FORMAT
        JsonPlaceHolderPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(),JsonPlaceHolderPojo.class );

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataPojo.getUserId(),actualDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(),actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(),actualDataPojo.getCompleted());



  }
}
