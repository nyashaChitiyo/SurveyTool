package com.codel.zw.saint_mobile_go;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gifty on 12/6/17.
 */

public class KycRecords extends StringRequest{

    private static final String REGISTER_REQUEST_URL = "http://saints.codel.co.zw/kycdata.php";
    private Map<String, String> params;

    public KycRecords(String firstname, String lastname, String personalphone, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("firstname", firstname);
        params.put("lastname", lastname);
        params.put("personalphone", personalphone);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
