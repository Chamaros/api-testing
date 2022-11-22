package GET_REQUESTS;

import BaseUrls.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class Get16ObjectMapper extends DummyRestApiBaseUrl {
    /*
    URL: https://dummy.restapiexample.com/api/v1/employees

    HTTP Request Method : GET Request
    Test case: Type by using Gherkin Language
    assert: i) Status code is 200
            ii) There are 24 employees        //HAS SIZE METHOD FOR EXAMPLE
            iii)"Tiger Nixon" and "Garret Winters" are among the employees
            iv) The greatest age is 66
            v) The name of the lowest age is "Tatyana Fitzpatrick"
            vi) Total salary of all employees is 6,644,770

             to type  test cases we use " GHERKIN LANGUAGE"
   The keywords are x) Given : it is for pre-requisities
                    y) When:   it is for actions
                    z) Then : it is for outputs
                    t) And   : it is used for multiple given, when or then
     */ /*
     WE ARE TYPING A TEST CASE NOW.
     Given
       https://dummy.restapiexample.com/api/v1/employees
       When
       User sends get request to the Url
       Then
       Status code is 200
       And
       There are 24 employees
       And
       "Tiger Nixon" and "Garret Winters" are among the employees
       And
       The greatest age is 66
       And
       The name of the lowest age is "[Tatyana Fitzpatrick]"
       And
       Total salary of all employees is 6,644,770
     */
    @Test
    public void get01(){
        // 1.STEP: Set the Url
        spec.pathParam("first","employees");

        // 2.STEP: Set the expected data
        // IT DOES NOT ASK US TO CHECK THE WHOLE BODY.SO WE DONT NEED ANY BODY
        //WE ARE JUST GOING TO CHECK THE STATUS.WE ARE GOING TO TAKE THE NUMBER OF EMPLOYEES
        //AND WE ARE GONNA DO SOME MANIPULATIONS INSIDE THE BODY
        // SO HOW DO WE DO IT? WE CAN USE JSON PATH OBJECT

      // 3. STEP Send the request and get the response
       Response response = given().spec(spec).when().get("/{first}/");
       response.prettyPrint();
        // 4.STEP DO ASSERTION
        response.then().assertThat().statusCode(200).body("data.id",hasSize(24),
                "data.employee_name",hasItems("Tiger Nixon","Garret Winters"));

        JsonPath json = response.jsonPath();
        // WE WILL USE GROOVY LANGUAGE FOR FILTERING DATA
        List<Integer> agelist = json.getList("data.findAll{it.employee_age>65}.employee_age");
        System.out.println(agelist);
        Collections.sort(agelist);
        System.out.println("Greatest age is "+ agelist.get(agelist.size()-1));
        assertEquals(66,(int) agelist.get(agelist.size()-1));
       // String nameOfLowestAge = json.getString("data.findAll{it.employee_age==19}.employee_name"); ILK BOYLE YAPTIK AMA HARD CODING
        String nameOfLowestAge = json.getString("data.findAll{it.employee_age=="+agelist.get(0)+"}.employee_name");
        System.out.println(nameOfLowestAge);

        assertEquals("[Tatyana Fitzpatrick]",nameOfLowestAge);
        List<Integer> salaryList = json.getList("data.findAll{it.data}.employee_salary");
        System.out.println(salaryList);
        // FIRST WAY
        int sum= 0;
        for (int w:salaryList){
            sum+=w;
        }
        System.out.println(sum);
        // SECOND WAY
        int sum2 =salaryList.stream().reduce(0,(t,u)->(t+u));
        System.out.println(sum2);
        // THIRD WAY
        int sum3 = salaryList.stream().reduce(0,Math::addExact);
        System.out.println(sum3);

        assertEquals(6644770,sum3);
    }
}
