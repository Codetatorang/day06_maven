package sg.edu.nus.iss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "\tRunnable..." + i);
                }
            }

        });
        // thread1.start();

        MyRunnableImplementation mRI = new MyRunnableImplementation("task 1");
        MyRunnableImplementation mRI2 = new MyRunnableImplementation("task 2");
        MyRunnableImplementation mRI3 = new MyRunnableImplementation("task 3");
        MyRunnableImplementation mRI4 = new MyRunnableImplementation("task 4");
        MyRunnableImplementation mRI5 = new MyRunnableImplementation("task 5");
        // Thread thread2 = new Thread(mRI);
        // thread2.start();

        // Thread thread3 = new Thread(mRI);
        // thread3.start();

        // single thread exercuteable
        // ExecutorService exercutorService = Executors.newSingleThreadExecutor();
        // exercutorService.execute(mRI);
        // exercutorService.execute(mRI2);
        // exercutorService.shutdown();

        // ExecutorService exercutorService = Executors.newFixedThreadPool(3);
        // exercutorService.execute(mRI);
        // exercutorService.execute(mRI2);
        // exercutorService.execute(mRI3);
        // exercutorService.execute(mRI4);
        // exercutorService.execute(mRI5);
        // exercutorService.shutdown();

        ExecutorService exercutorService = Executors.newCachedThreadPool();
        // exercutorService.execute(mRI);
        // exercutorService.execute(mRI2);
        // exercutorService.execute(mRI3);
        // exercutorService.execute(mRI4);
        // exercutorService.execute(mRI5);
        exercutorService.shutdown();

        MyRunnableInterface<Integer> addOperation = (a, b) -> {
            return a + b;
        };

        MyRunnableInterface<Integer> multiplyOperation = (a, b) -> {
            return a * b;
        };
        MyRunnableInterface<Integer> divideOperation = (a, b) -> {
            return a / b;
        };

        MyMessageInterface printString = (a) -> {
            System.out.println(a);
        };

        System.out.println("addOperation: " + addOperation.process(1, 1));
        System.out.println("multiplyOperation: " + multiplyOperation.process(1, 1));
        System.out.println("divideOperation: " + divideOperation.process(1, 1));
        printString.printMessage("lets take a break at 12pm.");

        // list of employees
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "donny", "yen", 50000));
        employees.add(new Employee(2, "bat", "man", 50000));
        employees.add(new Employee(3, "super", "man", 50000));
        employees.add(new Employee(4, "wonder", "woman", 50000));
        employees.add(new Employee(5, "iron", "man", 50000));
        employees.add(new Employee(6, "spider", "man", 50000));
        employees.add(new Employee(7, "doctor", "mambo", 50000));

        
        List<Employee> filteredemployees = employees.stream().filter(emp -> emp.getLastName().contains("yen"))
                .collect(Collectors.toList());

        // filteredemployees.forEach(emp->System.out.println(emp));
        // employees.sort(Comparator.comparing(e->e.getFirstName()));
        // employees.sort(Comparator.comparing(Employee::getFirstName));
        // employees.sort(Comparator.comparing(Employee::getFirstName).reversed());
        Comparator<Employee> compare = Comparator.comparing(Employee::getFirstName);
        employees.sort(compare.reversed());
        
        // employees.forEach(emp -> {
        //     System.out.println(emp);
        // });

        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
        employees.sort(groupByComparator);
        
        employees.forEach(emp -> {
            System.out.println(emp);
        });
        

    }
}
