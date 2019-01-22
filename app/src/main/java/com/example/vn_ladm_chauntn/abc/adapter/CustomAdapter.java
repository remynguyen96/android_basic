package com.example.vn_ladm_chauntn.abc.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vn_ladm_chauntn.abc.R;
import com.example.vn_ladm_chauntn.abc.model.Contact;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Contact> {
  private final String TAG = getClass().getSimpleName();
  private Context context;
  private int resource;
  private ArrayList<Contact> arrContact;

  public CustomAdapter(Context context, int resource, ArrayList<Contact> arrContact) {
    super(context, resource, arrContact);
    this.context = context;
    this.resource = resource;
    this.arrContact = arrContact;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.activity_row_item_contact, parent, false);
      viewHolder = new ViewHolder();
      viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
      viewHolder.tvPhone = (TextView) convertView.findViewById(R.id.tv_phone);
      viewHolder.tvColor = (TextView) convertView.findViewById(R.id.tv_color);
      
      Log.d(TAG, "getView: " + position);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }

    Contact contact = arrContact.get(position);

    viewHolder.tvName.setText(contact.getmName());
    viewHolder.tvPhone.setText(contact.getmNumber());
    viewHolder.tvColor.setBackgroundColor(contact.getmColor());
    viewHolder.tvColor.setText(String.valueOf(position + 1));

    return convertView;
  }

  public class ViewHolder {
    TextView tvName, tvPhone, tvColor;
  }
}
