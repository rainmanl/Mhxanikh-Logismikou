import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		Runnable processRunnable = new Runnable() {
			public void run() {
				Auction auction[] = Auction.checkTimeout();
				for (int i = 0; i < auction.length; i++) {
					auction[i].processAuction();
				}
			}
		};

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(processRunnable, 0, 20, TimeUnit.SECONDS);
	}

}
