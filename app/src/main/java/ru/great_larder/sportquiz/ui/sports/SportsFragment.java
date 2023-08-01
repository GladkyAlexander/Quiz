package ru.great_larder.sportquiz.ui.sports;

import android.os.Bundle;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentSportsBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;

public class SportsFragment extends Fragment{
    FrameLayout frLayout;
    ImageView imageViewSportz;
    Button btnStartSport;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SporsViewModel sporsViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SporsViewModel.class);
        FragmentSportsBinding binding = FragmentSportsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        frLayout = binding.frLayoutSports;
        imageViewSportz = binding.imageViewSportz;
        btnStartSport = binding.btnStartSport;
        loadFragment(GlobalLinkUser.getUser());
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            btnStartSport.setVisibility(View.GONE);
            imageViewSportz.setVisibility(View.VISIBLE);
            Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show();
        } else {
            btnStartSport.setVisibility(View.VISIBLE);
            imageViewSportz.setVisibility(View.VISIBLE);
        }
        btnStartSport.setOnClickListener(v ->{
            btnStartSport.setVisibility(View.GONE);
            imageViewSportz.setVisibility(View.GONE);
            OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
            Bundle bundle = new Bundle();
            bundle.putString("getGuestion", "Sports");
            ofTheGameFragment.setArguments(bundle);
            ofTheGameFragment.setCont(this);
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(frLayout.getId(), ofTheGameFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }
}