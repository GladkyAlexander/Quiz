package ru.great_larder.sportquiz;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.great_larder.sportquiz.database.DatabaseAdapter;
import ru.great_larder.sportquiz.databinding.FragmentOfTheGameBinding;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.question.*;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

import java.util.*;

public class OfTheGameFragment extends Fragment {
    TextView textViewTimeGame, tv_second_game, textViewQuestionGame;
    LinearLayout llAnswersGame, llButtonsGame;
    CheckBox checkBoxGame1, checkBoxGame2, checkBoxGame3, checkBoxGame4;
    Button buttonResumeGame, buttonOutGame;
    ImageView img1, img2, img3, img4;
    private CountDownTimer chronometer = null;
    GetQuestion getQuestion;
    Map<CheckBox, ImageView> map = new HashMap<>();
    ImageView view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        FragmentOfTheGameBinding binding = FragmentOfTheGameBinding.inflate(inflater, container, false);
        
        View root = binding.getRoot();
        
        textViewTimeGame = binding.textViewTimeGame;
        tv_second_game = binding.tvSecondGame;
        textViewQuestionGame = binding.textViewQuestionGame;
        
        llAnswersGame = binding.llAnswersGame;
        llButtonsGame = binding.llButtonsGame;
        
        checkBoxGame1 = binding.checkBoxGame1;
        checkBoxGame2 = binding.checkBoxGame2;
        checkBoxGame3 = binding.checkBoxGame3;
        checkBoxGame4 = binding.checkBoxGame4;
        
        buttonResumeGame = binding.buttonResumeGame;
        buttonOutGame = binding.buttonOutGame;
        
        map.put(checkBoxGame1, img1 = binding.imgCB1);
        map.put(checkBoxGame2, img2 = binding.imgCB2);
        map.put(checkBoxGame3, img3 = binding.imgCB3);
        map.put(checkBoxGame4, img4 = binding.imgCB4);
        
        buttonResumeGame.setOnClickListener(f->{
            timerResume();
        });
        buttonOutGame.setOnClickListener(a->{
            chronometer.cancel();
            requireActivity().getSupportFragmentManager().popBackStack();
            requireActivity().getSupportFragmentManager().popBackStack();
            
        });
        
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            setQue(bundle.getString("getGuestion"));
            startQuiz();
        }
        
        return root;
    }
    
    private void startQuiz(){
            clear();
            Question b = getQuestion.getRandomQuestion(null);
            List<String> l = new ArrayList<>();
            l.add(b.getRightAnswer());
            l.add(b.getWrongAnswer1());
            l.add(b.getWrongAnswer2());
            l.add(b.getWrongAnswer3());
            Collections.shuffle(l);
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
    }
    private void timerResume(){
        chronometer.cancel();
        startQuiz();
    }
    
    private void setQue(String arg) {
        if(arg.equals("Biology")){
            getQuestion = new GetQuestionBiology();
        }
        if(arg.equals("History")){
            getQuestion = new GetQuestionHistory();
        }
        if(arg.equals("Geography")){
            getQuestion = new GetQuestionGeography();
        }
        if(arg.equals("Physics")){
            getQuestion = new GetQuestionPhisics();
        }
        if(arg.equals("Mathematics")){
            getQuestion = new GetQuestionMathematics();
        }
        if(arg.equals("Sports")){
            getQuestion = new GetQuestionSportsImpl();
        }
        if(arg.equals("Russian language")){
            getQuestion = new GetQuestionRuLanguageImpl();
        }
        if(arg.equals("English language")){
            getQuestion = new GetQuestionEnLanguageImpl();
        }
        if(arg.equals("Traffic Laws")){
            getQuestion = new GetQuestionTrafficLaws();
        }
    }
    private void stageLoading(String q, List<String> list, String right_answer){
        
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
        
        for (CheckBox c : checkBoxList){
            c.setOnCheckedChangeListener((buttonView, isChecked) -> {
                
                if(isChecked){
                    if(buttonView.getText().equals(right_answer)){
                        setScores();
                        buttonView.setBackgroundResource(R.drawable.check_box);
                        for (CheckBox f : checkBoxList){
                            f.setClickable(false);
                        }
                    } else {
                        view = map.get(c);
                        assert view != null;
                        view.setVisibility(View.VISIBLE);
                        
                        view.setImageResource(R.drawable.animat);
                        
                        AnimationDrawable frameAnimation = (AnimationDrawable) view.getDrawable();
                        frameAnimation.setOneShot(true);
                        frameAnimation.start();
                        
                        /*c.setBackgroundResource(R.drawable.animat);
                        AnimationDrawable frameAnimation = (AnimationDrawable) c.getBackground();
                        frameAnimation.setOneShot(true);
                        frameAnimation.start();*/
                        
                        for (CheckBox f : checkBoxList){
                            f.setClickable(false);
                        }
                        showHandler(buttonView);
                    }
                }
            });
            
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
    private void setScores() {
        
        User u = GlobalLinkUser.getUser();
        int gl = u.getGlasses();
        u.setGlasses(gl + 1);
        GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(u));
        GlobalLinkUser.setUser(u);
        
        DatabaseAdapter adapter = new DatabaseAdapter(requireActivity());
        adapter.open();
        adapter.update(GlobalLinkUser.getUser());
        adapter.close();
        
    }
    private void clear(){
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
}