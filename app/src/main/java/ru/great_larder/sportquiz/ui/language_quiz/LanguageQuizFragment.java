package ru.great_larder.sportquiz.ui.language_quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentLanguageQuizBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.NameQuestion;

import java.util.ArrayList;


public class LanguageQuizFragment extends Fragment {
    private LinearLayout linearLayoutButtonRuEn, linearLayoutButtonBA, linearLayoutButtonTatCh;
    private FrameLayout frameLayoutLanguage;
    private ImageButton button_language_ru, button_language_en, button_language_bashkir, button_language_chuvash
            , button_language_tatar, button_language_chechen;
    FragmentLanguageQuizBinding binding;
    ArrayList<ImageButton> imageButtonArrayList = new ArrayList<>();
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LanguageQuizFragmentViewModel languageQuizFragmentViewModel = new ViewModelProvider(this, new ViewModelProvider
                .NewInstanceFactory()).get(LanguageQuizFragmentViewModel.class);
        
        binding = FragmentLanguageQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        imageButtonArrayList.add(button_language_ru = binding.buttonLanguageRu);
        imageButtonArrayList.add(button_language_en = binding.buttonLanguageEn);
        imageButtonArrayList.add(button_language_bashkir = binding.buttonLanguageBashkir);
        imageButtonArrayList.add(button_language_chuvash = binding.buttonLanguageChuvash);
        imageButtonArrayList.add(button_language_chechen = binding.buttonLanguageChechen);
        imageButtonArrayList.add(button_language_tatar = binding.buttonLanguageTatar);
        
        linearLayoutButtonBA = binding.linearLayoutButtonBA;
        linearLayoutButtonRuEn = binding.linearLayoutButtonRuEn;
        linearLayoutButtonTatCh = binding.linearLayoutButtonTatCh;
        
        frameLayoutLanguage = binding.frameLayoutLanguage;
        loadFragment(GlobalLinkUser.getUser());
  
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            setVisibleLayout(true);
            for (ImageButton imageButton : imageButtonArrayList){setClickButton(imageButton);}
        } else {
            setVisibleLayout(true);
            
            button_language_en.setOnClickListener(h-> openQuestion(NameQuestion.ENGLISH_LANGUAGE));
            button_language_ru.setOnClickListener(h-> openQuestion(NameQuestion.RUSSIAN_LANGUAGE));
            button_language_bashkir.setOnClickListener(h -> openQuestion(NameQuestion.BASHKIR_LANGUAGE));
            button_language_chuvash.setOnClickListener(h -> openQuestion(NameQuestion.CHUVASH_LANGUAGE));
            button_language_chechen.setOnClickListener(h -> openQuestion(NameQuestion.CHECHEN_LANGUAGE));
            button_language_tatar.setOnClickListener(h -> openQuestion(NameQuestion.TATAR_LANGUAGE));
        }
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void setVisibleLayout(boolean def){
        if(def) {
            linearLayoutButtonRuEn.setVisibility(View.VISIBLE);
            linearLayoutButtonBA.setVisibility(View.VISIBLE);
            linearLayoutButtonTatCh.setVisibility(View.VISIBLE);
            frameLayoutLanguage.setVisibility(View.GONE);
        } else {
            linearLayoutButtonRuEn.setVisibility(View.GONE);
            linearLayoutButtonBA.setVisibility(View.GONE);
            linearLayoutButtonTatCh.setVisibility(View.GONE);
            frameLayoutLanguage.setVisibility(View.VISIBLE);
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
        transaction.replace(frameLayoutLanguage.getId(), ofTheGameFragment);
        
        transaction.addToBackStack(null);
        transaction.commit();
    }
}