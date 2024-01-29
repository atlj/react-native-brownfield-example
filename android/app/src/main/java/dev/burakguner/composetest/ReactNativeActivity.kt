package dev.burakguner.composetest

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.facebook.react.JSEngineResolutionAlgorithm
import com.facebook.react.PackageList
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactPackage
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.soloader.SoLoader

class ReactNativeActivity : Activity(), DefaultHardwareBackBtnHandler {
    private var reactRootView: ReactRootView? = null
    private var reactInstanceManager: ReactInstanceManager? = null

    companion object {
        fun createIntent(activity: ComponentActivity) =
            android.content.Intent(activity, ReactNativeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        reactRootView = ReactRootView(this);

        SoLoader.init(this, false)
        val packages: List<ReactPackage> = PackageList(application).packages

        reactInstanceManager = ReactInstanceManager.builder()
            .setApplication(application)
            .setCurrentActivity(this)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("index")
            .setJSEngineResolutionAlgorithm(JSEngineResolutionAlgorithm.HERMES)
            .addPackages(packages)
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()

        reactRootView!!.startReactApplication(reactInstanceManager, "Brownfield", null);
        setContentView(reactRootView);
    }

    override fun onPause() {
        super.onPause()
        reactInstanceManager?.onHostPause(this)
    }

    override fun onResume() {
        super.onResume()
        reactInstanceManager?.onHostResume(this, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        reactInstanceManager?.onHostDestroy(this)
        reactRootView?.unmountReactApplication()
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }
}