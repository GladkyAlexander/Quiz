package ru.great_larder.sportquiz.ui.etiquette;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.databinding.FragmentEtiquetteBinding;
import ru.great_larder.sportquiz.databinding.FragmentLanguageQuizBinding;
import ru.great_larder.sportquiz.ui.language_quiz.LanguageQuizFragmentViewModel;

public class EtiquetteFragment extends Fragment {
    
    private LinearLayout linearLayoutButtonEtiquette;
    private FrameLayout frameLayoutLanguage;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        FragmentEtiquetteBinding binding = FragmentEtiquetteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        ImageButton buttonBusiness = binding.buttonBusiness;
        ImageButton buttonSecular = binding.buttonSecular;
        
        linearLayoutButtonEtiquette = binding.linearLayoutButtonEtiquette;
        
        frameLayoutLanguage = binding.frameLayoutEtiquette;
        
        buttonSecular.setOnClickListener(b->{
            linearLayoutButtonEtiquette.setVisibility(View.GONE);
            frameLayoutLanguage.setVisibility(View.VISIBLE);
            OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
            
            Bundle bundle = new Bundle();
            bundle.putString("getGuestion", "Etiquette Secular");
            ofTheGameFragment.setArguments(bundle);
            
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(frameLayoutLanguage.getId(), ofTheGameFragment);
            
            transaction.addToBackStack(null);
            transaction.commit();
            
        });
        
        buttonBusiness.setOnClickListener(g->{
            linearLayoutButtonEtiquette.setVisibility(View.GONE);
            frameLayoutLanguage.setVisibility(View.VISIBLE);
            OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
            
            Bundle bundle = new Bundle();
            bundle.putString("getGuestion", "Etiquette Business");
            ofTheGameFragment.setArguments(bundle);
            
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(frameLayoutLanguage.getId(), ofTheGameFragment);
            
            transaction.addToBackStack(null);
            transaction.commit();
        });
        
        return root;
    }
}