package com.example.vn_ladm_chauntn.abc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = MainActivity.class.getSimpleName();
  public static final String EXTRA_MESSAGE = "SEND_MESSAGE";
  public static final int REQUEST_CODE = 2019;
  public static final String VALUE_FIRST = "VALUE_FIRST";
  public static final String VALUE_SECOND = "VALUE_SECOND";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState == null) {
      Log.e(TAG, "Bug here!");
    } else {
      Log.e(TAG, "Well done!");
    }

    setContentView(R.layout.activity_main);
    listNavigation();
  }

  public void showToast(View view) {
    Intent intentToast = new Intent(MainActivity.this, SecondScreen.class);
    intentToast.putExtra(VALUE_FIRST, "VALUE FIRST 1.");
    intentToast.putExtra(VALUE_SECOND, "VALUE SECOND 2.");

    startActivityForResult(intentToast, REQUEST_CODE);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
      if (data.hasExtra(SecondScreen.RETURN_KEY_FOR_ACTIVE));
      Toast.makeText(this, data.getStringExtra(SecondScreen.RETURN_KEY_FOR_ACTIVE), Toast.LENGTH_SHORT).show();
    }
  }

  public void sendMessage(View view) {
    Intent serviceIntent = new Intent(this, DisplayMessageActivity.class);

    EditText editText = (EditText) findViewById(R.id.editText);
    String message = editText.getText().toString();
    serviceIntent.putExtra(EXTRA_MESSAGE, message);
//    Bundle bundle = new Bundle();
    startActivity(serviceIntent);
  }

  public void listNavigation() {
    ListView listNavigation = (ListView) findViewById(R.id.listViewNavigation);
    final ArrayList<String> arrView = new ArrayList<String>();
    arrView.add("First Layout XML 1");
    arrView.add("Core Layout Linear 2");
    arrView.add("Calculator 3");
    arrView.add("Spinner Tutorial 4");
    arrView.add("Dialog And AlertDialog 5");
    arrView.add("ListView Basic 6");
    arrView.add("ListView Custom Basic 7");
    arrView.add("Shared Preferences Basic 8");
    arrView.add("Layout Custom Sixth Default");

    ArrayAdapter<String> adapterLayout = new ArrayAdapter<>(
      MainActivity.this,
      android.R.layout.simple_list_item_1,
      arrView
    );

    listNavigation.setAdapter(adapterLayout);
    listNavigation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intentLayout;

        switch (position + 1) {
          case 1:
            intentLayout = new Intent(MainActivity.this, FirstLayout.class);
            break;
          case 2:
            intentLayout = new Intent(MainActivity.this, CoreLinear.class);
            break;
          case 3:
            intentLayout = new Intent(MainActivity.this, Calculator.class);
            break;
          case 4:
            intentLayout = new Intent(MainActivity.this, SpinnerTest.class);
            break;
          case 5:
            intentLayout = new Intent(MainActivity.this, DialogAndAlert.class);
            break;
          case 6:
            intentLayout = new Intent(MainActivity.this, ListViewBasic.class);
            break;
          case 7:
            intentLayout = new Intent(MainActivity.this, ListViewCustom.class);
            break;
          case 8:
            intentLayout = new Intent(MainActivity.this, SharedPreferencesBasic.class);
            break;
          default:
            intentLayout = new Intent(MainActivity.this, CoreRelative.class);
            break;
        }
        startActivity(intentLayout);
      }
    });
  }
}