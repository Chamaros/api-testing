package GET_REQUESTS;

import BaseUrls.JsonPlaceHolderBaseUrls;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrls {


    /*
        GIVEN
        https://jsonplaceholder.typicode.com/todos
        WHEN
        I send a GET request to the URL
         AND
         Accept type is "aplication/json"
        THEN
        HTTP Status code should be 200
         AND
        response format  should be "aplication/json"
        AND
        there should be 200 todos
         AND
        "quis eius est sint explicabo " should be one of the todos title
       AND
       2,7, and 9 should be among the userIDs
         */
@Test
    public void Get01(){

    //1 st step :SET THE URL
    spec.pathParam("first","todos");

    // 2nd step: set the expected data

    // 3rd step: send the Request and get the response
   Response response = given().spec(spec).accept(ContentType.JSON).when().get("{first}");
   //response.prettyPrint();
   // 4th step :do assertion
    response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
            body("id",hasSize(200),"title",hasItem("quis eius est sint explicabo"),"userId",hasItems(2,7,9));


}










}
