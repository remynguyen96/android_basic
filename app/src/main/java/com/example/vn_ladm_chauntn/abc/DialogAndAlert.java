package com.example.vn_ladm_chauntn.abc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogAndAlert extends AppCompatActivity {
  private Button btnShow;
  private Button btnShowAlert;
  Dialog dialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dialog_and_alert);

    btnShowAlert = (Button) findViewById(R.id.btn_show_alert_dialog);
    btnShowAlert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogAndAlert.this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("Are you sure want to logout?");
        builder.setCancelable(false);
        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(DialogAndAlert.this, "Logout Successful!", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
          }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

      }
    });


    btnShow = (Button) findViewById(R.id.btn_show_dialog);
    btnShow.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showDialog();
      }
    });
  }

  public void showDialog() {
    dialog = new Dialog(DialogAndAlert.this);
    dialog.setTitle("Warning");
    dialog.setCancelable(false);
    dialog.setContentView(R.layout.dialog_layout);
    dialog.show();
  }

  public void logoutDialog(View view) {
    Toast.makeText(DialogAndAlert.this, "Logout Successful!", Toast.LENGTH_SHORT).show();
    dialog.dismiss();
  }

  public void cancelDialog(View view) {
        dialog.dismiss();
  }


}
