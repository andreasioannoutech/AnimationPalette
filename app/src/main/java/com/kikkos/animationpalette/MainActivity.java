package com.kikkos.animationpalette;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sharedElement)
    Button btnSharedElement;
    @BindView(R.id.imageViewMain)
    ImageView imageViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sharedElement)
    public void startSharedElementTransition() {
        // start activity with transition scene animation effect.
        if (imageViewMain != null) {
            Intent intent = new Intent(this, DetailsActivity.class);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(
                                this,
                                imageViewMain,
                                "sharedIcon");
                startActivity(intent, options.toBundle());
            }
        }
    }
}
