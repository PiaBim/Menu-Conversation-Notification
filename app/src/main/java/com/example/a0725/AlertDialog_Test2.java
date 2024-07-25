package com.example.a0725;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialog_Test2 extends AppCompatActivity {
    private String selectedDrink;
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialog_test2);

        imageView=findViewById(R.id.imageView);
        Button showDialogButton=findViewById(R.id.button);
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDrinkSelectionDialog();
            }
        });
    }
    private void showDrinkSelectionDialog(){
        final String[] drinks={"커피","티","밀크"};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("음료 선택")
                .setSingleChoiceItems(drinks, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            selectedDrink=drinks[which];
                            if(which==0) imageView.setImageResource(R.drawable.ic_launcher_background);
                            else if(which ==1) imageView.setImageResource(R.drawable.ic_launcher_foreground);
                            else imageView.setImageResource(R.drawable.ic_launcher_foreground);
                        }
                }).setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     dialog.dismiss();
                    }
                }).setNegativeButton("취소",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
}
