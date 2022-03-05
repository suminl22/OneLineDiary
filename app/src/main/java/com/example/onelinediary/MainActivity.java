package com.example.onelinediary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements OnTabItemSelectedListener{

    Fragment fragment1;
    Fragment fragment2;
    Fragment fragment3;

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment();
        fragment2 = new Fragment();
        fragment3 = new Fragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item){
                        switch (item.getItemId()){
                            case R.id.tab1:
                                Toast.makeText(getApplicationContext(),"첫 번째 탭 선택됨",Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                                return true;

                            case R.id.tab2:
                                Toast.makeText(getApplicationContext(),"두 번째 탭 선택됨",Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                                return true;

                            case R.id.tab3:
                                Toast.makeText(getApplicationContext(),"세 번째 탭 선택됨",Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
                                return true;
                        }
                        return false;
                    }
                });
    }

    public void onTabSelected(int position){
        if(position==0){
            bottomNavigation.setSelectedItemId(R.id.tab1);
        } else if(position==1){
            bottomNavigation.setSelectedItemId(R.id.tab2);
        } else if(position==2){
            bottomNavigation.setSelectedItemId(R.id.tab3);
        }
    }
}