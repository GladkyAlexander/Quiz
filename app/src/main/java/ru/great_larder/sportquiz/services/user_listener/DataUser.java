package ru.great_larder.sportquiz.services.user_listener;

import ru.great_larder.sportquiz.domain.User;

public class DataUser {
    private final User user;

    public DataUser(User user) {
        this.user = user;
    }

    public User getUser(){
        return user;
    }

}
