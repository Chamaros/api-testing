package Test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData  {
    public Map<String,String> bookingdatesSetup(String checkin, String checkout){
        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin",checkin);
        bookingDatesMap.put("checkout",checkout);

        return bookingDatesMap;
    }
    public Map<String,Object> expectedDataSetup(String firstname, String lastname,int totalprice,boolean depositpaid,Map<String,String>bookingdates){
        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname",lastname);
        expectedDataMap.put("totalprice",totalprice);
        expectedDataMap.put("depositpaid",depositpaid);
        expectedDataMap.put("bookingdates",bookingdates);

        return expectedDataMap;
    }









    /*
      "firstname": "John",
              "lastname": "Doe",
              "totalprice": 11111,
              "depositpaid": true,
              "bookingdates": {
        "checkin": "2021-09-09",
                "checkout": "2021-09-21",

     */









}
