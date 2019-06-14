package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Phone {
    private int id;
    private String name;
    private String brand;
    private String price;
    private String description;
    private HashMap<String, ArrayList<String>> errors;


    public Phone() {
    }

    public Phone(String name, String brand, String price, String description) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public Phone(int id, String name, String brand, String price, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValid() {
        validate();
        return this.errors.size() == 0;
    }

    public void validate() {
        if (this.errors == null) {
            this.errors = new HashMap<>();
        }
        ArrayList<String> errorName = this.errors.get("name");
        if (errorName == null) {
            errorName = new ArrayList<>();
        }
        if (this.name == null || this.name.length() == 0) {
            errorName.add("Name is required");
        } else if (this.name.length() < 2 || this.name.length() > 30) {
            errorName.add("Name is length 2-30");
        }
        ArrayList<String> errorDes = this.errors.get("description");
        if (errorDes == null) {
            errorDes = new ArrayList<>();
        }
        if (this.description == null || this.description.length() == 0) {
            errorDes.add("Description is required");
        } else if (this.description.length() < 2 || this.description.length() > 30) {
            errorDes.add("Description is length 2-30");
        }
        ArrayList<String> errPrice = this.errors.get("price");
        if (errPrice == null) {
            errPrice = new ArrayList<>();
        }
        if (this.price == null || this.price.length() == 0) {
            errPrice.add("Price is required");

        }
        if (errorName.size() > 0) {
            this.errors.put("name", errorName);
            this.errors.put("description", errorDes);
            this.errors.put("price", errPrice);
        }

    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return this.errors;
    }

}
