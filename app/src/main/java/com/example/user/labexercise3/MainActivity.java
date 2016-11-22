package com.example.user.labexercise3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    private int posit;
    private int[] Premium = new int[]{50,55,60,70,120,160,200,250};
    private int[] ExtraPremium = new int[]{0,0,50,100,100,50,0,0};
    private int[] ExtraPremiumSmoker = new int[]{0,0,0,100,150,150,250,250};
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create connection to UI
        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        checkBoxSmoker = (CheckBox) findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView) findViewById(R.id.textViewPremium);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.age_range,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView textViewAge;
        textViewAge = (TextView) findViewById(R.id.textViewAge);
        textViewAge.setText("Position="+position);
        posit=position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View v){
        int genderIndex = radioGroupGender.getCheckedRadioButtonId();
        int totalamount = 0;
        boolean isSmoker = checkBoxSmoker.isChecked();
        totalamount += Premium[posit];
        totalamount += ExtraPremium[posit];
        totalamount += ExtraPremiumSmoker[posit];
        textViewPremium.setText("Premium : RM"+totalamount);
    }
}
