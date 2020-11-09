
package local.topicos.controller.rest;


import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import local.topicos.dao.VendasDAO;
import local.topicos.entities.Vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VendasControllerAPI {


    @Autowired
    VendasDAO vendaDAO;

    // -------------------Retrieve All Vendas---------------------------------------------

    @RequestMapping(value = "/venda", method = RequestMethod.GET)
    public ResponseEntity<List<Vendas>> listAllUsuarios() {
        List<Vendas> vendas = vendaDAO.findAll();
        if (vendas.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    // -------------------Retrieve Single Vendas------------------------------------------

    @RequestMapping(value = "/venda/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getVendas(@PathVariable("id") long id) {

    	Vendas venda = vendaDAO.findById(id).get();
        if (venda == null) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }
    
    

    // -------------------Create a Venda-------------------------------------------

    @RequestMapping(value = "/venda", method = RequestMethod.POST)
    public ResponseEntity<?> createVenda(@RequestBody Vendas venda) {
                
        try {
            String url = "http://localhost:8080/api/clienteCPF/" + venda.getCpfVenda();
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if(conn.getResponseCode() != 200){
             return new ResponseEntity<>("Cliente não encontrado", HttpStatus.NOT_FOUND);
            }
           conn.disconnect();
        } catch (Exception ex) {
           return  new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
        try{
        String url = "http://localhost:8081/api/cartaoPorCpf?cpf=" + venda.getCpfVenda()+"&numero="+ venda.getNumeroCartao();
              
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if(conn.getResponseCode() != 200){
             return new ResponseEntity<>("Cartao não encontrado", HttpStatus.NOT_FOUND);
            }
           conn.disconnect();
        }catch(Exception ex){
            return  new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
       
        vendaDAO.save(venda);
      
       return new ResponseEntity<>(venda, HttpStatus.OK);
        
    }
    

    // ------------------- Update a Venda ------------------------------------------------

    @RequestMapping(value = "/venda/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUsuario(@PathVariable("id") long id, @RequestBody Vendas venda) {

    	Vendas currentVenda = vendaDAO.findById(id).get();

        if (currentVenda == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        vendaDAO.save(currentVenda);
        return new ResponseEntity<>(currentVenda, HttpStatus.OK);
    }

    // ------------------- Delete a Venda-----------------------------------------

    @RequestMapping(value = "/venda/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVenda(@PathVariable("id") long id) {
        Vendas venda = vendaDAO.findById(id).get();
        if (venda == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        vendaDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Vendas-----------------------------

    @RequestMapping(value = "/venda", method = RequestMethod.DELETE)
    public ResponseEntity<Vendas> deleteAllVendas() {
        vendaDAO.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
