package com.example.finalspractice;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.finalspractice.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    Button btnChangePhoto;
    ImageView bg;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        bg = binding.imageView;
        btnChangePhoto = binding.btnChangeIcon;
        TextView changeMe = binding.changeMe;

//        binding.imageView.setImageResource(R.drawable.salad);
//        changeMe.setText("Some text");

//        binding.btnChangeIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Toast.makeText(getActivity(), "123", Toast.LENGTH_LONG).show();
////                binding.imageView.setImageResource(R.drawable.salad);
//                Log.i("whatever", "any message");
//            }
//        });

        binding.btnChangeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void changeStuff(View view) {
//        Toast.makeText(getActivity(), "123", Toast.LENGTH_LONG).show();
//        binding.imageView.setImageResource(R.drawable.salad);
//        Log.i("whatever", "any message");
        binding.changeMe.setText("Some text");

    }
}