package com.example.harkka9;

import android.net.ParseException;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Post {


    public int id;
    public String name;
    public String location;
    public String availability;
    public String weekdayend;
    public int weekdayend;
    public String timestart;
    public String timeend;

    private static int parseDayOfWeek(String day, Locale locale)
            throws ParseException {
        SimpleDateFormat dayFormat = new SimpleDateFormat("E", locale);
        Date date = dayFormat.parse(day);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }
    public Post(int i, String n, String l, String a)    {
        String list[];
        name = n;
        location = l;
        availability = a;
        id = i;
        list = availability.split(",");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }


    @NonNull
    @Override
    public String toString() {
        String parsed[] = name.split(",");
        String parsed2 = parsed[1].trim();

        return parsed2;
    }
}
