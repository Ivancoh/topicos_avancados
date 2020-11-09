
package local.topicos.dao;

import local.topicos.entities.Vendas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;



@Repository
public interface VendasDAO extends JpaRepository<Vendas, Long> {
    
    boolean existsById(Vendas venda);
    
    @Query("SELECT v FROM Vendas v where  v.dataCompra = :compra GROUP BY v.dataCompra")
    public Vendas encontrarVendasMes(@Param("compra") String dataCompra);
    
}
