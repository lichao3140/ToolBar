package com.lichao.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back);

        //替换actionBar
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        toolbar.showOverflowMenu();
        //设置主标题字体样式
//        toolbar.setTitleTextAppearance();
        //设置副标题
//        toolbar.setSubtitleTextAppearance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.view_item, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        //v14    v14之后版本
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        SearchView searchView = (SearchView) menuItem.getActionView();

        ImageView imageView = searchView.findViewById(R.id.search_go_btn);
        imageView.setImageResource(R.drawable.abc_ic_voice_search_api_mtrl_alpha);
        imageView.setVisibility(View.VISIBLE);
        searchView.setSubmitButtonEnabled(true);
        return super.onCreateOptionsMenu(menu);
    }
}
