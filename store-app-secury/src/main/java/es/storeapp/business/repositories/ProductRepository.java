package es.storeapp.business.repositories;

import es.storeapp.business.entities.Product;
import java.text.MessageFormat;
import java.util.List;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends AbstractRepository<Product> {
    
    private static final java.util.Set<String> ALLOWED_SORT_FIELDS =
            java.util.Set.of("price", "name", "productId", "sales");

    @SuppressWarnings("unchecked")
    public List<Product> findByCategory(String category, String orderColumn) {
        if (!ALLOWED_SORT_FIELDS.contains(orderColumn)) {
            throw new IllegalArgumentException("Campo de ordenacion no permitido");
        }
        Query query = entityManager.createQuery(
            "SELECT p FROM Product p WHERE p.category.name = :category ORDER BY p." + orderColumn);
        query.setParameter("category", category);
        return query.getResultList();
    }
}
