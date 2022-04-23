package com.bridgelabz;


import java.util.HashMap;
import java.util.Map;

public class InvoiceService {
  private static final double MINIMUM_COST_PER_KM = 10; // 10RS PER KM
  private static final int COST_PER_TIME = 1; // 1RS PER MINUTE
  private static final double MINIMUM_FARE = 5; // minimum fare is 5
  private Map<String,Ride[]> rideRepository = new HashMap<>();

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

/*
adding rides to into hash map rideRepository as key as userID and value as Ride[]
 */
  public void addRides(String userId, Ride[] rides) {
    rideRepository.put(userId,rides);
  }

  public InvoiceSummary getInvoiceSummary(String userId) {
    Ride[] rides=rideRepository.get(userId);
    return new InvoiceService().calculateFare(rides);
  }
}
