package lithan.abc.cars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lithan.abc.cars.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

        @Query(value = "SELECT * FROM tb_car "
                + "WHERE make ILIKE CONCAT('%', :keyword, '%') "
                + "OR model ILIKE CONCAT('%', :keyword, '%') "
                + "OR CAST(year AS TEXT) ILIKE CONCAT('%', :keyword, '%')", nativeQuery = true)
        List<Car> searchCar(@Param("keyword") String keyword);

        @Query(value = "SELECT * FROM tb_car "
                + "WHERE price >= :low AND price <= :high", nativeQuery = true)
        List<Car> searchCarByPriceRange(@Param("low") int low, @Param("high") int high);

        @Query(value = "SELECT * FROM tb_car "
                + "WHERE (make ILIKE CONCAT('%', :keyword, '%') "
                + "OR model ILIKE CONCAT('%', :keyword, '%') "
                + "OR CAST(year AS TEXT) ILIKE CONCAT('%', :keyword, '%')) "
                + "AND price >= :low AND price <= :high", nativeQuery = true)
        List<Car> searchCarByKeywordAndPriceRange(@Param("keyword") String keyword, @Param("low") int low,
                                                  @Param("high") int high);

        @Query(value = "SELECT * FROM tb_car WHERE status = 'ACTIVE' ORDER BY RANDOM() LIMIT 3", nativeQuery = true)
        List<Car> featuredCars();
}
