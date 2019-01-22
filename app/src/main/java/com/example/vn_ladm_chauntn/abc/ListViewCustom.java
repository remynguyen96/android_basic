package com.example.vn_ladm_chauntn.abc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.widget.ListView;

import com.example.vn_ladm_chauntn.abc.adapter.CustomAdapter;
import com.example.vn_ladm_chauntn.abc.model.Contact;

import java.util.ArrayList;

public class ListViewCustom extends AppCompatActivity {
  private ListView lvContactCustom;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_view_custom2);

    lvContactCustom = (ListView) findViewById(R.id.lv_contact_custom);

    ArrayList<Contact> arrayList = new ArrayList<>();

    Contact contact1 = new Contact("Jack Johnon", "0958637566", Color.BLUE);
    Contact contact2 = new Contact("Remy Nguyen", "09437658556", Color.RED);
    Contact contact3 = new Contact("Honer Jack", "09348767563", Color.GRAY);
    Contact contact4 = new Contact("Reeuby Hoerk", "09357856743", Color.GREEN);
    Contact contact5 = new Contact("Jock Johny", "09578469456", Color.DKGRAY);
    Contact contact6 = new Contact("Kenny Hurk", "09346565645", Color.MAGENTA);
    Contact contact7 = new Contact("Hurk darken", "04837549556", Color.CYAN);
    Contact contact8 = new Contact("Light Enggy", "02395784667", Color.YELLOW);
    Contact contact9 = new Contact("Brother Hood", "09438756485", Color.LTGRAY);

    arrayList.add(contact1);
    arrayList.add(contact2);
    arrayList.add(contact3);
    arrayList.add(contact4);
    arrayList.add(contact5);
    arrayList.add(contact6);
    arrayList.add(contact7);
    arrayList.add(contact8);
    arrayList.add(contact9);

    CustomAdapter customAdapter = new CustomAdapter(this, R.layout.activity_row_item_contact, arrayList);

    lvContactCustom.setAdapter(customAdapter);
  }
}