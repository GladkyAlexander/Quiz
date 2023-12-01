package ru.great_larder.sportquiz.ui.etiquette;

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
import ru.great_larder.sportquiz.databinding.FragmentEtiquetteBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.NameQuestion;

import java.util.ArrayList;

public class EtiquetteFragment extends Fragment {
    
    private LinearLayout linearLayoutButtonEtiquette;
    private FrameLayout frameLayoutEtiquette;
    private ImageButton buttonSecular, buttonBusiness;
    FragmentEtiquetteBinding binding;
    ArrayList<ImageButton> imageButtonArrayList = new ArrayList<>();
    
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        binding = FragmentEtiquetteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        imageButtonArrayList.add(buttonBusiness = binding.buttonBusiness);
        imageButtonArrayList.add(buttonSecular = binding.buttonSecular);
        linearLayoutButtonEtiquette = binding.linearLayoutButtonEtiquette;
        frameLayoutEtiquette = binding.frameLayoutEtiquette;
        loadFragment(GlobalLinkUser.getUser());
        
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            setVisibleLayout(true);
            for (ImageButton imageButton : imageButtonArrayList){setClickButton(imageButton);}
        } else {
            setVisibleLayout(true);
            buttonSecular.setOnClickListener(b-> openQuestion(NameQuestion.ETIQUETTE_SECULAR));
            buttonBusiness.setOnClickListener(g-> openQuestion(NameQuestion.ETIQUETTE_BUSINESS));
        }
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void setVisibleLayout(boolean def){
        if(def){
            linearLayoutButtonEtiquette.setVisibility(View.VISIBLE);
            frameLayoutEtiquette.setVisibility(View.GONE);
        } else {
            linearLayoutButtonEtiquette.setVisibility(View.GONE);
            frameLayoutEtiquette.setVisibility(View.VISIBLE);
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
        transaction.replace(frameLayoutEtiquette.getId(), ofTheGameFragment);
        
        transaction.addToBackStack(null);
        transaction.commit();
    }
}