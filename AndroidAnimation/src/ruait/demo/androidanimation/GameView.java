package ruait.demo.androidanimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;

public class GameView extends SurfaceView implements Callback {
	private Bitmap bm;
	private SurfaceHolder holder;

	public GameView(Context context) {
		super(context);
		holder = getHolder();
		holder.addCallback(this);
		bm = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		canvas.drawBitmap(bm, 10, 10, null);

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Canvas c = holder.lockCanvas();
		onDraw(c);
		holder.unlockCanvasAndPost(c);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
}