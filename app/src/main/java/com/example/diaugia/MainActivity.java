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
    private University UoA = new University("UoA");
    private University UoM = new University("UoM");
    private University UoI = new University("UoI");
    private int count = 0, countU=0;

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

    }

    public void resultsOnClick(View v) throws InterruptedException {

            //UoA
            //TOTAL PRAKSEIS
            getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2020-07-01&to_issue_date=2020-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2020-01-01&to_issue_date=2020-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2020-07-01&to_issue_date=2020-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
                @Override
                public void callback(ArrayList<Integer> returnedObject) {
                    ArrayList<Integer> s = returnedObject;
                    UoA.setDecisions(s, 2020);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            uoaTxt1.setText(UoA.getDecisions().get(0).getDecisionsSize().toString());
                        }
                    });
                }
            });

            getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2021-01-01&to_issue_date=2021-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2021-07-01&to_issue_date=2021-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2021-01-01&to_issue_date=2021-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2021-07-01&to_issue_date=2021-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
                @Override
                public void callback(ArrayList<Integer> returnedObject) {
                    ArrayList<Integer> s = returnedObject;
                    UoA.setDecisions(s, 2021);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            uoaTxt2.setText(UoA.getDecisions().get(1).getDecisionsSize().toString());
                        }
                    });

                }
            });

            getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2022-01-01&to_issue_date=2022-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2022-07-01&to_issue_date=2022-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2022-01-01&to_issue_date=2022-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2022-07-01&to_issue_date=2022-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
                @Override
                public void callback(ArrayList<Integer> returnedObject) {
                    ArrayList<Integer> s = returnedObject;
                    UoA.setDecisions(s, 2022);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            uoaTxt3.setText(UoA.getDecisions().get(2).getDecisionsSize().toString());
                        }
                    });

                }
            });

            //UoM
            getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-07-01&to_issue_date=2020-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-01-01&to_issue_date=2020-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-07-01&to_issue_date=2020-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
                @Override
                public void callback(ArrayList<Integer> returnedObject) {
                    ArrayList<Integer> s = returnedObject;
                    UoM.setDecisions(s, 2020);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            uomTxt1.setText(UoM.getDecisions().get(0).getDecisionsSize().toString());
                        }
                    });

                }
            });

            getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2021-01-01&to_issue_date=2021-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2021-07-01&to_issue_date=2021-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2021-01-01&to_issue_date=2021-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2021-07-01&to_issue_date=2021-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
                @Override
                public void callback(ArrayList<Integer> returnedObject) {
                    ArrayList<Integer> s = returnedObject;
                    UoM.setDecisions(s, 2021);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            uomTxt2.setText(UoM.getDecisions().get(1).getDecisionsSize().toString());
                        }
                    });
                }
            });

            getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2022-01-01&to_issue_date=2022-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2022-07-01&to_issue_date=2022-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2022-01-01&to_issue_date=2022-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2022-07-01&to_issue_date=2022-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
                @Override
                public void callback(ArrayList<Integer> returnedObject) {
                    ArrayList<Integer> s = returnedObject;
                    UoM.setDecisions(s, 2022);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            uomTxt3.setText(UoM.getDecisions().get(2).getDecisionsSize().toString());
                        }
                    });
                }
            });

            //UoI
            getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-07-01&to_issue_date=2020-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-01-01&to_issue_date=2020-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-07-01&to_issue_date=2020-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
                @Override
                public void callback(ArrayList<Integer> returnedObject) {
                    ArrayList<Integer> s = returnedObject;
                    UoI.setDecisions(s, 2020);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            uoiTxt1.setText(UoI.getDecisions().get(0).getDecisionsSize().toString());
                        }
                    });
                }
            });

            getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2021-01-01&to_issue_date=2021-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2021-07-01&to_issue_date=2021-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2021-01-01&to_issue_date=2021-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2021-07-01&to_issue_date=2021-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
                @Override
                public void callback(ArrayList<Integer> returnedObject) {
                    ArrayList<Integer> s = returnedObject;
                    UoI.setDecisions(s, 2021);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            uoiTxt2.setText(UoI.getDecisions().get(1).getDecisionsSize().toString());
                        }
                    });
                }
            });

            getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2022-01-01&to_issue_date=2022-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2022-07-01&to_issue_date=2022-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2022-01-01&to_issue_date=2022-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2022-07-01&to_issue_date=2022-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
                @Override
                public void callback(ArrayList<Integer> returnedObject) {
                    ArrayList<Integer> s = returnedObject;
                    UoI.setDecisions(s, 2022);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            uoiTxt3.setText(UoI.getDecisions().get(2).getDecisionsSize().toString());
                        }
                    });
                }
            });

            //show Units
            getUnits("https://diavgeia.gov.gr/opendata/organizations/99203020/units.json?status=active", new CallbackListener<ArrayList<String>>() {
                @Override
                public void callback(ArrayList<String> returnedObject) {
                    ArrayList<String> s = returnedObject;
                    UoA.setUnits(s);
                    UoA.setUnitsSize(s.size());
                }
            });

            getUnits("https://diavgeia.gov.gr/opendata/organizations/99206919/units.json?status=active", new CallbackListener<ArrayList<String>>() {
                @Override
                public void callback(ArrayList<String> returnedObject) {
                    ArrayList<String> s = returnedObject;
                    UoM.setUnits(s);
                    UoM.setUnitsSize(s.size());
                }
            });

            getUnits("https://diavgeia.gov.gr/opendata/organizations/99206915/units.json?status=active", new CallbackListener<ArrayList<String>>() {
                @Override
                public void callback(ArrayList<String> returnedObject) {
                    ArrayList<String> s = returnedObject;
                    UoI.setUnits(s);
                    UoI.setUnitsSize(s.size());
                    System.out.println("UoI Units (" + s.size() + "):" + s);

                }
            });



    }
    public static void getTotal(String StringUrl, String StringUrl2, String RevUrl, String RevUrl2, CallbackListener<ArrayList<Integer>> t) throws InterruptedException {

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
                    URL revurl = new URL(RevUrl);
                    URL revurl2 = new URL(RevUrl2);

                    //make connection
                    URLConnection urlc = url.openConnection();
                    URLConnection urlc2 = url2.openConnection();
                    URLConnection revurlc = revurl.openConnection();
                    URLConnection revurlc2 = revurl2.openConnection();

                    //use post mode
                    //urlc.setDoOutput(true);
                    urlc.setAllowUserInteraction(false);
                    //urlc2.setDoOutput(true);
                    urlc2.setAllowUserInteraction(false);
//                    revurlc.setDoOutput(true);
                    revurlc.setAllowUserInteraction(false);
//                    revurlc2.setDoOutput(true);
                    revurlc2.setAllowUserInteraction(false);

                    //get result
                    ArrayList<Integer> totals = new ArrayList<Integer>();
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
                    JSONObject obj = new JSONObject(br.readLine());

                    BufferedReader br2 = new BufferedReader(new InputStreamReader(urlc2.getInputStream()));
                    JSONObject obj2 = new JSONObject(br2.readLine());
                    totals.add(obj.getJSONObject("info").getInt("total") + obj2.getJSONObject("info").getInt("total"));

                    //get anakliseis result
                    BufferedReader br3 = new BufferedReader(new InputStreamReader(revurlc.getInputStream()));
                    JSONObject obj3 = new JSONObject(br3.readLine());

                    BufferedReader br4 = new BufferedReader(new InputStreamReader(revurlc2.getInputStream()));
                    JSONObject obj4 = new JSONObject(br4.readLine());

                    //get pneumatika dikaiomata result
                    totals.add(obj3.getJSONObject("info").getInt("total") + obj4.getJSONObject("info").getInt("total"));

                    Integer count =0;
                    for (int i = 0; i < obj3.getJSONArray("decisions").length(); i++) {
                        Boolean a = obj3.getJSONArray("decisions").getJSONObject(i).getBoolean("privateData");

                        if (a) {
                            count++;
                        }
                    }

                    for (int i = 0; i < obj4.getJSONArray("decisions").length(); i++) {
                        Boolean a = obj4.getJSONArray("decisions").getJSONObject(i).getBoolean("privateData");
                        if (a) {
                            count++;
                        }
                    }

                    totals.add(count);

                    t.callback(totals);

                    br.close();
                    br2.close();

                    br3.close();
                    br4.close();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    public static void getUnits(String StringUrl, CallbackListener<ArrayList<String>> u) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(StringUrl);

                    //make connection
                    URLConnection urlc = url.openConnection();

                    //use post mode
//                    urlc.setDoOutput(true);
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


}