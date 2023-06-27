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
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentLanguageQuizBinding;


public class LanguageQuizFragment extends Fragment {
    private LinearLayout linearLayoutButtonRuEn;
    private FrameLayout frameLayoutLanguage;
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LanguageQuizFragmentViewModel languageQuizFragmentViewModel = new ViewModelProvider(this, new ViewModelProvider
                .NewInstanceFactory()).get(LanguageQuizFragmentViewModel.class);
        FragmentLanguageQuizBinding binding = FragmentLanguageQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        ImageButton button_language_ru = binding.buttonLanguageRu;
        ImageButton button_language_en = binding.button2LanguageEn;
        
        linearLayoutButtonRuEn = binding.linearLayoutButtonRuEn;
        
        frameLayoutLanguage = binding.frameLayoutLanguage;
        
        button_language_en.setOnClickListener(b->{
            linearLayoutButtonRuEn.setVisibility(View.GONE);
            frameLayoutLanguage.setVisibility(View.VISIBLE);
            OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
            
            Bundle bundle = new Bundle();
            bundle.putString("getGuestion", "English language");
            ofTheGameFragment.setArguments(bundle);
            
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
            bundle.putString("getGuestion", "Russian language");
            ofTheGameFragment.setArguments(bundle);
            
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(frameLayoutLanguage.getId(), ofTheGameFragment);
            
            transaction.addToBackStack(null);
            transaction.commit();
        });
       
        return root;
    }
}