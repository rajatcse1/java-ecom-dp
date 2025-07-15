package org.example.builder;

import java.io.Serializable;

public class User {
    //  mandatory
    private final String userName;
    private final String email;
    //  optional
    private final int phone;

    private User(Builder builder){
        this.userName = builder.userName;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public String getUserName(){
        return userName;
    }

    public String getEmail(){
        return email;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString(){
        return """
                User {
                    userName : '%s',
                    email : '%s',
                    phone : '%s',
                }
                """.formatted(userName, email, phone);
    }


    public static class Builder{
        //  mandatory
        private final String userName;
        private final String email;
        //  optional
        private int phone;

        public Builder(String userName, String email) {
            this.userName = userName;
            this.email = email;
        }

        public Builder phone(int phone){
            this.phone = phone;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
