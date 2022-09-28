package com.flintcore.tarea_2_movil.events;

import static com.flintcore.tarea_2_movil.views.AppPrimitiveResources.STATUS_SUCCESS_CLOSE;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class ClearNCloseTouchEvent implements View.OnTouchListener {

    //    Constants
    public static final float MIN_SLICE_DIFF = 530f;
    //    attributes of the class
    private float xStartPoint;
    private final ExternalDoAction cleanAction;
    private final WindowManager managerScreen;

    public ClearNCloseTouchEvent(ExternalDoAction cleanAction, WindowManager managerScreen) {
        this.cleanAction = cleanAction;
        this.managerScreen = managerScreen;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        Point point = getDisplay();
        final float eventX = motionEvent.getX();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.xStartPoint = eventX;
                break;

            case MotionEvent.ACTION_UP:
                if (this.xStartPoint != eventX) {
                    float relativeScreenSlice = point.x - MIN_SLICE_DIFF;
                    float sliceAction = this.xStartPoint - eventX;

                    if (Math.abs(sliceAction) >= relativeScreenSlice) {

                        if (sliceAction > 0) {
                            this.cleanAction.start();
                        } else {
                            System.exit(STATUS_SUCCESS_CLOSE);
                        }
                    }
//                    end decision to action
                }
//                end all
        }

        return true;
    }

    private Point getDisplay() {
        Point pointScreen = new Point();

        this.managerScreen.getDefaultDisplay().getSize(pointScreen);

        return pointScreen;
    }
}
