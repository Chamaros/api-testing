package GET_REQUESTS;

import BaseUrls.GoRestBaseUrl;
import Test_data.GoRestTestData;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10 extends GoRestBaseUrl {
         /*
    Given
    https://gorest.co.in/public/v1/users/13 //v1 WILL BE ALWAYS IN BASE URL
    notes: we are using the swagger documentation
     WHEN
        user send  GET request to the URL
        THEN
           status code should be 200
           and
        response body should be like;
        {
        "meta":null,
        "data": {
        "id":13,
        "name": "Dandak Adiga",
        "email":"adiga_dandak@christiansen-schimmel.biz",
        "gender":"female",
        "status":"active"
        }
        }
 */
@Test
    public void get01(){
    //1. set the url
    spec.pathParams("first","users","second",13);

    // 2. set the expected data
    GoRestTestData goRestTestData = new GoRestTestData();
    Map<String, String> dataMap = goRestTestData.dataKeyMap ("Dandak Adiga","adiga_dandak@christiansen-schimmel.biz"
    ,"female","active");
    Map<String,Object> expectedData = goRestTestData.expectedDataMap("null",dataMap);
    System.out.println(expectedData);

    // 3.step :send the request get the response
    Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();
    // 4.step:Do ASSERTION

    Map<String,Object> actualData = response.as(HashMap.class);
    assertEquals(expectedData.get("meta"),actualData.get("meta"));
    assertEquals(dataMap.get("name"),((Map)actualData.get("data")).get("name"));
    assertEquals(dataMap.get("email"),((Map)actualData.get("data")).get("email"));
    assertEquals(dataMap.get("gender"),((Map)actualData.get("data")).get("gender"));
    assertEquals(dataMap.get("status"),((Map)actualData.get("data")).get("status"));
    assertEquals("200",response.getStatusCode());


}













}
