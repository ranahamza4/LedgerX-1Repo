package com.bigcompany.ledgerx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HisLedgerActivity extends AppCompatActivity {

    ActionBar actionBar;

    BottomNavigationView mTakeGiveBottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_his_ledger);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mTakeGiveBottomNavigation = findViewById(R.id.bnv_hisLedger_navigateTakeGive);

        actionBar.setTitle("His name"); // name of clicked user
        mTakeGiveBottomNavigation.setOnNavigationItemSelectedListener(takeOrGiveNavigationSelector);
    }

    BottomNavigationView.OnNavigationItemSelectedListener takeOrGiveNavigationSelector
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.nav_his_take:
                    actionBar.setTitle("user Name(Take)");
                    return true;
                case R.id.nav_his_give:
                    actionBar.setTitle("user Name(Give)");
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}