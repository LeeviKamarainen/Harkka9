package com.example.harkka9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    Context context = null;
    SmartPost smartPost = new SmartPost();
    Spinner list;
    EditText date;
    String input_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        list = findViewById(R.id.spinner);
        date = findViewById(R.id.Date1);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        smartPost.readXML();
        final ArrayAdapter<Post> adapter = new ArrayAdapter<Post>(this, android.R.layout.simple_spinner_item, SmartPost.posts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list.setAdapter(adapter);
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
    public void refresh(View v) {
        smartPost.readXML();
    }

    public void readData(View v) {
        Post post = (Post) list.getSelectedItem();
        Toast.makeText(context, post.getName() + "\n" + post.getLocation() + "\n" + post.getAvailability() + "\n" + post.getId(), Toast.LENGTH_SHORT).show();
    }

    public void getDate(View v) {
        try {
            input_date = date.getText().toString();
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
            Date dt1 = format1.parse(input_date);
            DateFormat format2 = new SimpleDateFormat("u");
            String finalDay = format2.format(dt1);
            System.out.println(finalDay);
        } catch (ParseException e) {
            Toast.makeText(context,"Invalid date-type.",Toast.LENGTH_SHORT).show();
            System.out.println("Error");
        }
    }
}
