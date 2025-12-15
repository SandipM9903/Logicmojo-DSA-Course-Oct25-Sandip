function fibonacci(n) {
    // Base cases: fib(0) = 0, fib(1) = 1
    if (n === 0) return 0;
    if (n === 1) return 1;

    // Recursively calculate previous two numbers
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// Example
console.log(fibonacci(10));
console.log("=================");


//Fibonacci Series
function printFibonacciSeries(n, a = 0, b = 1, count = 1) {
    // Print the current number
    console.log(a);

    // Stop when we've printed n numbers
    if (count === n) {
        return;
    }

    // Recursively print the next number
    printFibonacciSeries(n, b, a + b, count + 1);
}

// Example: print first 10 Fibonacci numbers
printFibonacciSeries(10);
