package ru.great_larder.sportquiz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.database.repository.GetQuestion;
import ru.great_larder.sportquiz.database.repository.impl.GetQuestionImpl;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.DatabaseAdapterUserSQLite;
import ru.great_larder.sportquiz.databinding.FragmentOfTheGameBinding;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;
import ru.great_larder.sportquiz.ui.city.CityFragment;
import ru.great_larder.sportquiz.ui.etiquette.EtiquetteFragment;
import ru.great_larder.sportquiz.ui.language_quiz.LanguageQuizFragment;
import ru.great_larder.sportquiz.ui.school.FragmentSchool;
import ru.great_larder.sportquiz.ui.sports.SportsFragment;
import ru.great_larder.sportquiz.ui.traffic_laws.FragmentTrafficLaws;

import java.util.*;

public class OfTheGameFragment extends Fragment {
    TextView textViewTimeGame, tv_second_game, textViewQuestionGame;
    LinearLayout llAnswersGame, llButtonsGame, linearLayoutGame;
    CheckBox checkBoxGame1, checkBoxGame2, checkBoxGame3, checkBoxGame4;
    Button buttonResumeGame, buttonOutGame;
    ImageView img1, img2, img3, img4, imageViewFinish, view;
    private CountDownTimer chronometer = null;
    Map<CheckBox, ImageView> map = new HashMap<>();
    List<Question> questionList;
    private EtiquetteFragment etiquetteFragment;
    private LanguageQuizFragment languageQuizFragment;
    private FragmentSchool fragmentSchool;
    private SportsFragment sportsFragment;
    private FragmentTrafficLaws fragmentTrafficLaws;
    private CityFragment cityFragment;
    FragmentOfTheGameBinding binding;
    String nameCity;
    
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        binding = FragmentOfTheGameBinding.inflate(inflater, container, false);
        
        View root = binding.getRoot();
        
        textViewTimeGame = binding.textViewTimeGame;
        tv_second_game = binding.tvSecondGame;
        textViewQuestionGame = binding.textViewQuestionGame;
        
        llAnswersGame = binding.llAnswersGame;
        llButtonsGame = binding.llButtonsGame;
        linearLayoutGame = binding.linearLayoutGame;
        checkBoxGame1 = binding.checkBoxGame1;
        checkBoxGame2 = binding.checkBoxGame2;
        checkBoxGame3 = binding.checkBoxGame3;
        checkBoxGame4 = binding.checkBoxGame4;
        
        buttonResumeGame = binding.buttonResumeGame;
        buttonOutGame = binding.buttonOutGame;
        
        imageViewFinish = binding.imageViewFinish;
        
        map.put(checkBoxGame1, img1 = binding.imgCB1);
        map.put(checkBoxGame2, img2 = binding.imgCB2);
        map.put(checkBoxGame3, img3 = binding.imgCB3);
        map.put(checkBoxGame4, img4 = binding.imgCB4);
        
        buttonResumeGame.setOnClickListener(f -> timerResume());
        buttonOutGame.setOnClickListener(a -> {
            chronometer.cancel();
            back(GlobalLinkUser.getUser());
            requireActivity().getOnBackPressedDispatcher();
        });
        
        if (getArguments() != null) {
            if (getArguments().getString("nameCity") != null) {
                nameCity = getArguments().getString("nameCity");
            }
            GetQuestion getQuestion = new GetQuestionImpl();
            questionList = getQuestion.getListQuestion(getContext(), getArguments().getString("getQuestion"), nameCity);
            startQuiz();
        }
        
