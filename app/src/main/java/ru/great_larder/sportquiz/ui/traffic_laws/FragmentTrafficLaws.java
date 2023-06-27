package ru.great_larder.sportquiz.ui.traffic_laws;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentTrafficLawsBinding;

public class FragmentTrafficLaws extends Fragment {
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        FragmentTrafficLawsBinding binding = FragmentTrafficLawsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        FrameLayout frameLayoutTrafficLaws = binding.frameLayoutTrafficLaws;
        
        OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
        
        Bundle bundle = new Bundle();
        bundle.putString("getGuestion", "Traffic Laws");
        ofTheGameFragment.setArguments(bundle);
        
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(frameLayoutTrafficLaws.getId(), ofTheGameFragment);
        
        transaction.addToBackStack(null);
        transaction.commit();
        
        return root;
    }
}