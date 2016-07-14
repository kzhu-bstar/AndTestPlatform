package cn.pig.andtestlib.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * 获取设备信息
 *
 * Created by pig on 2016/7/14.
 */
public class DeviceUtil {

    public static void getDeviceInfo() {
        int sdk=android.os.Build.VERSION.SDK_INT; // SDK号
        String release=android.os.Build.VERSION.RELEASE; // android系统版本号
        String model=android.os.Build.MODEL; // 手机型号
        String mtyb= android.os.Build.BRAND;//手机品牌
    }

    //获取当前版本号
    private String getAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            versionName = packageInfo.versionName;
            if (TextUtils.isEmpty(versionName)) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }
}
