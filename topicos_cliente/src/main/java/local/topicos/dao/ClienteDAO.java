/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.topicos.dao;

import local.topicos.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {

    Cliente findByNome(String nome);

    Cliente findByCpf(String cpf);

    boolean existsById(Cliente Usuario);
    
    @Query("SELECT p FROM Cliente p WHERE p.cpf = :cpf")
    public Cliente encontrarClienteCpf(@Param("cpf") String cpf);
}
