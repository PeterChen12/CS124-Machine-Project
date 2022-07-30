package edu.illinois.cs.cs124.ay2021.mp.models;

// Create a preference model
public class Preference {
  private String id;

  public String getId() {
    return id;
  }

  private String[] restaurantIDs;

  public String[] getRestaurantIDs() {
    return restaurantIDs;
  }

  public Preference() {}
}
