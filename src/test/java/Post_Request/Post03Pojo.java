package Post_Request;

import BaseUrls.JsonPlaceHolderBaseUrls;
import pojos.JsonPlaceHolderPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03Pojo extends JsonPlaceHolderBaseUrls {
     /*
    GIVEN
    https://jsonplaceholder.typicode.com/todos/23
    2){
    "userId":55,
    "title":"Tidy your room",
    "completed":false
    }

    WHEN
    I send a POST request to the URL
    THEN
    HTTP Status code should be 201
    AND
    response BODY  should be is like{ "userId":55,
                                     "title":"Tidy your room",
                                         "completed":false
                                         "id":201,
    }
    */
@Test
    public void post01(){
    //1.step :set the Url
    spec.pathParam("first","todos");
    //2.step :Set the expected data
    JsonPlaceHolderPojo payload = new JsonPlaceHolderPojo(55,"Tidy your room",false);
    System.out.println("expectedData: "+payload);
    //PAYLOAD MEANS EXPECTED DATA OR REQUEST BODY
    System.out.println(payload);

    // 3.step:SEND THE POST REQUEST AND GET THE RESPONSE
    Response response = given().spec(spec).contentType(ContentType.JSON).body(payload).when().post("/{first}");
    response.prettyPrint();

    //4.step DO ASSERTION
    JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
    System.out.println("actualData: "+actualData);
    assertEquals(payload.getUserId(),actualData.getUserId());
    assertEquals(payload.getTitle(),actualData.getTitle());
    assertEquals(payload.getCompleted(),actualData.getCompleted());
    assertEquals(201,response.getStatusCode());






}







}
