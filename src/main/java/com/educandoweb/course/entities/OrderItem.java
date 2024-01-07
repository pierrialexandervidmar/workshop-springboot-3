package com.educandoweb.course.entities;

import com.educandoweb.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa um item de pedido no sistema, contendo informações como identificador composto,
 * quantidade, preço unitário e métodos para cálculos relacionados.
 * A classe implementa métodos para acesso, modificação e comparação de objetos OrderItem.
 * @author Pierri Alexander Vidmar
 * @version 1.0
 * @since 2023-01-01
 */
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    /**
     * Identificador de versão serial para garantir a compatibilidade durante a serialização.
     * Este valor deve ser mantido consistente para evitar erros de desserialização.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador composto para o objeto OrderItem, representando a chave primária na tabela associada.
     */
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    /**
     * Quantidade de produtos associados a este item de pedido.
     */
    private Integer quantity;

    /**
     * Preço unitário do produto associado a este item de pedido.
     */
    private Double price;

    /**
     * Construtor padrão sem argumentos.
     */
    public OrderItem() {
    }

    /**
     * Construtor que inicializa os atributos da classe.
     *
     * @param order    Pedido associado a este item.
     * @param product  Produto associado a este item.
     * @param quantity Quantidade de produtos.
     * @param price    Preço unitário do produto.
     */
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Obtém o pedido associado a este item.
     *
     * @return O pedido associado a este item.
     */
    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    /**
     * Define o pedido associado a este item.
     *
     * @param order O pedido a ser associado a este item.
     */
    public void setOrder(Order order) {
        id.setOrder(order);
    }

    /**
     * Obtém o produto associado a este item.
     *
     * @return O produto associado a este item.
     */
    public Product getProduct() {
        return id.getProduct();
    }

    /**
     * Define o produto associado a este item.
     *
     * @param product O produto a ser associado a este item.
     */
    public void setProduct(Product product) {
        id.setProduct(product);
    }

    /**
     * Obtém a quantidade de produtos associados a este item.
     *
     * @return A quantidade de produtos.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Define a quantidade de produtos associados a este item.
     *
     * @param quantity A nova quantidade de produtos.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Obtém o preço unitário do produto associado a este item.
     *
     * @return O preço unitário do produto.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Define o preço unitário do produto associado a este item.
     *
     * @param price O novo preço unitário do produto.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Calcula e retorna o subtotal do item, multiplicando a quantidade pelo preço unitário.
     *
     * @return O subtotal do item.
     */
    public Double getSubTotal() {
        return price * quantity;
    }

    /**
     * Sobrescreve o método equals para comparar objetos OrderItem por seus identificadores únicos.
     *
     * @param o O objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    /**
     * Sobrescreve o método hashCode para gerar um código de hash baseado no identificador único do item de pedido.
     *
     * @return O código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}