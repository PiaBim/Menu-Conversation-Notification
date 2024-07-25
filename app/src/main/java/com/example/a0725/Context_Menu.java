package com.example.a0725;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Context_Menu extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_menu);
        text=(TextView)findViewById(R.id.textView1);
        registerForContextMenu(text);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("컨텍스트메뉴");
        menu.add(0,1,0,"배경색:빨강");
        menu.add(0,2,0,"배경색:초록");
        menu.add(0,3,0,"배경색:파랑");
        menu.add(0,4,0,"빨강");
        menu.add(0,5,0,"초록");
        menu.add(0,6,0,"파랑");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==1){
            text.setBackgroundColor(Color.RED);
            return true;
            }
        else if(id==2){
            text.setBackgroundColor(Color.GREEN);
            return true;
        }
        else if(id==3) {
            text.setBackgroundColor(Color.BLUE);
            return true;
        }
        else if(id==4){
            text.setTextColor(Color.RED);
            return true;
        }
        else if(id==5){
            text.setTextColor(Color.GREEN);
            return true;
        }
        else if(id==6){
            text.setTextColor(Color.BLUE);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}

