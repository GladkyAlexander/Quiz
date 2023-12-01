package ru.great_larder.sportquiz.ui.sports;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentSportsBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.NameQuestion;

public class SportsFragment extends Fragment{
    FrameLayout frLayout;
    ImageView imageViewSportz;
    Button btnStartSport;
    FragmentSportsBinding binding;
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SporsViewModel sporsViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SporsViewModel.class);
        binding = FragmentSportsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        frLayout = binding.frLayoutSports;
        imageViewSportz = binding.imageViewSportz;
        btnStartSport = binding.btnStartSport;
        loadFragment(GlobalLinkUser.getUser());
        return root;
    }
    public void loadFragment(User user){
        frLayout.removeAllViews();
        if(user == null){
            setVisibleLayout(true);
            btnStartSport.setOnClickListener(v-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
        } else {
           setVisibleLayout(true);
            btnStartSport.setOnClickListener(v -> openQuestion(NameQuestion.SPORTS));
        }
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void openQuestion(String s){
        setVisibleLayout(false);
        OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
        Bundle bundle = new Bundle();
        bundle.putString("getQuestion", s);
        ofTheGameFragment.setArguments(bundle);
        ofTheGameFragment.setCont(this);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(frLayout.getId(), ofTheGameFragment, null);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    
    private void setVisibleLayout(boolean b) {
        if(b){
            btnStartSport.setVisibility(View.VISIBLE);
            imageViewSportz.setVisibility(View.VISIBLE);
            frLayout.setVisibility(View.GONE);
        } else {
            btnStartSport.setVisibility(View.GONE);
            imageViewSportz.setVisibility(View.GONE);
            frLayout.setVisibility(View.VISIBLE);
        }
    }
}