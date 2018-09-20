package rethinkux.com.bootcamptask2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_example);

        getCurrentAffairs("https://brightacademy.in/currentAffairsHomepage");

    }

    private void getCurrentAffairs(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("username",s);
        map.put("password",s);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, s, new JSONObject(map),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                        if (BuildConfig.DEBUG)Log.d(TAG, "onResponse: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "onErrorResponse: " + error );
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyExampleActivity.this);
        requestQueue.add(jsonObjectRequest);

    }
}
