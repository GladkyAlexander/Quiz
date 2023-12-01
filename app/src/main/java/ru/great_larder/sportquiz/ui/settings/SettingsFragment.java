package ru.great_larder.sportquiz.ui.settings;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.databinding.FragmentSettingsBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.CheckNetClass;
import ru.great_larder.sportquiz.services.load.LoadDataFromMySQLForSQLite;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class SettingsFragment extends Fragment {
	private FragmentSettingsBinding binding;
	SettingsViewModel settingsViewModel;
	private Button buttonDone, buttonChangeUser, btn_account_setting, uploadQuestions, btnDatePicker;
	private ImageView imageViewAddImage;
	private TextView textViewLets, textViewCity;
	private EditText editTextTextPersonName, editTextDate;
	private FrameLayout frame_layout_user;
	boolean flagChooseAwatar = false;
	
	public static SettingsFragment newInstance() {
		return new SettingsFragment();
	}
	
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		settingsViewModel =
				new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SettingsViewModel.class);
		
		binding = FragmentSettingsBinding.inflate(inflater, container, false);
		View root = binding.getRoot();
		
		btnDatePicker = binding.btnDate;
		buttonDone = binding.buttonDone;
		buttonChangeUser = binding.buttonChangeUser;
		btn_account_setting = binding.btnAccountSetting;
		uploadQuestions = binding.uploadQuestions;
		
		imageViewAddImage = binding.imageViewaddImage;
		imageViewAddImage.setClickable(true);
		
		textViewLets = binding.textViewLets;
		textViewCity = binding.editTextTextCity;
		
		editTextTextPersonName = binding.editTextTextPersonName;
		editTextDate = binding.pickedDate;
		
		frame_layout_user = binding.frameLayoutUser;
		
		settingsViewModel.getMyUser().observe(getViewLifecycleOwner(), this::loadFragment);
		
		return root;
	}
	
	private void loadFragment(User user) {
		imageViewAddImage.setOnClickListener(d -> loadImage());
		btn_account_setting.setOnClickListener(s ->{
			setVisibleLayout(true);
			if (GlobalLinkUser.getUser() != null) {
				buttonDone.setVisibility(View.GONE);
				buttonChangeUser.setVisibility(View.VISIBLE);
				textViewLets.setText("Внесите изменения");
				editTextTextPersonName.setText(GlobalLinkUser.getUser().getName());
				textViewCity.setText(GlobalLinkUser.getUser().getCity());
				editTextDate.setText(GlobalLinkUser.getUser().getDate_of_birth());
				
				if (GlobalLinkUser.getUser().getAwatar() != null && GlobalLinkUser.getUser().getAwatar().length > 0) {
					imageViewAddImage.setImageBitmap(BitmapFactory.decodeByteArray(GlobalLinkUser.getUser().getAwatar()
							, 0, GlobalLinkUser.getUser().getAwatar().length));
				}
			} else {
				buttonChangeUser.setVisibility(View.GONE);
				buttonDone.setVisibility(View.VISIBLE);
			}
		});
		buttonDone.setOnClickListener(v -> {
			saveUser(settingsViewModel);
			GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(GlobalLinkUser.getUser()));
			//new HideKeyboard(requireActivity(), tableLayoutHi);
			setVisibleLayout(false);
		});
		buttonChangeUser.setOnClickListener(d -> {
			changeUser(settingsViewModel);
			GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(GlobalLinkUser.getUser()));
			//new HideKeyboard(requireActivity(), tableLayoutHi);
			setVisibleLayout(false);
		});
		btnDatePicker.setOnClickListener(f -> callDatePicker());
		
		uploadQuestions.setEnabled(true);
		uploadQuestions.setClickable(true);
		
		uploadQuestions.setOnClickListener(d-> {
			uploadQuestions.setEnabled(false);
			uploadQuestions.setClickable(false);
			if(GlobalLinkUser.getUser() != null) {
				if (new CheckNetClass().getConnectionType(GlobalLinkUser.getMainActivity()) == 0) {
					Toast.makeText(GlobalLinkUser.getMainActivity(), "Нет подключения к интернету!", Toast.LENGTH_LONG).show();
				} else if (new CheckNetClass().getConnectionType(GlobalLinkUser.getMainActivity()) == 1) {
					new CheckNetClass().isInternetAvailable().subscribe((hasInternet) -> {
						if(hasInternet) {
							GlobalLinkUser.getMainActivity().getProgressBar().setIndeterminate(true);
							new LoadDataFromMySQLForSQLite().load(GlobalLinkUser.getUser(), GlobalLinkUser.getMainActivity()
									, GlobalLinkUser.getMainActivity().getProgressBar());
						}else {
							Toast.makeText(GlobalLinkUser.getMainActivity(), "Проверьте подключение к интернету!", Toast.LENGTH_LONG).show();
						}
					});
				} else if (new CheckNetClass().getConnectionType(GlobalLinkUser.getMainActivity()) == 2) {
					new CheckNetClass().isInternetAvailable().subscribe((hasInternet) -> {
						if(hasInternet) {
							GlobalLinkUser.getMainActivity().getProgressBar().setIndeterminate(true);
							new LoadDataFromMySQLForSQLite().load(GlobalLinkUser.getUser(), GlobalLinkUser.getMainActivity()
									, GlobalLinkUser.getMainActivity().getProgressBar());
						}else {
							Toast.makeText(GlobalLinkUser.getMainActivity(), "Проверьте подключение к интернету!", Toast.LENGTH_LONG).show();
						}
					});
				}
			} else Toast.makeText(GlobalLinkUser.getMainActivity(), "Зарегистрируйтесь", Toast.LENGTH_LONG).show();
		});
	}
	
	ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
			uri -> {
				flagChooseAwatar = true;
				imageViewAddImage.setImageURI(uri);
			});
	private void loadImage() {
		mGetContent.launch("image/*");
	}
	private void saveUser(SettingsViewModel settingsViewModel){
		User userRecord = new User();
		userRecord.setName(String.valueOf(editTextTextPersonName.getText()));
		userRecord.setCity(String.valueOf(textViewCity.getText()));
		userRecord.setGlasses(0);
		userRecord.setThemeInstalledNow(0);
		userRecord.setDate_of_birth(String.valueOf(editTextDate.getText()));
		userRecord.setLastName("");
		System.out.println("---------------------------------------------------" + flagChooseAwatar);
		if(flagChooseAwatar){
			Bitmap bitmap = ((BitmapDrawable) imageViewAddImage.getDrawable()).getBitmap();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
			userRecord.setAwatar(stream.toByteArray());
		} else {
			imageViewAddImage.setImageResource(R.drawable.cheat_sheet);
			Bitmap bitmap = ((BitmapDrawable) imageViewAddImage.getDrawable()).getBitmap();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
			userRecord.setAwatar(stream.toByteArray());
		}
		
		settingsViewModel.saveUser(userRecord);
	}
	private void changeUser(SettingsViewModel settingsViewModel){
		GlobalLinkUser.getUser().setName(String.valueOf(editTextTextPersonName.getText()));
		GlobalLinkUser.getUser().setCity(String.valueOf(textViewCity.getText()));
		GlobalLinkUser.getUser().setGlasses(GlobalLinkUser.getUser().getGlasses());
		GlobalLinkUser.getUser().setThemeInstalledNow(GlobalLinkUser.getUser().getThemeInstalledNow());
		GlobalLinkUser.getUser().setDate_of_birth(String.valueOf(editTextDate.getText()));
		GlobalLinkUser.getUser().setLastName("");
		
		Bitmap bitmap = ((BitmapDrawable) imageViewAddImage.getDrawable()).getBitmap();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
		
		GlobalLinkUser.getUser().setAwatar(stream.toByteArray());
		settingsViewModel.changeUser(GlobalLinkUser.getUser());
	}
	private void callDatePicker() {
		// получаем текущую дату
		final Calendar cal = Calendar.getInstance();
		int mYear = cal.get(Calendar.YEAR);
		int mMonth = cal.get(Calendar.MONTH);
		int mDay = cal.get(Calendar.DAY_OF_MONTH);
		
		// инициализируем диалог выбора даты текущими значениями
		DatePickerDialog datePickerDialog = new DatePickerDialog(requireActivity(),
				(view, year, monthOfYear, dayOfMonth) -> {
					String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
					editTextDate.setText(editTextDateParam);
				}, mYear, mMonth, mDay);
		datePickerDialog.show();
	}
	private void setVisibleLayout(boolean def){
		if(def) {
			frame_layout_user.setVisibility(View.VISIBLE);
			btn_account_setting.setVisibility(View.GONE);
			uploadQuestions.setVisibility(View.GONE);
		} else {
			frame_layout_user.setVisibility(View.GONE);
			btn_account_setting.setVisibility(View.VISIBLE);
			uploadQuestions.setVisibility(View.VISIBLE);
		}
	}
}