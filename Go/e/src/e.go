package main

import(
  "fmt"
  "math"
  "os"
  "strconv"
)

func main() {
  num, err := strconv.Atoi(os.Args[1])
  if err != nil {
    fmt.Println(err)
    os.Exit(2)
  }
  fmt.Printf("%.*f\n", num, math.E)
}
