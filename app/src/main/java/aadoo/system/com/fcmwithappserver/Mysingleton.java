package aadoo.system.com.fcmwithappserver;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by User1 on 2/24/2018.
 */

public class Mysingleton {

    private static Mysingleton mInstance;
    private static Context mCtx;
    private RequestQueue requestQueue;

    private Mysingleton(Context context)
    {
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized Mysingleton getmInstance(Context context)
    {
        if(mInstance==null)
        {
            mInstance = new Mysingleton(context);
        }
        return mInstance;
    }

    public<T> void addToRequestque(Request<T> request)
    {
        getRequestQueue().add(request);
    }

}
