package ruait.demo.androidanimation;

import android.graphics.Canvas;

public class GameThread extends Thread {
	private GameView gameView;
	private boolean running;

	public GameThread(GameView view) {
		this.gameView = view;
	}

	@Override
	public void run() {
		while (running) {
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
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
