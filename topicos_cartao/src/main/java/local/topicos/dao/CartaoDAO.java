
package local.topicos.dao;

import local.topicos.entities.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface CartaoDAO extends JpaRepository<Cartao, Long> {
    
    boolean existsById(Cartao cartao);
    
    @Query("SELECT p FROM Cartao p WHERE cpfCliente = :cpf and numeroCartao = :numero")
    public Cartao encontrarCartaoCpf(@Param("cpf") String cpf , @Param("numero") String numero);
    
}
