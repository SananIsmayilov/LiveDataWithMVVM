package com.sananismayilov.livedata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.sananismayilov.livedata.databinding.ActivityMainBinding;
import com.sananismayilov.livedata.fragments.FirstFragment;
import com.sananismayilov.livedata.fragments.SecondFragment;
import com.sananismayilov.livedata.tablayoutcomponents.TabAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public ArrayList<Fragment> fragmentArrayList;
    private ArrayList<String> fragmentArrayListTittle;
   private ViewPager2 viewPager2;
   public TabAdapter tabAdapter;

private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        TabLayoutInitialize();
    }

    public  void TabLayoutInitialize(){
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(FirstFragment.newInstance());
        fragmentArrayList.add(SecondFragment.newInstance());

        fragmentArrayListTittle = new ArrayList<>();
        fragmentArrayListTittle.add("First");
        fragmentArrayListTittle.add("Second");

        tabAdapter = new TabAdapter(this,fragmentArrayList);
        binding.pager2.setAdapter(tabAdapter);

        new TabLayoutMediator(binding.tabs, binding.pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(fragmentArrayListTittle.get(position));
            }
        }).attach();


    }
}