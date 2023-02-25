package com.example.menus1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // Hiển thị thông báo khi người dùng chuyển đến Activity mới từ menuitem
        Toast.makeText(this, "Đã chuyển đến Activity mới!", Toast.LENGTH_SHORT).show();
    }
}

