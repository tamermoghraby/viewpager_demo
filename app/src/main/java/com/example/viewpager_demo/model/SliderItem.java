package com.example.viewpager_demo.model;

public class SliderItem {
    private String image;
    private double price;
    private int validity;
    private double data;
    private boolean isBestSeller = false;
    private boolean hasRewards = false;
    private boolean hasWelcomeData = false;
    private String[] rewardsImages;

    public SliderItem(String image, double price, int validity, double data, boolean isBestSeller, boolean hasRewards, boolean hasWelcomeData, String[] rewardsImages) {
        this.image = image;
        this.price = price;
        this.validity = validity;
        this.data = data;
        this.isBestSeller = isBestSeller;
        this.hasRewards = hasRewards;
        this.hasWelcomeData = hasWelcomeData;
        this.rewardsImages = rewardsImages;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        isBestSeller = bestSeller;
    }

    public boolean hasRewards() {
        return hasRewards;
    }

    public void setHasRewards(boolean hasRewards) {
        this.hasRewards = hasRewards;
    }

    public String[] getRewardsImages() {
        return rewardsImages;
    }

    public void setRewardsImages(String[] rewardsImages) {
        this.rewardsImages = rewardsImages;
    }

    public boolean hasHasWelcomeData() {
        return hasWelcomeData;
    }

    public void setHasWelcomeData(boolean hasWelcomeData) {
        this.hasWelcomeData = hasWelcomeData;
    }
}
