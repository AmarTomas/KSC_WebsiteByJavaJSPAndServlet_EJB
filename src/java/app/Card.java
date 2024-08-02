package app;

import java.sql.Blob;
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MC
 */

public class Card {
    private int id;
    private String name;
     private String image;
    private String date_time;
    private String fees_details;
    private String email;
     private String Location;
    private String Terms_Conditions;

    public Card(int id, String name, String image, String date_time, String fees_details, String email, String Location, String Terms_Conditions) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.date_time = date_time;
        this.fees_details = fees_details;
        this.email = email;
        this.Location = Location;
        this.Terms_Conditions = Terms_Conditions;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

   

    public Card() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getFees_details() {
        return fees_details;
    }

    public void setFees_details(String fees_details) {
        this.fees_details = fees_details;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTerms_Conditions() {
        return Terms_Conditions;
    }

    public void setTerms_Conditions(String Terms_Conditions) {
        this.Terms_Conditions = Terms_Conditions;
    }

   

   
  


    
    
}