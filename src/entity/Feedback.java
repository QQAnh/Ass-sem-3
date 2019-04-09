package entity;

public class Feedback {
    private int id ;
    private String description;
    private int status;

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


}
