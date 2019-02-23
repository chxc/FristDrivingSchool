package intro.com.fristdrivingschool.tool.Net;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ClearCacheRequest;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.Map;

import intro.com.fristdrivingschool.Bean.MainBean;
import intro.com.fristdrivingschool.tool.StaticValue;
import intro.com.fristdrivingschool.tool.YCStringTool;

public class MyNetListener {

    private static RequestQueue requestQueue;

    public interface NetListener{
        void success(String str,int mark,int... position);
        void error(String str,int mark,int... position);
    }

    public static void getString(final Context context, int RequestMethod, final NetListener netListener, String url, final int mark, final Map<String,String> map){
        try {
            if (requestQueue == null) {
                requestQueue = getRequestQueue(context);
            }
            url=StaticValue.PATH+url;
            StringRequest sRequest = new StringRequest(RequestMethod, url.replace(" ", ""),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (netListener != null) {
                        Gson gson=new GsonBuilder().enableComplexMapKeySerialization().create();
                        MainBean mainBean = gson.fromJson(response, MainBean.class);
                        if(mainBean.getRet()==200&&mainBean.getData()!=null) {
                            netListener.success(response.toString(), mark);
                        }else {
                            netListener.error(response.toString(),mark);
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError arg0) {
                    if (netListener != null) {
                        netListener.error(arg0.toString(),mark);
                        YCStringTool.logi(this.getClass(),"请求失败"+arg0.toString());
                    }
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    return map;
                }
            };
            sRequest.setShouldCache(false);
            requestQueue.add(sRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static RequestQueue getRequestQueue(Context context) {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        File cacheDir = new File(context.getCacheDir(), "drivingSchool");
        DiskBasedCache cache = new DiskBasedCache(cacheDir);
        requestQueue.start();
        // clear all volley caches.
        requestQueue.add(new ClearCacheRequest(cache, null));
        return requestQueue;
    }
}
