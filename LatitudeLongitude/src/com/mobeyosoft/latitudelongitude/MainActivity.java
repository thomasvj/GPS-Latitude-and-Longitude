package com.mobeyosoft.latitudelongitude;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {   
    Button btnShowLocation;  
    TextView textLatitude;
    TextView textLongitude;
    GPSTracker gps; 
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
        initComponents();
        setListener();
    }
    
    private void initComponents(){
        btnShowLocation = (Button) findViewById(R.id.btnGetLocation); 
        textLatitude = (TextView) findViewById(R.id.textLatitude);
        textLongitude = (TextView) findViewById(R.id.textLongitude);
    }
    
    private void setListener(){
    	
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {       
               
                gps = new GPSTracker(MainActivity.this);
               
                if(gps.canGetLocation()){                  
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();  
                    textLatitude.setText("\nLatitude: "+""+latitude);
                    textLongitude.setText("\nLongitude: "+""+longitude);
                }
                else{
                    gps.showSettingsAlert();
                }               
            }
        });
    }   
}