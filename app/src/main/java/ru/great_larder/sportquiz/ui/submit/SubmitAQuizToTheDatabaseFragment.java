package ru.great_larder.sportquiz.ui.submit;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputEditText;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.request_set_mysql.*;
import ru.great_larder.sportquiz.databinding.FragmentSubmitAQuizToTheDatabaseBinding;
import ru.great_larder.sportquiz.domain.*;
import ru.great_larder.sportquiz.services.NameQuestion;
import ru.great_larder.sportquiz.services.chapters.GetChapters;
import ru.great_larder.sportquiz.services.chapters.GetChaptersImpl;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class SubmitAQuizToTheDatabaseFragment extends Fragment {
	
	private SubmitAQuizToTheDatabaseViewModel mViewModel;
	private FragmentSubmitAQuizToTheDatabaseBinding binding;
	private Spinner spinnerChapter;
	GetChapters getChapters = new GetChaptersImpl();
	private final List<Chapter> chapters = getChapters.getChapters();
	public TextInputEditText textViewCityFragmentSubmit, textViewQuestionFragmentSubmit, textViewRightAnswerFragmentSubmit, textViewAnswerOption1FragmentSubmit, textViewAnswerOption2FragmentSubmit, textViewAnswerOption3FragmentSubmit, textViewLinkFragmentQuestionsFromAuthorFragmentSubmit;
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
		imageViewChoosePhoto.setOnClickListener(d -> choosePhoto());
		buttonSendFSQD.setOnClickListener(v -> sendQuiz());
		
		return root;
	}
	
	private void choosePhoto() {
		mGetContent.launch("image/*");
	}
	
	private void sendQuiz() {
		if (question instanceof QuestionCity) {
			((QuestionCity) question).setCity(String.valueOf(textViewCityFragmentSubmit.getText()));
			question.setQuestion(String.valueOf(textViewQuestionFragmentSubmit.getText()));
			question.setRightAnswer(String.valueOf(textViewRightAnswerFragmentSubmit.getText()));
			question.setWrongAnswer1(String.valueOf(textViewAnswerOption1FragmentSubmit.getText()));
			question.setWrongAnswer2(String.valueOf(textViewAnswerOption2FragmentSubmit.getText()));
			question.setWrongAnswer3(String.valueOf(textViewAnswerOption3FragmentSubmit.getText()));
			question.setLink(String.valueOf(textViewLinkFragmentQuestionsFromAuthorFragmentSubmit.getText()));
			
			Bitmap bitmap = ((BitmapDrawable) imageViewChoosePhoto.getDrawable()).getBitmap();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
			
			((QuestionCity) question).setLabel(stream.toByteArray());
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
		if (h != null) {
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
	
	private void setQ(String s) {
		
		if (s.equals("Города")) {
			textViewCityFragmentSubmit.setVisibility(View.VISIBLE);
			imageViewChoosePhoto.setVisibility(View.VISIBLE);
		} else {
			textViewCityFragmentSubmit.setVisibility(View.GONE);
			imageViewChoosePhoto.setVisibility(View.GONE);
		}
		
		if (s.equals(NameQuestion.MATHEMATICS)) {question = new QuestionMathematics();}
		if (s.equals(NameQuestion.PHYSICS)) {question = new QuestionPhysics();}
		if (s.equals(NameQuestion.BIOLOGY)) {question = new QuestionBiology();}
		if (s.equals(NameQuestion.GEOGRAPHY)) {question = new QuestionGeography();}
		if (s.equals(NameQuestion.HISTORY)) {question = new QuestionHistory();}
		if (s.equals(NameQuestion.SOCIAL_STUDIES)) {question = new QuestionSocialStudies();}
		
		if (s.equals(NameQuestion.RUSSIAN_LANGUAGE)) {question = new QuestionRuLanguage();}
		if (s.equals(NameQuestion.ENGLISH_LANGUAGE)) {question = new QuestionEnLanguage();}
		if (s.equals(NameQuestion.BASHKIR_LANGUAGE)) {question = new QuestionBashkirLanguage();}
		if (s.equals(NameQuestion.CHUVASH_LANGUAGE)) {question = new QuestionChuvashLanguage();}
		if (s.equals(NameQuestion.CHECHEN_LANGUAGE)) {question = new QuestionChechenLanguage();}
		if (s.equals(NameQuestion.TATAR_LANGUAGE)) {question = new QuestionTatarLanguage();}
		
		if (s.equals(NameQuestion.AVIATION_TRANSPORT)) {question = new QuestionAviationTransport();}
		if (s.equals(NameQuestion.RAILWAY_TRANSPORT)) {question = new QuestionRailwayTransport();}
		if (s.equals(NameQuestion.ROAD_TRANSPORT)) {question = new QuestionRoadTransport();}
		
		if (s.equals(NameQuestion.SPORTS)) {question = new QuestionSports();}
		
		if (s.equals(NameQuestion.ETIQUETTE_BUSINESS)) {question = new QuestionEtiquetteBusiness();}
		if (s.equals(NameQuestion.ETIQUETTE_SECULAR)) {question = new QuestionEtiquetteSecular();}
		
		if (s.equals(NameQuestion.CITY)) {question = new QuestionCity();}
		
	}
	
	private Integer sendQuestion(Question q) {
		if (question instanceof QuestionBiology) {
			SetQuestion setQuestion = new SetQuestionBiologyMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionSocialStudies) {
			SetQuestion setQuestion = new SetQuestionSocialStudiesMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionGeography) {
			SetQuestion setQuestion = new SetQuestionGeographyMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionHistory) {
			SetQuestion setQuestion = new SetQuestionHistoryMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionMathematics) {
			SetQuestion setQuestion = new SetQuestionMathematicsMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionPhysics) {
			SetQuestion setQuestion = new SetQuestionPhisicsMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		/*------------------------------------- School end -----------------------------------------------------------*/
		if (question instanceof QuestionEnLanguage) {
			SetQuestion setQuestion = new SetQuestionEnLanguageMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionRuLanguage) {
			SetQuestion setQuestion = new SetQuestionRuLanguageMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionBashkirLanguage) {
			SetQuestion setQuestion = new SetQuestionBashkirLanguageMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionChuvashLanguage) {
			SetQuestion setQuestion = new SetQuestionChuvashLanguageMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionChechenLanguage) {
			SetQuestion setQuestion = new SetQuestionsChechenLanguageMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionTatarLanguage) {
			SetQuestion setQuestion = new SetQuestionTatarLanguageMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		/*------------------------------------- Language end ---------------------------------------------------------*/
		if (question instanceof QuestionSports) {
			SetQuestion setQuestion = new SetQuestionSportsMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		/*--------------------------------------- Sport end ----------------------------------------------------------*/
		if (question instanceof QuestionEtiquetteBusiness) {
			SetQuestion setQuestion = new SetQuestionEtiquetteBusinessMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionEtiquetteSecular) {
			SetQuestion setQuestion = new SetQuestionEtiquetteSecularMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		/*------------------------------------- Etiquette end --------------------------------------------------------*/
		if (question instanceof QuestionCity) {
			SetQuestion setQuestion = new SetQuestionCityMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		/*---------------------------------------- City end ----------------------------------------------------------*/
		if (question instanceof QuestionAviationTransport) {
			SetQuestion setQuestion = new SetQuestionAviationTransportMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionRailwayTransport) {
			SetQuestion setQuestion = new SetQuestionRailwayTransportMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		if (question instanceof QuestionRoadTransport) {
			SetQuestion setQuestion = new SetQuestionRoadTransportMySQLImpl();
			return setQuestion.setQuestion(GlobalLinkUser.getUser(), requireActivity(), q);
		}
		/*------------------------------------- Transport end --------------------------------------------------------*/
		return null;
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}