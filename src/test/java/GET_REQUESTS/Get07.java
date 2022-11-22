package GET_REQUESTS;

import BaseUrls.JsonPlaceHolderBaseUrls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends JsonPlaceHolderBaseUrls {

     /*
        GIVEN
        https://jsonplaceholder.typicode.com/todos
        WHEN
        user sends a GET request to the URL
        THEN
        1)HTTP Status code should be 200
        2)Print all ids greater than 190 on the console
           Assert that there are 10 ids greater than 190
        3) Print all userIds whose  are less than 5 on the console
        assert that the number of  userIds whose ids are less than 5 is 4
        4) Print all titles whose ids are less than 5
        assert that "delectus aut aoutem" is one of the titles whose id is less than 5

         */
    @Test
   public void get01(){

       // 1.set the Url
       spec.pathParam("first","todos");

// 2.step set the expected data

       // 3.step: send the request and get the response
       Response response = given().spec(spec).when().get("/{first}");
       response.prettyPrint();
//4.step: Do assertion-
//        1)HTTP Status code should be 200
        response.then().assertThat().statusCode(200); // BIRINCI YOL
        assertEquals(200,response.getStatusCode());// IKINCI YOL
//        2)Print all ids greater than 190 on the console

        JsonPath json = response.jsonPath();
       List<Integer> ids =  json.getList("FindAll{it.id>190}.id");// groovy language
        System.out.println("ids greater than 190: "+ids);
        //        Assert that there are 10 ids greater than 190
        assertEquals("10",ids.size());
//        3) Print all userIds whose  are less than 5 on the console

        // GROOVY LANGUAGE - GROOVY LANGUAGE
        List<Integer> userIds = json.getList("FindAll{it.id<5}.userId");
        System.out.println("userIds whose  are less than 5: "+userIds);
        //        assert that the number of  userIds whose ids are less than 5 is 4
        assertEquals("Number of userIds whose Ids are less than 5 is not 4",4,userIds.size());
//        4) Print all titles whose ids are less than 5
        List<String> titles = json.getList("FindAll{it.id<5}.title");
        System.out.println("titles whose ids are less than 5: "+titles);
//        assert that "delectus aut aoutem" is one of the titles whose id is less than 5
        //1. way
        assertTrue("Expected title is not among them",titles.contains("delectus aut aoutem"));
        // 2.way
        assertTrue("Expected title is not among them",titles.stream().anyMatch(t->t.equals("delectus aut aoutem")));


   }





}
