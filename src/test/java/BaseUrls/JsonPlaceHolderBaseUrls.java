package BaseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrls {

    protected RequestSpecification spec;
    // IF YOU USE @Before annotation at the top a method, it will be executed before every test method
    @Before
    public void setup(){

       spec= new RequestSpecBuilder().setBaseUri( "https://jsonplaceholder.typicode.com").build();

    }
   // https://jsonplaceholder.typicode.com
}
