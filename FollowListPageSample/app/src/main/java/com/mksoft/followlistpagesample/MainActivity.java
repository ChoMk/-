package com.mksoft.followlistpagesample;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    SwipeRefreshLayout follow_list_page_swipe_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        follow_list_page_swipe_layout = findViewById(R.id.follow_list_page_swipe_layout);

        viewPager = findViewById(R.id.follow_list_page_viewpager);
        tabLayout = findViewById(R.id.follow_list_page_tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addTab(tabLayout.newTab().setText("팔로워"));
        tabLayout.addTab(tabLayout.newTab().setText("팔로잉"));
        FollowListPageViewPagerAdapter followListPageViewPagerAdapter =new FollowListPageViewPagerAdapter(this);
        viewPager.setAdapter(followListPageViewPagerAdapter);

        viewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled( int position, float v, int i1 ) {
            }

            @Override
            public void onPageSelected( int position ) {
            }

            @Override
            public void onPageScrollStateChanged( int state ) {
                follow_list_page_swipe_layout.setEnabled( state == ViewPager.SCROLL_STATE_IDLE );
            }
        } );
        //스와이프의 새로고침과 옆으로 스크롤이 겹쳐지는 현상을 막을 수 있다.


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });//텝과 이어준다.
        List<List<UserData>> tempData = new ArrayList<>();
        List<UserData> temp1 = new ArrayList<>();
        List<UserData> temp2 = new ArrayList<>();

        for(int i =0; i<10; i++){
            UserData userData = new UserData();
            userData.setUserId("test1"+i);
            temp1.add(userData);
        }
        for(int i =0; i<10; i++){

            UserData userData = new UserData();
            userData.setUserId("test2"+i);
            temp2.add(userData);
        }
        tempData.add(temp1);
        tempData.add(temp2);
        followListPageViewPagerAdapter.updateFollowList(tempData);
    }
}
