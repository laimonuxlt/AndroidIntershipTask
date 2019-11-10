package com.example.vismaintership;


//class for data we want to use from JSON file.
//in this case we are given array of  web links to image file, but that's all we need
public class DogsInfo {
   String dogImgLink;

    public DogsInfo(String dogImgLink) {
        this.dogImgLink = dogImgLink;
    }

    public String getDogImgLink() {
        return dogImgLink;
    }

    public void setDogImgLink(String dogImgLink) {
        this.dogImgLink = dogImgLink;
    }
}
