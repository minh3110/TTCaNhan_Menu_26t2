package com.example.menus1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private Button PopupButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tìm và lấy reference đến Button trong layout
        PopupButton = findViewById(R.id.btnPopupMenu);
        // Đặt OnClickListener cho Button
        PopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo PopupMenu mới, gắn vào Button
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, PopupButton);

                // Inflate menu vào PopupMenu
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                // Đặt OnMenuItemClickListener cho PopupMenu
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Kiểm tra xem MenuItem nào được click và xử lý tương ứng
                        switch (menuItem.getItemId()) {
                            case R.id.menu_item1:
                                // Chuyển sang NewActivity và hiển thị thông báo
                                Intent intent1 = new Intent(MainActivity.this, NewActivity.class);
                                startActivity(intent1);
                                Toast.makeText(MainActivity.this, "Popup menu item 1 clicked", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu_item2:
                                // Chuyển sang NewActivity và hiển thị thông báo
                                Intent intent2 = new Intent(MainActivity.this, NewActivity.class);
                                startActivity(intent2);
                                Toast.makeText(MainActivity.this, "Popup menu item 2 clicked", Toast.LENGTH_SHORT).show();
                                return true;

                            default:
                                return false;
                        }
                    }
                });

                // Hiển thị PopupMenu
                popupMenu.show();
            }


        });

        ///Contextual menu
//        TextView textView = findViewById(R.id.text_view);
        registerForContextMenu(findViewById(R.id.text_view));

    };


    //option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item1:
                // Nếu người dùng click vào menu item 1
                // Thực hiện chuyển sang một activity mới và in ra thông báo
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                intent.putExtra("MESSAGE", "Bạn đã click vào Menu Item 1");
                startActivity(intent);
                return true;
            case R.id.menu_item2:
                // Nếu người dùng click vào menu item 2
                // Thực hiện chuyển sang một activity mới và in ra thông báo
                Intent intent2 = new Intent(MainActivity.this, NewActivity.class);
                intent2.putExtra("MESSAGE", "Bạn đã click vào Menu Item 2");
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //contextual menu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextual_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
     int id = item.getItemId();
     if (id == R.id.menu_item1) {
         Intent intent = new Intent(this,NewActivity.class);
         startActivity(intent);
         Toast.makeText(this, "Menu item 1 selected",Toast.LENGTH_SHORT).show();
         return true;
     } else if (id == R.id.menu_item2) {
         Intent intent = new Intent(this, NewActivity.class);
         startActivity(intent);
         Toast.makeText(this, "Menu item 2 selected", Toast.LENGTH_SHORT).show();
         return true;
     }

        return super.onContextItemSelected(item);
    }



}