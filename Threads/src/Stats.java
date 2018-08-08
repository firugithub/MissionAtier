import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * 1,IBM 22.22,AAPL 33.33,IBM 44.44,AAPL 55.55,IBM 66.66

AAPL 44.4400 2
IBM 44.4400 3
 */
public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		private final ConcurrentHashMap<String, List<Double>> conHashMap = new ConcurrentHashMap<String, List<Double>>();

		@Override
		public void putNewPrice(String symbol, double price) {
			List<Double> symPrices;
			if (symbol.length() > 0 && price > 0) {
				if ((symPrices = conHashMap.get(symbol)) != null) {
					symPrices.add(price);
					conHashMap.put(symbol, symPrices);
				} else {
					symPrices = Collections.synchronizedList(new ArrayList<>());
					symPrices.add(price);
					conHashMap.put(symbol, symPrices);

				}
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
			List<Double> symPrices;
			if (symbol != null && symbol.length() > 0) {
				if ((symPrices = conHashMap.get(symbol)) != null) {
					return symPrices.stream().mapToDouble(prices -> prices).average().getAsDouble();
				}
			}
			return -1;
		}

		@Override
		public int getTickCount(String symbol) {
			List<Double> symPrices;
			if (symbol != null && symbol.length() > 0) {
				if ((symPrices = conHashMap.get(symbol)) != null) {
					return symPrices.size();
				}
			}
			return -1;
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(
						String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}