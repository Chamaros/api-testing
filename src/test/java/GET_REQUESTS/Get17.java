package GET_REQUESTS;

import BaseUrls.DummyRestApiBaseUrl;
import org.testng.annotations.Test;
import pojos.DataPojo;
import pojos.DummyRestApiPojo;

public class Get17 extends DummyRestApiBaseUrl {
    /*
     URL: https://dummy.restapiexample.com/api/v1/employee/1

    HTTP Request Method : GET Request
    Test case: Type by using Gherkin Language
    assert: i) Status code is 200
            ii) employee_name is "Tiger Nixon"
            iii) "employee_salary" is 320800
            iv) "employee_age" is 61
            v) "status" is "success"
            vi) "message" is "Successfully! Record has been fetched."
     *//*
     WE ARE TYPING A TEST CASE NOW.
     Given
       https://dummy.restapiexample.com/api/v1/employee/1
       When
       User sends get request to the Url
       Then
       Status code is 200
       And
       employee_name is "Tiger Nixon"
       And
       "employee_salary" is 320800
       And
       "employee_age" is 61
       And
       "status" is "success"
       And
       "message" is "Successfully! Record has been fetched."
     */
    @Test
    public void get01(){
        // 1.STEP: Set the Url
        spec.pathParams("first","employee","second",1);

        // 2.STEP: Set the expected data
        DataPojo dataPojo = new DataPojo();
        DummyRestApiPojo expectedData = new DummyRestApiPojo();

        // I WILL USE THE BEST WAY. IT IS THE OBJECT MAPPER WITH POJO

        // 3. STEP Send the request and get the response

        // 4.STEP DO ASSERTION
    }

}
