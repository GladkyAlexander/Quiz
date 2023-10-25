package ru.great_larder.sportquiz.ui.home;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ru.great_larder.sportquiz.GlobalLinkUser;

public class HomeViewModel extends ViewModel {
    
    private final MutableLiveData<String> mText;
    
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }
    
    public LiveData<String> getText() {
        return mText;
    }
}