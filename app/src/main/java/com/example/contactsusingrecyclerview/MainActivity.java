package com.example.contactsusingrecyclerview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //custom toolbar
    Toolbar toolbar;

    TabLayout tab;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpagerMain);


        ViewpagerAdapterContacts adapter = new ViewpagerAdapterContacts(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);

        //replacing the default action bar by custom toolbar. also enables us to use actionbar methods.
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            //accessing toolbar as an actionbar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My Contacts ");

        }
    }


    //converting menus xml layout into views using inflater
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.tool_bar, menu);

        return super.onCreateOptionsMenu(menu);
    }


    //onclick listener for the option buttons
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if(itemId == R.id.opt_new){
            Toast.makeText(this, "New created! ", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.opt_save){
            Toast.makeText(this, "Saved! ", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.opt_open){
            Toast.makeText(this, "Opened! ", Toast.LENGTH_SHORT).show();
        }else {
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}