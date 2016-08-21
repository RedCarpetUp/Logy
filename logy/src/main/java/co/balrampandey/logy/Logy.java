package co.balrampandey.logy;

import android.os.Build;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Balram Pandey on 10/08/16.
 * Copyright 2016 Balram Pandey

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
public class Logy {

    private static boolean DEBUG = BuildConfig.DEBUG;



    /** Log a verbose message with logy.  */

    public static void v(String c, String s) {
        if (isEnable()) {
            if (s == null)
                s = "\"NULL\"";
            Log.v(c, s);
        }
    }



    /** Log a debug message with logy. */

    public static void d(String c, String s) {
        if (isEnable()){
            if (s == null)
                s = "\"NULL\"";
            Log.d(c, s);
        }
    }



    /** Log an info message with logy.  */

    public static void i(String c, String s) {
        if (isEnable()) {
            if (s == null)
                s = "\"NULL\"";
            Log.i(c, s);
        }
    }

    /** Log a warning message with logy. */

    public static void w(String c, String s) {
        if (isEnable()) {
            if (s == null)
                s = "\"NULL\"";
            Log.w(c, s);
        }
    }

    /** Log an error message with logy. */

    public static void e(String c, String s) {
        if (isEnable()) {
            if (s == null)
                s = "\"NULL\"";
            Log.e(c, s);
        }
    }

    /** Log an debug message with class name and method name. */

    public static void d(String logMsg) {
        if (isEnable()) {
            log(getCurrentClassName(), getCurrentMethodName() + "(): " + logMsg);
        }
    }


    /** Log an josn message with structural format. */

    public static void json(String tag, Object source) {
        if (isEnable()) {
            Object o = getJsonObjFromStr(source);
            if (o != null) {
                try {
                    if (o instanceof JSONObject) {
                        format(tag, ((JSONObject) o).toString(2));
                    } else if (o instanceof JSONArray) {
                        format(tag, ((JSONArray) o).toString(2));
                    } else {
                        format(tag, source);
                    }
                } catch (JSONException e) {
                    format(tag, source);
                }
            } else {
                format(tag, source);
            }
        }
    }

    private static void log(String tag, String msg) {
        Log.d(tag, msg);
    }

    private static String getSplitter(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    private static void format(String tag, Object source) {
        tag = " " + tag + " ";
        log(" ", " ");
        log(" ", getSplitter(50) + tag + getSplitter(50));
        log(" ", "" + source);
        log(" ", getSplitter(100 + tag.length()));
        log(" ", " ");
    }

    private static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[4].getMethodName();
    }

    private static String getCurrentClassName() {
        String className = Thread.currentThread().getStackTrace()[4].getClassName();
        String[] temp = className.split("[\\.]");
        className = temp[temp.length - 1];
        return className;
    }

    private static Object getJsonObjFromStr(Object test) {
        Object o = null;
        try {
            o = new JSONObject(test.toString());
        } catch (JSONException ex) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    o = new JSONArray(test);
                }
            } catch (JSONException ex1) {
                return null;
            }
        }
        return o;
    }

    public static boolean isEnable() {
        return DEBUG;
    }

    public static void setEnable(boolean flag) {
        Logy.DEBUG = flag;
    }


}
