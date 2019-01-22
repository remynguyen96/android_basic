package com.example.vn_ladm_chauntn.abc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class DisplayMessageActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_message);

    Intent intent = getIntent();
    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    TextView textView = findViewById(R.id.textView);

    Random random = new Random();
    int numberRandom = random.nextInt(10);

    textView.setText(String.valueOf(numberRandom + "--" + message));

    listViewArr();
  }


  public void listViewArr() {
    ListView layoutListView = (ListView) findViewById(R.id.listViewSubject);
    final ArrayList<String> arrSubject = new ArrayList<String>();
    arrSubject.add("Web Subject");
    arrSubject.add("Android Subject");
    arrSubject.add("Devobs Subject");
    arrSubject.add("IOS Subject");

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
      DisplayMessageActivity.this,
      android.R.layout.simple_list_item_1,
      arrSubject
    );

    layoutListView.setAdapter(adapter);

    layoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(DisplayMessageActivity.this, arrSubject.get(position), Toast.LENGTH_SHORT).show();
      }
    });

  }
}
