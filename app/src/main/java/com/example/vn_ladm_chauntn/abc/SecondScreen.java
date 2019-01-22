package com.example.vn_ladm_chauntn.abc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
//import android.net.Uri;

public class SecondScreen extends AppCompatActivity {
  private static final String FIRST_VAL = "FIRST_VAL";
  private static final String SECOND_VAL = "SECOND_VAL";
  private static final String RESULT_APP = "RESULT_APP";
  public static final String RETURN_KEY_FOR_ACTIVE = "RETURN_KEY_FOR_ACTIVE";

  private EditText firstVal;
  private EditText secondVal;
  private TextView resultVal;

  private int firstNumber;
  private int secondNumber;
  private int resultNumber;


  @SuppressLint("LongLogTag")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second_screen);

    showIntent();

    firstVal = (EditText) findViewById(R.id.first);
    secondVal = (EditText) findViewById(R.id.second);
    resultVal = (TextView) findViewById(R.id.result);

//    resultVal.setText(String.valueOf(resultNumber));
    if (savedInstanceState != null) {
      firstVal.setText(String.valueOf(savedInstanceState.getInt(FIRST_VAL)));
      secondVal.setText(String.valueOf(savedInstanceState.getInt(SECOND_VAL)));
      resultVal.setText(String.valueOf(savedInstanceState.getInt(RESULT_APP)));
    }

    /*Button btnOpenUrl = (Button) findViewById(R.id.btnOpen);
    btnOpenUrl.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intentUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
        startActivity(intentUrl);
      }
    });*/
  }

  public void calculateSum(View view) {
    Button btnCalculate = (Button) findViewById(R.id.calculate);

    if (view == btnCalculate) {
      if (firstVal.getText().toString().isEmpty() || secondVal.getText().toString().isEmpty()) {
        Toast.makeText(this, "Please enter full number", Toast.LENGTH_SHORT).show();
      } else {
        firstNumber = Integer.parseInt(firstVal.getText().toString());
        secondNumber = Integer.parseInt(secondVal.getText().toString());

        resultNumber = firstNumber + secondNumber;
        resultVal.setText(String.valueOf(resultNumber));
//        finish();
      }
    }
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    if (!firstVal.getText().toString().isEmpty()) {
      outState.putInt(FIRST_VAL, Integer.parseInt(firstVal.getText().toString()));
    }
    if (!secondVal.getText().toString().isEmpty()) {
      outState.putInt(SECOND_VAL, Integer.parseInt(secondVal.getText().toString()));
    }
    if (!resultVal.getText().toString().isEmpty()) {
      outState.putInt(RESULT_APP, Integer.parseInt(resultVal.getText().toString()));
    }
    super.onSaveInstanceState(outState);
  }

  public void showIntent() {
    Intent intent = getIntent();
    String dataIntent1 = intent.getStringExtra(MainActivity.VALUE_FIRST);
    String dataIntent2 = intent.getStringExtra(MainActivity.VALUE_SECOND);
    Toast.makeText(this, dataIntent1 + "---" + dataIntent2, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void finish() {
    Intent intentData = new Intent();
    intentData.putExtra(RETURN_KEY_FOR_ACTIVE, "RETURN KEY ACTIVE SUCCESSFUL!");
    setResult(RESULT_OK, intentData);
    super.finish();
  }
}
