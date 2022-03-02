package demo.spring;

import demo.spring.entity.Car;
import demo.spring.entity.CarProperties;
import demo.spring.service.CarService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * car 自动配置类
 *
 * @author junqiu
 */
@Configuration
@ConditionalOnClass(CarService.class)
@EnableConfigurationProperties(value = CarProperties.class)
public class CarAutoConfiguration {

    private final CarProperties carProperties;

    public CarAutoConfiguration(CarProperties carProperties) {
        this.carProperties = carProperties;
    }

    @Bean
    public CarService carService() {
        CarService carService = new CarService();
        Car car = new Car();
        car.name = carProperties.getName();
        car.color = carProperties.getColor();
        carService.setCar(car);
        return carService;
    }

}
