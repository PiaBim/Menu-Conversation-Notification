package com.example.a0725;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomDialog extends AppCompatActivity implements View.OnClickListener{
    TextView text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customdialog);
        text = findViewById(R.id.textView);

    }
    @Override
    public void onClick(View v){
        final Dialog loginDialog = new Dialog(this);
        loginDialog.setContentView(R.layout.customdialog_sub);
        loginDialog.setTitle("로그인 화면");

        Button login=(Button) loginDialog.findViewById(R.id.button1);
        Button cancel=(Button) loginDialog.findViewById(R.id.button2);
        final EditText username = (EditText) loginDialog.findViewById(R.id.editTextText1);
        final EditText password = (EditText) loginDialog.findViewById(R.id.editTextText2);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(username.getText().toString().trim().length()>0&&password.getText().toString().trim().length()>0){
                    Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_LONG).show();
                    text.setText("아이디: "+username.getText()+"\n패스워드:"+password.getText());
                    loginDialog.dismiss();
                }else{
                    Toast.makeText(getApplicationContext(),"다시 입력",Toast.LENGTH_LONG).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                loginDialog.dismiss();
            }
        });
        loginDialog.show();
    }

}
