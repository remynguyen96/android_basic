package com.example.vn_ladm_chauntn.abc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewBasic extends AppCompatActivity {

  private ListView lv_contact;
  private String number[] = {"0937853635", "09433554635", "09838484334", "09723563754", "03483847574"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_view_basic);

    lv_contact = (ListView) findViewById(R.id.lv_contact);

    ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, number);

    lv_contact.setAdapter(adapter);

    lv_contact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(ListViewBasic.this, number[position], Toast.LENGTH_SHORT).show();
      }
    });

  }
}
