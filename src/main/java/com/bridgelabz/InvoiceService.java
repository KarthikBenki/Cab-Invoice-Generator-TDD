package com.bridgelabz;

public class InvoiceService {
  private static final double MINIMUM_COST_PER_KM = 10; // 10RS PER KM
  private static final int COST_PER_TIME = 1; // 1RS PER MINUTE
  private static final double MINIMUM_FARE = 5; // minimum fare is 5

  /*
  method to calculate total fare
   */
  public double calculateFare(double distance, int time) {
    double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
    return Math.max(totalFare, MINIMUM_FARE);
  }

  public InvoiceSummary calculateFare(Ride[] rides) {
    double totalFare = 0;
    for (Ride ride : rides) {
      totalFare += this.calculateFare(ride.distance, ride.time);
    }
    return new InvoiceSummary(rides.length, totalFare);
  }


}
