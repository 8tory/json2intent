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

package json2intent.model;

import android.content.Context;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

import com.bluelinelabs.logansquare.LoganSquare;

import com.bluelinelabs.logansquare.typeconverters.*;
import android.app.Intent;

/**
 *
 * <pre>
 *  "android": {
 *      "intent": {
 *          "action": "android.intent.action.VIEW",
 *          "uri": "https://play.google.com/store/apps/details?id=com.story8.android.gallery"
 *      }
 *  }
 *  </pre>
 */
@Keep
@KeepClassMembers
@JsonObject
public class AndroidIntent {
    @JsonField
    public Intent intent;

    Context context;

    public static AndroidIntent parse(Context context, String json) {
        LoganSquare.registerTypeConverter(Intent.class, new IntentConverter(context));
        try {
            AndroidIntent androidIntent = LoganSquare.parse(json, AndroidIntent.class);
            androidIntent.context = context;
            return androidIntent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String serialize() {
        LoganSquare.registerTypeConverter(Intent.class, new IntentConverter(context));
        try {
            return LoganSquare.serialize(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
