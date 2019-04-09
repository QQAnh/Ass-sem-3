package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    private int id;
    private String username;
    private String password;
    private int role;
    private HashMap<String , ArrayList<String>> errors;

    public Account(String username, String password ,int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Account(String username) {
    }

    public Account() {

    }

    public Account(String username, int role) {
        this.username = username;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int  role) {
        this.role = role;
    }

    public boolean isValid(){
        validate();
        return this.errors.size()==0;
    }

    public void validate(){
        if (this.errors ==null){
            this.errors = new HashMap<>();
        }
        ArrayList<String> errorUser = this.errors.get("username");
        if (errorUser == null){
            errorUser = new ArrayList<>();
        }
        if (this.username == null || this.username.length() == 0){
            errorUser.add("Username is required");
        }else if (this.username.length()<2 || this.username.length()>30){
            errorUser.add("username is length 2-30");
        }
        ArrayList<String> errPass = this.errors.get("password");
        if (errPass == null){
            errPass = new ArrayList<>();
        }
        if (this.password == null || this.password.length() ==0){
            errPass.add("Password is required");

        }else if (this.password.length()<2 || this.password.length() > 30){
            errPass.add("Password is length 2-30");
        }
        if (errorUser.size()>0 ){
            this.errors.put("username", errorUser);
            this.errors.put("password" , errPass);
        }

    }
    public HashMap<String,ArrayList<String>> getErrors(){
        return this.errors;
    }
}
