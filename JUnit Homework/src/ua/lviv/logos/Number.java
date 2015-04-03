package ua.lviv.logos;

public class Number {
	
public double divOnTwo(double number){
	return number/2;
}

public double getSqrt(double number){
	return Math.sqrt(number);
}

public boolean isTotal(double number){
	return getSqrt(divOnTwo(number))%1==0;
}

public void showResult(double number){
	System.out.println("This number("+number+") can show as summ sqrt - "+isTotal(number));
}

public void eximaineNumbers(int start, int end){
  for (int i = start; i < end; i++) {
    if(isTotal(i)){
      System.out.print(i+" ");
    }
    
  }
}
}
