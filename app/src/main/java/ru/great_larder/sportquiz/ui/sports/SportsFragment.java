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
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentSportsBinding;

public class SportsFragment extends Fragment {
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SporsViewModel sporsViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SporsViewModel.class);
        FragmentSportsBinding binding = FragmentSportsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        FrameLayout frLayout = binding.frLayoutSports;
        
        OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
        
        Bundle bundle = new Bundle();
        bundle.putString("getGuestion", "Sports");
        ofTheGameFragment.setArguments(bundle);
        
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(frLayout.getId(), ofTheGameFragment);
        
        transaction.addToBackStack(null);
        transaction.commit();
        
        return root;
    }

}