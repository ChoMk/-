package com.mksoft.followlistpagesample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorLong;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FollowListPageViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<FollowListPageListViewAdapter> followListAdapter = new ArrayList<>();
    private List<List<UserData>> items =  Collections.emptyList();
    FollowListPageViewPagerAdapter(Context context) {
        this.context = context;
        FollowListPageListViewAdapter followeeListAdapter =new FollowListPageListViewAdapter(context);
        FollowListPageListViewAdapter followerListAdapter =new FollowListPageListViewAdapter(context);
        followListAdapter.add(followeeListAdapter);
        followListAdapter.add(followerListAdapter);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null ;
        if (context != null) {
            // LayoutInflater를 통해 "/res/layout/page.xml"을 뷰로 생성.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.follow_list_page_viewpager_item, container, false);
            RecyclerView follow_list_page_recyclerView = view.findViewById(R.id.follow_list_page_recyclerView);
            RecyclerView.LayoutManager layoutManager;
            layoutManager = new LinearLayoutManager(context);
            follow_list_page_recyclerView.setHasFixedSize(true);
            follow_list_page_recyclerView.setAdapter(followListAdapter.get(position));
            follow_list_page_recyclerView.setLayoutManager(layoutManager);
        }
        container.addView(view) ;
        return view ;
    }

    public void updateFollowList(List<List<UserData>> items){
        this.items = items;
        for(int i =0; i<items.size(); i++){
            followListAdapter.get(i).updateFollowList(items.get(i));
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return  (view == (View)object);
    }


}
