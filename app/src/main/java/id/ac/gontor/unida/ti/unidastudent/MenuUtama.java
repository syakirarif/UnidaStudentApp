package id.ac.gontor.unida.ti.unidastudent;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;

import static id.ac.gontor.unida.ti.unidastudent.R.string.tentang;

public class MenuUtama extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private WebView webUnidaStudent;
    Context context;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //Perubahan ada disini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

//        getSupportActionBar().hide();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        webUnidaStudent = (WebView) findViewById(R.id.web_UnidaStudent);
        WebSettings webSettings = webUnidaStudent.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webUnidaStudent.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webUnidaStudent.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webUnidaStudent.getSettings().setAppCacheEnabled(true);
        webUnidaStudent.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);



        webUnidaStudent.loadUrl("http://www.unidastudent.com");

        //biar link yang di klik user dibuka di aplikasi kita
        webUnidaStudent.setWebViewClient(new webUnidaStudentClient());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_utama, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_tentang){
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Tentang")
                    .setMessage(getString(R.string.tentang))
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        return super.onOptionsItemSelected(item);
    }

    //untuk menampilkan dialog informasi tentang

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_berita) {
            // Link nya disini bro
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/news/");
        } else if (id == R.id.nav_event) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/event/");
        } else if (id == R.id.nav_video) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/video/");
        } else if (id == R.id.nav_demapusat) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/dema/");
        } else if (id == R.id.nav_demawilayah) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/dema/");
        } else if (id == R.id.nav_himatif) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/himpunan/himatif/");
        } else if (id == R.id.nav_himakom) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/himpunan/himakom/");

        } else if (id == R.id.nav_HIU) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/himpunan/hiu/");

        } else if (id == R.id.nav_ilmuRohani) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/ukm/keilmuan-dan-kerohanian");

        } else if (id == R.id.nav_olahraga) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/ukm/keolahragaan/");

        } else if (id == R.id.nav_kesenian) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/ukm/kesenian");

        } else if (id == R.id.nav_MinatKhusus) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/category/ukm/minat-khusus");

        } else if (id == R.id.nav_tentang) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/tentang/");

        } else if (id == R.id.nav_home) {
            webUnidaStudent.loadUrl("http://www.unidastudent.com/");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("MenuUtama Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://www.unidastudent.com"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }




    private class webUnidaStudentClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (Uri.parse(url).getHost().equals("www.unidastudent.com")) {
                //membuka konten url di webview
                return false;
            } else {

                //untuk ngebuka link di external app
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }


        }

        ProgressDialog pd = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            pd = new ProgressDialog(MenuUtama.this);
            pd.setTitle("Memuat");
            pd.setMessage("Allah Swt Bersama Orang yang Sabar...");
            pd.show();
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            pd.dismiss();
            super.onPageFinished(view, url);
        }
    }

    //ketika pencet back, kembali ke link sebelumnya

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction()==KeyEvent.ACTION_DOWN){
            switch (keyCode){
                case KeyEvent.KEYCODE_BACK:
                    if(webUnidaStudent.canGoBack()){
                        webUnidaStudent.goBack();
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                                .setTitle("Konfirmasi")
                                .setMessage("Yakin mau keluar?")
                                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    return true;

            }
        }
        return super.onKeyDown(keyCode, event);
    }


}