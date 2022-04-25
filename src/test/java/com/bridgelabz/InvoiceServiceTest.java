package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
  InvoiceService invoiceService = null;

  @BeforeEach
  public void setUp() {
    invoiceService = new InvoiceService();
  }

  /*
  test to calculate total fare
   */
  @Test
  public void givenDistanceAndTime_ShouldReturnTotalFare() {
    double distance = 2.0;
    int time = 5;
    double fare =
        invoiceService.calculateFare(distance, time); // calculating fare by calling method
    assertEquals(25, fare); // comparing expected and actual
  }

  /*
  test to calculate minimum fare
   */
  @Test
  public void givenLessDistanceAndTime_ShouldReturnTrue() {
    double distance = 0.1;
    int time = 1;
    double fare = invoiceService.calculateFare(distance, time); // 0.1*10+1*1=2;
    assertEquals(5, fare); // expected is 5 as minimum fare is five
  }

  /*
  test to calculate fare for multiple rides
     */
  @Test
  public void givenMultipleRides_ShouldReturnInvoiceSummary() {
    Ride[] rides = {new Ride(2.0, 5), new Ride(0.1, 1)};
    InvoiceSummary summary = invoiceService.calculateFare(rides);
    InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
    assertEquals(expectedInvoiceSummary, summary);
  }

  @Test
  public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
    String user1 = "karthik";
    Ride[] rides1 = {new Ride(2.0, 5), new Ride(0.1, 1)};
    invoiceService.addRides(user1,rides1);
    String user2 = "benki";
    Ride[] rides2 = {new Ride(3.0, 5), new Ride(0.1, 1)};
    invoiceService.addRides(user2,rides2);
    InvoiceSummary summary = invoiceService.getInvoiceSummary(user1);
    InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30);
    assertEquals(expectedInvoiceSummary,summary);
  }

  @Test
  public void givenNormalAndPremiumRides_ShouldReturnInvoiceSummary() {
    String user1 = "karthik";
    Ride[] rides1 = {new Ride(RideCategory.PREMIUM,2.0, 5), new Ride(RideCategory.NORMAL,0.1, 1)};
    invoiceService.addRides(user1,rides1);
    String user2 = "benki";
    Ride[] rides2 = {new Ride(RideCategory.PREMIUM,3.0, 5), new Ride(RideCategory.NORMAL,0.1, 1)};
    invoiceService.addRides(user2,rides2);
    InvoiceSummary summary = invoiceService.getInvoiceSummary(user1);
    InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45);
    assertEquals(expectedInvoiceSummary,summary);
  }
}
