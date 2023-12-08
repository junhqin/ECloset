package com.ecloset.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.ecloset.Adapter.vpAdapter;
import com.ecloset.Fragment.ClosetFragment;
import com.ecloset.Fragment.ClothesFragment;
import com.ecloset.Fragment.HomeFragment;
import com.ecloset.Fragment.MineFragment;
import com.ecloset.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private BottomNavigationView mbottomNavigationView;
    private vpAdapter mStateVpAdapter;
    private List<Fragment> mFragmentList;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onPagerScrolled(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if( item.getItemId()==R.id.menu_home){
                    mViewPager.setCurrentItem(0);
                }

                else if (item.getItemId()==R.id.menu_clothes)
                {
                    mViewPager.setCurrentItem(1);
                }

                else if (R.id.menu_closet== item.getItemId()) {
                    mViewPager.setCurrentItem(2);
                }
                else if (R.id.menu_mine== item.getItemId()) {
                    mViewPager.setCurrentItem(3);
                }
                return true;

            }
        });
    }
    private void onPagerScrolled(int position) {
        switch (position) {
            case 0:
                mbottomNavigationView.setSelectedItemId(R.id.menu_home);
                break;
            case 1:
                mbottomNavigationView.setSelectedItemId(R.id.menu_clothes);
                break;
            case 2:
                mbottomNavigationView.setSelectedItemId(R.id.menu_closet);
                break;
            case 4:
                mbottomNavigationView.setSelectedItemId(R.id.menu_mine);
                break;
            default:
                break;
        }
    }
    private void init(){
        mViewPager = findViewById(R.id.vp);
        mbottomNavigationView = findViewById(R.id.bottom_menu);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new ClothesFragment());
        mFragmentList.add(new ClosetFragment());
        mFragmentList.add(new MineFragment());
        mStateVpAdapter = new vpAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mStateVpAdapter);
    }

}