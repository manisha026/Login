package rethinkux.com.bootcamptask2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;

public class CoordinatorActivity extends AppCompatActivity {

    private FloatingActionButton mFab;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        mFab = findViewById(R.id.fab);
        mCoordinatorLayout = findViewById(R.id.coordinatorLayout);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mCoordinatorLayout,
                        "This is a simple Snackbar", Snackbar.LENGTH_LONG)
                .setAction("CLOSE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
            }
        });

        Bitmap image = BitmapFactory.decodeResource(getResources(),
                R.id.image);
        Palette.from(image).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                if (vibrantSwatch != null) {
                    mCoordinatorLayout.setBackgroundColor(vibrantSwatch.getRgb());
//                    titleText.setTextColor(vibrantSwatch.getTitleTextColor());
//                    bodyText.setTextColor(vibrantSwatch.getBodyTextColor());
                }
            }

    });
}
}
