package Patch_Request;

import BaseUrls.JsonPlaceHolderBaseUrls;
import Test_data.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrls {
      /*
    GIVEN
    1) https://jsonplaceholder.typicode.com/todos/198
     2) {

     "title": "Wash the dishes"

     }
      WHEN
   I send the patch  request  to the Url

    THEN
    HTTP Status code is 200
    AND
    response body is like { "userId":10,
                    "title": "Wash the dishes"
                     "completed": true
                     "id":198
     }
    */
    @Test
            public void patch01() {


// 1.step SET THE URL

        spec.pathParams("first", "todos", "second", 198);
        //2.step :set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
       Map<String,Object> expectedData =  obj.expectedDataWithMissingKey(null,"Wash the dishes",null);
        System.out.println(expectedData); //{title=wash the dishes}

        //3.step SEND THE PATCH REQUEST AND GET THE RESPONSE
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");
        response.prettyPrint();

        //4. DO ASSERTION
        // FIRST WAY
        response.then().assertThat().statusCode(200).body("title",equalTo(expectedData.get("title")));

        //SECOND WAY -IF SOMEONE ASK YOU TO ASSERT ALL THE BODY , YOU CAN DO THE FOLLOWING
        Map<String,Object>  expectedDataMapAllKeys =obj.expectedDataWithAllKey(10,"Wash the dishes",true);
        Map<String,Object> actualDataMap = response.as(HashMap.class);
        assertEquals(expectedDataMapAllKeys.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMapAllKeys.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMapAllKeys.get("completed"),actualDataMap.get("completed" ));

        //THIRD WAY
        response.then().assertThat().statusCode(200).body("title",equalTo(expectedDataMapAllKeys.get("title")),
                "userId",equalTo(expectedDataMapAllKeys),"completed",equalTo(expectedDataMapAllKeys.get("completed")));





    }
}
