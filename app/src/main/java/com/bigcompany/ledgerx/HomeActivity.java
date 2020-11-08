package com.bigcompany.ledgerx;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Memory of ------");
        /* ------ in line 18 will be username of signed in user as per*/

  /*---UI Related Code*/
        RecyclerView mrecyclerView =findViewById(R.id.homeRecyclerView);
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Code Just For Testing purpose. Here real data of users will be applied afterwards
        UserData[] myUserData=new UserData[]{
                new UserData("Rana Hamza","@RD47","rdhamza47",500,1000),
                new UserData("Sarmad Sohaib","@RD47","rdhamza47",900,100),
                new UserData("Khaleek Ahmad","@RD47","rdhamza47",5010,3400),
                new UserData("Hamood Zicco","@RD47","rdhamza47",5120,1340),
                new UserData("Muhammad Nouman","@RD47","rdhamza47",40,10),
                new UserData("Haseeb Rao","@RD47","rdhamza47",300,1200),
                new UserData("Rehan Anjum","@RD47","rdhamza47",900,1500),
                new UserData("Aman Usman","@RD47","rdhamza47",1500,300),
                new UserData("Jutt da Muqabla","@RD47","rdhamza47",400,90000),

        };
        UserDataAdapter userDataAdapter= new UserDataAdapter(myUserData,this);
        mrecyclerView.setAdapter(userDataAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*Linking menu_main.xml to Home activity*/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);


        return super.onCreateOptionsMenu(menu);
    }
}