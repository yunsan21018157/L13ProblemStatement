package sg.edu.rp.c346.id21018157.l13problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvEnrolment;
    AsyncHttpClient client;
    TextView tvEnrolment;
    Spinner spinnerYear;

    ArrayList<Enrolment> alEnrolment;
    //ArrayAdapter<Enrolment> aaEnrolment;
    CustomAdapter adapter;

    int year; //for spinner

    @Override
    protected void onResume() {
        super.onResume();

        alEnrolment = new ArrayList<>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=4ad866a7-c43a-4645-87fd-fc961c9de78a&limit=9", new JsonHttpResponseHandler() {

            int enrolment;
            int year;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //super.onSuccess(statusCode, headers, response);
                try {
                    JSONObject jsonObjResult = response.getJSONObject("result"); //{}result
                    JSONArray jsonArrRecords = jsonObjResult.getJSONArray("records"); //[]records

                    for (int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject jsonObjRecord = jsonArrRecords.getJSONObject(i);
                        enrolment = jsonObjRecord.getInt("enrolment");
                        year = jsonObjRecord.getInt("year");
                        Enrolment enrol = new Enrolment(enrolment, year);
                        alEnrolment.add(enrol);
                    }
                } catch (JSONException e) {

                }
//                    aaEnrolment = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alEnrolment);
                    adapter = new CustomAdapter(MainActivity.this, R.layout.row, alEnrolment);
                    lvEnrolment.setAdapter(adapter);

            } // end of onSuccess
        });
        } // end of onResume

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                lvEnrolment = findViewById(R.id.lvEnrolment);
                tvEnrolment = findViewById(R.id.tvEnrolment);
                spinnerYear = findViewById(R.id.spinnerYear);
                client = new AsyncHttpClient();

                spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                year = 2014;

                                break;

                            case 1:
                                year = 2015;
                                break;

                            case 2:
                                year = 2016;
                                break;

                            case 3:
                                year = 2017;
                                break;

                            case 4:
                                year = 2018;
                                break;

                            case 5:
                                year = 2019;
                                break;

                            case 6:
                                year = 2020;
                                break;

                            case 7:
                                year = 2021;
                                break;

                            case 8:
                                year = 2022;
                                break;
                        }
                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }
    }