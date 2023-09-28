package ru.great_larder.sportquiz.ui.questions_from_the_author;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.textfield.TextInputEditText;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.MainActivity;
import ru.great_larder.sportquiz.services.CheckNetClass;
import ru.great_larder.sportquiz.ui.partners.PartnersFragment;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class QuestionsFromAuthorFragment extends Fragment {
    private TextInputEditText textViewQuestion, textViewRightAnswer, textViewAnswerOption1, textViewAnswerOption2
        , textViewAnswerOption3, textViewLinkFragmentQuestionsFromAuthor, textViewSection, textInputEditTextLastName
        , textInputEditTextFirstName;
    private EditText editTextTextEmailAddressFQFA, editTextPhoneFQFA;
    private ImageView imageViewEmail, imageViewWattsap, imageViewTelegram;
    private QuestionsFromAuthorViewModel mViewModel;
    
    private PartnersFragment partnersFragment;
    
    public PartnersFragment getPartnersFragment() {
        return partnersFragment;
    }
    
    public void setPartnersFragment(PartnersFragment partnersFragment) {
        this.partnersFragment = partnersFragment;
    }
    
    public static QuestionsFromAuthorFragment newInstance() {
        return new QuestionsFromAuthorFragment();
    }
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        
        ru.great_larder.sportquiz.databinding.FragmentQuestionsFromAuthorBinding binding = ru.great_larder.sportquiz.databinding.FragmentQuestionsFromAuthorBinding.inflate(inflater, container, false);
        ViewGroup root = binding.getRoot();
        
        textInputEditTextFirstName = binding.textInputEditTextFirstName;
        textInputEditTextLastName = binding.textInputEditTextLastName;
        
        textViewQuestion = binding.textViewQuestion;
        textViewRightAnswer = binding.textViewRightAnswer;
        textViewAnswerOption1 = binding.textViewAnswerOption1;
        textViewAnswerOption2 = binding.textViewAnswerOption2;
        textViewAnswerOption3 = binding.textViewAnswerOption3;
        textViewLinkFragmentQuestionsFromAuthor = binding.textViewLinkFragmentQuestionsFromAuthor;
        textViewSection = binding.textViewSection;
        
        editTextTextEmailAddressFQFA = binding.editTextTextEmailAddressFQFA;
        editTextPhoneFQFA = binding.editTextPhoneFQFA;
        
        imageViewEmail = binding.imageViewEmail;
        imageViewEmail.setClickable(true);
        imageViewTelegram = binding.imageViewTelegram;
        imageViewTelegram.setClickable(true);
        imageViewWattsap = binding.imageViewWattsap;
        imageViewWattsap.setClickable(true);
        
        loadFragment();
        
        return root;
    }
    
    private void loadFragment() {
        if(GlobalLinkUser.getUser() != null){
            textInputEditTextLastName.setText(GlobalLinkUser.getUser().getLastName());
            textInputEditTextFirstName.setText(GlobalLinkUser.getUser().getName());
        }
        imageViewEmail.setOnClickListener(v ->{
            if(GlobalLinkUser.getUser() != null) {
                if (new CheckNetClass().getConnectionType(requireActivity()) > 0) {
                sendEmail();
                } else {
                    Toast.makeText(requireActivity(), "Нет интернета! Проверьте подключение", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show();
            }
        });
        imageViewWattsap.setOnClickListener(v ->{
            if(GlobalLinkUser.getUser() != null) {
                if (new CheckNetClass().getConnectionType(requireActivity()) > 0) {
                    sendWatsap();
                } else {
                    Toast.makeText(requireActivity(), "Нет интернета! Проверьте подключение", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show();
            }
        });
        imageViewTelegram.setOnClickListener(v ->{
            if(GlobalLinkUser.getUser() != null) {
                if (new CheckNetClass().getConnectionType(requireActivity()) > 0) {
                    sendTelegram();
                } else {
                    Toast.makeText(requireActivity(), "Нет интернета! Проверьте подключение", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show();
            }
        });
    }
    
    private String getMailText() {
        return "Здравствуйте. Это " + GlobalLinkUser.getUser().getName() + " . "
            + " " + GlobalLinkUser.getUser().getLastName() + " . "
            + " " + GlobalLinkUser.getUser().getDate_of_birth() + " года рождения . "
            + "  Мой адрес электронной почты : " + editTextTextEmailAddressFQFA.getText() + " . "
            + "  Мой телефон : " + editTextPhoneFQFA.getText() + " . "
            + "  Я предлагаю вопрос к разделу : " + textViewSection.getText() + " . "
            + "  Вопрос : " + textViewQuestion.getText() + " . "
            + "  Правильный ответ : " + textViewRightAnswer.getText() + " . "
            + "  Вариант ответа 1 : " + textViewAnswerOption1.getText() + " . "
            + "  Вариант ответа 2 : " + textViewAnswerOption2.getText() + " . "
            + "  Вариант ответа 3 : " + textViewAnswerOption3.getText() + " . "
            + "  Ссылка на расширенный ответ размещенный в группе Викторинка в ВК : " + textViewLinkFragmentQuestionsFromAuthor.getText()
            ;
    }
    private void sendEmail(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@great-larder.ru"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Вопрос для Викторинки. Раздел " + textViewSection.getText());
        i.putExtra(Intent.EXTRA_TEXT, getMailText());
        try {
            startActivity(Intent.createChooser(i, "Отправить письмо..."));
            getPartnersFragment().frameLayoutFragmentPartners.removeAllViews();
            getPartnersFragment().frameLayoutFragmentPartners.setVisibility(View.GONE);
            getPartnersFragment().loadFragment();
            ((MainActivity) requireActivity()).getImg_fairies().setVisibility(View.VISIBLE);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(requireActivity(), "Почтовые клиенты не установлены.", Toast.LENGTH_SHORT).show();
        }
    }
    private void sendWatsap(){
        String link = "https://chat.whatsapp.com/Fhnbm4sNmG6E0z4fwiEx7W";
        startActivity(
            new Intent(Intent.ACTION_VIEW,
                Uri.parse(
                    String.format("https://api.whatsapp.com/send?phone=%s&text=%s", link /*phoneNumberWithCountryCode*/, getMailText())
                )
            )
        );
    }
    private void sendTelegram() {
        Intent sendIntent = new Intent();
        sendIntent.setDataAndType(Uri.parse("https://t.me/@a_s_gladky"),"text/plain");
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,getMailText());
        sendIntent.setPackage("org.telegram.messenger");
        try{
            startActivity(sendIntent);
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getContext(),"Install Telegram",Toast.LENGTH_LONG).show();
        }
    }
    
}