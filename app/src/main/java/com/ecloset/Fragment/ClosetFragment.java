package com.ecloset.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ecloset.Adapter.TypeLeftAdapter;
import com.ecloset.Adapter.TypeRightAdapter;
import com.ecloset.Bean.MySqliteDB;
import com.ecloset.Bean.clothes;
import com.ecloset.R;

import java.util.ArrayList;
import java.util.List;

public class ClosetFragment extends Fragment {
    private ListView lv_left;
    private RecyclerView rv_right;
    private TypeLeftAdapter leftAdapter;
    private Context mContext;
    private TypeRightAdapter rightAdapter;
    private List<clothes> list_clothes;
    private MySqliteDB mydb;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        leftAdapter = new TypeLeftAdapter(mContext);
        mydb = new MySqliteDB(mContext);
    }

    public void GetData(String type){
        list_clothes = mydb.getClothes(type);
        //解析右边视图

        rightAdapter = new TypeRightAdapter(mContext, list_clothes);
        rv_right.setAdapter(rightAdapter);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        rv_right.setLayoutManager(manager);

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

    }
    private void initListener(){
        lv_left.setAdapter(leftAdapter);
        GetData("上衣");
        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GetData(leftAdapter.changeSelected(position));
                leftAdapter.notifyDataSetChanged();
            }
        });


    }





}