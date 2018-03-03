package models;
import static org.junit.Assert.*;
import org.junit.Test;
import static play.test.Helpers.*;

public class FibonacciTest {
    @Test
    public void testFibonacciModel(){
        running(fakeApplication(inMemoryDatabase()), new Runnable(){
            @Override
            public void run(){
                Integer amount = 5;
                Fibonacci fibonacci = new Fibonacci(amount);
                fibonacci.fib();
                assertEquals(fibonacci.amount, amount);
                assertEquals(fibonacci.sequence,"1 1 2 3 5 ");
            }
        });

    }
}
