package org.example.proxy;

public class RealImage implements ProductImage{
    private String fileName;
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImage();
    }

    @Override
    public void display() {
        System.out.println(String.format("Display real image : %s", fileName));
    }

    private void loadImage(){
        try {
            System.out.println(String.format("Loading image: %s", fileName));
            Thread.sleep(3000);
            System.out.println(String.format("Loading Completed: %s", fileName));
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
