package cn.pig.andtestlib.core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import cn.pig.andtestlib.http.NanoHTTPD;
import cn.pig.andtestlib.http.RouterNanoHTTPD;
import cn.pig.andtestlib.utils.FileUtil;


public class HomeHandler extends RouterNanoHTTPD.DefaultHandler {

    public static final String TEMPLATE_FILE_NAME = "Test.html";

    @Override
    public String getText() {
        return "not implemented";
    }

    public String getText(Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
//        String text = "<html><body>User handler. Method: " + session.getMethod().toString() + "<br>";
//        text += "<h1>Uri parameters:</h1>";
//        for (Map.Entry<String, String> entry : urlParams.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            text += "<div> Param: " + key + "&nbsp;Value: " + value + "</div>";
//        }
//        text += "<h1>Query parameters:</h1>";
//        for (Map.Entry<String, String> entry : session.getParms().entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            text += "<div> Query Param: " + key + "&nbsp;Value: " + value + "</div>";
//        }
//        text += "</body></html>";

        return FileUtil.readFile(AppContext.getTempleteDir() + File.separator + TEMPLATE_FILE_NAME);
    }

    @Override
    public String getMimeType() {
        return "text/html";
    }

    @Override
    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }

    public NanoHTTPD.Response get(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        String text = getText(urlParams, session);
        ByteArrayInputStream inp = new ByteArrayInputStream(text.getBytes());
        int size = text.getBytes().length;
        return NanoHTTPD.newFixedLengthResponse(getStatus(), getMimeType(), inp, size);
    }

}