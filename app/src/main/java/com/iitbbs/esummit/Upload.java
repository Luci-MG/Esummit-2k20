package com.iitbbs.esummit;

public class Upload {

    private String mName;
    private String mImageUrl;
    private String mDescp;
    private String mPos;

    public Upload(){

    }

    public Upload(String name,String imageUrl,String descp,String pos){
        mName = imageUrl;
        mImageUrl = name;
        mDescp = descp;
        mPos = pos;
    }

    public String getName(){
        return mName;
    }

    public void setName(String name){
        mName = name;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public void setimageUrl(String imageUrl){
        mImageUrl = imageUrl;
    }

    public String getDescp(){
        return mDescp;
    }

    public void setdescp(String descp){
        mDescp = descp;
    }

    public String getPos(){
        return mPos;
    }

    public void setpos(String pos){
        mPos  = pos;
    }

}
