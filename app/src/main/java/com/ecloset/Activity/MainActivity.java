package com.ecloset.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.ecloset.Adapter.vpAdapter;
import com.ecloset.dialog.MyBottomSheetDialog;
import com.ecloset.Fragment.ClosetFragment;
import com.ecloset.Fragment.ClothesFragment;
import com.ecloset.Fragment.HomeFragment;
import com.ecloset.Fragment.MineFragment;
import com.ecloset.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private BottomNavigationView mbottomNavigationView;
    private vpAdapter mStateVpAdapter;
    private List<Fragment> mFragmentList;
    private FloatingActionButton btn_add;
    private TextView tv_title;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();
        setListener();
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
            case 3:
                mbottomNavigationView.setSelectedItemId(R.id.menu_mine);
                break;
            default:
                break;
        }
    }


    private void init(){
        tv_title = findViewById(R.id.title);
        btn_add = findViewById(R.id.floatingButton);
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

    private void setListener(){
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
                    tv_title.setText("主页");
                }

                else if (item.getItemId()==R.id.menu_clothes)
                {
                    mViewPager.setCurrentItem(1);
                    tv_title.setText("逛逛");
                }

                else if (R.id.menu_closet== item.getItemId()) {
                    mViewPager.setCurrentItem(2);
                    tv_title.setText("衣橱");
                }
                else if (R.id.menu_mine== item.getItemId()) {
                    mViewPager.setCurrentItem(3);
                    tv_title.setText("我的");
                }
                return true;

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermission();
                MyBottomSheetDialog myBottomSheetDialog = new MyBottomSheetDialog();
                myBottomSheetDialog.show(getSupportFragmentManager(), "MyBottomSheetDialog");
            }
        });

    }

    //动态申请权限
    private void requestPermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
        }
    }
}