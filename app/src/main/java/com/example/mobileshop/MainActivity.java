package com.example.mobileshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity   implements AdapterView.OnItemSelectedListener {
    String[] Mob = {"Select" ,"Samsung", "Iphone", "Huawei", "Nokia"};
    ListView listView;
    TextView textView;
    String[] listItem;
    String value="";
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        listView=(ListView)findViewById(R.id.Listview);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Mob);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                        {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                                // TODO Auto-generated method stub
                                                 value=adapter.getItem(position);

                                      Price();
                                            }
                                        }
        );


    }
    public void Price()
    {
        switch (value) {
            case "Note9 128": Toast.makeText(MainActivity.this,"630$", Toast.LENGTH_SHORT).show();break;
            case "Note9 256":Toast.makeText(MainActivity.this,"600$", Toast.LENGTH_SHORT).show();break;
            case "S9-Plus": Toast.makeText(MainActivity.this,"550$", Toast.LENGTH_SHORT).show();break;
            case"A9-2018" : Toast.makeText(MainActivity.this,"400$", Toast.LENGTH_SHORT).show();break;

            case "ip x 64 silver": Toast.makeText(MainActivity.this,"900$", Toast.LENGTH_SHORT).show();break;
            case "ip x 64 black":Toast.makeText(MainActivity.this,"850$", Toast.LENGTH_SHORT).show();break;
            case "ip 8 64 silver": Toast.makeText(MainActivity.this,"800$", Toast.LENGTH_SHORT).show();break;
            case"ip 8 128" : Toast.makeText(MainActivity.this,"7500$", Toast.LENGTH_SHORT).show();break;


            case "Y9 2019": Toast.makeText(MainActivity.this,"205$", Toast.LENGTH_SHORT).show();break;
            case "Y7 2019":Toast.makeText(MainActivity.this,"155$", Toast.LENGTH_SHORT).show();break;
            case "Y7 2018": Toast.makeText(MainActivity.this,"142$", Toast.LENGTH_SHORT).show();break;
            case"Y5 2018" : Toast.makeText(MainActivity.this,"100$", Toast.LENGTH_SHORT).show();break;

            case "Nokia 8": Toast.makeText(MainActivity.this,"200$", Toast.LENGTH_SHORT).show();break;
            case "Nokia 7":Toast.makeText(MainActivity.this,"125$", Toast.LENGTH_SHORT).show();break;
            case "Nokia 6": Toast.makeText(MainActivity.this,"115$", Toast.LENGTH_SHORT).show();break;
            case"Nokia 5" : Toast.makeText(MainActivity.this,"190$", Toast.LENGTH_SHORT).show();break;


        }}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



        String type = (String) parent.getItemAtPosition(position);
        //Toast.makeText(MainActivity.this,type, Toast.LENGTH_SHORT).show();
            //String[] Mob = {"---" ,"Samsung", "Iphone", "Huawei", "Nokia"};
                if(type!="Select") {
                    switch (type) {
                        case "Samsung":
                            listItem = getResources().getStringArray(R.array.array_Samsung);
                            break;
                        case "Iphone":
                            listItem = getResources().getStringArray(R.array.array_Iphone);
                            break;
                        case "Huawei":
                            listItem = getResources().getStringArray(R.array.array_Huawei);
                            break;
                        case "Nokia":
                            listItem = getResources().getStringArray(R.array.array_Nokia);
                            break;

                    }
                    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItem);
                    listView.setAdapter(adapter);

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Nothing", Toast.LENGTH_SHORT).show();
                }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(MainActivity.this,"Nothing", Toast.LENGTH_SHORT).show();
    }

}
