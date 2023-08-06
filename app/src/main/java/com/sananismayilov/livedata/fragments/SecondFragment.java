package com.sananismayilov.livedata.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sananismayilov.livedata.R;
import com.sananismayilov.livedata.databinding.FragmentSecondBinding;
import com.sananismayilov.livedata.viewmodel.MainActivityViewModel;


public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    private MainActivityViewModel mainActivityViewModel;
    public SecondFragment() {
        // Required empty public constructor
    }


    public static SecondFragment newInstance() {

        return new SecondFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mainActivityViewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false);

        mainActivityViewModel.getStringMutableLiveData().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                System.out.println("textt" + s);
                binding.textView.setText(s);
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}