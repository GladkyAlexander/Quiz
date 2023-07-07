package ru.great_larder.sportquiz.ui.partners;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.great_larder.sportquiz.R;

public class PartnersFragment extends Fragment {

    public static PartnersFragment newInstance(String param1, String param2) {
        PartnersFragment fragment = new PartnersFragment();
        Bundle args = new Bundle();
      
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_partners, container, false);
    }
}