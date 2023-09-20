package ru.great_larder.sportquiz.ui.school;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentSchoolBinding;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.services.user_listener.ObserverUser;

public class FragmentSchool extends Fragment {
    
    private LinearLayout linearLayout1, linearLayout2, linearLayout3;
    private FrameLayout frameLayoutShool;
    private ImageButton button_biolog, button_geografik, button_history, button_physics, button_mathematics;
    
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ru.great_larder.sportquiz.databinding.FragmentSchoolBinding binding = FragmentSchoolBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        button_biolog = binding.buttonBiolog;
        button_geografik = binding.buttonGeografik;
        button_history = binding.buttonHistory;
        button_physics = binding.buttonPhysics;
        button_mathematics = binding.buttonMathematics;
        
        linearLayout1 = binding.linearLayout1;
        linearLayout2 = binding.linearLayout2;
        linearLayout3 = binding.linearLayout3;
        
        frameLayoutShool = binding.frameLayoutShool;
        loadFragment(GlobalLinkUser.getUser());
        
        return root;
    }
    public void loadFragment(User user){
        if(user == null){
            
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.VISIBLE);
            linearLayout3.setVisibility(View.VISIBLE);
            frameLayoutShool.setVisibility(View.GONE);
            
            button_biolog.setOnClickListener(a-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
            button_history.setOnClickListener(a-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
            button_geografik.setOnClickListener(a-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
            button_physics.setOnClickListener(a-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
            button_mathematics.setOnClickListener(a-> Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show());
        } else {
            
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.VISIBLE);
            linearLayout3.setVisibility(View.VISIBLE);
            frameLayoutShool.setVisibility(View.GONE);
            
            button_biolog.setOnClickListener(a->{
                
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.GONE);
                frameLayoutShool.setVisibility(View.VISIBLE);
                OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
                
                Bundle bundle = new Bundle();
                bundle.putString("getQuestion", "Biology");
                ofTheGameFragment.setArguments(bundle);
                ofTheGameFragment.setCont(this);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(frameLayoutShool.getId(), ofTheGameFragment);
                
                transaction.addToBackStack(null);
                transaction.commit();
            });
            button_history.setOnClickListener(a->{
                
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.GONE);
                frameLayoutShool.setVisibility(View.VISIBLE);
                OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
                
                Bundle bundle = new Bundle();
                bundle.putString("getQuestion", "History");
                ofTheGameFragment.setArguments(bundle);
                ofTheGameFragment.setCont(this);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(frameLayoutShool.getId(), ofTheGameFragment);
                
                transaction.addToBackStack(null);
                transaction.commit();
            });
            button_geografik.setOnClickListener(a->{
                
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.GONE);
                frameLayoutShool.setVisibility(View.VISIBLE);
                OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
                
                Bundle bundle = new Bundle();
                bundle.putString("getQuestion", "Geography");
                ofTheGameFragment.setArguments(bundle);
                ofTheGameFragment.setCont(this);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(frameLayoutShool.getId(), ofTheGameFragment);
                
                transaction.addToBackStack(null);
                transaction.commit();
            });
            button_physics.setOnClickListener(a->{
                
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.GONE);
                frameLayoutShool.setVisibility(View.VISIBLE);
                OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
                
                Bundle bundle = new Bundle();
                bundle.putString("getQuestion", "Physics");
                ofTheGameFragment.setArguments(bundle);
                ofTheGameFragment.setCont(this);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(frameLayoutShool.getId(), ofTheGameFragment);
                
                transaction.addToBackStack(null);
                transaction.commit();
            });
            button_mathematics.setOnClickListener(a->{
                
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.GONE);
                frameLayoutShool.setVisibility(View.VISIBLE);
                OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
                
                Bundle bundle = new Bundle();
                bundle.putString("getQuestion", "Mathematics");
                ofTheGameFragment.setArguments(bundle);
                ofTheGameFragment.setCont(this);
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(frameLayoutShool.getId(), ofTheGameFragment);
                
                transaction.addToBackStack(null);
                transaction.commit();
            });
        }
    }
}