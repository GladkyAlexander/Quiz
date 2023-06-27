package ru.great_larder.sportquiz.ui.school;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentSchoolBinding;

public class FragmentSchool extends Fragment {
    
    private LinearLayout linearLayout1, linearLayout2, linearLayout3;
    private FrameLayout frameLayoutShool;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ru.great_larder.sportquiz.databinding.FragmentSchoolBinding binding = FragmentSchoolBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        ImageButton button_biolog = binding.buttonBiolog;
        ImageButton button_geografik = binding.buttonGeografik;
        ImageButton button_history = binding.buttonHistory;
        ImageButton button_physics = binding.buttonPhysics;
        ImageButton button_mathematics = binding.buttonMathematics;
        
        linearLayout1 = binding.linearLayout1;
        linearLayout2 = binding.linearLayout2;
        linearLayout3 = binding.linearLayout3;
        
        frameLayoutShool = binding.frameLayoutShool;
        
        button_biolog.setOnClickListener(a->{
            
            linearLayout1.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.GONE);
            linearLayout3.setVisibility(View.GONE);
            frameLayoutShool.setVisibility(View.VISIBLE);
            OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
            
            Bundle bundle = new Bundle();
            bundle.putString("getGuestion", "Biology");
            ofTheGameFragment.setArguments(bundle);
            
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
            bundle.putString("getGuestion", "History");
            ofTheGameFragment.setArguments(bundle);
            
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
            bundle.putString("getGuestion", "Geography");
            ofTheGameFragment.setArguments(bundle);
            
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
            bundle.putString("getGuestion", "Physics");
            ofTheGameFragment.setArguments(bundle);
            
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
            bundle.putString("getGuestion", "Mathematics");
            ofTheGameFragment.setArguments(bundle);
            
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(frameLayoutShool.getId(), ofTheGameFragment);
            
            transaction.addToBackStack(null);
            transaction.commit();
        });
        
        return root;
    }
}