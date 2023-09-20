package ru.great_larder.sportquiz.ui.partners;

import android.annotation.SuppressLint;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import ru.great_larder.sportquiz.database.author_and_partners.ListLoadAuthor;
import ru.great_larder.sportquiz.databinding.FragmentPartnersBinding;
import ru.great_larder.sportquiz.domain.Author;
import ru.great_larder.sportquiz.ui.questions_from_the_author.QuestionsFromAuthorFragment;
import ru.great_larder.sportquiz.ui.submit.SubmitAQuizToTheDatabaseFragment;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PartnersFragment extends Fragment implements RecyclerViewAdapterAuthor.ItemClickListener{

    private RecyclerViewAdapterAuthor adapterAuthor;
    public RecyclerView recycleViewAuthors;
    public FrameLayout frameLayoutFragmentPartners;
//    public ImageView imageViewAuthorFrPartOpen;
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
        Button buttonDYWTB_anAuthor = binding.buttonDYWTBAnAuthor;
        frameLayoutFragmentPartners = binding.frameLayoutFragmentPartners;

        /*imageViewAuthorFrPartOpen = binding.imageViewAuthorFrPartOpen;
        imageViewAuthorFrPartOpen.setClickable(true);
        imageViewAuthorFrPartOpen.setOnClickListener(c-> openAuthorPane());*/
        
        loadFragment();
        
        buttonDYWTB_anAuthor.setOnClickListener(v-> openFormQuestionsFromAuthor());
        
        return root;
    }
    
    @SuppressLint("UseCompatLoadingForDrawables")
    public void loadFragment() {
        List<Author> authorsExternal = ListLoadAuthor.getAuthors();
        if(authorsExternal != null && !authorsExternal.isEmpty()) {
            List<String> nameAuthor = new ArrayList<>();
            List<String> lastNameAuthor = new ArrayList<>();
            List<byte[]> photoAuthor = new ArrayList<>();
            for (Author author : authorsExternal) {
                nameAuthor.add(author.getFirstNameAuthor());
                lastNameAuthor.add(author.getLastNameAuthor());
                photoAuthor.add(author.getPhoto());
            }
            
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(requireActivity()
                , LinearLayoutManager.HORIZONTAL, false);
            recycleViewAuthors.setLayoutManager(horizontalLayoutManager);
            adapterAuthor = new RecyclerViewAdapterAuthor(requireActivity(), nameAuthor, lastNameAuthor, photoAuthor);
        } else {
            List<Author> authors = new ArrayList<>();
            authors.add(new Author("Обуховская", "Дарья", null));
            @SuppressLint("UseCompatLoadingForDrawables")
            Bitmap bitmap = ((BitmapDrawable) Objects.requireNonNull(ContextCompat.getDrawable(requireActivity(), R.drawable.a_s_gl))).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            
            authors.add(new Author("Гладкий", "Александр", stream.toByteArray()));
            authors.add(new Author("", "", null));
            authors.add(new Author("", "", null));
            
            List<String> nameAuthor = new ArrayList<>();
            List<String> lastNameAuthor = new ArrayList<>();
            List<byte[]> photoAuthor = new ArrayList<>();
            for (Author author : authors) {
                nameAuthor.add(author.getFirstNameAuthor());
                lastNameAuthor.add(author.getLastNameAuthor());
                photoAuthor.add(author.getPhoto());
            }
            
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(requireActivity()
                , LinearLayoutManager.HORIZONTAL, false);
            recycleViewAuthors.setLayoutManager(horizontalLayoutManager);
            adapterAuthor = new RecyclerViewAdapterAuthor(requireActivity(), nameAuthor, lastNameAuthor, photoAuthor);
        }
        adapterAuthor.setClickListener(this);
        recycleViewAuthors.setAdapter(adapterAuthor);
    }
    
    @Override
    public void onItemClick(View view, int position) {
//        Toast.makeText(requireActivity(), "Вы нажали " + adapterAuthor.getItem(position) + " по позиции элемента " + position, Toast.LENGTH_SHORT).show();
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