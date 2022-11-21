package com.tapenjoy.actx

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import com.tapenjoy.actx.StarterClass.Companion.C1hhhhh
import com.tapenjoy.actx.StarterClass.Companion.gtghyhyhy
import com.tapenjoy.actx.StarterClass.Companion.rfrgtgttt
import com.tapenjoy.actx.databinding.ActivityOpenUrlBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class OpenUrlActivity : AppCompatActivity() {
    private val ofjpeorjfperjg = 1
    lateinit var jgidhgjdk: WebView
    lateinit var hrfghrdssxc: ActivityOpenUrlBinding
    var rfrgt: ValueCallback<Array<Uri>>? = null
    var ftgt: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hrfghrdssxc = ActivityOpenUrlBinding.inflate(layoutInflater)
        setContentView(hrfghrdssxc.root)

        jgidhgjdk = hrfghrdssxc.viiiwiiivw
        Snackbar.make(
            hrfghrdssxc.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val cmngcmng = CookieManager.getInstance()
        cmngcmng.setAcceptCookie(true)
        cmngcmng.setAcceptThirdPartyCookies(jgidhgjdk, true)
        dddererer()
        val aaaaa: Activity = this
        jgidhgjdk.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (gthykkyjhuu(url)) {

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                view.loadUrl(url)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                sacaacaca(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(aaaaa, description, Toast.LENGTH_SHORT).show()
            }


        }
        jgidhgjdk.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                rfrgt?.onReceiveValue(null)
                rfrgt = filePathCallback
                var pffrfgt: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (pffrfgt!!.resolveActivity(packageManager) != null) {

                    var photoFile: File? = null
                    try {
                        photoFile = furhfhr()
                        pffrfgt.putExtra("PhotoPath", ftgt)
                    } catch (ex: IOException) {
                    }

                    if (photoFile != null) {
                        ftgt = "file:" + photoFile.absolutePath
                        pffrfgt.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile)
                        )
                    } else {
                        pffrfgt = null
                    }
                }
                val gtgttg = Intent(Intent.ACTION_GET_CONTENT)
                gtgttg.addCategory(Intent.CATEGORY_OPENABLE)
                gtgttg.type = "image/*"
                val frfrfsdddd: Array<Intent?> =
                    pffrfgt?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val cbcbcbcb = Intent(Intent.ACTION_CHOOSER)
                cbcbcbcb.putExtra(Intent.EXTRA_INTENT, gtgttg)
                cbcbcbcb.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_chooser))
                cbcbcbcb.putExtra(Intent.EXTRA_INITIAL_INTENTS, frfrfsdddd)
                startActivityForResult(
                    cbcbcbcb, ofjpeorjfperjg
                )
                return true
            }

            @Throws(IOException::class)
            private fun furhfhr(): File {
                var imageStorageDir = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!imageStorageDir.exists()) {
                    imageStorageDir.mkdirs()
                }

                imageStorageDir =
                    File(imageStorageDir.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return imageStorageDir
            }

        }

        jgidhgjdk.loadUrl(frfrrfrfrrfrf())
    }


    private fun dfrggfggr(string: String) {
        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val frrfrf = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $frrfrf"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val sssdede =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $sssdede"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val frgccccv = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $frgccccv"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }

    private fun dddererer() {
        val wstwstwstwst = jgidhgjdk.settings
        wstwstwstwst.javaScriptEnabled = true

        wstwstwstwst.useWideViewPort = true

        wstwstwstwst.loadWithOverviewMode = true
        wstwstwstwst.allowFileAccess = true
        wstwstwstwst.domStorageEnabled = true
        wstwstwstwst.userAgentString = wstwstwstwst.userAgentString.replace("; wv", "")

        wstwstwstwst.javaScriptCanOpenWindowsAutomatically = true
        wstwstwstwst.setSupportMultipleWindows(false)

        wstwstwstwst.displayZoomControls = false
        wstwstwstwst.builtInZoomControls = true
        wstwstwstwst.setSupportZoom(true)

        wstwstwstwst.pluginState = WebSettings.PluginState.ON
        wstwstwstwst.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        wstwstwstwst.setAppCacheEnabled(true)

        wstwstwstwst.allowContentAccess = true
    }

    private fun frfrrfrfrrfrf(): String {

        val kokokok = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

        val jukukjouk = "com.tapenjoy.actx"

        val myTrID: String? = Hawk.get(StarterClass.frgtgttg, "null")
        val hkykkyhkyk: String? = Hawk.get(StarterClass.gttgttggtt, "null")
        val hyhjyjihj: String? = Hawk.get(C1hhhhh)
        val hoyhyjhi: String? = Hawk.get(gtghyhyhy, "null")

        val gtijgjhitjgt: String = Hawk.get(StarterClass.ghyhplyplhy)

        val gtjhjyjhiy = AppsFlyerLib.getInstance().getAppsFlyerUID(this)


        AppsFlyerLib.getInstance().setCollectAndroidID(true)


        val one = "deviceID="
        val subOne = "sub_id_1="
        val thrhtrhtrhtrht = "ad_id="
        val fofofofofofofofofo = "sub_id_4="
        val fififififififififif = "sub_id_5="
        val sisisisifsisis = "sub_id_6="


        val lololololololo = "naming"


        val kiokjjlikjhmkij = Build.VERSION.RELEASE

        val linkAB: String = Hawk.get(rfrgtgttt)

        var aft = ""
        if (gtijgjhitjgt == "1") {
            aft =
                "$linkAB$subOne$hyhjyjihj&$one$gtjhjyjhiy&$thrhtrhtrhtrht$hoyhyjhi&$fofofofofofofofofo$jukukjouk&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
            dfrggfggr(gtjhjyjhiy.toString())
        } else {
            aft =
                "$linkAB$one$myTrID&$thrhtrhtrhtrht$hkykkyhkyk&$fofofofofofofofofo$jukukjouk&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
            dfrggfggr(myTrID.toString())
        }
        return kokokok.getString("SAVED_URL", aft).toString()
    }


    private fun gthykkyjhuu(uri: String): Boolean {

        val hyjiyjhjjyj = packageManager
        try {

            hyjiyjhjjyj.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)


            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != ofjpeorjfperjg || rfrgt == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {
                results = arrayOf(Uri.parse(ftgt))
            } else {
                val dataString = data.dataString
                if (dataString != null) {
                    results = arrayOf(Uri.parse(dataString))
                }
            }
        }
        rfrgt?.onReceiveValue(results)
        rfrgt = null
    }


    private var ujkukjujoujkuj = false

    fun sacaacaca(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (gghghghghhg == "") {
                gghghghghhg = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val spspspspsppspspsp =
                    getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val ededededededed = spspspspsppspspsp.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }

    override fun onBackPressed() {


        if (jgidhgjdk.canGoBack()) {
            if (ujkukjujoujkuj) {
                jgidhgjdk.stopLoading()
                jgidhgjdk.loadUrl(gghghghghhg)
            }
            this.ujkukjujoujkuj = true
            jgidhgjdk.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                ujkukjujoujkuj = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    var gghghghghhg = ""

}