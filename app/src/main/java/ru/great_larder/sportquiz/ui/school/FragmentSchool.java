package ru.great_larder.sportquiz.ui.school;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentSchoolBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.NameQuestion;

import java.util.ArrayList;

public class FragmentSchool extends Fragment {
    
    private LinearLayout linearLayout1, linearLayout2, linearLayout3;
    private FrameLayout frameLayoutShool;
    private ImageButton button_biolog, button_geografik, button_history, button_physics, button_mathematics, button_social_studies;
    FragmentSchoolBinding binding;
    ArrayList<ImageButton> imageButtonArrayList = new ArrayList<>();
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        binding = FragmentSchoolBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        imageButtonArrayList.add(button_biolog = binding.buttonBiolog);
        imageButtonArrayList.add(button_geografik = binding.buttonGeografik);
        imageButtonArrayList.add(button_history = binding.buttonHistory);
        imageButtonArrayList.add(button_physics = binding.buttonPhysics);
        imageButtonArrayList.add(button_mathematics = binding.buttonMathematics);
        imageButtonArrayList.add(button_social_studies = binding.buttonSocialStudies);
        
        linearLayout1 = binding.linearLayout1;
        linearLayout2 = binding.linearLayout2;
        linearLayout3 = binding.linearLayout3;
        
        frameLayoutShool = binding.frameLayoutShool;
        loadFragment(GlobalLinkUser.getUser());
        
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            setVisibleLayout(true);
            for (ImageButton imageButton : imageButtonArrayList){setClickButton(imageButton);}
        } else {
            setVisibleLayout(true);
            
            button_biolog.setOnClickListener(a-> openQuestion(NameQuestion.BIOLOGY));
            button_history.setOnClickListener(a-> openQuestion(NameQuestion.HISTORY));
            button_geografik.setOnClickListener(a-> openQuestion(NameQuestion.GEOGRAPHY));
            button_physics.setOnClickListener(a-> openQuestion(NameQuestion.PHYSICS));
            button_mathematics.setOnClickListener(a-> openQuestion(NameQuestion.MATHEMATICS));
            button_social_studies.setOnClickListener(a-> openQuestion(NameQuestion.SOCIAL_STUDIES));
        }
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void setVisibleLayout(boolean def){
        if(def){
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.VISIBLE);
            linearLayout3.setVisibility(View.VISIBLE);
            frameLayoutShool.setVisibility(View.GONE);
        } else {
            linearLayout1.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.GONE);
            linearLayout3.setVisibility(View.GONE);
            frameLayoutShool.setVisibility(View.VISIBLE);
        }
    }
    private void setClickButton(ImageButton button){
        button.setOnClickListener(a -> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
    }
    private void openQuestion(String q){
        setVisibleLayout(false);
        OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
        
        Bundle bundle = new Bundle();
        bundle.putString("getQuestion", q);
        ofTheGameFragment.setArguments(bundle);
        ofTheGameFragment.setCont(this);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(frameLayoutShool.getId(), ofTheGameFragment);
        
        transaction.addToBackStack(null);
        transaction.commit();
    }
}