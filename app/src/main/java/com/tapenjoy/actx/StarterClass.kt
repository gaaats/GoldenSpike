package com.tapenjoy.actx

import android.app.Application
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import java.util.*

class StarterClass : Application() {
    companion object {
        const val ftgthyy = "92496125156370263017"

        var frgtgttg: String? = "myID"
        var gttgttggtt: String? = "instID"
        var rfrgtgttt = "link"
        var gtghyhyhy: String? = ""
        const val jglfkdkdkgjd = "a3610c6a-ac52-4d84-9a21-ea1e63f1208b"
        var ghyhplyplhy = "appsChecker"
        var C1hhhhh: String? = "c11"

    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(jglfkdkdkgjd)

        Hawk.init(this).build()


        val frgttgt = getSharedPreferences("PREFS_NAME", 0)

        val thttht = MyTracker.getTrackerParams()
        val frfrrf = MyTracker.getTrackerConfig()
        val bgbgb = MyTracker.getInstanceId(this)
        frfrrf.isTrackingLaunchEnabled = true
        if (frgttgt.getBoolean("my_first_time", true)) {
            val gtgththyy = UUID.randomUUID().toString()
            thttht.setCustomUserId(gtgththyy)
            Hawk.put(frgtgttg, gtgththyy)
            Hawk.put(gttgttggtt, bgbgb)
            frgttgt.edit().putBoolean("my_first_time", false).apply()

        } else {
            val IDIN = Hawk.get(frgtgttg, "null")
            thttht.setCustomUserId(IDIN)
        }
        MyTracker.initTracker(ftgthyy, this)

    }


}
