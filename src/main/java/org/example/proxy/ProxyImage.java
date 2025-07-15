package org.example.proxy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProxyImage implements ProductImage{
    private String fileName;
    private RealImage realImage;
    private Future<RealImage> futureImage;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public ProxyImage(String fileName) {
        this.fileName = fileName;
        this.futureImage = executor.submit(() -> {
            return new RealImage(fileName);
        });
    }

    @Override
    public void display() {
        try {
            if(futureImage.isDone()){
                futureImage.get().display();
            } else{
                System.out.println(String.format("Image is still loading : %s", fileName));
            }
        } catch (Exception e){
            System.out.println("Image load issue");
        }
    }

    public void shutdownExecutor(){
        executor.shutdown();
        System.out.println("Process finished.");
    }
}
