package com.example.nooru.tlma_fyp.Controller;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.codetroopers.betterpickers.datepicker.DatePickerDialogFragment;
import com.codetroopers.betterpickers.timepicker.TimePickerBuilder;
import com.codetroopers.betterpickers.timepicker.TimePickerDialogFragment;
import com.example.nooru.tlma_fyp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by nooru on 9/22/2017.
 */

public class TwoFragment extends Fragment {
    Calendar c= Calendar.getInstance();
    int year, month, day;
    static int hour, min;
    java.sql.Time timeValue;

    TextView txtstartdate, txtstarttime,txtenddate, txtendtime;
    Button btnstarttimepicker, btnstartdatepicker,btnendtimepicker, btnenddatepicker;
    SimpleDateFormat formatter;
    SimpleDateFormat format;
    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        hour = c.get(Calendar.HOUR_OF_DAY);
        min = c.get(Calendar.MINUTE);

        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        txtstartdate = (TextView) view.findViewById(R.id.txtstartdate);
        txtenddate = (TextView)view.findViewById(R.id.txtenddate);
        txtstarttime = (TextView)view.findViewById(R.id.txtstarttime);
        txtendtime = (TextView)view.findViewById(R.id.txtendtime);
        btnstartdatepicker = (Button)view.findViewById(R.id.btnstartdatepicker);
        btnstarttimepicker = (Button)view.findViewById(R.id.btnstarttimepicker);
        btnenddatepicker = (Button)view.findViewById(R.id.btnenddatepicker);
        btnendtimepicker = (Button)view.findViewById(R.id.btnendtimepicker);

        btnstartdatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerBuilder dpb = new DatePickerBuilder()
                        .setFragmentManager(getFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment_Light)
                        .setYearOptional(true);

                dpb.show();
                dpb.addDatePickerDialogHandler(new DatePickerDialogFragment.DatePickerDialogHandler() {
                                                   @Override
                                                   public void onDialogDateSet(int reference, int year, int monthOfYear, int dayOfMonth) {
                                                       try {
                                                           formatter = new SimpleDateFormat("dd/MM/yyyy");
                                                           String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                                           Date date = formatter.parse(dateInString);
                                                           txtstartdate.setText(formatter.format(date).toString());
                                                           formatter = new SimpleDateFormat("dd/MMM/yyyy");

                                                           txtstartdate.setText(txtstartdate.getText().toString() + "\n" + formatter.format(date).toString());

                                                           formatter = new SimpleDateFormat("dd-MM-yyyy");

                                                           txtstartdate.setText(txtstartdate.getText().toString() + "\n" + formatter.format(date).toString());

                                                           formatter = new SimpleDateFormat("dd.MMM.yyyy");

                                                           txtstartdate.setText(txtstartdate.getText().toString() + "\n" + formatter.format(date).toString());
                                                       } catch (Exception ex) {
                                                           txtstartdate.setText(ex.getMessage().toString());
                                                       }
                                                   }
                                               }

                );
            }
        });
        btnenddatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerBuilder dpb = new DatePickerBuilder()
                        .setFragmentManager(getFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment_Light)
                        .setYearOptional(true);

                dpb.show();
                dpb.addDatePickerDialogHandler(new DatePickerDialogFragment.DatePickerDialogHandler() {
                                                   @Override
                                                   public void onDialogDateSet(int reference, int year, int monthOfYear, int dayOfMonth) {
                                                       try {
                                                           formatter = new SimpleDateFormat("dd/MM/yyyy");
                                                           String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                                           Date date = formatter.parse(dateInString);
                                                           txtenddate.setText(formatter.format(date).toString());
                                                           formatter = new SimpleDateFormat("dd/MMM/yyyy");

                                                           txtenddate.setText(txtenddate.getText().toString() + "\n" + formatter.format(date).toString());

                                                           formatter = new SimpleDateFormat("dd-MM-yyyy");

                                                           txtenddate.setText(txtenddate.getText().toString() + "\n" + formatter.format(date).toString());

                                                           formatter = new SimpleDateFormat("dd.MMM.yyyy");

                                                           txtenddate.setText(txtenddate.getText().toString() + "\n" + formatter.format(date).toString());
                                                       } catch (Exception ex) {
                                                           txtenddate.setText(ex.getMessage().toString());
                                                       }
                                                   }
                                               }

                );
            }
        });

        btnstarttimepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerBuilder tpb = new TimePickerBuilder()
                        .setFragmentManager(getFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                tpb.show();
                tpb.addTimePickerDialogHandler(new TimePickerDialogFragment.TimePickerDialogHandler() {
                    @Override
                    public void onDialogTimeSet(int reference, int hourOfDay, int minute) {
                        try {
                            String dtStart = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
                            format = new SimpleDateFormat("HH:mm");

                            timeValue = new java.sql.Time(format.parse(dtStart).getTime());
                            txtstarttime.setText(String.valueOf(timeValue));
                            String amPm = hourOfDay % 12 + ":" + minute + " " + ((hourOfDay >= 12) ? "PM" : "AM");
                            txtstarttime.setText(amPm + "\n" + String.valueOf(timeValue));
                        } catch (Exception ex) {
                            txtstarttime.setText(ex.getMessage().toString());
                        }
                    }
                });
            }
        });
        btnendtimepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerBuilder tpb = new TimePickerBuilder()
                        .setFragmentManager(getFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment_Light);
                tpb.show();
                tpb.addTimePickerDialogHandler(new TimePickerDialogFragment.TimePickerDialogHandler() {
                    @Override
                    public void onDialogTimeSet(int reference, int hourOfDay, int minute) {
                        try {
                            String dtStart = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
                            format = new SimpleDateFormat("HH:mm");

                            timeValue = new java.sql.Time(format.parse(dtStart).getTime());
                            txtendtime.setText(String.valueOf(timeValue));
                            String amPm = hourOfDay % 12 + ":" + minute + " " + ((hourOfDay >= 12) ? "PM" : "AM");
                            txtendtime.setText(amPm + "\n" + String.valueOf(timeValue));
                        } catch (Exception ex) {
                            txtendtime.setText(ex.getMessage().toString());
                        }
                    }
                });
            }
        });
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}