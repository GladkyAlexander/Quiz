package ru.great_larder.sportquiz.ui.home;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.*;
import ru.great_larder.sportquiz.database.DatabaseAdapter;

import ru.great_larder.sportquiz.database.PuzzleDatabaseAdapter;
import ru.great_larder.sportquiz.databinding.FragmentHomeBinding;
import ru.great_larder.sportquiz.domain.Puzzle;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment{
    
    private FragmentHomeBinding binding;
    private TableLayout tableLayoutHi;
    private EditText editTextTextPersonName;
    private TextView textViewNameUser, textViewGlasses, textViewLets, textViewCity;
    private LinearLayout linearLayoutHello, linearLayoutGlasses, fra;
    private Button buttonDone;
    private ImageView imageViewSettings;
    private User user;
    DatabaseAdapter adapter;
    
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        
        HomeViewModel homeViewModel =
            new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        adapter = new DatabaseAdapter(requireActivity());
        
        buttonDone = binding.buttonDone;
        imageViewSettings = binding.imageViewSettings;
        imageViewSettings.setClickable(true);
        
        linearLayoutHello = binding.linearLayoutHello;
        linearLayoutGlasses = binding.linearLayoutGlasses;
        fra = binding.fra;
        
        textViewNameUser = binding.textViewNameUser;
        textViewGlasses = binding.textViewGlasse;
        textViewLets = binding.textViewLets;
        textViewCity = binding.editTextTextCity;
        
        editTextTextPersonName = binding.editTextTextPersonName;

        tableLayoutHi = binding.tableLayoutHi;
        
        user = GlobalLinkUser.getUser();
        if(user == null){
            tableLayoutHi.setVisibility(View.VISIBLE);
            loadFragment(null);
        } else {
            tableLayoutHi.setVisibility(View.GONE);
            loadFragment(GlobalLinkUser.getUser());
        }
        buttonDone.setOnClickListener(v -> {
            
            if(user == null) {
                adapter.open();
                long idUs = adapter.insert(new User(editTextTextPersonName.getText().toString(), textViewCity.getText().toString(), 0,0));
                adapter.close();
                adapter.open();
                User user = adapter.getUserById(idUs);
                adapter.close();
                GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(user));
                GlobalLinkUser.setUser(user);
                loadFragment(user);
            } else {
                adapter.open();
                user.setName(editTextTextPersonName.getText().toString());
                user.setCity(textViewCity.getText().toString());
                long idUs = adapter.insert(user);
                adapter.close();
                adapter.open();
                User user = adapter.getUserById(idUs);
                adapter.close();
                GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(user));
                GlobalLinkUser.setUser(user);
                loadFragment(user);
            }
        });
        imageViewSettings.setOnClickListener(d ->{
            if(tableLayoutHi.getVisibility() == View.VISIBLE){
                tableLayoutHi.setVisibility(View.GONE);
            } else {
                tableLayoutHi.setVisibility(View.VISIBLE);
                if(user != null) {
                    tableLayoutHi.setVisibility(View.VISIBLE);
                    textViewLets.setText("Внесите изменения");
                    editTextTextPersonName.setText(user.getName());
                    textViewCity.setText(user.getCity());
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
   
    private void loadFragment(User u){
        if(u == null) {
            tableLayoutHi.setVisibility(View.VISIBLE);
            linearLayoutHello.setVisibility(View.GONE);
            linearLayoutGlasses.setVisibility(View.GONE);
        } else {
            tableLayoutHi.setVisibility(View.GONE);
            linearLayoutHello.setVisibility(View.VISIBLE);
            linearLayoutGlasses.setVisibility(View.VISIBLE);
            textViewNameUser.setText(u.getName());
            textViewGlasses.setText(String.valueOf(u.getGlasses()));
        }
    }
    
}