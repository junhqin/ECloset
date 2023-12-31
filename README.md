##  ECloset（E衣柜）开发日志

> 华东师范大学2023移动应用开发大作业
>
> 本项目有参照市面上“搭搭APP”页面设计和板块，是个人学习项目

- **存在的问题**

1. 状态栏沉浸式问题

3. `if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) ` 返回null，但是直接调用startActivityForResult确实能调用相机

   

- **已完成**

1. 利用lottie实现启动App的动画（12.8）
2. 设计好了登录界面（12.8）

3. 利用viewPager滑动Fragment（平时作业实现过了）

4. 利用BottomSheetDialogFragment实现上传图片时选择上传方式

5. 调用相机和相册功能

- **新学到的**

1. `setStyle` 是 `DialogFragment` 和 `BottomSheetDialogFragment` 中的一个方法，允许您设置对话框的样式和主题

2. @Nullable` 表示标注的元素可以是 `null,@NonNull` 表示标注的元素不能是 `null

3. 获取照相机及保存的代码参考https://developer.android.com/training/camera/photobasics?hl=zh-cn#java

4. 当你调用 `notifyDataSetChanged()` 方法时，`ListView` 会认为所有的可视化数据都可能已经改变，并将对可见区域内的==每个列表项==调用 `getView` 方法。



- ##### 踩坑

1. `drawable` 文件夹用于存储图形资源，PNG图片往往按不同尺寸存放，用来适配不同屏幕密度的设备。

![image-20231207185532645](./assets/image-20231207185532645.png)

2. 借助Android Studio生成图标（图片）的xml文件：[CSDN博客](https://blog.csdn.net/gongjing457/article/details/126149840?ops_request_misc=&request_id=&biz_id=102&utm_term=android%E4%B8%AD%E5%A6%82%E4%BD%95%E5%88%9B%E5%BB%BA%E5%9B%BE%E6%A0%87%E8%B5%84%E6%BA%90%E6%96%87%E4%BB%B6&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-1-126149840.142^v96^pc_search_result_base7&spm=1018.2226.3001.4187)

3. 后面发现bottomAppbar作为底部导航栏不是很明智的选择，最后采用透明BottomNavigationView实现BottomAppBar导航

   参考：[CSDN博客](https://blog.csdn.net/weixin_44759237/article/details/128667949?ops_request_misc=&request_id=&biz_id=102&utm_term=android%20%E5%BC%80%E5%8F%91%20bottomappbar&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-5-128667949.142pc_search_result_base7&spm=1018.2226.3001.4187)

4. `com.google.android.material:material`升级到1.8.0的坑，最后的解决，修改了版本。

   ```
   implementation("com.google.android.material:material:1.6.0")
   implementation("androidx.constraintlayout:constraintlayout:2.1.4")
   ```

![image-20231207203652957](./assets/image-20231207203652957.png)



5. 对于原始bottomNavigationView定制化可以看这条博客:[博客](https://blog.csdn.net/u012400885/article/details/110791780?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522170205354816800197072112%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=170205354816800197072112&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-1-110791780-null-null.142^v96^pc_search_result_base7&utm_term=%E5%A6%82%E4%BD%95%E4%BF%AE%E6%94%B9BottomNavigationView%E9%AB%98%E5%BA%A6&spm=1018.2226.3001.4187)

6. 模拟机对spinner的下拉框会有挤压得情况发生，放在真机上就是正常显示。

7. 

`RecyclerView` 中实现上下文菜单相对于 `ListView` 来说稍显复杂，本身不支持，只能自己实现触发上下文菜单的逻辑。
