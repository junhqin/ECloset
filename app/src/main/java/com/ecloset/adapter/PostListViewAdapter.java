package com.ecloset.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ecloset.Bean.Post;
import com.ecloset.R;
import com.opendanmaku.DanmakuItem;
import com.opendanmaku.DanmakuView;
import com.opendanmaku.IDanmakuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PostListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<Post> postList;
    private List<String> comment_list;
    private int[] drawables = new int[] {
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4
    };

    public PostListViewAdapter(Context mContext, List<Post> postList) {
        this.mContext = mContext;
        this.postList = postList;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_post_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Post post = postList.get(position);
        holder.tvComments.setText(String.valueOf(post.getComments()));
        holder.tvAddTime.setText(post.getPostTime()); // 假设有getAddTime()方法
        holder.tvSaying.setText(post.getSaying());
        holder.tvLikes.setText(String.valueOf(post.getLikes()));
        holder.ivCommunityFigure.setImageResource(R.drawable.img_1); // 替换 some_image 为您的某个实际的图片资源名
//        Log.d("qjh",post.getImg());
//
//        String imageName = post.getImg().substring(0, post.getImg().lastIndexOf('.'));
//        Log.d("qjh",""+ mContext.getPackageName());
//        int imageResId = mContext.getResources().getIdentifier(imageName, "drawable", mContext.getPackageName());
//        Log.d("qjh",""+imageResId);
        int index = Integer.parseInt(post.getId());
        holder.ivCommunityFigure.setImageResource(drawables[index-1]);


        comment_list = (List<String>) post.getCommentLists();
        if (comment_list != null && comment_list.size() > 0) {
            holder.danmakuView.setVisibility(View.VISIBLE);

            List<IDanmakuItem> list = new ArrayList<>();
            for (int i = 0; i < comment_list.size(); i++) {
                IDanmakuItem item = new DanmakuItem(mContext, comment_list.get(i), holder.danmakuView.getWidth());
                list.add(item);
            }
            Collections.shuffle(comment_list);
            holder.danmakuView.addItem(list, true);
            holder.danmakuView.show();
        }else{
            holder.danmakuView.setVisibility(View.GONE);
        }



        return convertView;
    }



    //绑定视图组件

    static class ViewHolder{
        private RelativeLayout rl;
        private ImageView ivCommunityFigure;
        private DanmakuView danmakuView;
        private TextView tvComments;
        private ImageButton ibNewPostAvatar;
        private TextView tvAddTime;
        private TextView tvSaying;
        private TextView tvLikes;
        ViewHolder(View view) {
            rl = view.findViewById(R.id.rl);
            ivCommunityFigure = view.findViewById(R.id.iv_community_figure);
            danmakuView = view.findViewById(R.id.danmakuView);
            tvComments = view.findViewById(R.id.tv_comments);
            ibNewPostAvatar = view.findViewById(R.id.ib_new_post_avatar);
            tvAddTime = view.findViewById(R.id.tv_addtime);
            tvSaying = view.findViewById(R.id.tv_saying);
            tvLikes = view.findViewById(R.id.tv_likes);
        }
    }

}
