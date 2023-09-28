package ru.great_larder.sportquiz.ui.city;

import android.annotation.SuppressLint;
import android.widget.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentCityBinding;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.question.GetQuestionCityImpl;
import ru.great_larder.sportquiz.services.CheckNetClass;
import ru.great_larder.sportquiz.services.load.LoadDataAppService;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CityFragment extends Fragment implements RecyclerViewAdapterCity.ItemClickListener{
    private CityViewModel mViewModel;
    private FrameLayout frameLayoutCity;
    private RecyclerView recyclerViewFragmentCity;
    User user = GlobalLinkUser.getUser();
    RecyclerViewAdapterCity adapterCity;
    List<QuestionCity> questionCityList;
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        CityViewModel cityViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(CityViewModel.class);
        
        FragmentCityBinding binding = FragmentCityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        frameLayoutCity = binding.frameLayoutCity;
        recyclerViewFragmentCity = binding.reciclerViewFragmentCity;
        
        loadFragment();
        
        return root;
    }
    
    @SuppressLint("SetTextI18n")
    public void loadFragment() {
        recyclerViewFragmentCity.setVisibility(View.VISIBLE);
        frameLayoutCity.setVisibility(View.GONE);
        if(user != null){
            GetQuestionCityImpl getQuestion = new GetQuestionCityImpl();
            List<Question> questionCities = getQuestion.getListAll();
            if(questionCities != null && !questionCities.isEmpty()){
                List<QuestionCity> jk = new ArrayList<>();
                for (Question q : questionCities){
                    jk.add((QuestionCity) q);
                }
                
                TreeSet<QuestionCity> outList = new TreeSet<>(Comparator.comparing(QuestionCity::getCity));
                outList.addAll(jk);
                
                questionCityList = new ArrayList<>(outList);
                
                LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(requireActivity()
                , LinearLayoutManager.VERTICAL, false);
                recyclerViewFragmentCity.setLayoutManager(verticalLayoutManager);
                
                adapterCity = new RecyclerViewAdapterCity(requireActivity(), questionCityList/*listNameCity, listLogo*/);
                adapterCity.setClickListener(this);
                recyclerViewFragmentCity.setAdapter(adapterCity);
                
            } else if(new CheckNetClass().getConnectionType(requireActivity()) > 0){
                    Toast.makeText(requireActivity(), "Вопросы еще не загрузились. Подождите", Toast.LENGTH_LONG).show();
                    WorkManager workManager = WorkManager.getInstance(requireActivity());
                    workManager.enqueue(OneTimeWorkRequest.from(LoadDataAppService.class));
            } else if(new CheckNetClass().getConnectionType(requireActivity()) < 0){
                    Toast.makeText(requireActivity(), "Нет интернета!", Toast.LENGTH_LONG).show();
                }
        } else Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onItemClick(View view, int position) {
       startVictory(questionCityList.get(position).getCity());
    }
    
    private void startVictory(String city) {
        recyclerViewFragmentCity.setVisibility(View.GONE);
        frameLayoutCity.setVisibility(View.VISIBLE);
        OfTheGameFragment ofTheGameFragment = new OfTheGameFragment();
        Bundle bundle = new Bundle();
        bundle.putString("getQuestion", "City");
        bundle.putString("nameCity", city);
        ofTheGameFragment.setArguments(bundle);
        ofTheGameFragment.setCont(this);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(frameLayoutCity.getId(), ofTheGameFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }
    
}