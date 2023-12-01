package ru.great_larder.sportquiz.ui.settings;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.StartAppData;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.DatabaseAdapterUserSQLite;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

import java.util.List;

public class SettingsViewModel extends ViewModel {
	private final MutableLiveData<User> mUser;
	
	public SettingsViewModel() {
		mUser = new MutableLiveData<>();
		mUser.setValue(loadUser());
	}
	public MutableLiveData<User> getMyUser() {
		return mUser;
	}
	public void changeUser(User user) {
		DatabaseAdapterUserSQLite adapter = new DatabaseAdapterUserSQLite(GlobalLinkUser.getMainActivity());
		adapter.open();
		long idUs = adapter.update(user);
		adapter.close();
		adapter.open();
		adapter.getUserById(idUs);
		adapter.close();
		mUser.setValue(loadUser());
		GlobalLinkUser.setUser(mUser.getValue());
		GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(mUser.getValue()));
	}
	public User loadUser() {
		List<User> users;
		DatabaseAdapterUserSQLite adapter = new DatabaseAdapterUserSQLite(GlobalLinkUser.getMainActivity());
		adapter.open();
		users = adapter.getUsers();
		adapter.close();
		StartAppData startAppData = new StartAppData();
		startAppData.loadData(GlobalLinkUser.getMainActivity());
		if (!users.isEmpty()) {
			return users.get(0);
		} else return null;
	}
	public void saveUser(User userRecord) {
		DatabaseAdapterUserSQLite adapter = new DatabaseAdapterUserSQLite(GlobalLinkUser.getMainActivity());
		adapter.open();
		long idUs = adapter.insert(userRecord);
		adapter.close();
		adapter.open();
		adapter.getUserById(idUs);
		adapter.close();
		mUser.setValue(loadUser());
		GlobalLinkUser.setUser(mUser.getValue());
		GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(mUser.getValue()));
	}
	// TODO: Implement the ViewModel
}