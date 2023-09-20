package ru.great_larder.sportquiz.ui.traffic_laws;

import android.os.Bundle;
import android.widget.*;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentTrafficLawsBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;

public class FragmentTrafficLaws extends Fragment {
    
    FrameLayout frameLayoutTrafficLaws;
    ImageView imageViewPdd;
    Button btnStartPdd;
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTrafficLawsBinding binding = FragmentTrafficLawsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        frameLayoutTrafficLaws = binding.frameLayoutTrafficLaws;
        imageViewPdd = binding.imageViewPdd;
        btnStartPdd = binding.btnStartPdd;
        loadFragment(GlobalLinkUser.getUser());
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            imageViewPdd.setVisibility(View.VISIBLE);
            btnStartPdd.setVisibility(View.GONE);
            Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show();
        } else {
            imageViewPdd.setVisibility(View.VISIBLE);
            btnStartPdd.setVisibility(View.VISIBLE);
        }
        btnStartPdd.setOnClickListener(v ->{
            imageViewPdd.setVisibility(View.GONE);
            btnStartPdd.setVisibility(View.GONE);
            frameLayoutTrafficLaws.setVisibility(View.VISIBLE);
            OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
            Bundle bundle = new Bundle();
            bundle.putString("getQuestion", "Traffic Laws");
            ofTheGameFragment.setArguments(bundle);
            ofTheGameFragment.setCont(this);
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(frameLayoutTrafficLaws.getId(), ofTheGameFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }
}