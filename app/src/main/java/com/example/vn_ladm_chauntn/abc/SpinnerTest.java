package com.example.vn_ladm_chauntn.abc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerTest extends AppCompatActivity {
  private Spinner spnCategories;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_spinner);
    spnCategories = (Spinner) findViewById(R.id.spnCategories);
    List<String> listView = new ArrayList<String>();
    listView.add("IOS");
    listView.add("Android");
    listView.add("Windows");
    listView.add("Linux");
    listView.add("MAC");

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, listView);

    adapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);

    spnCategories.setAdapter(adapter);
    spnCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    Toast.makeText(SpinnerTest.this, spnCategories.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(SpinnerTest.this, "Nothing", Toast.LENGTH_SHORT).show();
      }
    });


  }
}
