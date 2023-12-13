package com.ecloset.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.ecloset.Activity.AddClothesActivity;
import com.ecloset.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyBottomSheetDialog extends BottomSheetDialogFragment {
    private static final int CROP_PHOTO_TAKE = 12;
    private static final int CROP_PHOTO_LOCAL = 14;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_my_bottom_sheet, container, false);
        initView(view);
        return view;

    }


    private void initView(View view){
        //do something
        TextView tv_cancel = view.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        //照相模块
        LinearLayout btn_camera = view.findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        //相册模块
        LinearLayout btn_photo = view.findViewById(R.id.btn_photo);
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakeAlbumIntent();
            }
        });


    }

    private void dispatchTakeAlbumIntent(){
        Intent takeAlbumIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(takeAlbumIntent,CROP_PHOTO_LOCAL);
    }


    //有点问题
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, CROP_PHOTO_TAKE);
        // 确保有相机活动可以处理这个意图
//        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
//
//        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CROP_PHOTO_TAKE) {
                // 处理拍照返回的数据
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    // 创建要传递的新 Intent
                    Intent intent = new Intent(getActivity(), AddClothesActivity.class);
                    intent.putExtra("bitmap", imageBitmap); // 传递 Bitmap
                    startActivity(intent);
                }
            } else if (requestCode == CROP_PHOTO_LOCAL) {
                // 处理相册选择返回的数据
                Uri imageUri = data.getData();
                // 创建要传递的新 Intent
                Intent intent = new Intent(getActivity(), AddClothesActivity.class);
                intent.setData(imageUri); // 传递 Uri
                startActivity(intent);
            }
        }
    }


    @Override
    public void onStart() {
        super.onStart();
    }
}
