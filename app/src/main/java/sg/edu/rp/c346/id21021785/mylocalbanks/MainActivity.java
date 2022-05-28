package sg.edu.rp.c346.id21021785.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbsText);
        ocbc = findViewById(R.id.ocbcText);
        uob = findViewById(R.id.uobText);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == dbs) {
            wordClicked = "dbs";
        } else if (v == ocbc) {
            wordClicked = "ocbc";
        } else if (v == uob) {
            wordClicked = "uob";
        }

        getMenuInflater().inflate(R.menu.menu_main, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (id == R.id.website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
                startActivity(intent);

                return true;

            } else if (id == R.id.contact) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbsNo)));
                startActivity(intent);

                return true;
            } else if (id == R.id.favourite) {
                if (dbs.getText() == getString(R.string.dbs)) {
                    dbs.setText(R.string.dbsFav);
                    return true;
                } else {
                    dbs.setText(R.string.dbs);
                    return true;
                }
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (id == R.id.website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
                startActivity(intent);

                return true;

            } else if (id == R.id.contact) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.ocbcNo)));
                startActivity(intent);

                return true;
            } else if (id == R.id.favourite) {
                if (ocbc.getText() == getString(R.string.ocbc)) {
                    ocbc.setText(R.string.ocbcFav);
                    return true;
                } else {
                    ocbc.setText(R.string.ocbc);
                    return true;
                }
            }
        } else if (wordClicked.equalsIgnoreCase("uob")) {
            if (id == R.id.website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
                startActivity(intent);

                return true;

            } else if (id == R.id.contact) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobNo)));
                startActivity(intent);

                return true;
            } else if (id == R.id.favourite) {
                if (uob.getText() == getString(R.string.uob)) {
                    uob.setText(R.string.uobFav);
                    return true;
                } else {
                    uob.setText(R.string.uob);
                    return true;
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menuOptions) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menuOptions);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem optionsItem) {
        // Handle action bar item clicks here.
        int id = optionsItem.getItemId();

        if (id == R.id.english) {
            dbs.setText(R.string.dbs);
            ocbc.setText(R.string.ocbc);
            uob.setText(R.string.uob);
            return true;
        } else if (id == R.id.chinese) {
            dbs.setText(R.string.dbsCL);
            ocbc.setText(R.string.ocbcCL);
            uob.setText(R.string.uobCL);
            return true;
        }

        return super.onOptionsItemSelected(optionsItem);
    }


}