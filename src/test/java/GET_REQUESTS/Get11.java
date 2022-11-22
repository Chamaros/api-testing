package GET_REQUESTS;

import BaseUrls.GoRestBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.List;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {
        /*
    Given
    https://gorest.co.in/public/v1/users //v1 WILL BE ALWAYS IN BASE URL
    notes: we are using the swagger documentation
     WHEN
        user send  GET request to the URL
        THEN
           the value of pagination is 10
           AND
           the "current link" should be " https://gorest.co.in/public/v1/users?page=1"
           AND
           the number of users should be 10  //HAS SIZE METHOD
           AND
           we have at least one "active" status
           AND
           "Shashi Sethi ", "Dr.Chandravati Pothuvaal, "Deepesh Nambeesan" are among the users
           AND
           the female users are more than male users

         */

@Test
    public void get01 (){
    // 1.step: set the Url
    spec.pathParam("first","users");

    //2.step : set the expected data

    // 3. step send the request and get the response
    Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{first}");
    response.prettyPrint();

    //4. step :Do assertion  // WE CAN DO EVERYTHING WITH THE BODY METHOD BECAUSE OF THAT WE DONT DO LIST
    response.
            then().assertThat().
            statusCode(200).
            body("meta.pagination.limit", (Matcher<?>) equalTo(10),// NORMALDE BOYLE DEGIL
                    "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                    "data.id",hasSize (10),"data.status", hasItem("active"),"data.name",hasItems("Shashi Sethi","Dr.Chandravati Pothuvaal","Deepesh Nambeesan"));
    //DATA.ID BIZE TUM IDLERI LISTE HALINDE VERIR STRING LIST OLARAK VERIR
            // HASSIZE METHOD IS JUST FOR CHECKING / IT HAS 10 USERS OR NOT

            //--the female users are more than male users
          // I will compare number if female and male user in 2 ways
            // i) I will get all genders then I will count the females than I will calculate males and I will check which one is more ...
    JsonPath json = response.jsonPath();
    List<String> genders = json.getList("data.gender");
    System.out.println("genders list: "+genders);

    int numofFemales = 0;
    for(String w:genders){
        if (w.equals("female")){
            numofFemales++;
        }
    }
    System.out.println("numofFemales: "+numofFemales);
    assertTrue(numofFemales> genders.size()-numofFemales);
    //THIS WAY IS RECOMMENDED
    // ii) I will get all females by using Groovy,i will get all males by groovy then compare them
  List<String> femalelist =   json.getList("data.findAll{it.gender=='female'}.gender");
    System.out.println("femaleList: "+femalelist);// [female,female,female,female,female,female,]

    List<String> malelist =   json.getList("data.findAll{it.gender=='male'}.gender");
    System.out.println("maleList: "+malelist); //[ male, male,male,male]

    assertTrue(femalelist.size()>malelist.size());






}






}
