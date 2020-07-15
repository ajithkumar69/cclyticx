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

public class NewPassword extends AppCompatActivity {
    TextView EMAIL;
    EditText NEWPWD,CONFIRMPWD;
    Button SUBMIT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        EMAIL=findViewById(R.id.textView16);
        NEWPWD=findViewById(R.id.et1);
        CONFIRMPWD=findViewById(R.id.et2);
        SUBMIT=findViewById(R.id.button);

    Intent Values=getIntent();
    if (Values!=null){

        String rmail=Values.getStringExtra("mail1");
        EMAIL.setText(rmail);

    }


        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String p1=NEWPWD.getText().toString();
                String p2=CONFIRMPWD.getText().toString();
                if(NEWPWD.getText().toString().equals("")&&CONFIRMPWD.getText().toString().equals("")){
                    Toast.makeText(NewPassword.this, "Enter The Required Details", Toast.LENGTH_LONG).show();
                }

                else if (p1.equals(p2)) {


                    submit();
                }
                else {
                    Toast.makeText(NewPassword.this,"Enter correctly",Toast.LENGTH_LONG).show();
                    NEWPWD.setText("");
                    CONFIRMPWD.setText("");
                }

            }
        });
    }

    private void submit() {
        Intent res=getIntent();
        final String email=res.getStringExtra("mail1");
        final String pwd=NEWPWD.getText().toString();
      //  final String cpwd=CONFIRMPWD.getText().toString();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, "https://ajith61.000webhostapp.com/newpassword.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Toast.makeText(NewPassword.this,response,Toast.LENGTH_LONG).show();

                if (response.equals("Success")){

                    Intent intent=new Intent(NewPassword.this,Main2Activity.class);
                    startActivity(intent);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> value = new HashMap<String, String>();
                value.put("EMAIL",EMAIL.getText().toString());
                value.put("NEWPWD", NEWPWD.getText().toString());
                //value.put("CONFIRMPWD",cpwd);
                return (value);
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);







    }
}
