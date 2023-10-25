package ru.great_larder.sportquiz.ui.partners;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
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
import ru.great_larder.sportquiz.database.repository.GetAuthors;
import ru.great_larder.sportquiz.database.repository.GetCompanyPartners;
import ru.great_larder.sportquiz.database.repository.get_live.ListAuthor;
import ru.great_larder.sportquiz.database.repository.get_live.ListCompanyPartners;
import ru.great_larder.sportquiz.database.repository.impl.GetAuthorImpl;
import ru.great_larder.sportquiz.database.repository.impl.GetCompanyPartnersImpl;
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
    
    public RecyclerView recycleViewAuthors, recyclerViewCompany;
    public FrameLayout frameLayoutFragmentPartners;
    RecyclerViewAdapterAuthor adapterAuthor;
    RecyclerViewAdapterCompanyPartners adapterCompany;
    FragmentPartnersBinding binding;
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
        
        binding = FragmentPartnersBinding.inflate(inflater, container, false);
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
        List<Author> authorsExternal = ListAuthor.getAuthorsList();
        List<CompanyPartners> companyesExternal = ListCompanyPartners.getCompanyPartners();
        
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
            
            authors.add(new Author(1,"Гладкий", "Александр", "", "", stream.toByteArray()));
            authors.add(new Author(2,"Обуховская", "Дарья", "", "", null));
            
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
        String linkAuthor = adapterAuthor.getItem(position).getLink();
        if(linkAuthor != null && !linkAuthor.isEmpty()) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkAuthor));
            startActivity(browserIntent);
        } else Toast.makeText(requireActivity(), "Извините, но автор не предоставил ссылку на свой ресурс", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onItemClickCompanyPartners(View view, int position, CompanyPartners companyPartners) {
        String linkCompanyPartners = adapterCompany.getItem(position).getLink();
        if(linkCompanyPartners != null && !linkCompanyPartners.isEmpty()) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkCompanyPartners));
            startActivity(browserIntent);
        } else Toast.makeText(requireActivity(), "Извините, но партнер не предоставил ссылку на свой ресурс", Toast.LENGTH_SHORT).show();
    }
    private void openFormQuestionsFromAuthor() {
        QuestionsFromAuthorFragment questionsFromAuthorFragment = new QuestionsFromAuthorFragment();
        questionsFromAuthorFragment.setPartnersFragment(this);
        ((MainActivity) requireActivity()).getImg_fairies().setVisibility(View.GONE);
        ((MainActivity) requireActivity()).getProgressBar().setVisibility(View.GONE);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        frameLayoutFragmentPartners.setVisibility(View.VISIBLE);
        transaction.replace(frameLayoutFragmentPartners.getId(), questionsFromAuthorFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        
    }
    private void openAuthorPane(){
        SubmitAQuizToTheDatabaseFragment submitAQuizToTheDatabaseFragment = new SubmitAQuizToTheDatabaseFragment();
        
        ((MainActivity) requireActivity()).getImg_fairies().setVisibility(View.GONE);
        ((MainActivity) requireActivity()).getProgressBar().setVisibility(View.GONE);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        frameLayoutFragmentPartners.setVisibility(View.VISIBLE);
        transaction.replace(frameLayoutFragmentPartners.getId(), submitAQuizToTheDatabaseFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}