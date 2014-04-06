package com.example.beaconv2;
 
public class Contact {
     
    //private variables
    int _id;
    String _name;
    String _description;
    int _end;
    float _lon;
    float _lat;
     
    // Empty constructor
    public Contact(){
         
    }
    // constructor
    public Contact(int id, String name, int _end, float _lon, float _lat, String _description){
        this._id = id;
        this._name = name;
        this._end = _end;
        this._lon = _lon;
        this._lat = _lat;
        this._description = _description;
    }
     
    // constructor
    public Contact(String name, int _end, float _lon, float _lat, String _description){
        this._name = name;
        this._end = _end;
        this._lon = _lon;
        this._lat = _lat;
        this._description= _description;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
     
    // setting id
    public void setID(int id){
        this._id = id;
    }
     
    // getting name
    public String getName(){
        return this._name;
    }
     
    // setting name
    public void setName(String name){
        this._name = name;
    }
     
    // getting phone number
    public int getEnd(){
        return this._end;
    }
     
    // setting phone number
    public void setEnd(int end){
        this._end = end;
    }
    
    public float getLon(){
    	return this._lon;
    }
    
    public void setLon(float lon){
    	this._lon = lon;
    }
    
    public float getLat(){
    	return this._lat;
    }
    
    public void setLat(float lat){
    	this._lat = lat;
    }
    public String getDescription(){
        return this._description;
    }
     
    public void setDescription(String description){
        this._description = description;
    }
}
