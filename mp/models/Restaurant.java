package edu.illinois.cs.cs124.ay2021.mp.models;

import androidx.annotation.NonNull;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Model storing information about a restaurant retrieved from the restaurant server.
 *
 * You will need to understand some of the code in this file and make changes starting with MP1.
 *
 * If your project builds successfully, you can safely ignore the warning about "Related problems" here.
 * It seems to be a bug in Android studio.
 */
@SuppressWarnings("unused")
public final class Restaurant implements SortedListAdapter.ViewModel {
  // Name of the restaurant
  private String name;

  // Name of the cuisine
  private String cuisine;

  // Name of the id
  private String id;

  // Name of the url
  private String url;

  // Getter for the name
  public String getName() {
    return name;
  }

  // Getter for the cuisine
  public String getCuisine() {
    return cuisine;
  }
  // Getter for the id
  public String getId() {
    return id;
  }

  // Getter for the url
  public String geturl() {
    return url;
  }

  // You will need to add more fields here...

  public static List<Restaurant> search(final List<Restaurant> restaurants, final String search) {
    if (search == null || restaurants == null) {
      throw new IllegalArgumentException();
    }
    if (search.trim().length() == 0) {
      List<Restaurant> nospace = new ArrayList<>();
      nospace.addAll(restaurants);
      return nospace;
    }
    String lowerCase = search.trim().toLowerCase();
    List<Restaurant> restaurant = new ArrayList<>();

    for (Restaurant single : restaurants) {
      if (single.getCuisine().trim().toLowerCase().equals(lowerCase)) {
        restaurant.add(single);
      }
    }
    if (restaurant.size() == 0) {
      for (Restaurant single : restaurants) {
        if (single.getName().trim().toLowerCase().contains(lowerCase)
            || single.getCuisine().trim().toLowerCase().contains(lowerCase)) {
          restaurant.add(single);
        }
      }
    }
    return restaurant;
  }

  /*
   * The Jackson JSON serialization library we are using requires an empty constructor.
   * So don't remove this!
   */
  public Restaurant() {}

  /*
   * Function to compare Restaurant instances by name.
   * Currently this does not work, but you will need to implement it correctly for MP1.
   * Comparator is like Comparable, except it defines one possible ordering, not a canonical ordering for a class,
   * and so is implemented as a separate method rather than directly by the class as is done with Comparable.
   */
  public static final Comparator<Restaurant> SORT_BY_NAME =
      ((Restaurant restaurant1, Restaurant restaurant2) -> {
        String r1 = restaurant1.getName();
        String r2 = restaurant2.getName();
        int small = Math.min(r1.length(), r2.length());
        for (int i = 0; i < small; i++) {
          if (r1.charAt(i) != r2.charAt(i)) {
            return r1.charAt(i) - r2.charAt(i);
          }
        }
        if (r1.length() != r2.length()) {
          return r1.length() - r2.length();
        } else {
          return 0;
        }
      });

  // You should not need to modify this code, which is used by the list adapter component
  @Override
  public <T> boolean isSameModelAs(@NonNull final T model) {
    return equals(model);
  }

  // You should not need to modify this code, which is used by the list adapter component
  @Override
  public <T> boolean isContentTheSameAs(@NonNull final T model) {
    return equals(model);
  }
}
