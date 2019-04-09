package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Feedback {
    private int id ;
    private String description;
    private int status;
    private HashMap<String , ArrayList<String>> errors;


    public Feedback(String description) {
        this.description = description;
    }
    public Feedback(String description , int status) {
        this.description = description;
        this.status = status;
    }

    public Feedback(int id, String des) {
        this.id = id;
        this.description = des;
    }

    public Feedback() {

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isValid(){
        validate();
        return this.errors.size()==0;
    }

    public void validate(){
        if (this.errors ==null){
            this.errors = new HashMap<>();
        }
        ArrayList<String> errorUser = this.errors.get("description");
        if (errorUser == null){
            errorUser = new ArrayList<>();
        }
        if (this.description == null || this.description.length() == 0){
            errorUser.add("description is required");
        }else if (this.description.length()<2 || this.description.length()>30){
            errorUser.add("description is length 2-30");
        }
        if (errorUser.size()>0 ){
            this.errors.put("username", errorUser);
        }

    }
    public HashMap<String,ArrayList<String>> getErrors(){
        return this.errors;
    }


}
