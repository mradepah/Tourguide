package com.example.tourguide;

public class Items {
    //    declaring member variables
    private String mshortItemDescription;
    private String mlongItemDescription;
    private int mItemImage;

    // Constructors
    public Items(int itemImage, String shortItemDescription, String longItemDescription) {

//      assigning constructor variables to member variables
        mshortItemDescription = shortItemDescription;
        mlongItemDescription = longItemDescription;
        mItemImage = itemImage;
    }

    public Items(int itemImage, String shortItemDescription) {

//      assigning constructor variables to member variables
        mshortItemDescription = shortItemDescription;
        mItemImage = itemImage;
    }

    //        Getters
    public String getshortItemDescription() {
        return mshortItemDescription;
    }

    public String getlongItemDescription() {
        return mlongItemDescription;
    }

    public int getItemImage() {
        return mItemImage;
    }


}
