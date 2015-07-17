/*
 * Copyright (C) 2015 8tory, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package json2intent.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import android.app.Intent;
import json2intent.Json2Intent;

import android.content.Context;

import org.json.JSONObject;
import org.json.JSONException;
import json2intent.model.AndroidIntent;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    TextView jsonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jsonView = (TextView) findViewById(R.id.json);

        String wikiJson = readFile("wiki.json");
        jsonView.setText(wikiJson);
        new AsyncTask<String, Void, Void>() {
            @Override public Void doInBackground(String... jsons) {
                android.util.Log.d("json2intent-app", "json:" + jsons[0]);

                //Intent n = Json2Intent.from(MainActivity.this).with(jsons[0]).intent();

                AndroidIntent androidIntent = AndroidIntent.parse(MainActivity.this, jsons[0]);
                android.util.Log.d("json2intent-app", "intent:" + androidIntent.intent);
                android.util.Log.d("json2intent-app", "serialize:" + androidIntent.serialize());
                return null;
            }
        }.execute(wikiJson);
    }

    private String readFile(String filename) {
        StringBuilder sb = new StringBuilder();

        try {
            InputStream json = getAssets().open(filename);
            BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));

            String str;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }

            in.close();
        } catch (Exception e) {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("The JSON file was not able to load properly. These tests won't work until you completely kill this demo app and restart it.")
                    .setPositiveButton("OK", null)
                    .show();
        }

        return sb.toString();
    }
}
