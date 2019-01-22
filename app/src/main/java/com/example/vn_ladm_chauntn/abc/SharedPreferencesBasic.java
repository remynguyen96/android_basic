package com.example.vn_ladm_chauntn.abc;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SharedPreferencesBasic extends AppCompatActivity {
  public final String SHARED_PREFERENCES_NAME = "TestABC";
  public final String NAME = "NAME";
  public final String AGE = "AGE";
  public final String IS_SINGLE = "IS_SINGLE";
  private Button btnSaveData;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shared_preferences_basic);
    btnSaveData = (Button) findViewById(R.id.saveData);
    btnSaveData.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME, "Remy Nguyen");
        editor.putInt(AGE, 23);
        editor.putBoolean(IS_SINGLE, false);

        editor.apply();
      }
    });


  }
}
