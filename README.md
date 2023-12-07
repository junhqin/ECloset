##  ECloset（E衣柜）开发日志

> 华东师范大学2023移动应用开发大作业
>
> 本项目有参照市面上搭搭APP页面设计和板块，是个人学习项目









- ##### 开发学到的东西

1. `drawable` 文件夹用于存储图形资源，PNG图片往往按不同尺寸存放，用来适配不同屏幕密度的设备。

![image-20231207185532645](./assets/image-20231207185532645.png)

2. 借助Android Studio生成图标（图片）的xml文件：[CSDN博客](https://blog.csdn.net/gongjing457/article/details/126149840?ops_request_misc=&request_id=&biz_id=102&utm_term=android%E4%B8%AD%E5%A6%82%E4%BD%95%E5%88%9B%E5%BB%BA%E5%9B%BE%E6%A0%87%E8%B5%84%E6%BA%90%E6%96%87%E4%BB%B6&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-1-126149840.142^v96^pc_search_result_base7&spm=1018.2226.3001.4187)

3. 
4. `com.google.android.material:material`升级到1.8.0的坑

![image-20231207203652957](./assets/image-20231207203652957.png)

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Activity.MainActivity">

    <androidx.coordinatorlayout.widget.CoordinatorLayout
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent">


        <com.google.android.material.bottomappbar.BottomAppBar
            android:id="@+id/app_bar"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            android:layout_gravity="bottom"
            app:backgroundTint="@color/white"

            app:fabCradleMargin="8dp"
            app:fabCradleRoundedCornerRadius="50dp"
            app:fabCradleVerticalOffset="6dp">


            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="0.25"
                    android:orientation="vertical">

                    <ImageView
                        android:id="@+id/bottom_home"
                        android:layout_width="20dp"
                        android:layout_height="20dp"
                        android:layout_gravity="center"
                        android:layout_marginTop="8dp"
                        app:srcCompat="@drawable/home" />

                    <TextView
                        android:id="@+id/tv_home"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:text="主页"
                        android:textAlignment="center" />
                </LinearLayout>

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="0.25"
                    android:orientation="vertical">

                    <ImageView
                        android:id="@+id/bottom_clothes"
                        android:layout_width="20dp"
                        android:layout_height="20dp"
                        android:layout_gravity="center"
                        android:layout_marginTop="8dp"
                        app:srcCompat="@drawable/clothes" />

                    <TextView
                        android:id="@+id/tv_clothes"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:text="搭配"
                        android:textAlignment="center" />
                </LinearLayout>

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="0.25"
                    android:orientation="vertical"
                    android:visibility="invisible">

                    <ImageView
                        android:id="@+id/i_another"
                        android:layout_width="20dp"
                        android:layout_height="20dp"
                        android:layout_gravity="center"
                        android:layout_marginTop="8dp"
                        app:srcCompat="@drawable/home" />

                    <TextView
                        android:id="@+id/tv_another"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:text="Home"
                        android:textAlignment="center" />
                </LinearLayout>

                <LinearLayout
                    android:id="@+id/pofileBtn"
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="0.25"
                    android:orientation="vertical">

                    <ImageView
                        android:id="@+id/bottom_closet"
                        android:layout_width="20dp"
                        android:layout_height="20dp"
                        android:layout_gravity="center"
                        android:layout_marginTop="8dp"
                        app:srcCompat="@drawable/closet" />

                    <TextView
                        android:id="@+id/textView12"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:text="衣柜"
                        android:textAlignment="center" />
                </LinearLayout>

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="0.25"
                    android:orientation="vertical">

                    <ImageView
                        android:id="@+id/bottom_mine"
                        android:layout_width="20dp"
                        android:layout_height="20dp"
                        android:layout_gravity="center"
                        android:layout_marginTop="8dp"
                        app:srcCompat="@drawable/mine" />

                    <TextView
                        android:id="@+id/tv_mine"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:text="我的"
                        android:textAlignment="center" />
                </LinearLayout>
            </LinearLayout>
        </com.google.android.material.bottomappbar.BottomAppBar>


        <com.google.android.material.floatingactionbutton.FloatingActionButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:contentDescription="TODO"
            app:layout_anchor="@id/app_bar"
            app:maxImageSize="30dp"
            app:shapeAppearance="@style/ShapeAppearanceOverlay.Material3.Button"
            app:srcCompat="@drawable/add" />
    </androidx.coordinatorlayout.widget.CoordinatorLayout>


</androidx.constraintlayout.widget.ConstraintLayout>
```

