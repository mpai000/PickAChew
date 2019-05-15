package com.example.pickachew.Matches;

public class MatchesObject {
    private String userID;
//    private String name;
//    private String profileImageUrl;
    public MatchesObject (String userID){
        this.userID = userID;
//        this.name = name;
//        this.profileImageUrl = profileImageUrl;
    }

    public String getUserID(){
        return userID;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }

//    public String getName(){
//        return name;
//    }
//    public void setName(String name){
//        this.name = name;
//    }
}
