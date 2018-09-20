package rethinkux.com.bootcamptask2;

import android.app.Application;

public class Stetho extends Application {

    public void onCreate() {
        super.onCreate();

        com.facebook.stetho.Stetho.InitializerBuilder initializerBuilder =
                com.facebook.stetho.Stetho.newInitializerBuilder(this);

        initializerBuilder.enableWebKitInspector(
                com.facebook.stetho.Stetho.defaultInspectorModulesProvider(this)
        );

        initializerBuilder.enableDumpapp(
                com.facebook.stetho.Stetho.defaultDumperPluginsProvider(this)
        );

        com.facebook.stetho.Stetho.Initializer initializer = initializerBuilder.build();

        com.facebook.stetho.Stetho.initialize(initializer);

    }

}
