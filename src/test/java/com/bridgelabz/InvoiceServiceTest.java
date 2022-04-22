package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
  InvoiceGenerator invoiceGenerator = null;
  @BeforeEach
  public void setUp() {
    invoiceGenerator = new InvoiceGenerator();
  }

  /*
    test to calculate total fare
     */
  @Test
  public void givenDistanceAndTime_ShouldReturnTotalFare() {
    double distance = 2.0;
    int time = 5;
    double fare =
        invoiceGenerator.calculateFare(distance, time); // calculating fare by calling method
    Assertions.assertEquals(25, fare); // comparing expected and actual
  }

  /*
  test to calculate minimum fare
   */
  @Test
  public void givenLessDistanceAndTime_ShouldReturnTrue() {
    double distance = 0.1;
    int time = 1;
    double fare = invoiceGenerator.calculateFare(distance, time); // 0.1*10+1*1=2;
    Assertions.assertEquals(5, fare); // expected is 5 as minimum fare is five
  }

  /*
test to calculate fare for multiple rides
   */
  @Test
  public void givenMultipleRides_ShouldReturnTotalFare() {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator(); // creating invoice generator object
    Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1,1)
    };
    double totalFare = invoiceGenerator.calculateFare(rides);
    Assertions.assertEquals(30,totalFare);
  }



}
