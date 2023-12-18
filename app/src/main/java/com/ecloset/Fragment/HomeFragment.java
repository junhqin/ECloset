package com.ecloset.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ecloset.Adapter.PostListViewAdapter;
import com.ecloset.Bean.Post;
import com.ecloset.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    private ListView lv_post;
    private List<Post> resultPost;
    private Context mContext;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mContext = getActivity();
        initView(view);
        initData();
        return view;
    }

    private void initView(View view){
        lv_post = view.findViewById(R.id.lv_post);
    }

    private void initData(){
        resultPost = createMockPosts();
        PostListViewAdapter adapter = new PostListViewAdapter(mContext, resultPost);
        lv_post.setAdapter(adapter);

    }
    private List<Post> createMockPosts() {
        // 创建和填充模拟帖子数据
        List<Post> posts = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            List<String> comments = Arrays.asList("评论 " + i + "-1", "评论 " + i + "-2");
            Post post = new Post(
                    String.valueOf(i),
                    "用户" + i,
                    "这是第" + i + "个模拟帖子。",
                    "image_" + i + ".png", // 使用drawable资源
                    comments,
                    "2023-12-17 10:00:00",
                    i * 10, // 假设每个帖子的喜欢数为ID的10倍
                    comments.size()
            );
            posts.add(post);
        }
        return posts;
    }
}