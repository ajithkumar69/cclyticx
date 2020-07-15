package com.example.cclyticx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText NAME,ADDRESS,CITY,STATE,ZIP_CODE,MOBILE_NUMBER,EMAIL,COUNTRY,PASSWORD,RE_ENTER_PASSWORD;
    Button REGISTER;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NAME=findViewById(R.id.editText2);
        ADDRESS=findViewById(R.id.editText4);
        CITY=findViewById(R.id.editText5);
        STATE=findViewById(R.id.editText6);
        ZIP_CODE=findViewById(R.id.editText7);
        MOBILE_NUMBER=findViewById(R.id.editText8);
        EMAIL=findViewById(R.id.editText9);
        COUNTRY=findViewById(R.id.editText10);
        PASSWORD=findViewById(R.id.editText11);
        RE_ENTER_PASSWORD=findViewById(R.id.editText12);

        REGISTER=findViewById(R.id.button);
        REGISTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p = PASSWORD.getText().toString();
                String p2 = RE_ENTER_PASSWORD.getText().toString();


                if (NAME.getText().toString().equals("")||NAME.getText().toString().length()>=3) {
                    Toast.makeText(MainActivity.this, "Enter The Required Ddetails", Toast.LENGTH_LONG).show();
                }
                else if (ADDRESS.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter The Required Ddetails",Toast.LENGTH_LONG).show();
                }
                else if (CITY.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter The Required Ddetails",Toast.LENGTH_LONG).show();
                }
                else if (STATE.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter The Required Ddetails",Toast.LENGTH_LONG).show();
                }
                else if (ZIP_CODE.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter The Required Ddetails",Toast.LENGTH_LONG).show();
                }
                else if (MOBILE_NUMBER.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter The Required Ddetails",Toast.LENGTH_LONG).show();
                }
                else if (EMAIL.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter The Required Ddetails",Toast.LENGTH_LONG).show();
                }
                else if (COUNTRY.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter The Required Ddetails",Toast.LENGTH_LONG).show();
                }
                else if (PASSWORD.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter The Required Ddetails",Toast.LENGTH_LONG).show();
                }
                else if (RE_ENTER_PASSWORD.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Enter The Required Ddetails",Toast.LENGTH_LONG).show();
                }
                else if (p.equals(p2)) {

                    register();

                }
                else {
                    Toast.makeText(MainActivity.this,"Enter correctly",Toast.LENGTH_LONG).show();
                    PASSWORD.setText("");
                    RE_ENTER_PASSWORD.setText("");
                }

            }
        });

    }

    private void register() {
        final String name=NAME.getText().toString();
        final String address=ADDRESS.getText().toString();
        final String city=CITY.getText().toString();
        final String state=STATE.getText().toString();
        final String zipcode=ZIP_CODE.getText().toString();
        final String mobilenumber=MOBILE_NUMBER.getText().toString();
        final String email=EMAIL.getText().toString();
        final String country=COUNTRY.getText().toString();
        final String password=PASSWORD.getText().toString();



        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://ajith61.000webhostapp.com/register.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Success")){

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

                    Toast.makeText(MainActivity.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                }


                else {
                    Toast.makeText(MainActivity.this,"Email Already Exists",Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                

                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> values=new HashMap<String, String>();
                values.put("NAME",name);
                values.put("ADDRESS",address);
                values.put("CITY",city);
                values.put("STATE",state);
                values.put("ZIPCODE",zipcode);
                values.put("MOBILENUMBER",mobilenumber);
                values.put("EMAIL",email);
                values.put("COUNTRY",country);
                values.put("PASSWORD",password);

                return values;

            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
