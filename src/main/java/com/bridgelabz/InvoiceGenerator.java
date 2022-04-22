package com.bridgelabz;

public class InvoiceGenerator {
  private static final double MINIMUM_COST_PER_KM = 10; // 10RS PER KM
  private static final int COST_PER_TIME = 1; // 1RS PER MINUTE
  private static final double MINIMUM_FARE = 5; // minimum fare is 5

  /*
  method to calculate total fare
   */
  public double calculateFare(double distance, int time) {
    double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
    if (totalFare < MINIMUM_FARE) {
      return MINIMUM_FARE;
    }
    return totalFare;
  }
}
