package com.example.a0725;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Pop_Menu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_menu);
    }
    public void onClick(View v){
        PopupMenu popup=new PopupMenu(this,v);
        popup.getMenuInflater().inflate(R.menu.pop_menu,popup.getMenu());
        popup.setOnMenuItemClickListener(
        new PopupMenu.OnMenuItemClickListener(){
            public boolean onMenuItemClick(MenuItem item){
                Toast.makeText(getApplicationContext(),"클릭된 팝업 메뉴:"+item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popup.show();
    }
}
