package com.example.healthservices;

public class GridItem {
    private int imageResource;
    private String itemName;
    private Class<?> destinationClass; // Add this field

    public GridItem(int imageResource, String itemName, Class<?> destinationClass) {
        this.imageResource = imageResource;
        this.itemName = itemName;
        this.destinationClass = destinationClass;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getItemName() {
        return itemName;
    }

    public Class<?> getDestinationClass() {
        return destinationClass;
    }
}
