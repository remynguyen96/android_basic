package com.example.vn_ladm_chauntn.abc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CoreLinear extends AppCompatActivity {
  private LinearLayout linearLayoutRoot;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initialLayoutLinear();
    setContentView(linearLayoutRoot);
    //    setContentView(R.layout.activity_core_linear);
  }

  public void initialLayoutLinear() {
    linearLayoutRoot = new LinearLayout(this);
    LinearLayout.LayoutParams layoutParamsRoot = new LinearLayout.LayoutParams(
      ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
    );
    linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
    linearLayoutRoot.setLayoutParams(layoutParamsRoot);

//    LinearLayout second
    LinearLayout linearSecond = new LinearLayout(this);
    linearSecond.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    linearSecond.setOrientation(LinearLayout.HORIZONTAL);

//    ImageView

    ImageView imgView = new ImageView(this);
    imgView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    imgView.setImageResource(R.mipmap.ic_launcher);

//    TextView
    TextView tv = new TextView(this);
    LinearLayout.LayoutParams paramsTx = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    paramsTx.setMargins(20 , 0, 0, 0);
    paramsTx.gravity = Gravity.CENTER;
    tv.setLayoutParams(paramsTx);
    tv.setText(R.string.hi_msg);

    linearSecond.addView(imgView);
    linearSecond.addView(tv);

//    Button Click

    Button btnClick = new Button(this);
    LinearLayout.LayoutParams paramsBtn = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    paramsBtn.gravity = Gravity.CENTER;
    btnClick.setPadding(20, 0, 0, 0);
    btnClick.setLayoutParams(paramsBtn);
    btnClick.setAllCaps(false);
    btnClick.setText(R.string.subscribe);

    Button btnClick2 = new Button(this);
    btnClick2.setPadding(20, 0, 0, 0);
    btnClick2.setLayoutParams(paramsBtn);
    btnClick2.setAllCaps(false);
    btnClick2.setText(R.string.edit_message);

    linearLayoutRoot.addView(linearSecond);
    linearLayoutRoot.addView(btnClick);
    linearLayoutRoot.addView(btnClick2);
  }
}
