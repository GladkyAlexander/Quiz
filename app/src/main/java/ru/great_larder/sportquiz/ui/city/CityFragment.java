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
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.databinding.FragmentCityBinding;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.question.GetQuestionCityImpl;
import ru.great_larder.sportquiz.services.CheckNetClass;
import ru.great_larder.sportquiz.services.load.LoadDataAppService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CityFragment extends Fragment implements RecyclerViewAdapterCity.ItemClickListener{
    private CityViewModel mViewModel;
    private FrameLayout frameLayoutCity;
    private RecyclerView recyclerViewFragmentCity;
    User user = GlobalLinkUser.getUser();
    RecyclerViewAdapterCity adapterCity;
    private List<String> listNameCity;
    
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
                Set<String> nameCity = new HashSet<>();
                Set<byte[]> logo = new HashSet<>();
                for (Question questionCity : questionCities){
                    nameCity.add(((QuestionCity)questionCity).getCity());
                    logo.add(((QuestionCity)questionCity).getLabel());
                }
                listNameCity = new ArrayList<>(nameCity);
                List<byte[]> listLogo = new ArrayList<>(logo);
                
                LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(requireActivity()
                , LinearLayoutManager.VERTICAL, false);
                recyclerViewFragmentCity.setLayoutManager(verticalLayoutManager);
                
                adapterCity = new RecyclerViewAdapterCity(requireActivity() ,listNameCity, listLogo);
                adapterCity.setClickListener(this);
                recyclerViewFragmentCity.setAdapter(adapterCity);
                
            } else {
                Toast.makeText(requireActivity(), "Вопросы еще не загрузились. Подождите", Toast.LENGTH_LONG).show();
                if (new CheckNetClass().getConnectionType(requireActivity()) > 0) {
                    WorkManager workManager = WorkManager.getInstance(requireActivity());
                    workManager.enqueue(OneTimeWorkRequest.from(LoadDataAppService.class));
                } else {
                    Toast.makeText(requireActivity(), "Нет интернета!", Toast.LENGTH_LONG).show();
                }
            }
        } else Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onItemClick(View view, int position) {
       startVictory(listNameCity.get(position));
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