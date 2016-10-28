package com.example.administrator.day06_04sms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    private EditText ed_phone;
    private EditText editText_content;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_phone = (EditText) findViewById(R.id.ed_phone);
        editText_content = (EditText) findViewById(R.id.ed_text);


    }

    /**
     * @param requestCode:请求码;用来判断请求谁的数据
     * @param resultCode:返回码:用来判断哪个activity返回的数据
     * @param data                               :返回的数据
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == 10)
        {
            String phone = data.getStringExtra("phone");
            ed_phone.setText(phone);
        } else if (resultCode == 20)
        {
            //说明数据是smsmodelActivity返回的
            String sms = data.getStringExtra("smscontent");
            editText_content.setText(sms);


        }
    }

    public void OnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bt1:
                Intent intent = new Intent(this, ContestActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.bt_send:
                String phone = ed_phone.getText().toString().trim();
                String content = editText_content.getText().toString().trim();

                //点击按钮发送短信
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phone, null, content, null, null);

                break;
            case R.id.bt_insert:
                Intent intent1 = new Intent(this, MsmModelActivity.class);
                startActivityForResult(intent1, 2);


                break;
        }


    }
}
