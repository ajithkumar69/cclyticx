package com.example.cclyticx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Main2Activity extends AppCompatActivity {

    EditText EMAIL,PASSWORD;
    Button LOGIN;
    TextView forgetpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EMAIL =findViewById(R.id.EmailET);
        PASSWORD =findViewById(R.id.PasswordET);
        forgetpassword=findViewById(R.id.textView);

        LOGIN =findViewById(R.id.button);
        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String p = EMAIL.getText().toString();
                String p2 = PASSWORD.getText().toString();

                if (EMAIL.getText().toString().equals(""))
                {
                    Toast.makeText(Main2Activity.this,"Enter The Required Details",Toast.LENGTH_LONG).show();
                }
                else if (PASSWORD.getText().toString().equals(""))
                {
                    Toast.makeText(Main2Activity.this,"Enter The Required Details",Toast.LENGTH_LONG).show();
                }


                 LOGIN();

            }
        });

forgetpassword.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent=new Intent(Main2Activity.this,Main4Activity.class);
        startActivity(intent);

    }
});
    }

    private void LOGIN() {
        final String email=EMAIL.getText().toString();
        final String password=PASSWORD.getText().toString();



        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://ajith61.000webhostapp.com/login.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {


             /*   try {
                    JSONObject object=new JSONObject(response);
                    JSONArray jsonArray=object.getJSONArray("project_details");
                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                    String string1=jsonObject.getString("email");
                    String string2=jsonObject.getString("password");

                    Toast.makeText(Main2Activity.this,"email"+string1+"password"+string2,Toast.LENGTH_LONG).show();
                }

                catch (JSONException e) {


                    e.printStackTrace();
                }*/
                if (response.equals("Success")){
                    Intent intent=new Intent(Main2Activity.this,Main5Activity.class);
                    startActivity(intent);
                    Toast.makeText(Main2Activity.this,"login success",Toast.LENGTH_LONG).show();
                }


                else {
                    Toast.makeText(Main2Activity.this,"enter the correct email address or password",Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> result = new HashMap<String, String>();
                result.put("EMAIL", email);
                result.put("PASSWORD",password);
                return result;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}

