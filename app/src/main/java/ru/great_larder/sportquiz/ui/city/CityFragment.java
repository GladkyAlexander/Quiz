package ru.great_larder.sportquiz.ui.city;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.OfTheGameFragment;
import ru.great_larder.sportquiz.database.repository.GetQuestion;
import ru.great_larder.sportquiz.database.repository.impl.GetQuestionImpl;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.CityAdapterSQLite;
import ru.great_larder.sportquiz.databinding.FragmentCityBinding;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.CheckNetClass;

import java.util.*;

public class CityFragment extends Fragment implements RecyclerViewAdapterCity.ItemClickListener
    , RecyclerViewAdapterLinkHistoryOneStreet.ItemClickListener{
    private CityViewModel mViewModel;
    private FrameLayout frameLayoutCity;
    private RecyclerView recyclerViewFragmentCity, recyclerViewOneStreet;
    private TextView textViewOnStreet;
    User user = GlobalLinkUser.getUser();
    RecyclerViewAdapterCity adapterCity;
    RecyclerViewAdapterLinkHistoryOneStreet adapterLinkHistoryOneStreet;
    List<QuestionCity> questionCityList;
    FragmentCityBinding binding;
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        CityViewModel cityViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(CityViewModel.class);
        
        binding = FragmentCityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        frameLayoutCity = binding.frameLayoutCity;
        recyclerViewFragmentCity = binding.reciclerViewFragmentCity;
        recyclerViewOneStreet = binding.recyclerViewOneStreet;
        textViewOnStreet = binding.textViewOnStreet;
        
        recyclerViewFragmentCity.setVisibility(View.VISIBLE);
        recyclerViewOneStreet.setVisibility(View.VISIBLE);
        textViewOnStreet.setVisibility(View.VISIBLE);
        
        frameLayoutCity.setVisibility(View.GONE);
        
        loadFragment();
        
        return root;
    }
    
    @SuppressLint("SetTextI18n")
    public void loadFragment() {
        recyclerViewFragmentCity.setVisibility(View.VISIBLE);
        recyclerViewOneStreet.setVisibility(View.VISIBLE);
        textViewOnStreet.setVisibility(View.VISIBLE);
        
        frameLayoutCity.setVisibility(View.GONE);
        if(user != null){
            textViewOnStreet.setVisibility(View.VISIBLE);
            
            CityAdapterSQLite cityAdapterSQLite = new CityAdapterSQLite(requireActivity());
            cityAdapterSQLite.open();
            List<Question> questionCities = new ArrayList<>(cityAdapterSQLite.getQuestionCityes());
            cityAdapterSQLite.close();
            
            if(!questionCities.isEmpty()){
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
                
                adapterCity = new RecyclerViewAdapterCity(requireActivity(), questionCityList);
                adapterCity.setClickListener(this);
                recyclerViewFragmentCity.setAdapter(adapterCity);
                
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(requireActivity()
                , LinearLayoutManager.HORIZONTAL, false);
                recyclerViewOneStreet.setLayoutManager(horizontalLayoutManager);
                
                
                adapterLinkHistoryOneStreet = new RecyclerViewAdapterLinkHistoryOneStreet(requireActivity().getLayoutInflater(), questionCityList);
                adapterLinkHistoryOneStreet.setClickListener(this);
                recyclerViewOneStreet.setAdapter(adapterLinkHistoryOneStreet);
                
            } else if(new CheckNetClass().getConnectionType(requireActivity()) > 0){
                    textViewOnStreet.setVisibility(View.GONE);
                    Toast.makeText(requireActivity(), "Вопросы еще не загрузились. Подождите", Toast.LENGTH_LONG).show();
            } else if(new CheckNetClass().getConnectionType(requireActivity()) < 0){
                    textViewOnStreet.setVisibility(View.GONE);
                    Toast.makeText(requireActivity(), "Нет интернета!", Toast.LENGTH_LONG).show();
                }
        } else {
            textViewOnStreet.setVisibility(View.GONE);
            Toast.makeText(requireActivity(), "Зарегистрируйтесь!", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onItemClick(View view, int position) {
       startVictory(questionCityList.get(position).getCity());
    }
    
    private void startVictory(String city) {
        recyclerViewFragmentCity.setVisibility(View.GONE);
        frameLayoutCity.setVisibility(View.VISIBLE);
        
        recyclerViewOneStreet.setVisibility(View.GONE);
        textViewOnStreet.setVisibility(View.GONE);
        
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
    
    @Override
    public void onItemClickLinkHistoryOneStreet(View view, int position) {
        String linkOneStreet = adapterLinkHistoryOneStreet.getItem(position).getLinkHistoryOneStreet();
        if(linkOneStreet != null && !linkOneStreet.isEmpty()) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkOneStreet));
            startActivity(browserIntent);
        }
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}