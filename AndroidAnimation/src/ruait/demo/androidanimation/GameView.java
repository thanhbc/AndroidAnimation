package ruait.demo.androidanimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class GameView extends View {
	private Bitmap bm;

	public GameView(Context context) {
		super(context);
		bm = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		canvas.drawBitmap(bm, 10, 10, null);

	}
}
