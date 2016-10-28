package com.example.administrator.day06_02renping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText ed_name;
    private RadioGroup radioGroup;
    private int sex;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_name = (EditText) findViewById(R.id.edit);
        radioGroup= (RadioGroup) findViewById(R.id.radio_group);

    }

    public  void OnClick(View view)
    {
        String name = ed_name.getText().toString().trim();
        if (name.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"请输入姓名",Toast.LENGTH_LONG).show();
            return;
        }
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        switch (radioButtonId)
        {
            case R.id.rb1:
                sex = 1;
                break;
            case R.id.rb2:
                sex = 2;
                break;
            case R.id.rb3:
                sex = 3;
                break;
        }
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("name",name);//用intent传递数据
        intent.putExtra("sex",sex);
        startActivity(intent);


    }
}
