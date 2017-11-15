package com.hqs.vevo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.hqs.vevo.adapter.MyPagerAdapter;
import com.hqs.vevo.config.Config;
import com.hqs.vevo.fragment.VevoCategoryFragment;
import com.hqs.vevo.fragment.VevoExploreFragment;
import com.hqs.vevo.imageloader.PicassoImageLoader;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Banner banner;
    private List<String> bannerImageUrls;

    private String[] tabTitles = new String[]{ "探索", "个人养成", "日常生活", "家的管理", "家的升级" };
    private ViewPager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        fullScreen(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);        //去掉显示标题

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // 广告轮播
        banner = (Banner) findViewById(R.id.banner);
        banner.setImageLoader(new PicassoImageLoader());
        bannerImageUrls = new ArrayList<String>();
        bannerImageUrls.add("https://wewow.wewow.com.cn/article/20171109/185610204098.png");
        bannerImageUrls.add("https://wewow.wewow.com.cn/article/20171102/153519284814.png");
        bannerImageUrls.add("https://wewow.wewow.com.cn/article/20171109/190304699993.png");
        banner.setImages(bannerImageUrls);
        banner.setDelayTime(Config.BANNER_DELAY_TIME );
        banner.start();

        // tabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        for( int i = 0 ; i < tabTitles.length ; i++ ){
            tabLayout.addTab( tabLayout.newTab().setText(tabTitles[i]) );
        }
        mainViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        setUpViewPager();

        tabLayout.setupWithViewPager(mainViewPager);
    }

    private void setUpViewPager() {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(VevoExploreFragment.newInstance(),tabTitles[0]);
        adapter.addFragment(VevoCategoryFragment.newInstance("2"),tabTitles[1]);
        adapter.addFragment(VevoCategoryFragment.newInstance("3"),tabTitles[2]);
        adapter.addFragment(VevoCategoryFragment.newInstance("4"),tabTitles[3]);
        adapter.addFragment(VevoCategoryFragment.newInstance("5"),tabTitles[4]);
        mainViewPager.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 在 onStart() 方法开始 自动播放
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 在 onStop() 方法停止 自动播放
        banner.stopAutoPlay();
    }

    private void fullScreen(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                //导航栏颜色也可以正常设置
//                window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
//                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("tag","activity 被销毁");
    }
}
