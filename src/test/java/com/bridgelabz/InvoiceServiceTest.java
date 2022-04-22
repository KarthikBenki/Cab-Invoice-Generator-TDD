package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    /*
    test to calculate total fare
     */
  @Test
  public void givenDistanceAndTime_ShouldReturnTotalFare() {
      InvoiceGenerator invoiceGenerator = new InvoiceGenerator();//creating invoice generator object
      double distance = 2.0;
      int time = 5;
      double fare = invoiceGenerator.calculateFare(distance, time);//calculating fare by calling method
      Assertions.assertEquals(25,fare);//comparing expected and actual
  }

  @Test
  public void givenLessDistanceAndTime_ShouldReturnTrue() {
      InvoiceGenerator invoiceGenerator = new InvoiceGenerator();//creating invoice generator object
      double distance = 0.1;
      int time = 1;
      double fare = invoiceGenerator.calculateFare(distance, time);//0.1*10+1*1=2;
      Assertions.assertEquals(5,fare);//expected is 5 as minimum fare is five
  }
}
