package ru.great_larder.sportquiz;

import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.HandlerUserListener;

public class GlobalLinkUser {
    public static User user;
    public static HandlerUserListener handlerUserListener;
    
    public static HandlerUserListener getHandlerUserListener() {
        return handlerUserListener;
    }
    
    public static void setHandlerUserListener(HandlerUserListener handlerUserListener) {
        GlobalLinkUser.handlerUserListener = handlerUserListener;
    }
    
    GlobalLinkUser(){
    
    }
    
    public static User getUser(){
        return user;
    }
    public static void setUser(User user){
        GlobalLinkUser.user = user;
    }
}