        return root;
    }
    
    private void startQuiz() {
        if (isAdded()) {
            clear();
            Random random = new Random();
            llAnswersGame.setVisibility(View.VISIBLE);
            linearLayoutGame.setVisibility(View.VISIBLE);
            textViewQuestionGame.setVisibility(View.VISIBLE);
            imageViewFinish.setVisibility(View.GONE);
            if (questionList != null && !questionList.isEmpty()) {
                
                Question b = questionList.get(random.nextInt(questionList.size()));
                questionList.remove(b);
                List<String> l = new ArrayList<>();
                l.add(b.getRightAnswer());
                l.add(b.getWrongAnswer1());
                l.add(b.getWrongAnswer2());
                l.add(b.getWrongAnswer3());
                Collections.shuffle(l);
                
                if(isAdded()){
                    ((MainActivity) requireActivity()).setHintButton(b.getLink());
                }
                
                stageLoading(b.getQuestion(), l, b.getRightAnswer());
                
                chronometer = new CountDownTimer(2 * 10000L, 1000) {
                    @SuppressLint("SetTextI18n")
                    public void onTick(long millisUntilFinished) {
                        tv_second_game.setText(String.valueOf(millisUntilFinished / 1000));
                    }
                    
                    public void onFinish() {
                        startQuiz();
                    }
                }.start();
            } else {
                imageViewFinish.setVisibility(View.VISIBLE);
                llAnswersGame.setVisibility(View.GONE);
                linearLayoutGame.setVisibility(View.GONE);
                textViewQuestionGame.setVisibility(View.GONE);
                
                new Handler(Looper.getMainLooper()).postDelayed(() -> back(GlobalLinkUser.getUser()), 1000);
                
                onDestroyView();
            }
        } else {
            back(GlobalLinkUser.getUser());
            onDestroyView();
        }
    }
    private void timerResume() {
        chronometer.cancel();
        startQuiz();
    }
    
    private void stageLoading(String q, List<String> list, String right_answer) {
        textViewQuestionGame.setText(q);
        checkBoxGame1.setText(list.get(0));
        checkBoxGame2.setText(list.get(1));
        checkBoxGame3.setText(list.get(2));
        checkBoxGame4.setText(list.get(3));
        
        List<CheckBox> checkBoxList = new ArrayList<>();
        checkBoxList.add(checkBoxGame1);
        checkBoxList.add(checkBoxGame2);
        checkBoxList.add(checkBoxGame3);
        checkBoxList.add(checkBoxGame4);
        
        for (CheckBox c : checkBoxList) {
            c.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    if (buttonView.getText().equals(right_answer)) {
                        setScoresPlus();
                        buttonView.setBackgroundResource(R.drawable.check_box);
                        for (CheckBox f : checkBoxList) {
                            f.setClickable(false);
                        }
                        new Handler(Looper.getMainLooper()).postDelayed(this::timerResume, 1000);
                        
                    } else {
                        view = map.get(c);
                        assert view != null;
                        view.setVisibility(View.VISIBLE);
                        view.setImageResource(R.drawable.animat);
                        AnimationDrawable frameAnimation = (AnimationDrawable) view.getDrawable();
                        frameAnimation.setOneShot(true);
                        frameAnimation.start();
                        setScoresMinus();
                        for (CheckBox f : checkBoxList) {
                            f.setClickable(false);
                        }
                        showHandler(buttonView);
                        new Handler(Looper.getMainLooper()).postDelayed(this::timerResume, 1000);
                        
                    }
                }
            });
            
        }
    }
    
    private void setScoresMinus() {
        User u = GlobalLinkUser.getUser();
        int gl = u.getGlasses();
        if (gl > 0) {
            u.setGlasses(gl - 1);
            GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(u));
            GlobalLinkUser.setUser(u);
            
            DatabaseAdapterUserSQLite adapter = new DatabaseAdapterUserSQLite(requireActivity());
            adapter.open();
            adapter.update(GlobalLinkUser.getUser());
            adapter.close();
        }
    }
    
    private void showHandler(CompoundButton buttonView) {
        CountDownTimer f = new CountDownTimer(800, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
            
            }
            
            public void onFinish() {
                view.setVisibility(View.GONE);
                buttonView.setBackgroundResource(R.drawable.check_box_false);
            }
        }.start();
    }
    
    private void setScoresPlus() {
        User u = GlobalLinkUser.getUser();
        int gl = u.getGlasses();
        u.setGlasses(gl + 1);
        GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(u));
        GlobalLinkUser.setUser(u);
        
        DatabaseAdapterUserSQLite adapter = new DatabaseAdapterUserSQLite(requireActivity());
        adapter.open();
        adapter.update(GlobalLinkUser.getUser());
        adapter.close();
    }
    
    private void clear() {
        textViewQuestionGame.clearComposingText();
        checkBoxGame1.setChecked(false);
        checkBoxGame1.setClickable(true);
        checkBoxGame1.setBackgroundResource(R.drawable.check_box);
        checkBoxGame2.setChecked(false);
        checkBoxGame2.setClickable(true);
        checkBoxGame2.setBackgroundResource(R.drawable.check_box);
        checkBoxGame3.setChecked(false);
        checkBoxGame3.setClickable(true);
        checkBoxGame3.setBackgroundResource(R.drawable.check_box);
        checkBoxGame4.setChecked(false);
        checkBoxGame4.setClickable(true);
        checkBoxGame4.setBackgroundResource(R.drawable.check_box);
    }
    
    public void setCont(Fragment fragment) {
        
        if (fragment instanceof SportsFragment) {
            this.sportsFragment = (SportsFragment) fragment;
        }
        if (fragment instanceof FragmentTrafficLaws) {
            this.fragmentTrafficLaws = (FragmentTrafficLaws) fragment;
        }
        if (fragment instanceof FragmentSchool) {
            this.fragmentSchool = (FragmentSchool) fragment;
        }
        if (fragment instanceof LanguageQuizFragment) {
            this.languageQuizFragment = (LanguageQuizFragment) fragment;
        }
        if (fragment instanceof EtiquetteFragment) {
            this.etiquetteFragment = (EtiquetteFragment) fragment;
        }
        if (fragment instanceof CityFragment) {
            this.cityFragment = (CityFragment) fragment;
        }
    }
    
    private void back(User user) {
        if (sportsFragment != null) {
            sportsFragment.loadFragment(user);
        }
        if (fragmentTrafficLaws != null) {
            fragmentTrafficLaws.loadFragment(user);
        }
        if (fragmentSchool != null) {
            fragmentSchool.loadFragment(user);
        }
        if (languageQuizFragment != null) {
            languageQuizFragment.loadFragment(user);
        }
        if (etiquetteFragment != null) {
            etiquetteFragment.loadFragment(user);
        }
        if (cityFragment != null) {
            cityFragment.loadFragment();
        }
        if(isAdded()){
            ((MainActivity) requireActivity()).setHintButton(null);
        }
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}