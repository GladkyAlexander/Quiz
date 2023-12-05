package ru.great_larder.sportquiz.ui.traffic_laws;

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
import ru.great_larder.sportquiz.databinding.FragmentTrafficLawsBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.NameQuestion;

import java.util.ArrayList;

public class FragmentTrafficLaws extends Fragment {
    
    FrameLayout frameLayoutTrafficLaws;
    ImageButton button_road, button_aviation, button_railway;
    LinearLayout linear_layout_button_avia_jd, linear_layout_button_auto;
    FragmentTrafficLawsBinding binding;
    ArrayList<ImageButton> imageButtonArrayList = new ArrayList<>();
    
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTrafficLawsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        frameLayoutTrafficLaws = binding.frameLayoutTrafficLaws;
        
        imageButtonArrayList.add(button_aviation = binding.buttonAviation);
        imageButtonArrayList.add(button_railway = binding.buttonRailway);
        imageButtonArrayList.add(button_road = binding.buttonRoad);
        
        linear_layout_button_avia_jd = binding.linearLayoutButtonAviaJd;
        linear_layout_button_auto = binding.linearLayoutButtonAuto;
        
        loadFragment(GlobalLinkUser.getUser());
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            setVisibleLayout(true);
            for (ImageButton imageButton : imageButtonArrayList){setClickButton(imageButton);}
        } else {
            setVisibleLayout(true);
            button_aviation.setOnClickListener(a -> openQuestion(NameQuestion.AVIATION_TRANSPORT));
            button_railway.setOnClickListener(b -> openQuestion(NameQuestion.RAILWAY_TRANSPORT));
            button_road.setOnClickListener(c -> openQuestion(NameQuestion.ROAD_TRANSPORT));
        }
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void setVisibleLayout(boolean def){
        if(def){
            linear_layout_button_auto.setVisibility(View.VISIBLE);
            linear_layout_button_avia_jd.setVisibility(View.VISIBLE);
            frameLayoutTrafficLaws.setVisibility(View.GONE);
        } else {
            linear_layout_button_auto.setVisibility(View.GONE);
            linear_layout_button_avia_jd.setVisibility(View.GONE);
            frameLayoutTrafficLaws.setVisibility(View.VISIBLE);
        }
    }
    private void setClickButton(ImageButton imageButton) {
        imageButton.setOnClickListener(d -> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
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
        transaction.replace(frameLayoutTrafficLaws.getId(), ofTheGameFragment, null);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}