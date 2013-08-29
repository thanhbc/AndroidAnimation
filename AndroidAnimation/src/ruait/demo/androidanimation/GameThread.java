package ruait.demo.androidanimation;

import android.graphics.Canvas;

public class GameThread extends Thread {
	// limted 10 frame per second (FSP)
	static final long FPS = 10;
	private GameView gameView;
	private boolean running;

	public GameThread(GameView view) {
		this.gameView = view;
	}

	@Override
	public void run() {
		long ticksPS = 1000 / FPS;
		long startTime;
		long sleepTime;
		while (running) {
			startTime = System.currentTimeMillis();
			Canvas c = null;

			try {

				c = gameView.getHolder().lockCanvas();
				synchronized (gameView.getHolder()) {
					gameView.draw(c);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (c != null) {
					gameView.getHolder().unlockCanvasAndPost(c);
				}
			}

			sleepTime = ticksPS - (System.currentTimeMillis() - startTime);
			try {
				if (sleepTime > 0) {
					sleep(sleepTime);
				} else {
					sleep(10);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
