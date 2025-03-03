import org.junit.Test;
import org.senai.Weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestWeather {

    @Test
    public void when_summer() {
        Weather weather = new Weather();
        int result = weather.checkWeather(1);
        assertEquals(1, result);
    }

    @Test
    public void when_autumn() {
        Weather weather = new Weather();
        int result = weather.checkWeather(2);
        assertEquals(2, result);
    }


    @Test
    public void when_spring() {
        Weather weather = new Weather();
        int result = weather.checkWeather(3);
        assertEquals(3, result);
    }

    @Test
    public void when_winter() {
        Weather weather = new Weather();
        int result = weather.checkWeather(4);
        assertEquals(4, result);
    }

    @Test
    public void when_default_negative_number_nok() {
        Weather weather = new Weather();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            weather.checkWeather(-1);
        });
        assertEquals("404 Not found!", exception.getMessage());
    }

    @Test
    public void when_default_greater_than_four_nok() {
        Weather weather = new Weather();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            weather.checkWeather(5);
        });

        assertEquals("404 Not found!", exception.getMessage());
    }
}
