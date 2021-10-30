package com.app.mobilemonitoring;

import android.graphics.Color;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

public class DashboardActivity extends AppCompatActivity {
    private int flagConnect = 0;
    private RequestQueue queue;
    private TextView txtPhaseR;
    private TextView txtPhaseS;
    private TextView txtPhaseT;
    private TextView txtTemp1;
    private TextView txtTemp2;
    private TextView txtServer;
    private Button btnConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_dashboard);
        txtPhaseR = (TextView)findViewById(R.id.txt_phase_r);
        txtPhaseS = (TextView)findViewById(R.id.txt_phase_s);
        txtPhaseT = (TextView)findViewById(R.id.txt_phase_t);
        txtTemp1 = (TextView)findViewById(R.id.txt_temp_1);
        txtTemp2 = (TextView)findViewById(R.id.txt_temp_2);
        txtServer = (TextView)findViewById(R.id.txt_server);
        queue = Volley.newRequestQueue(getApplicationContext());

        btnConnect = (Button)findViewById(R.id.btn_connect);
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flagConnect < 1) {
                    btnConnect.setBackgroundColor(Color.RED);
                    btnConnect.setText("DISCONNECT");
                    flagConnect = 1;
                } else {
                    btnConnect.setBackgroundColor(Color.parseColor("#7CB342"));
                    btnConnect.setText("CONNECT");
                    flagConnect = 0;
                }
            }
        });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        if(flagConnect > 0) {
                            server_request();
                        }
                    }
                });
            }
        }, 0, 3000);
    }

    private void server_request() {
        String url = txtServer.getText().toString();
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jobject = null;
                        try {
                            jobject = new JSONObject(response);
                            txtPhaseR.setText(String.valueOf(jobject.getInt("txtPhaseR")));
                            txtPhaseS.setText(String.valueOf(jobject.getInt("txtPhaseS")));
                            txtPhaseT.setText(String.valueOf(jobject.getInt("txtPhaseT")));
                            txtTemp1.setText(String.valueOf(jobject.getInt("txtTemp1")));
                            txtTemp2.setText(String.valueOf(jobject.getInt("txtTemp2")));
                            Log.e("DASHBOARD",response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            txtPhaseR.setText("0");
                            txtPhaseS.setText("0");
                            txtPhaseT.setText("0");
                            txtTemp1.setText("0");
                            txtTemp2.setText("0");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

}
