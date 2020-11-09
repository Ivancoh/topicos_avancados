package local.topicos.entities;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Validated
public class Vendas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeroCartao;
    private String cpfVenda;
    private String	valorProduto;
    private String descricaoProduto;
    private String dataCompra;

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getCpfVenda() {
		return cpfVenda;
	}
	public void setCpfVenda(String cpfVenda) {
		this.cpfVenda = cpfVenda;
	}
	public String getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(String valorProduto) {
		this.valorProduto = valorProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
	
	public Vendas(Long id, String numeroCartao, String cpfVenda, String valorProduto, String descricaoProduto,
			String dataCompra) {
		super();
		this.id = id;
		this.numeroCartao = numeroCartao;
		this.cpfVenda = cpfVenda;
		this.valorProduto = valorProduto;
		this.descricaoProduto = descricaoProduto;
		this.dataCompra = dataCompra;
	}
	public Vendas() {
		super();
	}
	
 
   
}
