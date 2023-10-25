package ru.great_larder.sportquiz.ui.language_quiz;

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
import ru.great_larder.sportquiz.databinding.FragmentLanguageQuizBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;


public class LanguageQuizFragment extends Fragment {
    private LinearLayout linearLayoutButtonRuEn;
    private FrameLayout frameLayoutLanguage;
    private ImageButton button_language_ru, button_language_en;
    FragmentLanguageQuizBinding binding;
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LanguageQuizFragmentViewModel languageQuizFragmentViewModel = new ViewModelProvider(this, new ViewModelProvider
                .NewInstanceFactory()).get(LanguageQuizFragmentViewModel.class);
        binding = FragmentLanguageQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        button_language_ru = binding.buttonLanguageRu;
        button_language_en = binding.button2LanguageEn;
        
        linearLayoutButtonRuEn = binding.linearLayoutButtonRuEn;
        
        frameLayoutLanguage = binding.frameLayoutLanguage;
        loadFragment(GlobalLinkUser.getUser());
  
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            linearLayoutButtonRuEn.setVisibility(View.VISIBLE);
            frameLayoutLanguage.setVisibility(View.GONE);
            button_language_en.setOnClickListener(b-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
            
            button_language_ru.setOnClickListener(g-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
        } else {
            linearLayoutButtonRuEn.setVisibility(View.VISIBLE);
            frameLayoutLanguage.setVisibility(View.GONE);
            button_language_en.setOnClickListener(b->{
                linearLayoutButtonRuEn.setVisibility(View.GONE);
                frameLayoutLanguage.setVisibility(View.VISIBLE);
                OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
                Bundle bundle = new Bundle();
                bundle.putString("getQuestion", "English language");
                ofTheGameFragment.setArguments(bundle);
                ofTheGameFragment.setCont(this);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(frameLayoutLanguage.getId(), ofTheGameFragment);
                
                transaction.addToBackStack(null);
                transaction.commit();
                
            });
            
            button_language_ru.setOnClickListener(g->{
                linearLayoutButtonRuEn.setVisibility(View.GONE);
                frameLayoutLanguage.setVisibility(View.VISIBLE);
                OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
                
                Bundle bundle = new Bundle();
                bundle.putString("getQuestion", "Russian language");
                ofTheGameFragment.setArguments(bundle);
                ofTheGameFragment.setCont(this);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(frameLayoutLanguage.getId(), ofTheGameFragment);
                
                transaction.addToBackStack(null);
                transaction.commit();
            });
        }
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}