package com.tamtam.tamtaminfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class DetailNewsActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "com.tamtam.tamtaminfo.position";

    private News mNews;
    private int mposi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_tamtamlaunchertest);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        // Recuperation des infos de l'intent
        Intent i = getIntent();
        Bundle extra = i.getExtras();
        mposi = extra.getInt(EXTRA_POSITION, 10);

        // Get la data
        mNews = News.getNewsAt(this, mposi);

        // Get les refs sur les vues
        TextView dateView = (TextView) findViewById(R.id.detailDate);
        TextView titleView = (TextView) findViewById(R.id.detailTitle);
        TextView categView = (TextView) findViewById(R.id.detailCateg);
        ImageView imgView = (ImageView) findViewById(R.id.detailImg);
        TextView copyrightView = (TextView) findViewById(R.id.detailCopyright);
        TextView bodyView = (TextView) findViewById(R.id.detailBody);

        // Set les data des vues
        dateView.setText(getDateStr());
        titleView.setText(mNews.title);
        categView.setText(mNews.catName);
        imgView.setImageBitmap(mNews.imgBit);
        copyrightView.setText(mNews.copyright);
        bodyView.setText(mNews.body);
        categView.setBackgroundColor(mNews.catColor);
        copyrightView.setBackgroundColor(mNews.catColor);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Message from " + posi, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private String getDateStr() {
        String ret = "Publié le "
                + mNews.date.get(Calendar.DAY_OF_MONTH) + " "
                + mNews.date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRANCE) + " "
                + mNews.date.get(Calendar.YEAR) + " par Tam Tam Info";
        return (ret);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
