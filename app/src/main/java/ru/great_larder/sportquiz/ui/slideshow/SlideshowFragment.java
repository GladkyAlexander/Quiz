package ru.great_larder.sportquiz.ui.slideshow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.request_set_mysql.SetQuestionMathematicsImpl;
import ru.great_larder.sportquiz.database.mysql.request_set_mysql.SetQuestionSportsImpl;
import ru.great_larder.sportquiz.databinding.FragmentSlideshowBinding;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionMathematics;

public class SlideshowFragment extends Fragment {
    
    private FragmentSlideshowBinding binding;
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
            new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SlideshowViewModel.class);
        
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        /*final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/
        ImageButton imageButtonVK = binding.imageButtonVK;
        ImageButton imageButtonTelegram = binding.imageButtonTelegram;
        TextView textViewMail = binding.textViewMail;
        TextView textViewCall = binding.textViewCall;
        
        imageButtonVK.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/public221127130"));
            startActivity(browserIntent);
        });
        imageButtonTelegram.setOnClickListener(v -> {
            //Intent browserTelegram = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/+buSTBjoX_D9kMGQy"));
            Intent browserTelegram = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/@a_s_gladky"));
            startActivity(browserTelegram);
        });
        return root;
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}