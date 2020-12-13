package com.bigcompany.ledgerx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

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

        mTakeGiveBottomNavigation.setOnNavigationItemSelectedListener(takeOrGiveNavigationSelector);

        actionBar.setTitle("His name"); // name of clicked user
        TakeFragment takeFragment = new TakeFragment();
        FragmentTransaction takeFragmentTransaction = getSupportFragmentManager().beginTransaction();
        takeFragmentTransaction.replace(R.id.fl_hisLedger_contents, takeFragment, "");
        takeFragmentTransaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener takeOrGiveNavigationSelector
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.nav_his_take:
                    actionBar.setTitle("Take from user_name");
                    TakeFragment takeFragment = new TakeFragment();
                    FragmentTransaction takeFragmentTransaction = getSupportFragmentManager().beginTransaction();
                    takeFragmentTransaction.replace(R.id.fl_hisLedger_contents, takeFragment, "");
                    takeFragmentTransaction.commit();
                    return true;
                case R.id.nav_his_give:
                    actionBar.setTitle("Give to user_name");
                    GiveFragment giveFragment = new GiveFragment();
                    FragmentTransaction giveFragmentTransaction = getSupportFragmentManager().beginTransaction();
                    giveFragmentTransaction.replace(R.id.fl_hisLedger_contents, giveFragment, "");
                    giveFragmentTransaction.commit();
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