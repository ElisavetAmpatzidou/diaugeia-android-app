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

public class SecondActivity extends AppCompatActivity {

    private TextView pr2020,pr2021,pr2022,an2020,an2021,an2022,ded2020,ded2021,ded2022;
    private TextView org,units;
    private Button ba,bm,bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        ArrayList<Integer> totalUoM = new ArrayList<>();

        ArrayList<Integer> totalUoA = new ArrayList<>();
        ArrayList<Integer> totalUoI = new ArrayList<>();

        pr2020=(TextView) findViewById(R.id.txt2020pr);
        pr2021=(TextView) findViewById(R.id.txt2021pr);
        pr2022=(TextView) findViewById(R.id.txt2022pr);
        an2020=(TextView) findViewById(R.id.txt2020an);
        an2021=(TextView) findViewById(R.id.txt2021an);
        an2022=(TextView) findViewById(R.id.txt2022an);
        ded2020=(TextView) findViewById(R.id.txt2020ded);
        ded2021=(TextView) findViewById(R.id.txt2021ded);
        ded2022=(TextView) findViewById(R.id.txt2022ded);

        org=(TextView) findViewById(R.id.org);
        ba=(Button) findViewById(R.id.uoaBtn);
        bm=(Button) findViewById(R.id.uomBtn);
        bi=(Button) findViewById(R.id.uoiBtn);
        units=(TextView) findViewById(R.id.sumUnitstxt);


    }

//When UoA button is clicked
    public void firstButtonOnClick(View v) {
        //UOA
        ba.setBackgroundColor(getResources().getColor(R.color.dia1));
        bm.setBackgroundColor(getResources().getColor(R.color.teal_700));
        bi.setBackgroundColor(getResources().getColor(R.color.teal_700));
        loading();
        org.setText("UoA");
        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2020-07-01&to_issue_date=2020-12-31", new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOA 2020: " + s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2020.setText(s.toString());
                    }
                });
            }
        });


        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2021-01-01&to_issue_date=2021-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2021-07-01&to_issue_date=2021-12-31", new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOA 2021: " + s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2021.setText(s.toString());
                    }
                });
            }
        });

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2022-01-01&to_issue_date=2022-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2022-07-01&to_issue_date=2022-12-31", new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOA 2022: " + s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2022.setText(s.toString());
                    }
                });
            }
        });

        //show Units
        getUnits("https://diavgeia.gov.gr/opendata/organizations/99203020/units.json?status=active",new CallbackListener<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> returnedObject) {
                ArrayList<String> s = returnedObject;
                System.out.println("Units UoA ("+s.size()+"):"+ s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        units.setText("Units UoA ("+s.size()+"):");
                    }
                });
            }
        });
    }

//When Uom button is clicked
    public void secondButtonOnClick(View v) {
        //UOM
        bm.setBackgroundColor(getResources().getColor(R.color.dia1));
        ba.setBackgroundColor(getResources().getColor(R.color.teal_700));
        bi.setBackgroundColor(getResources().getColor(R.color.teal_700));
        loading();
        org.setText("UoM");
        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-07-01&to_issue_date=2020-12-31", new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOM 2020: " + s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2020.setText(s.toString());
                    }
                });

            }
        });

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2021-01-01&to_issue_date=2021-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2021-07-01&to_issue_date=2021-12-31", new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOM 2021: " + s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2021.setText(s.toString());
                    }
                });

            }
        });

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2022-01-01&to_issue_date=2022-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2022-07-01&to_issue_date=2022-12-31", new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOM 2022: " + s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2022.setText(s.toString());
                    }
                });

            }
        });

        //show Units
        getUnits("https://diavgeia.gov.gr/opendata/organizations/99206919/units.json?status=active",new CallbackListener<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> returnedObject) {
                ArrayList<String> s = returnedObject;
                System.out.println("Units UoM ("+s.size()+"):"+ s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        units.setText("Units UoM ("+s.size()+"):");
                    }
                });
            }
        });
    }

//When UoI button is clicked
    public void ThirdButtonOnClick(View v) {
//UOI
        bi.setBackgroundColor(getResources().getColor(R.color.dia1));
        bm.setBackgroundColor(getResources().getColor(R.color.teal_700));
        ba.setBackgroundColor(getResources().getColor(R.color.teal_700));
        loading();
        org.setText("UoI");
        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-07-01&to_issue_date=2020-12-31", new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOI 2020: " + s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2020.setText( s.toString());
                    }
                });

            }
        });

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2021-01-01&to_issue_date=2021-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2021-07-01&to_issue_date=2021-12-31", new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOI 2021: " + s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2021.setText( s.toString());
                    }
                });
            }
        });

        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2022-01-01&to_issue_date=2022-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2022-07-01&to_issue_date=2022-12-31", new CallbackListener<Integer>() {
            @Override
            public void callback(Integer returnedObject) {
                Integer s = returnedObject;
                System.out.println("UOI 2022: " + s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2022.setText(s.toString());
                    }
                });
            }
        });

        //show Units
        getUnits("https://diavgeia.gov.gr/opendata/organizations/99206915/units.json?status=active",new CallbackListener<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> returnedObject) {
                ArrayList<String> s = returnedObject;
                System.out.println("Units UoI ("+s.size()+"):"+ s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        units.setText("Units UoI ("+s.size()+"):");
                    }
                });
            }
        });
    }


        public static void getTotal(String StringUrl,String StringUrl2,CallbackListener<Integer> t) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

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

    public static void getUnits(String StringUrl, CallbackListener<ArrayList<String>> u) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(StringUrl);

                    //make connection
                    URLConnection urlc = url.openConnection();

                    //use post mode
                    //urlc.setDoOutput(true);
                    urlc.setAllowUserInteraction(false);

                    //get result
                    ArrayList<String> units = new ArrayList<String>();
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
                    JSONObject obj = new JSONObject(br.readLine());

                    for(int i=0;i<obj.getJSONArray("units").length();i++) {
                        units.add(obj.getJSONArray("units").getJSONObject(i).getString("label"));
                    }

                    //get unit result
                    u.callback(units);

                    br.close();



                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

        public void loading(){
            pr2020.setText("loading...");
            pr2021.setText("loading...");
            pr2022.setText("loading...");
            an2020.setText("loading...");
            an2021.setText("loading...");
            an2022.setText("loading...");
            ded2020.setText("loading...");
            ded2021.setText("loading...");
            ded2022.setText("loading...");
        }


    }
