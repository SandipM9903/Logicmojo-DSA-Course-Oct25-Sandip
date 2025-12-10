function printIToN(i,n){
    //We have to give a break point in recursion otherwise it will go on executing.
    if(i>n){
        return;
    }
    console.log(i);
    //calling the same method inside the method this is known as recursion.
    printIToN(i+1, n);
}

printIToN(1,10)