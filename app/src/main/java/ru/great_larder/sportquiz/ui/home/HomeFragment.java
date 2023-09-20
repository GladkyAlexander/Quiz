package ru.great_larder.sportquiz.ui.home;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.*;
import ru.great_larder.sportquiz.database.DatabaseAdapter;
import ru.great_larder.sportquiz.databinding.FragmentHomeBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.GetNamesVictik;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class HomeFragment extends Fragment {
    
    private FragmentHomeBinding binding;
    private LinearLayout tableLayoutHi;
    private EditText editTextTextPersonName, editTextTextLastName;
    private TextView textViewNameUser, textViewGlasses, textViewLets, textViewCity, textFieldVictorinok, textViewSlogan;
    private LinearLayout linearLayoutHello;
    private LinearLayout linearLayoutGlasses;
    private ImageView imageViewAnimCoins;
    private ImageView imgStartDetki;
    private User user;
    DatabaseAdapter adapter;
    
    private Button btnTimePicker, buttonDone, buttonChangeUser;
    private EditText editTextDate, editTextTime;
    ImageView imageViewAddImage;
    boolean flagChooseAwatar = false;
    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
        uri -> {
            // Handle the returned Uri
            flagChooseAwatar = true;
            imageViewAddImage.setImageURI(uri);
        });
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        
        HomeViewModel homeViewModel =
            new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        adapter = new DatabaseAdapter(requireActivity());
        
        buttonDone = binding.buttonDone;
        buttonChangeUser = binding.buttonChangeUser;
        
        ImageView imageViewSettings = binding.imageViewSettings;
        imageViewSettings.setClickable(true);
        imageViewAddImage = binding.imageViewaddImage;
        imageViewAddImage.setClickable(true);
        imageViewAnimCoins = binding.imageViewAnimCoins;
        imgStartDetki = binding.imgStartDetki;
        
        linearLayoutHello = binding.linearLayoutHello;
        linearLayoutGlasses = binding.linearLayoutGlasses;
        LinearLayout fra = binding.fra;
        
        textViewNameUser = binding.textViewNameUser;
        textViewGlasses = binding.textViewGlasse;
        textViewLets = binding.textViewLets;
        textViewCity = binding.editTextTextCity;
        textFieldVictorinok = binding.textFieldVictorinok;
        textViewSlogan = binding.textViewSlogan;
        
        editTextTextPersonName = binding.editTextTextPersonName;
        editTextTextLastName = binding.editTextTextLastName;
        
        tableLayoutHi = binding.tableLayoutHi;
        
        Button btnDatePicker = root.findViewById(R.id.btn_date);
        editTextDate = root.findViewById(R.id.picked_date);
        
        /*
        btnTimePicker = root.findViewById(R.id.btn_time);
        editTextTime = root.findViewById(R.id.picked_time);
        btnTimePicker.setOnClickListener(d -> callTimePicker());
        */
        
        btnDatePicker.setOnClickListener(f -> callDatePicker());
        imageViewAddImage.setOnClickListener(d -> loadImage());
        
        user = GlobalLinkUser.getUser();
     
        loadFragment();
        
        buttonDone.setOnClickListener(v -> {
            user = saveUser();
            GlobalLinkUser.setUser(user);
            GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(user));
            loadFragment();
        });
        buttonChangeUser.setOnClickListener(d ->{
            user = changeUser();
            GlobalLinkUser.setUser(user);
            GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(user));
            loadFragment();
        });
        imageViewSettings.setOnClickListener(d -> openSettings());
        
        return root;
    }
    
    private void loadImage() {
        // Pass in the mime type you want to let the user select
        // Передайте тип mime, который вы хотите, чтобы пользователь мог выбрать.
        // as the input   в качестве входных данных
        
        mGetContent.launch("image/*");
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    
    private void loadFragment() {
        if (user == null) {
            tableLayoutHi.setVisibility(View.VISIBLE);
            linearLayoutHello.setVisibility(View.GONE);
            linearLayoutGlasses.setVisibility(View.GONE);
            imgStartDetki.setVisibility(View.GONE);
            textViewSlogan.setVisibility(View.GONE);
            buttonChangeUser.setVisibility(View.GONE);
            buttonDone.setVisibility(View.VISIBLE);
        } else {
            tableLayoutHi.setVisibility(View.GONE);
            linearLayoutHello.setVisibility(View.VISIBLE);
            linearLayoutGlasses.setVisibility(View.VISIBLE);
            textViewNameUser.setText(user.getName());
            textViewGlasses.setText(String.valueOf(user.getGlasses()));
            textFieldVictorinok.setText(new GetNamesVictik().getVictik(user.getGlasses()));
            imgStartDetki.setVisibility(View.VISIBLE);
            textViewSlogan.setVisibility(View.VISIBLE);
            
            imageViewAnimCoins.setBackgroundResource(R.drawable.animat_home);
            AnimationDrawable frameAnimation = (AnimationDrawable) imageViewAnimCoins.getBackground();
            frameAnimation.setOneShot(true);
            frameAnimation.start();
        }
    }
    
    private void callTimePicker() {
        // получаем текущее время
        final Calendar cal = Calendar.getInstance();
        int mHour = cal.get(Calendar.HOUR_OF_DAY);
        int mMinute = cal.get(Calendar.MINUTE);
        
        // инициализируем диалог выбора времени текущими значениями
        TimePickerDialog timePickerDialog = new TimePickerDialog(requireActivity(),
            (view, hourOfDay, minute) -> {
                String editTextTimeParam = hourOfDay + " : " + minute;
                editTextTime.setText(editTextTimeParam);
            }, mHour, mMinute, false);
        timePickerDialog.show();
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
    
    private User saveUser(){
        
        User userRecord = new User();
        userRecord.setName(String.valueOf(editTextTextPersonName.getText()));
        userRecord.setCity(String.valueOf(textViewCity.getText()));
        userRecord.setGlasses(0);
        userRecord.setThemeInstalledNow(0);
        userRecord.setDate_of_birth(String.valueOf(editTextDate.getText()));
        userRecord.setLastName(String.valueOf(editTextTextLastName.getText()));
        
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
        
        adapter.open();
        long idUs = adapter.insert(userRecord);
        adapter.close();
        adapter.open();
        User userReturn = adapter.getUserById(idUs);
        adapter.close();
        
        return userReturn;
    }
    private User changeUser(){
        
        user.setName(String.valueOf(editTextTextPersonName.getText()));
        user.setCity(String.valueOf(textViewCity.getText()));
        user.setGlasses(0);
        user.setThemeInstalledNow(0);
        user.setDate_of_birth(String.valueOf(editTextDate.getText()));
        user.setLastName(String.valueOf(editTextTextLastName.getText()));
        
        Bitmap bitmap = ((BitmapDrawable) imageViewAddImage.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        
        user.setAwatar(stream.toByteArray());
        
        adapter.open();
        long idUs = adapter.update(user);
        adapter.close();
        adapter.open();
        User userReturn = adapter.getUserById(idUs);
        adapter.close();
        
        return userReturn;
    }
    private void openSettings(){
        
        if (tableLayoutHi.getVisibility() == View.VISIBLE) {
            tableLayoutHi.setVisibility(View.GONE);
        } else {
            tableLayoutHi.setVisibility(View.VISIBLE);
            if (user != null) {
                buttonDone.setVisibility(View.GONE);
                buttonChangeUser.setVisibility(View.VISIBLE);
                
                textViewLets.setText("Внесите изменения");
                editTextTextPersonName.setText(user.getName());
                editTextTextLastName.setText(user.getLastName());
                textViewCity.setText(user.getCity());
                editTextDate.setText(user.getDate_of_birth());
                
                if (user.getAwatar() != null && user.getAwatar().length > 0) {
                    imageViewAddImage.setImageBitmap(BitmapFactory.decodeByteArray(user.getAwatar()
                        , 0, user.getAwatar().length));
                }
            } else {
                buttonChangeUser.setVisibility(View.GONE);
                buttonDone.setVisibility(View.VISIBLE);
            }
        }
        
    }
}