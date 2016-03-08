package com.khawarislam.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.view.View;
import android.widget.EditText;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class ContactActivity extends Activity {

    EditText mEditFullName;
    EditText mEditPhoneNumber;
    EditText mEditComments;
    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();
        popualte();

    }

  private void popualte(){
      String strname=mSharedPreferences.getString("key_name","N/A");
      mEditFullName.setText(strname);
      mEditPhoneNumber.setText(mSharedPreferences.getString("key_phone", ""));

  }
  private void init()
  {
      mSharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
      mEditFullName=(EditText) findViewById(R.id.contact_EditText_name);
      mEditPhoneNumber=(EditText) findViewById(R.id.contact_EditText_phone);
      mEditComments=(EditText)findViewById(R.id.contact_EditText_comment);
  }

    private  void  showMessage(String messsage)
    {
        Toast.makeText(this, messsage,Toast.LENGTH_SHORT).show();
    }

     private void savePreferences()
     {
         SharedPreferences.Editor editor= mSharedPreferences.edit();
         editor.putString("key_name",mEditFullName.getText().toString());
         editor.putString("key_phone",mEditPhoneNumber.getText().toString());
         editor.putString("key_phone", mEditComments.getText().toString());
         editor.commit();

     }

    private boolean isValidate()
    {
        if (mEditFullName.length()==0) {
            showMessage("Please give the name");
            return false;
        }
        else if (mEditPhoneNumber.getText().toString().equalsIgnoreCase(""))
        {
            showMessage("Please Phone the name");
            return false;
        }
        else if (mEditComments.getText().toString().equalsIgnoreCase(""))
        {
            showMessage("Please give the Comment");
            return  false;
        }
        return  true;
    }

    public void onClick_send(View view)
    {
        if (isValidate()){
            savePreferences();
            startActivity(new Intent(this, ThanksActivity.class));
            finish();
        }
    }
}
