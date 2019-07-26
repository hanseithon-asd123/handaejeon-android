package com.example.handaejeon.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.handaejeon.R;
import com.example.handaejeon.adapter.RankingAdatper;
import com.example.handaejeon.model.RankingInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tv_name, tv_email;
    SharedPreferences sharedPreferences;
    String token, email;

    RecyclerView recyclerView;
    RankingAdatper adatper;
    List<RankingInfo> rankingInfos = new ArrayList<>();

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getApplicationContext().getSharedPreferences("Token", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");
        email = sharedPreferences.getString("email", "");

        if (token.equals("")) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {

        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("U KANG PU");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        tv_email = findViewById(R.id.tv_email);
        tv_name = findViewById(R.id.tv_name);

        recyclerView = findViewById(R.id.main_recyclerview);
        adatper = new RankingAdatper(rankingInfos);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adatper);
        Data();


    }

    public void Data() {
        rankingInfos.add(new RankingInfo(1, 12000, "강민우"));
        rankingInfos.add(new RankingInfo(2, 11000, "임희선"));
        rankingInfos.add(new RankingInfo(3, 10000, "조성원"));
        rankingInfos.add(new RankingInfo(4, 9000, "박준영"));
        rankingInfos.add(new RankingInfo(5, 8000, "최민규"));
        rankingInfos.add(new RankingInfo(6, 7000, "오유원"));
        rankingInfos.add(new RankingInfo(7, 6000, "김우혁"));
        rankingInfos.add(new RankingInfo(8, 5000, "이예준"));
        rankingInfos.add(new RankingInfo(9, 4000, "이주연"));
        rankingInfos.add(new RankingInfo(10, 3000, "김선규"));
        rankingInfos.add(new RankingInfo(11, 2000, "추성빈"));

        adatper.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(MainActivity.this, MyPageActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);


        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
