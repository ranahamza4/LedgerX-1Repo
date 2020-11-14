package com.bigcompany.ledgerx;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
        RecyclerView recyclerView=findViewById(R.id.homeRecycler);


        /* ------ in line 18 will be username of signed in user as per*/

        //Sample Data for home activity
        UserData[] mData= {
                new UserData("Rana Hamza","rana47","rdhamza47@gmail.com",500,1000),
                new UserData("Sarmad Sohaib","rana47","rdhamza47@gmail.com",300,1200),
                new UserData("Khaleek Ahmad","rana47","rdhamza47@gmail.com",200,100),
                new UserData("Rehan Anjum","rana47","rdhamza47@gmail.com",300,10),
                new UserData("Jutt Da Muqabla","rana47","rdhamza47@gmail.com",500,900)
        };

        //Connecting input Data to adapter
        UserDataAdapter adapter= new UserDataAdapter(mData,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*Linking menu_main.xml to Home activity*/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_profile:
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}