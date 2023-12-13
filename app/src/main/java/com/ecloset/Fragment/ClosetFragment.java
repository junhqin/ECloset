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
import androidx.recyclerview.widget.RecyclerView;

import com.ecloset.Adapter.TypeLeftAdapter;
import com.ecloset.R;

public class ClosetFragment extends Fragment {
    private ListView lv_left;
    private RecyclerView rv_right;
    private TypeLeftAdapter leftAdapter;
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        leftAdapter = new TypeLeftAdapter(mContext);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_closet, container, false);
        initView(view);
        initListener();
        return view;
    }

    private void initView(View view){
        lv_left = (ListView) view.findViewById(R.id.lv_left);
        rv_right = (RecyclerView) view.findViewById(R.id.rv_right);
        lv_left.setAdapter(leftAdapter);
    }
    private void initListener(){

    }


}