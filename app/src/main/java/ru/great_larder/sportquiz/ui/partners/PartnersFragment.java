package ru.great_larder.sportquiz.ui.partners;

import android.annotation.SuppressLint;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.MainActivity;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.database.author_and_partners.ListLoadAuthor;
import ru.great_larder.sportquiz.database.author_and_partners.ListLoadCompanyPartners;
import ru.great_larder.sportquiz.databinding.FragmentPartnersBinding;
import ru.great_larder.sportquiz.domain.Author;
import ru.great_larder.sportquiz.domain.CompanyPartners;
import ru.great_larder.sportquiz.ui.questions_from_the_author.QuestionsFromAuthorFragment;
import ru.great_larder.sportquiz.ui.submit.SubmitAQuizToTheDatabaseFragment;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PartnersFragment extends Fragment implements RecyclerViewAdapterAuthor.ItemClickListener, RecyclerViewAdapterCompanyPartners.ItemClickListener{

    private RecyclerViewAdapterAuthor adapterAuthor;
    private RecyclerViewAdapterCompanyPartners adapterCompany;
    public RecyclerView recycleViewAuthors, recyclerViewCompany;
    public FrameLayout frameLayoutFragmentPartners;
    public static PartnersFragment newInstance(String param1, String param2) {
        PartnersFragment fragment = new PartnersFragment();
        Bundle args = new Bundle();
      
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        FragmentPartnersBinding binding = FragmentPartnersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        recycleViewAuthors = binding.recycleViewAuthors;
        recyclerViewCompany = binding.recyclerViewCompany;
        Button buttonDYWTB_anAuthor = binding.buttonDYWTBAnAuthor;
        frameLayoutFragmentPartners = binding.frameLayoutFragmentPartners;
        
        loadFragment();
        
        buttonDYWTB_anAuthor.setOnClickListener(v-> openFormQuestionsFromAuthor());
        
        return root;
    }
    
    @SuppressLint("UseCompatLoadingForDrawables")
    public void loadFragment() {
        List<Author> authorsExternal = ListLoadAuthor.getAuthors();
        List<CompanyPartners> companyesExternal = ListLoadCompanyPartners.getCompanyPartners();
        
        loadRecyclerAuthors(authorsExternal);
        loadRecyclerCompany(companyesExternal);
    }
    
    private void loadRecyclerCompany(List<CompanyPartners> companyesExternal) {
        if(companyesExternal != null && !companyesExternal.isEmpty()) {
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(requireActivity()
                , LinearLayoutManager.HORIZONTAL, false);
            recyclerViewCompany.setLayoutManager(horizontalLayoutManager);
            adapterCompany = new RecyclerViewAdapterCompanyPartners(requireActivity(), companyesExternal);
        } else {
            List<CompanyPartners> companyPartners = new ArrayList<>();
            companyPartners.add(new CompanyPartners());
            companyPartners.add(new CompanyPartners());
            companyPartners.add(new CompanyPartners());
            companyPartners.add(new CompanyPartners());
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(requireActivity()
                , LinearLayoutManager.HORIZONTAL, false);
            recyclerViewCompany.setLayoutManager(horizontalLayoutManager);
            adapterCompany = new RecyclerViewAdapterCompanyPartners(requireActivity(), companyPartners);
        }
        adapterCompany.setClickListener(this);
        recyclerViewCompany.setAdapter(adapterCompany);
    }
    
    private void loadRecyclerAuthors(List<Author> authorsExternal) {
        if(authorsExternal != null && !authorsExternal.isEmpty()) {
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(requireActivity()
                , LinearLayoutManager.HORIZONTAL, false);
            recycleViewAuthors.setLayoutManager(horizontalLayoutManager);
            adapterAuthor = new RecyclerViewAdapterAuthor(requireActivity(), authorsExternal);
        } else {
            List<Author> authors = new ArrayList<>();
            @SuppressLint("UseCompatLoadingForDrawables")
            Bitmap bitmap = ((BitmapDrawable) Objects.requireNonNull(ContextCompat.getDrawable(requireActivity(), R.drawable.a_s_gl))).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            
            authors.add(new Author("Гладкий", "Александр", stream.toByteArray()));
            authors.add(new Author("Обуховская", "Дарья", null));
            authors.add(new Author());
            authors.add(new Author());
            
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(requireActivity()
                , LinearLayoutManager.HORIZONTAL, false);
            recycleViewAuthors.setLayoutManager(horizontalLayoutManager);
            adapterAuthor = new RecyclerViewAdapterAuthor(requireActivity(), authors);
        }
        adapterAuthor.setClickListener(this);
        recycleViewAuthors.setAdapter(adapterAuthor);
    }
    
    @Override
    public void onItemClickAuthor(View view, int position, Author author) {
//        Toast.makeText(requireActivity(), "Вы нажали " + adapterAuthor.getItem(position) + " по позиции элемента " + position, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onItemClickCompanyPartners(View view, int position, CompanyPartners companyPartners) {
    
    }
    private void openFormQuestionsFromAuthor() {
        QuestionsFromAuthorFragment questionsFromAuthorFragment = new QuestionsFromAuthorFragment();
        questionsFromAuthorFragment.setPartnersFragment(this);
        ((MainActivity) requireActivity()).getImg_fairies().setVisibility(View.GONE);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        frameLayoutFragmentPartners.setVisibility(View.VISIBLE);
        transaction.replace(frameLayoutFragmentPartners.getId(), questionsFromAuthorFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }
    private void openAuthorPane(){
        SubmitAQuizToTheDatabaseFragment submitAQuizToTheDatabaseFragment = new SubmitAQuizToTheDatabaseFragment();
        
        ((MainActivity) requireActivity()).getImg_fairies().setVisibility(View.GONE);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        frameLayoutFragmentPartners.setVisibility(View.VISIBLE);
        transaction.replace(frameLayoutFragmentPartners.getId(), submitAQuizToTheDatabaseFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}