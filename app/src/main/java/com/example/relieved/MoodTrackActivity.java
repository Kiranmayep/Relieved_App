package com.example.relieved;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MoodTrackActivity extends AppCompatActivity {

    EditText editdate,editrate;
    TextView date,rate,title,month,save;
    LineChart linechart;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myref;
    LineDataSet lineDataSet = new LineDataSet(null,null);
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    LineData lineData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_track);

        editdate=findViewById(R.id.editdate);
        editrate=findViewById(R.id.editrate);
        save=findViewById(R.id.save);
        date=findViewById(R.id.date);
        rate=findViewById(R.id.rate);
        title=findViewById(R.id.title);
        month=findViewById(R.id.month);
        linechart=findViewById(R.id.linechart);

        firebaseDatabase=firebaseDatabase.getInstance();
        myref=firebaseDatabase.getReference("ChartValues");
        insertData();
        lineDataSet.setLineWidth(6);

    }

    private void insertData() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=myref.push().getKey();
                int x = Integer.parseInt(editdate.getText().toString());
                int y = Integer.parseInt(editrate.getText().toString());

                DataPoint dataPoint = new DataPoint(x,y);
                myref.child(id).setValue(dataPoint);

                retrieveData();

            }
        });
    }

    private void retrieveData() {
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Entry> dataVals = new ArrayList<Entry>();

                if(dataSnapshot.hasChildren()){
                    for(DataSnapshot myDataSnapshot:dataSnapshot.getChildren()){
                        DataPoint dataPoint = myDataSnapshot.getValue(DataPoint.class);
                        dataVals.add(new Entry(dataPoint.geteditdate(),dataPoint.geteditrate()));
                    }
                    showChart(dataVals);
                }else{
                    linechart.clear();
                    linechart.invalidate();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void showChart(ArrayList<Entry> dataVals) {
        lineDataSet.setValues(dataVals);
        lineDataSet.setLabel("Date");
        iLineDataSets.clear();
        iLineDataSets.add(lineDataSet);
        lineData = new LineData((iLineDataSets));
        linechart.clear();
        linechart.setData(lineData);
        linechart.invalidate();


    }
}