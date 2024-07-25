package com.example.a0725;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DateTimePicker extends AppCompatActivity {
    private TextView selectedDateTextView, selectedTimeTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datetime_picker);

        selectedDateTextView = findViewById(R.id.editTextText1);
        selectedTimeTextView = findViewById(R.id.editTextText2);

        Button selectDateButton = findViewById(R.id.button1);
        Button selectTimeButton = findViewById(R.id.button2);
        selectDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        selectTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });
    }
    private void showDatePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view,int selectedYear,int selectedMonth,int selectedDayOfMonth) {
                String selectedDate = selectedYear + "/" + (selectedMonth + 1) + "/" + selectedDayOfMonth;
                selectedDateTextView.setText("선택한 날짜:"+selectedDate);

            }
        },year,month,dayOfMonth
        );
        datePickerDialog.show();
    }
    private void showTimePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
            @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                String selectedTime = selectedHour + ":" + selectedMinute;
                selectedTimeTextView.setText("선택한 시간:" + selectedTime);
            }
            },hour,minute,true);
                timePickerDialog.show();
    }
}
