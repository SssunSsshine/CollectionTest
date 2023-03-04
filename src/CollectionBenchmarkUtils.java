import java.util.Collection;
import java.util.List;

import static java.lang.String.format;

public final class CollectionBenchmarkUtils {
    private static final Long BENCHMARK_SIZE_ADD = 1000000L;
    private static final Long BENCHMARK_SIZE_ADD_FIRST = 100000L;
    private static final Long BENCHMARK_SIZE_ADD_LAST = 1000000L;
    private static final Long BENCHMARK_SIZE_CONTAINS = 100000L;
    public static BenchmarkResult runAddMethodBenchmark(Collection<String> collection) {
        String info = format("Testing add method of %s", collection.getClass().getName());
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BENCHMARK_SIZE_ADD; i++) {
            collection.add(String.format("Benchmark%s", i));
        }

        long endTime = System.currentTimeMillis();
        return new BenchmarkResult(endTime - startTime, info);
    }

    public static BenchmarkResult runAddFirstMethodBenchmark(List<String> list) {
        String info = format("Testing add (to begin) method of %s", list.getClass().getName());
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BENCHMARK_SIZE_ADD_FIRST; i++) {
            list.add(0,String.format("Benchmark%s", i));
        }

        long endTime = System.currentTimeMillis();
        return new BenchmarkResult(endTime - startTime, info);
    }

    public static BenchmarkResult runAddLastMethodBenchmark(List<String> list) {
        String info = format("Testing add (to end) method of %s", list.getClass().getName());
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BENCHMARK_SIZE_ADD_LAST; i++) {
            list.add(list.size(), String.format("Benchmark%s", i));
        }

        long endTime = System.currentTimeMillis();
        return new BenchmarkResult(endTime - startTime, info);
    }

    public static BenchmarkResult runContainsMethodBenchmark(Collection<Integer> collection) {
        String info = format("Testing contains method of %s", collection.getClass().getName());

        for (int i = 0; i < BENCHMARK_SIZE_CONTAINS; i++) {
            collection.add(i);
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < BENCHMARK_SIZE_CONTAINS; i++) {
            collection.contains(i);
        }

        long endTime = System.currentTimeMillis();
        return new BenchmarkResult(endTime - startTime, info);
    }
}
