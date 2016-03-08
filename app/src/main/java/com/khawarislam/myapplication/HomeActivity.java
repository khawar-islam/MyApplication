package com.khawarislam.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void OnClick_contact(View view){
        Intent intent1=new Intent(this,ContactActivity.class );
        startActivity(intent1);

    }

    public  void OnClick_browser(View view)
    {
        Intent intent =new Intent(this, BrowserActivity.class);
        startActivity(intent);
    }


}
