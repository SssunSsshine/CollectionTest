import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting benchmark");

        /*Добавление элемента в ArrayList выполняется быстрее, так как добавление происходит по индексу,
           HashSet основан на HashMap, использует бакеты, а при превышении дефолтного количества бакетов происходит расширение,
            что требует времени, то есть он работает медленно, если хэшкоды вставляемых объектов без совпадений, а само количество объектов велико,
             но даже если он не так часто раширяется, все равно работает медленнее, потому что использует хэшмаповский put,
             которому требуется сначала по хэшкоду найти бакет, а затем возможно еще и пройтись по связному списку пока не
             найдет пустую ячейку, либо ячейку в которой уже лежит добавляемый элемент.
          TreeSet использует красно-черное дерево, а значит упорядочивает все элементы.
          LinkedList выполняет добавление медленнее всех так как создание объекта узла занимает много времени.
          */
        System.out.println(CollectionBenchmarkUtils.runAddMethodBenchmark(new LinkedList<>()));
        System.out.println(CollectionBenchmarkUtils.runAddMethodBenchmark(new ArrayList<>()));
        System.out.println(CollectionBenchmarkUtils.runAddMethodBenchmark(new HashSet<>()));
        System.out.println(CollectionBenchmarkUtils.runAddMethodBenchmark(new TreeSet<>()));
        System.out.println();

        /*В LinkedList добавление в начало выполняется быстрее так как просто создается новый объект узла и меняются ссылки
        При осуществлении добавления в начало ArrayList'а происходит сдвиг всех элементов правее, поэтому он работает медленно*/
        System.out.println(CollectionBenchmarkUtils.runAddFirstMethodBenchmark(new LinkedList<>()));
        System.out.println(CollectionBenchmarkUtils.runAddFirstMethodBenchmark(new ArrayList<>()));
        System.out.println();

        /*В ArrayList добавление в конец выполняется по индексу, поэтому он работает быстрее
          LinkedList же основан на связном списке, то есть требуется время на переопределение связей при добавлении в конец и создание объекта*/
        System.out.println(CollectionBenchmarkUtils.runAddLastMethodBenchmark(new LinkedList<>()));
        System.out.println(CollectionBenchmarkUtils.runAddLastMethodBenchmark(new ArrayList<>()));
        System.out.println();

        /*HashSet быстрее, когда элементов большое количество. (Неупорядоченные элементы)
         Так как TreeSet реализовано на основе красно-черного дерева (элементы упорядочены, что требует время) и чем больше элементов,
          тем больше глубина дерева, и тем дольше обработка*/
        System.out.println(CollectionBenchmarkUtils.runContainsMethodBenchmark(new HashSet<>()));
        System.out.println(CollectionBenchmarkUtils.runContainsMethodBenchmark(new TreeSet<>()));
        System.out.println();

        /*HashSet.contains самый быстрый, так как не перебирает все элементы по порядку, а использует HashCode.
          ArrayList работает медленно по сравнению с HashSet, перебирает все элементы,
          элементы в одном блоке памяти, поэтому работает быстрее связного списка
          На последнем месте LinkedList, тоже перебирает все элементы + доступ к элементам
          сложнее (элеметы списка находятся на разных участках памяти), поэтому и выполняется медленнее.*/
        System.out.println(CollectionBenchmarkUtils.runContainsMethodBenchmark(new HashSet<>()));
        System.out.println(CollectionBenchmarkUtils.runContainsMethodBenchmark(new ArrayList<>()));
        System.out.println(CollectionBenchmarkUtils.runContainsMethodBenchmark(new LinkedList<>()));
    }
}
