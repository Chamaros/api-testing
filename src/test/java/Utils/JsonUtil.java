package Utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    private static ObjectMapper mapper; // it should not be interface it should be a class.
    // otherwise you can not  create an object from an interface

    // I do not want to create object for using this method for this interface
    // I will make it static to make it common for all classes
    // making it private for privacy
    // I WIll initialize it later

    static {   //static block. what does it do? it is working before every other code in the class
        mapper = new ObjectMapper(); // I WILL USE THIS IN OUR TEST
        //OBJECT MAPPER WILL DO THAT CONVERT PROCESS
    }

    //1.METHOD: This method will convert Json Data to Java Object (de-serialization)

    public static  <T> T     convertJsonToJavaObject(String json,Class<T>cls){  // this is called GENERIC METHOD
        // object is general and slow.
        // T means data type (any data type)
       T javaResult = null;
        try {
            javaResult = mapper.readValue(json,cls);// this will convert our json to any class I declare
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaResult;
    }
    //2.method THIS METHOD WILL CONVERT JAVA OBJECT TO JSON DATA (SERIALIZATION)
    public static String  convertJavaObjectToJson(Object obj) { // YOU CAN NOT USE JSON DATA DIRECTLY IN JAVA LANGUAGE
        String jsonResult =null;

        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) { // HOCANINKINDE catch (IOException e) oldu.
            e.printStackTrace();
        }
        return jsonResult;
    }
}
