import org.junit.Test;
import org.senai.Weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestWeather {

    @Test
    public void when_summer() {
        Weather weather = new Weather();
        int result = weather.checkWeather(1);
        assertEquals(5, result);
    }

    @Test
    public void when_summer_nok() {
        Weather weather = new Weather();
        assertThrows(IllegalArgumentException.class, () -> {
            weather.checkWeather(5);
        });
    }
}
