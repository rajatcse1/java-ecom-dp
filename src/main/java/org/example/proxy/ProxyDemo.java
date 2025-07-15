package org.example.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println(ProxyDemo.class.getSimpleName());
        ProxyImage proxyImage1 = new ProxyImage("image1.jpg");


        try {
            for (int i = 0; i < 5; i++) {
                proxyImage1.display();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        proxyImage1.shutdownExecutor();
    }
}
