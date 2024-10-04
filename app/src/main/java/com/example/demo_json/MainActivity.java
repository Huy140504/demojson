package com.example.demo_json;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        try {
            // Đọc file JSON từ thư mục assets
            String jsonString = loadJSONFromAsset("f.json");


            //333
            // Parse chuỗi JSON thành đối tượng JSONObject
            JSONObject jsonObject = new JSONObject(jsonString);

            // Hiển thị nội dung JSON
            textView.setText(jsonObject.toString(4)); // Số 4 là số khoảng trắng để định dạng
        } catch (JSONException e) {
            e.printStackTrace();
            textView.setText("Lỗi khi parse JSON: " + e.getMessage());
        }
    }

    private String loadJSONFromAsset(String fileName) {
        String json;
        try {
            InputStream is = getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}