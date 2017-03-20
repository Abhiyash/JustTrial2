package com.example.abhiyash.justtrial;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import java.sql.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    TextView tv;
    Statement stmt;
    Connection con;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        b1.setOnClickListener(this);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("1");
            con= DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/test","root","root");
            System.out.println("2");
            stmt=con.createStatement();
            System.out.println("3");

        } catch (Exception e) {

        }
    }
    @Override
    public void onClick(View v)
    {
        String name="";
        String id="";
               try{
                ResultSet rs=stmt.executeQuery("select * from student");
                   System.out.println("4");
                   while(rs.next())
                {
                    name=rs.getString(2);
                    id=rs.getString(1);
                }
                   con.close();
                   System.out.println("5");
            }
            catch(Exception e){

            }
            tv.setText(name+""+id);
    }
}
