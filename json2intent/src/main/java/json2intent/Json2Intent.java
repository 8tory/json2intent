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

package json2intent;

import android.app.Intent;
import android.content.Context;

import org.json.JSONObject;
import org.json.JSONException;

import json2intent.model.AndroidIntent;

public class Json2Intent {
    private static final String TAG = "json2intent";
    private Context context;
    private JSONObject jsonObject;

    public static Json2Intent from(Context context) {
        return new Json2Intent(context);
    }

    private Json2Intent(Context context) {
        this.context = context;
    }

    public Json2Intent with(String json) {
        try {
            return with(new JSONObject(json));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Json2Intent with(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    public Intent intent() {
        Intent intent = null;

        try {
            AndroidIntent androidIntent = AndroidIntent.parse(context, jsonObject.toString());
            intent = androidIntent.intent;
        } catch (Exception e) {
        }

        return intent;
    }

    public void startActivity() {
    }
}
