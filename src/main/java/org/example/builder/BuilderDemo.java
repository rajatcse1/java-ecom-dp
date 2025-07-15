package org.example.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        // user this pattern we can build the object based on our requied params
        // this can be achieved by overloaded constructors but this is not good
        User user1 = new User.Builder("Rajat", "rajat@gmail.com").build();
        User user2 = new User.Builder("Ghorai", "ghorai@gmail.com").phone(123456789).build();

        System.out.println(user1);
        System.out.println(user2);
    }
}
