package cn.pig.andtestlib.utils;

import android.content.Context;

import java.io.File;

/**
 * Created by pig on 2016/7/12.
 */
public class SdcardUtil {

    public static final String FREEMARKER_DIR = "FreeMarker";
    public static final String TEMPLETE = "templete";
    public static final String CONFIG = "config";

    public static String getFreeMarkerDir(Context context) {
        File file = context.getExternalFilesDir(FREEMARKER_DIR);
        return file.getAbsolutePath();
    }

    public static String getTempleteDir(Context context) {
        return SdcardUtil.getFreeMarkerDir(context) + File.separator + TEMPLETE;
    }

}
