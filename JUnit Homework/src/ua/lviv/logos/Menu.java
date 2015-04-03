package ua.lviv.logos;

import java.util.Scanner;

public class Menu {
Scanner scanner;
Number number;
  public void display(){
    System.out.println(
        "\t1 - Check number \n\t2 - Check number interval\n\t0 - Exit");
  }
  
  public void selectMenu(){
    boolean status = true;
    while(status){
    display();
    System.out.println("Select item: \n");
    scanner = new Scanner(System.in);
    number = new Number();
    int item = scanner.nextInt();
    if(item == 1){
      System.out.println("Enter number \n");
      int num = scanner.nextInt();
      number.showResult(num);
    }
    else if(item == 2){
      System.out.println("Enter start position");
      int start = scanner.nextInt();
      System.out.println("Enter end position");
      int end = scanner.nextInt();
      number.eximaineNumbers(start, end);
    }
    else if(item == 0){
      System.out.println("Good bye");
      status = false;
    }
    else{
      System.out.println("You select wrong number!!");
    }
  }
  }
  
}
