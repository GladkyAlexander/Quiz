package ru.great_larder.sportquiz.ui.submit;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.*;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.textfield.TextInputEditText;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.request_set_mysql.*;
import ru.great_larder.sportquiz.databinding.FragmentSubmitAQuizToTheDatabaseBinding;
import ru.great_larder.sportquiz.domain.*;
import ru.great_larder.sportquiz.services.chapters.GetChapters;
import ru.great_larder.sportquiz.services.chapters.GetChaptersImpl;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class SubmitAQuizToTheDatabaseFragment extends Fragment {
    
    private SubmitAQuizToTheDatabaseViewModel mViewModel;
    private FragmentSubmitAQuizToTheDatabaseBinding binding;
    private Spinner spinnerChapter;
    GetChapters getChapters = new GetChaptersImpl();
    private List<Chapter> chapters = getChapters.getChapters();
    public TextInputEditText textViewCityFragmentSubmit, textViewQuestionFragmentSubmit, textViewRightAnswerFragmentSubmit
        , textViewAnswerOption1FragmentSubmit, textViewAnswerOption2FragmentSubmit, textViewAnswerOption3FragmentSubmit
        , textViewLinkFragmentQuestionsFromAuthorFragmentSubmit;
    public Button buttonSendFSQD;
    public ImageView imageViewChoosePhoto;
    private ScrollView scrollViewSubmit;
    Question question;
    
    public static SubmitAQuizToTheDatabaseFragment newInstance() {
        return new SubmitAQuizToTheDatabaseFragment();
    }
    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
        uri -> imageViewChoosePhoto.setImageURI(uri));
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSubmitAQuizToTheDatabaseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        spinnerChapter = binding.spinnerChapter;
        
        textViewCityFragmentSubmit = binding.textViewCityFragmentSubmit;
        textViewQuestionFragmentSubmit = binding.textViewQuestionFragmentSubmit;
        textViewRightAnswerFragmentSubmit = binding.textViewRightAnswerFragmentSubmit;
        textViewAnswerOption1FragmentSubmit = binding.textViewAnswerOption1FragmentSubmit;
        textViewAnswerOption2FragmentSubmit = binding.textViewAnswerOption2FragmentSubmit;
        textViewAnswerOption3FragmentSubmit = binding.textViewAnswerOption3FragmentSubmit;
        textViewLinkFragmentQuestionsFromAuthorFragmentSubmit = binding.textViewLinkFragmentQuestionsFromAuthorFragmentSubmit;
        
        buttonSendFSQD = binding.buttonSendFSQD;
        imageViewChoosePhoto = binding.imageViewChoosePhoto;
        scrollViewSubmit = binding.scrollViewSubmit;
        
        MyCustomAdapterSubmit customAdapter = new MyCustomAdapterSubmit(requireActivity(), R.layout.row_chapter, chapters);
        spinnerChapter.setAdapter(customAdapter);
        spinnerChapter.setPromptId(R.string.section);
        spinnerChapter.setSelection(0, true);
        
       setQ(String.valueOf(chapters.get(spinnerChapter.getSelectedItemPosition()).getName()));
        spinnerChapter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setQ(chapters.get(position).getName());
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            
            }
        });
        
        
        imageViewChoosePhoto.setClickable(true);
        imageViewChoosePhoto.setOnClickListener(d-> choosePhoto());
        buttonSendFSQD.setOnClickListener(v -> sendQuiz());
        
        return root;
    }
    private void choosePhoto() {
        mGetContent.launch("image/*");
    }
    
    private void sendQuiz() {
        if(question instanceof QuestionCity) {
            ((QuestionCity)question).setCity(String.valueOf(textViewCityFragmentSubmit.getText()));
            question.setQuestion(String.valueOf(textViewQuestionFragmentSubmit.getText()));
            question.setRightAnswer(String.valueOf(textViewRightAnswerFragmentSubmit.getText()));
            question.setWrongAnswer1(String.valueOf(textViewAnswerOption1FragmentSubmit.getText()));
            question.setWrongAnswer2(String.valueOf(textViewAnswerOption2FragmentSubmit.getText()));
            question.setWrongAnswer3(String.valueOf(textViewAnswerOption3FragmentSubmit.getText()));
            question.setLink(String.valueOf(textViewLinkFragmentQuestionsFromAuthorFragmentSubmit.getText()));
            
            Bitmap bitmap = ((BitmapDrawable) imageViewChoosePhoto.getDrawable()).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
            
            ((QuestionCity)question).setLabel(stream.toByteArray());
        } else {
            textViewCityFragmentSubmit.setVisibility(View.GONE);
            question.setQuestion(String.valueOf(textViewQuestionFragmentSubmit.getText()));
            question.setRightAnswer(String.valueOf(textViewRightAnswerFragmentSubmit.getText()));
            question.setWrongAnswer1(String.valueOf(textViewAnswerOption1FragmentSubmit.getText()));
            question.setWrongAnswer2(String.valueOf(textViewAnswerOption2FragmentSubmit.getText()));
            question.setWrongAnswer3(String.valueOf(textViewAnswerOption3FragmentSubmit.getText()));
            question.setLevel(0);
            question.setLink(String.valueOf(textViewLinkFragmentQuestionsFromAuthorFragmentSubmit.getText()));
        }
        
        Integer h = sendQuestion(question);
        if(h != null){
            clean();
            requireActivity().getOnBackPressedDispatcher();
        } else {
            scrollViewSubmit.setBackgroundColor(Color.RED);
            Toast.makeText(requireActivity(), "Что-то пошло не так", Toast.LENGTH_LONG).show();
        }
        
    }
    
    private void clean() {
        textViewCityFragmentSubmit.setText("");
        textViewQuestionFragmentSubmit.setText("");
        textViewRightAnswerFragmentSubmit.setText("");
        textViewAnswerOption1FragmentSubmit.setText("");
        textViewAnswerOption2FragmentSubmit.setText("");
        textViewAnswerOption3FragmentSubmit.setText("");
        textViewLinkFragmentQuestionsFromAuthorFragmentSubmit.setText("");
        imageViewChoosePhoto.setImageResource(R.drawable.upphoto);
    }
    
    private void setQ(String s){
        
        if(s.equals("Города")) {
            textViewCityFragmentSubmit.setVisibility(View.VISIBLE);
            imageViewChoosePhoto.setVisibility(View.VISIBLE);
        } else {
            textViewCityFragmentSubmit.setVisibility(View.GONE);
            imageViewChoosePhoto.setVisibility(View.GONE);
        }
        
        if(s.equals("Математика")) {question = new QuestionMathematics();}
        if(s.equals("Физика")) {question = new QuestionPhysics();}
        if(s.equals("Биология")) {question = new QuestionBiology();}
        if(s.equals("География")) {question = new QuestionGeography();}
        if(s.equals("История")) {question = new QuestionHistory();}
        if(s.equals("ПДД")) {question = new QuestionTrafficLaws();}
        if(s.equals("Русский язык")) {question = new QuestionRuLanguage();}
        if(s.equals("Английский язык")) {question = new QuestionEnLanguage();}
        if(s.equals("Олимпиада")) {question = new QuestionSports();}
        if(s.equals("Деловой этикет")) {question = new QuestionEtiquetteBusiness();}
        if(s.equals("Светский этикет")) {question = new QuestionEtiquetteSecular();}
        if(s.equals("Города")) {question = new QuestionCity();}
    }
    private Integer sendQuestion(Question q){
                if(question instanceof QuestionBiology){
                    SetQuestion setQuestion = new SetQuestionBiologyImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionCity){
                    SetQuestion setQuestion = new SetQuestionCityImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionEnLanguage){
                    SetQuestion setQuestion = new SetQuestionEnLanguageImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionEtiquetteBusiness){
                    SetQuestion setQuestion = new SetQuestionEtiquetteBusinessImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionEtiquetteSecular){
                    SetQuestion setQuestion = new SetQuestionEtiquetteSecularImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionGeography){
                    SetQuestion setQuestion = new SetQuestionGeographyImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionHistory){
                    SetQuestion setQuestion = new SetQuestionHistoryImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionMathematics){
                    SetQuestion setQuestion = new SetQuestionMathematicsImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionPhysics){
                    SetQuestion setQuestion = new SetQuestionPhisicsImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionRuLanguage){
                    SetQuestion setQuestion = new SetQuestionRuLanguageImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionSports){
                    SetQuestion setQuestion = new SetQuestionSportsImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
                if(question instanceof QuestionTrafficLaws){
                    SetQuestion setQuestion = new SetQuestionTrafficLawsImpl();
                    return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
                }
        return null;
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}