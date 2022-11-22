package Test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    ///we will create an object to reach the method
    public Map<String,Object> expectedDataWithAllKey(Integer userId, String title, Boolean completed){
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",userId);
        expectedData.put("title",title);
        expectedData.put("completed",completed);


        return expectedData;
    }
    public Map<String,Object> expectedDataWithMissingKey(Integer userId, String title, Boolean completed){
        Map<String,Object> expectedData = new HashMap<>();

        if (userId!=null){
            expectedData.put("userId",userId);
        }
        if (title!=null){
            expectedData.put("title",title);
        }
        if (completed!=null){    //(completed!=null) completed NULL DEGILSE DEMEK
            expectedData.put("completed",completed);
        }

        return expectedData;
    }
     public String expectedDataInString(Integer userId,String title, Boolean completed){
        String expectedData = " {\n" +
                "  \"userId\":"+userId+",\n" +
                " \"title\":\""+title+"\",\n" +
                " \"completed\":"+completed+"\n" +
                "  }";

        return expectedData;

     }

    /*
    Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("title","quis ut nam facilis er officia qui");
        expectedData.put("completed",true); //WE SHOULD NOT USE THE TEST DATA IN TEST BODY. HE USED IT TO SHOW US THE LOGIC
        expectedData.put("StatusCode",200); //MY TEST DATA MUST BE IN ANOTHER CLASS
        expectedData.put("Via","1.1 vegur");
        expectedData.put("Server","cloudflare");
        System.out.println("expectedData: "+ expectedData);

     */






}
