package com.lccj.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.radio1_1)
  RadioButton mRadio_1_1;

  @BindView(R.id.radio1_2)
  RadioButton mRadio_1_2;

  @BindView(R.id.radio1_3)
  RadioButton mRadio_1_3;

  @BindView(R.id.radio2_1)
  RadioButton mRadio_2_1;

  @BindView(R.id.radio2_2)
  RadioButton mRadio_2_2;

  @BindView(R.id.radio2_3)
  RadioButton mRadio_2_3;

  @BindView(R.id.edtAnswer3)
  EditText mEdtAnwer3;

  @BindView(R.id.checkbox4_1)
  RadioButton mChecked4_1;

  @BindView(R.id.checkbox4_2)
  RadioButton mChecked4_2;

  @BindView(R.id.checkbox4_3)
  RadioButton mChecked4_3;

  @BindView(R.id.checkbox5_1)
  RadioButton mChecked5_1;

  @BindView(R.id.checkbox5_2)
  RadioButton mChecked5_2;

  @BindView(R.id.checkbox5_3)
  RadioButton mChecked5_3;

  @BindView(R.id.radioGroup1)
  RadioGroup radioGroup1;

  @BindView(R.id.radioGroup2)
  RadioGroup radioGroup2;

  @BindView(R.id.radioGroup3)
  RadioGroup radioGroup3;

  @BindView(R.id.radioGroup4)
  RadioGroup radioGroup4;

  private boolean isCheckedQ1, isCheckedQ2, isCheckedQ4, isCheckedQ5;
  private int scoreQ1, scoreQ2, scoreQ3, scoreQ4, scoreQ5;
  private String answer3;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  public void onCheckQuestion1(View view){

    isCheckedQ1 = ((RadioButton) view).isChecked();

    switch(view.getId()) {
      case R.id.radio1_1:
        if (isCheckedQ1)
          scoreQ1 = 0;
        break;

      case R.id.radio1_2:
        if (isCheckedQ1)
          scoreQ1 = 0;
        break;

      case R.id.radio1_3:
        if (isCheckedQ1)
          scoreQ1 = 20;
        break;
    }
  }

  public void onCheckQuestion2(View view){

    isCheckedQ2 = ((RadioButton) view).isChecked();

    switch(view.getId()) {
      case R.id.radio2_1:
        if (isCheckedQ2)
          scoreQ2 = 0;
        break;

      case R.id.radio2_2:
        if (isCheckedQ2)
          scoreQ2 = 20;
        break;

      case R.id.radio2_3:
        if (isCheckedQ2)
          scoreQ2 = 0;
        break;
    }
  }

  public void Question3(View view){

    answer3 =  mEdtAnwer3.getText().toString();

    if((mEdtAnwer3 != null) && answer3.toLowerCase().equals("JAVA"))

      scoreQ3 = 20;

    else
      scoreQ3 = 0;
  }

  public void onCheckQuestion4(View view){

    isCheckedQ4 = ((RadioButton) view).isChecked();

    switch(view.getId()) {
      case R.id.checkbox4_1:
        if (isCheckedQ4)
          scoreQ4 = 0;
        break;

      case R.id.checkbox4_2:
        if (isCheckedQ4)
          scoreQ4 = 20;
        break;

      case R.id.checkbox4_3:
        if (isCheckedQ4)
          scoreQ4 = 0;
        break;
    }
  }

  public void onCheckQuestion5 (View view){

    isCheckedQ5 = ((RadioButton) view).isChecked();

    switch(view.getId()) {
      case R.id.checkbox5_1:
        if (isCheckedQ5)
          scoreQ5 = 0;
        break;

      case R.id.checkbox5_2:
        if (isCheckedQ5)
          scoreQ5 = 0;
        break;

      case R.id.checkbox5_3:
        if (isCheckedQ5)
          scoreQ5 = 20;
        break;
    }
  }

  public void checkResult(View view) {

    if (isCheckedQ1 && isCheckedQ2 && !answer3.equals("") && isCheckedQ4 && isCheckedQ5 ) {

      int resultTotal = scoreQ1 + scoreQ2 + scoreQ3 + scoreQ4 + scoreQ5;

      Toast.makeText(MainActivity.this,
          "Your score is: " + resultTotal, Toast.LENGTH_LONG).show();

    }

    Toast.makeText(MainActivity.this,
        "Please answer all the questions", Toast.LENGTH_LONG).show();

  }

  public void restart(View view){

    uncheckRadioGroup(radioGroup1);
    uncheckRadioGroup(radioGroup2);
    uncheckRadioGroup(radioGroup3);
    uncheckRadioGroup(radioGroup4);

    mEdtAnwer3.setText("");
  }

  private void uncheckRadioGroup(RadioGroup radioGroup) {
    radioGroup.clearCheck();
  }

  }

