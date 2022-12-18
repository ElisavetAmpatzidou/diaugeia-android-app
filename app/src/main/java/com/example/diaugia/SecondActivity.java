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
    public void firstButtonOnClick(View v) {
        //UOA
        ba.setBackgroundColor(getResources().getColor(R.color.dia1));
        bm.setBackgroundColor(getResources().getColor(R.color.teal_700));
        bi.setBackgroundColor(getResources().getColor(R.color.teal_700));
        loading();
        units.setText("");
        unitString.setText("");
        org.setText("UoA");
//        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2020-07-01&to_issue_date=2020-12-31", new CallbackListener<Integer>() {
//            @Override
//            public void callback(Integer returnedObject) {
//                Integer s = returnedObject;
//                System.out.println("UOA 2020: " + s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pr2020.setText(s.toString());
//                    }
//                });
//            }
//        });
//
//
//        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2021-01-01&to_issue_date=2021-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2021-07-01&to_issue_date=2021-12-31", new CallbackListener<Integer>() {
//            @Override
//            public void callback(Integer returnedObject) {
//                Integer s = returnedObject;
//                System.out.println("UOA 2021: " + s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pr2021.setText(s.toString());
//                    }
//                });
//            }
//        });
//
//        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2022-01-01&to_issue_date=2022-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99203020&from_issue_date=2022-07-01&to_issue_date=2022-12-31", new CallbackListener<Integer>() {
//            @Override
//            public void callback(Integer returnedObject) {
//                Integer s = returnedObject;
//                System.out.println("UOA 2022: " + s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pr2022.setText(s.toString());
//                    }
//                });
//            }
//        });
//
//        //show Units
//        getUnits("https://diavgeia.gov.gr/opendata/organizations/99203020/units.json?status=active",new CallbackListener<ArrayList<String>>() {
//            @Override
//            public void callback(ArrayList<String> returnedObject) {
//                ArrayList<String> s = returnedObject;
//                System.out.println("Units UoA ("+s.size()+"):"+ s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        unitString.setText("");
//                        units.setText("Units UoA ("+s.size()+"):");
//                        for (int i=1;i<=s.size();i++){
//                            int g =i;
//                            unitString.setText(unitString.getText()+""+i+")"+s.get(i-1)+"\n");
//                        }
//                    }
//                });
//            }
//        });
    }

//When Uom button is clicked
    public void secondButtonOnClick(View v) {
        //UOM
        bm.setBackgroundColor(getResources().getColor(R.color.dia1));
        ba.setBackgroundColor(getResources().getColor(R.color.teal_700));
        bi.setBackgroundColor(getResources().getColor(R.color.teal_700));
        loading();
        units.setText("");
        unitString.setText("");
        org.setText("UoM");
//        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2020-07-01&to_issue_date=2020-12-31", new CallbackListener<Integer>() {
//            @Override
//            public void callback(Integer returnedObject) {
//                Integer s = returnedObject;
//                System.out.println("UOM 2020: " + s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pr2020.setText(s.toString());
//                    }
//                });
//
//            }
//        });
//
//        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2021-01-01&to_issue_date=2021-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2021-07-01&to_issue_date=2021-12-31", new CallbackListener<Integer>() {
//            @Override
//            public void callback(Integer returnedObject) {
//                Integer s = returnedObject;
//                System.out.println("UOM 2021: " + s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pr2021.setText(s.toString());
//                    }
//                });
//
//            }
//        });
//
//        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2022-01-01&to_issue_date=2022-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2022-07-01&to_issue_date=2022-12-31", new CallbackListener<Integer>() {
//            @Override
//            public void callback(Integer returnedObject) {
//                Integer s = returnedObject;
//                System.out.println("UOM 2022: " + s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pr2022.setText(s.toString());
//                    }
//                });
//
//            }
//        });
//
//        //show Units
//        getUnits("https://diavgeia.gov.gr/opendata/organizations/99206919/units.json?status=active",new CallbackListener<ArrayList<String>>() {
//            @Override
//            public void callback(ArrayList<String> returnedObject) {
//                ArrayList<String> s = returnedObject;
//                System.out.println("Units UoM ("+s.size()+"):"+ s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        unitString.setText("");
//                        units.setText("Units UoM ("+s.size()+"):");
//                        for (int i=1;i<=s.size();i++){
//                            unitString.setText(unitString.getText()+""+i+")"+s.get(i-1)+"\n");
//                        }
//                    }
//                });
//            }
//        });
    }

//When UoI button is clicked
    public void ThirdButtonOnClick(View v) {
//UOI
        bi.setBackgroundColor(getResources().getColor(R.color.dia1));
        bm.setBackgroundColor(getResources().getColor(R.color.teal_700));
        ba.setBackgroundColor(getResources().getColor(R.color.teal_700));
        loading();
        units.setText("");
        unitString.setText("");
        org.setText("UoI");
//        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-01-01&to_issue_date=2020-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2020-07-01&to_issue_date=2020-12-31", new CallbackListener<Integer>() {
//            @Override
//            public void callback(Integer returnedObject) {
//                Integer s = returnedObject;
//                System.out.println("UOI 2020: " + s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pr2020.setText( s.toString());
//                    }
//                });
//
//            }
//        });
//
//        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2021-01-01&to_issue_date=2021-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2021-07-01&to_issue_date=2021-12-31", new CallbackListener<Integer>() {
//            @Override
//            public void callback(Integer returnedObject) {
//                Integer s = returnedObject;
//                System.out.println("UOI 2021: " + s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pr2021.setText( s.toString());
//                    }
//                });
//            }
//        });
//
//        getTotal("https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2022-01-01&to_issue_date=2022-06-30", "https://diavgeia.gov.gr/opendata/search.json?org=99206915&from_issue_date=2022-07-01&to_issue_date=2022-12-31", new CallbackListener<Integer>() {
//            @Override
//            public void callback(Integer returnedObject) {
//                Integer s = returnedObject;
//                System.out.println("UOI 2022: " + s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pr2022.setText(s.toString());
//                    }
//                });
//            }
//        });
//
//        //show Units
//        getUnits("https://diavgeia.gov.gr/opendata/organizations/99206915/units.json?status=active",new CallbackListener<ArrayList<String>>() {
//            @Override
//            public void callback(ArrayList<String> returnedObject) {
//                ArrayList<String> s = returnedObject;
//                System.out.println("Units UoI ("+s.size()+"):"+ s);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        unitString.setText("");
//                        units.setText("Units UoI ("+s.size()+"):");
//                        for (int i=1;i<=s.size();i++){
//                            unitString.setText(unitString.getText()+""+i+")"+s.get(i-1)+"\n");
//                        }
//                    }
//                });
//            }
//        });
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
