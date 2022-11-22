package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestResponseBodyPojo {
      /*
1)Create private variables for every key
2) create a constructor with all parameters, and without any parameters
3) create getters and setters
4) create toString() method
 */

   //1)Create private variables for every key
    // meta data type can be any non primitive data type.but it is null so I dont know what it might be so
    //to cover all the character and data type it will be object
    private Object meta;
    private GoRestDataPojo data;

 //2) create a constructor with all parameters, and without any parameters

    public GoRestResponseBodyPojo(Object meta, GoRestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public GoRestResponseBodyPojo() {
    }
//3) create getters and setters

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojo data) {
        this.data = data;
    }


    //4) create toString() method


    @Override
    public String toString() {
        return "GoRestResponseBodyPojo{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
