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

import ru.great_larder.sportquiz.databinding.FragmentHomeBinding;
import ru.great_larder.sportquiz.domain.Fon;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

import java.util.ArrayList;

public class HomeFragment extends Fragment{
    
    private FragmentHomeBinding binding;
    private TableLayout tableLayoutHi;
    private EditText editTextTextPersonName;
    private TextView textViewNameUser, textViewGlasses/*, textViewNumberOfTopics*/;
    private LinearLayout linearLayoutHello, linearLayoutGlasses, /*llNumberTheme,*/ fra;
    private Button buttonDone;
    private User user;
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        
        HomeViewModel homeViewModel =
            new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        buttonDone = binding.buttonDone;

        
        linearLayoutHello = binding.linearLayoutHello;
        linearLayoutGlasses = binding.linearLayoutGlasses;
        fra = binding.fra;
        
        textViewNameUser = binding.textViewNameUser;
        textViewGlasses = binding.textViewGlasse;
        
        editTextTextPersonName = binding.editTextTextPersonName;

        tableLayoutHi = binding.tableLayoutHi;
        
        user = GlobalLinkUser.getUser();
        
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        if(user == null){
            tableLayoutHi.setVisibility(View.VISIBLE);
            loadFragment(null);
        } else {
            tableLayoutHi.setVisibility(View.GONE);
            loadFragment(GlobalLinkUser.getUser());
        }
        
        buttonDone.setOnClickListener(v -> {
            DatabaseAdapter adapter = new DatabaseAdapter(requireActivity());
            adapter.open();
            long idUs = adapter.insert(new User(editTextTextPersonName.getText().toString(), 0));
            adapter.close();
            adapter.open();
            User user = adapter.getUserById(idUs);
            adapter.close();
            user.setFonList(new ArrayList<>());
            GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(user));
            GlobalLinkUser.setUser(user);
            loadFragment(user);
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
//            llNumberTheme.setVisibility(View.GONE);

        } else {
            tableLayoutHi.setVisibility(View.GONE);
            linearLayoutHello.setVisibility(View.VISIBLE);
            linearLayoutGlasses.setVisibility(View.VISIBLE);
//            llNumberTheme.setVisibility(View.VISIBLE);

            textViewNameUser.setText(u.getName());
            textViewGlasses.setText(String.valueOf(u.getGlasses()));
//            textViewNumberOfTopics.setText(String.valueOf(u.getFonList().size()));
            
            
            /*
            GetFon getFon = new GetFonImpl();
            for (Fon f : getFon.getListFon()){
                carouselList.add(f.getImageI());
            }
                
                img.setOnClickListener(g->{
                    
                    User user = GlobalLinkUser.getUser();
                    user.setThemeInstalledNow(f.getId());
                    DatabaseAdapter databaseAdapter = new DatabaseAdapter(requireActivity());
                    databaseAdapter.open();
                    databaseAdapter.update(user);
                    databaseAdapter.close();
                    GlobalLinkUser.setUser(user);
                    
                    ((MainActivity) requireActivity()).setBackgroundActivity(f.getImageI());
                });
            */
        }
    }
    

}