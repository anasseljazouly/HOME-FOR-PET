package com.example.home_for_pet.fragments;

public class MessagesList {
    private String name,email,LastMessage;
    private int unseenMessages;

    public MessagesList(String name, String email, String lastMessage, int unseenMessages) {
        this.name = name;
        this.email = email;
        LastMessage = lastMessage;
        this.unseenMessages = unseenMessages;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLastMessage() {
        return LastMessage;
    }

    public int getUnseenMessages() {
        return unseenMessages;
    }
}
