package fdmgroup.OrderWebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRecipeRepository extends JpaRepository<OrderRecipeRepository, Integer>{

}
