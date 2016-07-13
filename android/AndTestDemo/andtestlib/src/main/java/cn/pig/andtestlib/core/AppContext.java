package cn.pig.andtestlib.core;

import android.content.Context;

import java.lang.ref.SoftReference;

import cn.pig.andtestlib.utils.SdcardUtil;


/**
 * Created by pig on 2016/7/12.
 */
public class AppContext {

    public static SoftReference<Context> contextSoftReference;

    public static void init(Context context) {
        if (contextSoftReference == null) {
            contextSoftReference = new SoftReference<Context>(context);
        }

    }

    public static String getTempleteDir() {
        if (contextSoftReference == null || contextSoftReference.get() == null) {
            throw new RuntimeException("Please AppContext.init(Context)!");
        }
        return SdcardUtil.getTempleteDir(contextSoftReference.get());
    }
}
