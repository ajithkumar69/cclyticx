package com.example.cclyticx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class Main4Activity extends AppCompatActivity {

    TextView regmail;
    EditText EMAIL;
    Button SENDOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        regmail=findViewById(R.id.textView2);
        EMAIL=findViewById(R.id.editText2);
        SENDOTP=findViewById(R.id.button);

        SENDOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = EMAIL.getText().toString();

                if (EMAIL.getText().toString().equals(""))
                {
                    Toast.makeText(Main4Activity.this,"Enter The Required Details",Toast.LENGTH_LONG).show();
                }
                else{

                forget();

            }}
        });



    }

    private void forget() {
        final String email=EMAIL.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://ajith61.000webhostapp.com/forget.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("otp stored success")){
                    Intent intent=new Intent(Main4Activity.this,verifyOTP.class);
                    intent.putExtra("mail",EMAIL.getText().toString());
                    startActivity (intent);

                }
                Toast.makeText(Main4Activity.this,response,Toast.LENGTH_LONG).show();

                //else {
                  //  Toast.makeText(Main4Activity.this,response.toString(),Toast.LENGTH_LONG).show();
                //}


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Main4Activity.this,error.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> value = new HashMap<String, String>();
                value .put("EMAIL",email);
                return value;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

    }
}
