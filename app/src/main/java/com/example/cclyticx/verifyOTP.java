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

public class verifyOTP extends AppCompatActivity {
    TextView EMAIL;
    EditText OTPNUM;
    Button VERIFYOTP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        EMAIL=findViewById(R.id.textView15);
        OTPNUM=findViewById(R.id.editText3);
        VERIFYOTP=findViewById(R.id.button4);


        Intent Values =getIntent();
        if (Values!=null){
            String rmail=Values.getStringExtra("mail");
            EMAIL.setText(rmail);

        }


    VERIFYOTP.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String otp =OTPNUM.getText().toString();

            if (OTPNUM.getText().toString().equals(""))
            {
                Toast.makeText(verifyOTP.this,"Enter The valid number",Toast.LENGTH_LONG).show();
            }



            verify();

        }
    });



    }

    private void verify() {

        Intent res=getIntent();
        final String email=res.getStringExtra("mail");
        final String verifyotp=VERIFYOTP.getText().toString();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, "https://ajith61.000webhostapp.com/verify.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(verifyOTP.this,response,Toast.LENGTH_LONG).show();

                if (response.equals("Success")){
                    Intent intent= new Intent(verifyOTP.this,NewPassword.class);
                    String result=EMAIL.getText().toString();
                  intent.putExtra("mail1",result);

                    startActivity(intent);
                }else {


                    Toast.makeText(verifyOTP.this, "Failure otp", Toast.LENGTH_LONG).show();
                }

            }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(verifyOTP.this,error.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> value=new HashMap<String, String>();
                value.put("EMAIL1",EMAIL.getText().toString());
                value.put("OTP",OTPNUM.getText().toString());

                return value;

            }
            };

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
