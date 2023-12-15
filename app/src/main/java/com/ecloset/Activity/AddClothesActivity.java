package com.ecloset.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ecloset.Bean.MySqliteDB;
import com.ecloset.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddClothesActivity extends ToolbarActivity {
    private static final int CROP_PHOTO_TAKE = 12;
    private static final int CROP_PHOTO_LOCAL = 14;
    private ImageView img_new;
    private Spinner spinner;
    private EditText et_name;
    private Button btn_save;
    private MySqliteDB mydb;
    private Bitmap bitmap;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothes);
        mydb = new MySqliteDB(this);
        initView();
        initListener();
        setupToolbar();
        // 获取 Intent 中的 Bitmap 数据
        bitmap = getIntent().getParcelableExtra("bitmap");
        if (bitmap != null) {
            img_new.setImageBitmap(bitmap);
        }

        // 或者，获取 Intent 中的 Uri 数据
        imageUri = getIntent().getData();
        if (imageUri != null) {
            img_new.setImageURI(imageUri);
        }

        //衣服分类选择spin
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.clothes_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }


    private void  initListener(){
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveClothes();
            }
        });
    }

    private void initView(){
        mToolbar = findViewById(R.id.toolbar);
        img_new = findViewById(R.id.img_new);
        spinner =findViewById(R.id.spin_category);
        et_name = findViewById(R.id.et_name);
        btn_save = findViewById(R.id.btn_save);
    }


    private String saveImageToInternalStorage(Bitmap bitmap) {
        String imageName = "clothes_" + System.currentTimeMillis() + ".jpg";
        File directory = getApplicationContext().getFilesDir();
        File imageFile = new File(directory, imageName);
        Log.d("qjh", "!!!");
        try {
            FileOutputStream fos = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();

            return imageFile.getAbsolutePath();
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }

    }

    private void saveClothes(){
        String name = et_name.getText().toString();
        String category = spinner.getSelectedItem().toString();
        String imagePath = null;
        if (bitmap != null) {
            // 保存从相机获取的Bitmap图片
            Log.d("qjh", "PASS");
            imagePath = saveImageToInternalStorage(bitmap);
        } else if (imageUri != null) {
            // 从Uri获取Bitmap，然后保存
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                imagePath = saveImageToInternalStorage(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 将信息保存到数据库
        if (imagePath != null) {
            MySqliteDB db = new MySqliteDB(this);
            db.addClothes(name, category, imagePath);
        }

        Toast.makeText(AddClothesActivity.this, "保存成功",Toast.LENGTH_SHORT).show();
        finish();
    }
}