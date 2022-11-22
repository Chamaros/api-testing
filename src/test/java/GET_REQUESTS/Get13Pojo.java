package GET_REQUESTS;

import BaseUrls.GoRestBaseUrl;
import pojos.GoRestDataPojo;
import pojos.GoRestResponseBodyPojo;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*; //once .given vardi sonra hepsini kapsamasi icin given yerine *
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {

    /*
    Given
    https://gorest.co.in/public/v1/users/3615 //v1 WILL BE ALWAYS IN BASE URL
    notes: we are using the swagger documentation
     WHEN
        user send  GET request to the URL
        THEN
           status code should be 200
           and
        response body should be like;
       {
    "meta": null,
    "data": {
        "id": 3615,
        "name": "Chandrakala Bharadwaj",
        "email": "chandrakala_bharadwaj@frami.biz",
        "gender": "female",
        "status": "inactive"
    }
}
 */
  @Test
    public void get01Pojo(){

      // 1.step SET THE URL
      spec.pathParams("first","users","second",3615);

      // 2.STEP : SET THE EXPECTED DATA
      GoRestDataPojo goRestDataPojo = new GoRestDataPojo(3615,"Chandrakala Bharadwaj","chandrakala_bharadwaj@frami.biz","female","inactive");
      GoRestResponseBodyPojo expectedData = new GoRestResponseBodyPojo(null,goRestDataPojo);
      System.out.println(expectedData);

    // 3. STEP SEND THE GET REQUEST AND GET THE RESPONSE
    Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

    // WE DO  NOT HAVE BODY. NO NEED TO  PUT BODY FOR THE GET REQUEST .WE ARE JUST READING DATA WE ARE NOT SENDING OR CREATING DATA. WE ARE JUST READING DATA.

    //4.STEP DO ASSERTION
    GoRestResponseBodyPojo actualData = response.as(GoRestResponseBodyPojo.class);

    assertEquals(expectedData.getMeta(),actualData.getMeta());
    assertEquals(expectedData.getData().getId(),actualData.getData().getId());
    assertEquals(expectedData.getData().getEmail(),actualData.getData().getEmail());
    assertEquals(expectedData.getData().getGender(),actualData.getData().getGender());
    assertEquals(expectedData.getData().getStatus(),actualData.getData().getStatus());

    assertEquals(200,response.getStatusCode());





  }



}
