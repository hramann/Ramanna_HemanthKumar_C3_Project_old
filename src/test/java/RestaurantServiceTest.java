import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RestaurantServiceTest {

  RestaurantService service = new RestaurantService();
  Restaurant restaurant;

  @BeforeEach
  void init() {
    LocalTime openingTime = LocalTime.parse("10:30:00");
    LocalTime closingTime = LocalTime.parse("22:00:00");
    restaurant = service.addRestaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
    restaurant.addToMenu("Sweet corn soup", 120);
    restaurant.addToMenu("Vegetable lasagne", 280);
  }
  //>>>>>>>>>>>>>>>>>>>>>>SEARCHING<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
  @Test
  void searching_for_existing_restaurant_should_return_expected_restaurant_object()
      throws restaurantNotFoundException {
    Restaurant r = service.findRestaurantByName("Amelie's cafe");
    assertEquals("Amelie's cafe", r.getName());
  }


  @Test
  void searching_for_non_existing_restaurant_should_throw_exception() {
    assertThrows(restaurantNotFoundException.class, () -> service.findRestaurantByName("Swiggy"));
  }
  //<<<<<<<<<<<<<<<<<<<<SEARCHING>>>>>>>>>>>>>>>>>>>>>>>>>>

}
