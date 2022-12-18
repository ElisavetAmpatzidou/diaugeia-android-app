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
    private TextView org,units,unitString;
    private Button ba,bm,bi;
    private University UoA = new University("UoA");
    private University UoM = new University("UoM");
    private University UoI = new University("UoI");


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
        unitString=(TextView) findViewById(R.id.unitString);
    }

//When UoA button is clicked
    public void firstButtonOnClick(View v) throws InterruptedException {
        //UOA
        ba.setBackgroundColor(getResources().getColor(R.color.dia1));
        bm.setBackgroundColor(getResources().getColor(R.color.teal_700));
        bi.setBackgroundColor(getResources().getColor(R.color.teal_700));
        loading();
        units.setText("");
        unitString.setText("");
        org.setText("UoA");

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
                        pr2020.setText(UoA.getDecisions().get(0).getDesicionSize().toString());
                        an2020.setText(UoA.getDecisions().get(0).getAnakliseis().toString());
                        ded2020.setText(UoA.getDecisions().get(0).getPneumatika().toString());                    }
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
                        pr2021.setText(UoA.getDecisions().get(1).getDesicionSize().toString());
                        an2021.setText(UoA.getDecisions().get(1).getAnakliseis().toString());
                        ded2021.setText(UoA.getDecisions().get(1).getPneumatika().toString());
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
                        pr2022.setText(UoA.getDecisions().get(2).getDesicionSize().toString());
                        an2022.setText(UoA.getDecisions().get(2).getAnakliseis().toString());
                        ded2022.setText(UoA.getDecisions().get(2).getPneumatika().toString());                    }
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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        unitString.setText("");
                        units.setText("Units UoA (" + UoA.getUnitsSize() + "):");
                        for (int i = 1; i <= UoA.getUnitsSize(); i++) {
                            unitString.setText(unitString.getText() + "" + i + ")" + UoA.getUnits().get(i - 1) + "\n");
                        }
                    }
                });
            }
        });
    }

//When Uom button is clicked
    public void secondButtonOnClick(View v) throws InterruptedException {
        //UOM
        bm.setBackgroundColor(getResources().getColor(R.color.dia1));
        ba.setBackgroundColor(getResources().getColor(R.color.teal_700));
        bi.setBackgroundColor(getResources().getColor(R.color.teal_700));
        loading();
        units.setText("");
        unitString.setText("");
        org.setText("UoM");

        //UoM
        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-07-01&to_issue_date=2020-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-01-01&to_issue_date=2020-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-07-01&to_issue_date=2020-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
            @Override
            public void callback(ArrayList<Integer> returnedObject) {
                ArrayList<Integer> s = returnedObject;
                UoM.setDecisions(s, 2020);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2020.setText(UoM.getDecisions().get(0).getDesicionSize().toString());
                        an2020.setText(UoM.getDecisions().get(0).getAnakliseis().toString());
                        ded2020.setText(UoM.getDecisions().get(0).getPneumatika().toString());                    }
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
                        pr2021.setText(UoM.getDecisions().get(1).getDesicionSize().toString());
                        an2021.setText(UoM.getDecisions().get(1).getAnakliseis().toString());
                        ded2021.setText(UoM.getDecisions().get(1).getPneumatika().toString());                    }
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
                        pr2022.setText(UoM.getDecisions().get(2).getDesicionSize().toString());
                        an2022.setText(UoM.getDecisions().get(2).getAnakliseis().toString());
                        ded2022.setText(UoM.getDecisions().get(2).getPneumatika().toString());                    }
                });
            }
        });

        //show Units
        getUnits("https://diavgeia.gov.gr/opendata/organizations/99206919/units.json?status=active", new CallbackListener<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> returnedObject) {
                ArrayList<String> s = returnedObject;
                UoM.setUnits(s);
                UoM.setUnitsSize(s.size());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    unitString.setText("");
                    units.setText("Units UoM ("+UoM.getUnitsSize()+"):");
                    for (int i=1;i<=UoM.getUnitsSize();i++) {
                        unitString.setText(unitString.getText() + "" + i + ")" +  UoM.getUnits().get(i - 1) + "\n");
                    }
                    }
                });
            }
        });
    }

//When UoI button is clicked
    public void ThirdButtonOnClick(View v) throws InterruptedException {
//UOI
        bi.setBackgroundColor(getResources().getColor(R.color.dia1));
        bm.setBackgroundColor(getResources().getColor(R.color.teal_700));
        ba.setBackgroundColor(getResources().getColor(R.color.teal_700));
        loading();
        units.setText("");
        unitString.setText("");
        org.setText("UoI");
        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-07-01&to_issue_date=2020-12-31", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-01-01&to_issue_date=2020-06-31&status=REVOKED", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-07-01&to_issue_date=2020-12-31&status=REVOKED", new CallbackListener<ArrayList<Integer>>() {
            @Override
            public void callback(ArrayList<Integer> returnedObject) {
                ArrayList<Integer> s = returnedObject;
                UoI.setDecisions(s, 2020);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pr2020.setText(UoI.getDecisions().get(0).getDesicionSize().toString());
                        an2020.setText(UoI.getDecisions().get(0).getAnakliseis().toString());
                        ded2020.setText(UoI.getDecisions().get(0).getPneumatika().toString());                       }
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
                        pr2021.setText(UoI.getDecisions().get(1).getDesicionSize().toString());
                        an2021.setText(UoI.getDecisions().get(1).getAnakliseis().toString());
                        ded2021.setText(UoI.getDecisions().get(1).getPneumatika().toString());                        }
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
                        pr2022.setText(UoI.getDecisions().get(2).getDesicionSize().toString());
                        an2022.setText(UoI.getDecisions().get(2).getAnakliseis().toString());
                        ded2022.setText(UoI.getDecisions().get(2).getPneumatika().toString());                        }
                });
            }
        });

        //show Units
        getUnits("https://diavgeia.gov.gr/opendata/organizations/99206915/units.json?status=active", new CallbackListener<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> returnedObject) {
                ArrayList<String> s = returnedObject;
                UoI.setUnits(s);
                UoI.setUnitsSize(s.size());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    unitString.setText("");
                    units.setText("Units UoI ("+UoI.getUnitsSize()+"):");
                    for (int i=1;i<=UoI.getUnitsSize();i++) {
                        unitString.setText(unitString.getText() + "" + i + ")" +  UoI.getUnits().get(i - 1) + "\n");
                    }
                }
            });
        }
        });
    }

    public static void getTotal(String StringUrl, String StringUrl2, String RevUrl, String RevUrl2, CallbackListener<ArrayList<Integer>> t) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

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
                    urlc.setAllowUserInteraction(false);
                    urlc2.setAllowUserInteraction(false);
                    revurlc.setAllowUserInteraction(false);
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
