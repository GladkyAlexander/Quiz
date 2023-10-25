package ru.great_larder.sportquiz.ui.etiquette;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentEtiquetteBinding;
import ru.great_larder.sportquiz.domain.User;

public class EtiquetteFragment extends Fragment {
    
    private LinearLayout linearLayoutButtonEtiquette;
    private FrameLayout frameLayoutLanguage;
    private ImageButton buttonSecular, buttonBusiness;
    FragmentEtiquetteBinding binding;
    
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        binding = FragmentEtiquetteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        buttonBusiness = binding.buttonBusiness;
        buttonSecular = binding.buttonSecular;
        linearLayoutButtonEtiquette = binding.linearLayoutButtonEtiquette;
        frameLayoutLanguage = binding.frameLayoutEtiquette;
        loadFragment(GlobalLinkUser.getUser());
        
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            linearLayoutButtonEtiquette.setVisibility(View.VISIBLE);
            frameLayoutLanguage.setVisibility(View.GONE);
            buttonSecular.setOnClickListener(b-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
            buttonBusiness.setOnClickListener(g-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
        } else {
            linearLayoutButtonEtiquette.setVisibility(View.VISIBLE);
            frameLayoutLanguage.setVisibility(View.GONE);
            buttonSecular.setOnClickListener(b->{
                linearLayoutButtonEtiquette.setVisibility(View.GONE);
                frameLayoutLanguage.setVisibility(View.VISIBLE);
                OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
                
                Bundle bundle = new Bundle();
                bundle.putString("getQuestion", "Etiquette Secular");
                ofTheGameFragment.setArguments(bundle);
                ofTheGameFragment.setCont(this);
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
                bundle.putString("getQuestion", "Etiquette Business");
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