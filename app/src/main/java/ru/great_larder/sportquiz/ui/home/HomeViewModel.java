package ru.great_larder.sportquiz.ui.home;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.StartAppData;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.DatabaseAdapterUserSQLite;
import ru.great_larder.sportquiz.domain.User;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    private final MutableLiveData<User> mUser;
    
    public MutableLiveData<User> getmUser() {
        return mUser;
    }
    
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        mUser = new MutableLiveData<>();
        mUser.setValue(loadUser());
    }
    
    public LiveData<String> getText() {
        return mText;
    }
    public User loadUser() {
        List<User> users;
        DatabaseAdapterUserSQLite adapter = new DatabaseAdapterUserSQLite(GlobalLinkUser.getMainActivity());
        adapter.open();
        users = adapter.getUsers();
        adapter.close();
        if (!users.isEmpty()) {
            mUser.setValue(users.get(0));
            return users.get(0);
        } else return null;
    }
    
    public void loadDate() {
        StartAppData startAppData = new StartAppData();
        startAppData.loadData(GlobalLinkUser.getMainActivity());
    }
}