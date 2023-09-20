package ru.great_larder.sportquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
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
    ImageView img1, img2, img3, img4, imageViewFinish;
    private CountDownTimer chronometer = null;
    GetQuestion getQuestion;
    Map<CheckBox, ImageView> map = new HashMap<>();
    ImageView view, img_hint;
    List<Question> questionList;
    private EtiquetteFragment etiquetteFragment;
    private LanguageQuizFragment languageQuizFragment;
    private FragmentSchool fragmentSchool;
    private SportsFragment sportsFragment;
    private FragmentTrafficLaws fragmentTrafficLaws;
    private CityFragment cityFragment;
    
    String nameCity;
    
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
        linearLayoutGame = binding.linearLayoutGame;
        checkBoxGame1 = binding.checkBoxGame1;
        checkBoxGame2 = binding.checkBoxGame2;
        checkBoxGame3 = binding.checkBoxGame3;
        checkBoxGame4 = binding.checkBoxGame4;
        
        buttonResumeGame = binding.buttonResumeGame;
        buttonOutGame = binding.buttonOutGame;
        
        img_hint = binding.imgHint;
        imageViewFinish = binding.imageViewFinish;
        
        map.put(checkBoxGame1, img1 = binding.imgCB1);
        map.put(checkBoxGame2, img2 = binding.imgCB2);
        map.put(checkBoxGame3, img3 = binding.imgCB3);
        map.put(checkBoxGame4, img4 = binding.imgCB4);
        
        buttonResumeGame.setOnClickListener(f-> timerResume());
        buttonOutGame.setOnClickListener(a->{
            chronometer.cancel();
            back(GlobalLinkUser.getUser());
            requireActivity().onBackPressed();
        });
        if (getArguments() != null) {
            if(getArguments().getString("nameCity") != null){
                nameCity = getArguments().getString("nameCity");
            }
            questionList = getQuestionList(getArguments().getString("getQuestion"));
            startQuiz();
        }
        
        return root;
    }
    
    private void startQuiz(){
            clear();
            Random random = new Random();
            if(!questionList.isEmpty()) {
                
                llAnswersGame.setVisibility(View.VISIBLE);
                linearLayoutGame.setVisibility(View.VISIBLE);
                textViewQuestionGame.setVisibility(View.VISIBLE);
                img_hint.setVisibility(View.VISIBLE);
                imageViewFinish.setVisibility(View.GONE);
                
                Question b = questionList.get(random.nextInt(questionList.size()));
                questionList.remove(b);
                List<String> l = new ArrayList<>();
                l.add(b.getRightAnswer());
                l.add(b.getWrongAnswer1());
                l.add(b.getWrongAnswer2());
                l.add(b.getWrongAnswer3());
                Collections.shuffle(l);
                setHint(b.getLink());
                
                stageLoading(b.getQuestion(), l, b.getRightAnswer());
                
                chronometer = new CountDownTimer(2 * 10000L, 1000) {
                    @SuppressLint("SetTextI18n")
                    public void onTick(long millisUntilFinished) {
                        tv_second_game.setText(String.valueOf(millisUntilFinished / 1000));
                    }
                    
                    public void onFinish() {
                        img_hint.setVisibility(View.GONE);
                        startQuiz();
                    }
                }.start();
            } else {
                imageViewFinish.setVisibility(View.VISIBLE);
                llAnswersGame.setVisibility(View.GONE);
                linearLayoutGame.setVisibility(View.GONE);
                textViewQuestionGame.setVisibility(View.GONE);
                img_hint.setVisibility(View.GONE);
            }
    }
    private void timerResume(){
        chronometer.cancel();
        startQuiz();
    }
    private List<Question> getQuestionList(String arg) {
        if(arg.equals("Biology")){
            getQuestion = new GetQuestionBiologyImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("History")){
            getQuestion = new GetQuestionHistoryImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("Geography")){
            getQuestion = new GetQuestionGeographyImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("Physics")){
            getQuestion = new GetQuestionPhysicsImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("Mathematics")){
            getQuestion = new GetQuestionMathematicsImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("Sports")){
            getQuestion = new GetQuestionSportsImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("Russian language")){
            getQuestion = new GetQuestionRuLanguageImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("English language")){
            getQuestion = new GetQuestionEnLanguageImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("Traffic Laws")){
            getQuestion = new GetQuestionTrafficLawsImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("Etiquette Business")){
            getQuestion = new GetEtiquetteBusinessImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("Etiquette Secular")){
            getQuestion = new GetEtiquetteSecularImpl();
            return getQuestion.getListQuestion(null);
        }
        if(arg.equals("City")){
            getQuestion = new GetQuestionCityImpl();
            if(nameCity != null){
                return getQuestion.getListQuestion(nameCity);
            }
        }
        return null;
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
                        setScoresPlus();
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
                        setScoresMinus();
                        for (CheckBox f : checkBoxList){
                            f.setClickable(false);
                        }
                        showHandler(buttonView);
                    }
                }
            });
            
        }
    }
    
    private void setScoresMinus() {
        User u = GlobalLinkUser.getUser();
        int gl = u.getGlasses();
        if(gl > 0){
            u.setGlasses(gl - 1);
            GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(u));
            GlobalLinkUser.setUser(u);
            
            DatabaseAdapter adapter = new DatabaseAdapter(requireActivity());
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
    
    public void setCont(Fragment fragment) {
        
        if(fragment instanceof SportsFragment){
            this.sportsFragment = (SportsFragment) fragment;
        }
        if(fragment instanceof FragmentTrafficLaws){
            this.fragmentTrafficLaws = (FragmentTrafficLaws) fragment;
        }
        if(fragment instanceof FragmentSchool){
            this.fragmentSchool = (FragmentSchool) fragment;
        }
        if(fragment instanceof LanguageQuizFragment){
            this.languageQuizFragment = (LanguageQuizFragment) fragment;
        }
        if(fragment instanceof EtiquetteFragment){
            this.etiquetteFragment = (EtiquetteFragment) fragment;
        }
        if(fragment instanceof CityFragment){
            this.cityFragment = (CityFragment) fragment;
        }
    }
    private void back(User user) {
        if(sportsFragment != null){
            sportsFragment.loadFragment(user);
        }
        if(fragmentTrafficLaws != null){
            fragmentTrafficLaws.loadFragment(user);
        }
        if(fragmentSchool != null){
            fragmentSchool.loadFragment(user);
        }
        if(languageQuizFragment != null){
            languageQuizFragment.loadFragment(user);
        }
        if(etiquetteFragment != null){
            etiquetteFragment.loadFragment(user);
        }
        if(cityFragment != null){
            cityFragment.loadFragment();
        }
    }
    public void setHint(String link){
        if(link != null && !link.isEmpty()){
            img_hint.setVisibility(View.VISIBLE);
            img_hint.setClickable(true);
            img_hint.setOnClickListener(n ->{
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(browserIntent);
            });
        } else img_hint.setVisibility(View.GONE);
    }
}