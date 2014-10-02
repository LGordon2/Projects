package main

import "os"
import "fmt"
import "strconv"

func main() {
  fmt.Println(os.Args[1])
  num, err := strconv.Atoi(os.Args[1])
  if err != nil{
    fmt.Println(err)
    os.Exit(2)
  }
  for i := 0; i < num; i++ {
    fmt.Println(fib(i))
  }
}

func fib(n int) int{
  if n < 0 {
    return 0
  }
  if n < 2 {
    return 1
  }
  return fib(n - 1) + fib(n - 2)
}
