package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {
/*
1)Create private variables for every key
2) create a constructor with all parameters, and without any parameters
3) create getters and setters
4) create toString() method
 */
// 1)Create private variables for every key
    private Integer userId;
    private String title;
    private Boolean completed ;
//  2) create a constructor with all parameters, and without any parameters

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }

 //3) create getters and setters

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //4) create toString() method

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
/*
HOW DO WE HANDLE DIFFERENT KEY-VALUES IN RESPONSE BODY?
WE USE @JsonIgnoreProperties(ignoreUnknown = true) AT THE TOP OF THE POJO CLASS
IT COMES FROM "ORG.CODEHAUS.JACKSON.ANNOTATE.JsonIgnoreProperties"
 */







   /*

    {
        "userId":55,
            "title":"Tidy your room",
            "completed":false
    }

 */











}
