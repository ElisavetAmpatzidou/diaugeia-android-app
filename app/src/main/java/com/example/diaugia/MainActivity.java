package com.example.diaugia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button resultsButton;
    private TextView uomTxt1,uomTxt2,uomTxt3,uoaTxt1,uoaTxt2,uoaTxt3,uoiTxt1,uoiTxt2,uoiTxt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultsButton = (Button) findViewById(R.id.resultsButton);
        uomTxt1=(TextView) findViewById(R.id.UoM2020);
        uomTxt2=(TextView) findViewById(R.id.UoM2021);
        uomTxt3=(TextView) findViewById(R.id.UoM2022);
        uoaTxt1=(TextView) findViewById(R.id.UoA2020);
        uoaTxt2=(TextView) findViewById(R.id.UoA2021);
        uoaTxt3=(TextView) findViewById(R.id.UoA2022);
        uoiTxt1=(TextView) findViewById(R.id.UoI2020);
        uoiTxt2=(TextView) findViewById(R.id.UoI2021);
        uoiTxt3=(TextView) findViewById(R.id.UoI2022);

        University UoA = new University("UoA");
        University UoM = new University("UoM");
        University UoI = new University("UoI");

    }
    public void resultsOnClick(View v){



        ArrayList<Integer> totalUoM=new ArrayList<>();

        ArrayList<Integer> totalUoA=new ArrayList<>();
        ArrayList<Integer> totalUoI=new ArrayList<>();
//UOA
        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2020-01-01&to_issue_date=2020-06-30","https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2020-07-01&to_issue_date=2020-12-31",new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOA 2020: "+s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        uoaTxt1.setText("2020: "+s);
                    }
                });

            }
        });


        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2021-01-01&to_issue_date=2021-06-30","https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2021-07-01&to_issue_date=2021-12-31",new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOA 2021: "+s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        uoaTxt2.setText("2021: "+s);
                    }
                });
            }
        });

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2022-01-01&to_issue_date=2022-06-30","https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2022-07-01&to_issue_date=2022-12-31",new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOA 2022: "+s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        uoaTxt3.setText("2022: "+s);
                    }
                });
            }
        });

//UOM

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-01-01&to_issue_date=2020-06-30","https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-07-01&to_issue_date=2020-12-31",new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOM 2020: "+s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        uomTxt1.setText("2020: "+s);
                    }
                });

            }
        });

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2021-01-01&to_issue_date=2021-06-30","https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2021-07-01&to_issue_date=2021-12-31",new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOM 2021: "+s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        uomTxt2.setText("2021: "+s);
                    }
                });

            }
        });

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2022-01-01&to_issue_date=2022-06-30","https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2022-07-01&to_issue_date=2022-12-31",new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOM 2022: "+s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        uomTxt3.setText("2022: "+s);
                    }
                });

            }
        });

//UOI

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-01-01&to_issue_date=2020-06-30","https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-07-01&to_issue_date=2020-12-31",new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOI 2020: "+s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        uoiTxt1.setText("2020: "+s);
                    }
                });

            }
        });

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2021-01-01&to_issue_date=2021-06-30","https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2021-07-01&to_issue_date=2021-12-31",new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOI 2021: "+s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        uoiTxt2.setText("2021: "+s);
                    }
                });


            }
        });


        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2022-01-01&to_issue_date=2022-06-30","https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2022-07-01&to_issue_date=2022-12-31",new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOI 2022: "+s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        uoiTxt3.setText("2022: "+s);
                    }
                });


            }
        });

    }
    public static void getTotal(String StringUrl,String StringUrl2,CallbackListener<Integer> t) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

//                     OkHttpHandler ok;
//
//                    int total =0;
//                    ok=new OkHttpHandler();
//                    String an=ok.callA(StringUrl);
//
//
//                    System.out.println("results printing:"+an);
//                    t.callback(total);
                try {
                    URL url = new URL(StringUrl);
                    URL url2 = new URL(StringUrl2);

                    //make connection
                    URLConnection urlc = url.openConnection();
                    URLConnection urlc2 = url2.openConnection();

                    //use post mode
                    //urlc.setDoOutput(true);
                    urlc.setAllowUserInteraction(false);
                    //urlc2.setDoOutput(true);
                    urlc2.setAllowUserInteraction(false);

                    //get result
                    int total =0;
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
                    JSONObject obj = new JSONObject(br.readLine());

                    BufferedReader br2 = new BufferedReader(new InputStreamReader(urlc2.getInputStream()));
                    JSONObject obj2 = new JSONObject(br2.readLine());
                    total= obj.getJSONObject("info").getInt("total") + obj2.getJSONObject("info").getInt("total");

                    t.callback(total);


                    br.close();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

    }


}