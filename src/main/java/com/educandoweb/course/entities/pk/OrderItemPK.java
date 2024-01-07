package com.educandoweb.course.entities.pk;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa a chave primária composta para a entidade OrderItem.
 * Esta classe é anotada com @Embeddable para indicar que pode ser incorporada em outra entidade.
 * A chave primária é composta pelas referências para as entidades Order e Product.
 *
 * @author [Seu Nome]
 * @version 1.0
 * @since [Data de Criação]
 */
@Embeddable
public class OrderItemPK implements Serializable {

    /**
     * Identificador de versão serial para garantir a compatibilidade durante a serialização.
     * Este valor deve ser mantido consistente para evitar erros de desserialização.
     */
    private static final long serialVersionUID = 1L;

    /** Entidade Order associada à chave primária. */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    /** Entidade Product associada à chave primária. */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Obtém a entidade Order associada à chave primária.
     *
     * @return A entidade Order.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Define a entidade Order associada à chave primária.
     *
     * @param order A entidade Order a ser associada.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Obtém a entidade Product associada à chave primária.
     *
     * @return A entidade Product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Define a entidade Product associada à chave primária.
     *
     * @param product A entidade Product a ser associada.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Sobrescreve o método equals para comparar objetos OrderItemPK por suas entidades Order e Product.
     *
     * @param o Objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    /**
     * Sobrescreve o método hashCode para gerar um código de hash baseado nas entidades Order e Product.
     *
     * @return O código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
