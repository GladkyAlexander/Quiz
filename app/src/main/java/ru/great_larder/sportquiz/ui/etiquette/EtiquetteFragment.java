package ru.great_larder.sportquiz.ui.etiquette;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.databinding.FragmentEtiquetteBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;

public class EtiquetteFragment extends Fragment implements ObserverUser {
    
    private LinearLayout linearLayoutButtonEtiquette;
    private FrameLayout frameLayoutLanguage;
    private ImageButton buttonSecular, buttonBusiness;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        FragmentEtiquetteBinding binding = FragmentEtiquetteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        buttonBusiness = binding.buttonBusiness;
        buttonSecular = binding.buttonSecular;
        linearLayoutButtonEtiquette = binding.linearLayoutButtonEtiquette;
        frameLayoutLanguage = binding.frameLayoutEtiquette;
        GlobalLinkUser.getHandlerUserListener().registerObserverUser(this);
        loadFragment(GlobalLinkUser.getUser());
        
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            buttonSecular.setOnClickListener(b-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
            
            buttonBusiness.setOnClickListener(g-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
        } else {
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
        }
    }
    
    @Override
    public void updateUser(DataUser dataUser) {
        loadFragment(dataUser.getUser());
    }
}