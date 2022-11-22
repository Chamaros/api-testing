package BaseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseUrl {
    protected RequestSpecification spec;
    // IF YOU USE @Before annotation at the top a method, it will be executed before every test method
    @Before
    public void setup(){

        spec= new RequestSpecBuilder().setBaseUri( "https://restful-booker.herokuapp.com/booking").build();


    //https://restful-booker.herokuapp.com/booking
}
}