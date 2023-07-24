package ru.great_larder.sportquiz.ui.traffic_laws;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentTrafficLawsBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;

public class FragmentTrafficLaws extends Fragment implements ObserverUser {
    
    FrameLayout frameLayoutTrafficLaws;
    ImageView imageViewPdd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTrafficLawsBinding binding = FragmentTrafficLawsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        frameLayoutTrafficLaws = binding.frameLayoutTrafficLaws;
        imageViewPdd = binding.imageViewPdd;
        GlobalLinkUser.getHandlerUserListener().registerObserverUser(this);
        loadFragment(GlobalLinkUser.getUser());
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            imageViewPdd.setVisibility(View.VISIBLE);
            Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show();
        } else {
            imageViewPdd.setVisibility(View.GONE);
            OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
            Bundle bundle = new Bundle();
            bundle.putString("getGuestion", "Traffic Laws");
            ofTheGameFragment.setArguments(bundle);
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(frameLayoutTrafficLaws.getId(), ofTheGameFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
    
    @Override
    public void updateUser(DataUser dataUser) {
        loadFragment(dataUser.getUser());
    }
}