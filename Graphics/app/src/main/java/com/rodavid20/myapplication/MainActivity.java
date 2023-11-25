package com.rodavid20.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int start = 0;
    LinearLayout llMainContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomView view = new CustomView(this);
        //setContentView(view);
        setContentView(R.layout.activity_main);
        CustomCircle customCircle = new CustomCircle(this);
        llMainContainer = findViewById(R.id.llMainContainer);
        llMainContainer.addView(customCircle);
        Button btnChange = findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start += 50;
                customCircle.invalidate();
            }
        });

    }

    private class CustomCircle extends View {
        public CustomCircle(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            canvas.drawCircle(start,500, 100, paint);
        }
    }


    private class CustomView extends View {
        public CustomView(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            paint.setColor(Color.RED);
            canvas.drawCircle(500,500, 100, paint);
            paint.setColor(Color.GREEN);
            canvas.drawRect(500, 700, 700, 900, paint);
            paint.setTextSize(100);
            paint.setColor(Color.BLACK);
            canvas.rotate(-15);
            canvas.save();
            canvas.rotate(-30);
            canvas.drawText("Graphics Demo", -400, 500, paint);
            canvas.restore();
            canvas.drawText("Graphics Demo New", 0, 500, paint);

        }
    }
}