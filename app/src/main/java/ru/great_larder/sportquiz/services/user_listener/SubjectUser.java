package ru.great_larder.sportquiz.services.user_listener;

import java.util.Set;

public interface SubjectUser {
    void registerObserverUser(ObserverUser observerUser);
    void unregisterObserverUser(ObserverUser observerUser);
    void notifyObserversUser();
    void clear();
    Set<ObserverUser> getOU();
}
