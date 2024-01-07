package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * Entidade JPA que representa informações de pagamento.
 * Mapeada para a tabela "tb_payment".
 * @author Pierri Alexander Vidmar
 * @version 1.0
 * @since 2023-01-01
 */
@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único do pagamento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Momento em que o pagamento foi realizado, representado como um Instant.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    /**
     * Pedido associado a este pagamento. Relacionamento One-to-One com a entidade Order.
     */
    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    /**
     * Construtor padrão sem argumentos.
     */
    public Payment() {
    }

    /**
     * Construtor que inicializa os atributos da classe.
     *
     * @param id      Identificador único do pagamento.
     * @param moment  Momento em que o pagamento foi realizado.
     * @param order   Pedido associado a este pagamento.
     */
    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    /**
     * Obtém o identificador único do pagamento.
     *
     * @return Identificador único do pagamento.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do pagamento.
     *
     * @param id Identificador único do pagamento.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o momento em que o pagamento foi realizado.
     *
     * @return Momento em que o pagamento foi realizado.
     */
    public Instant getMoment() {
        return moment;
    }

    /**
     * Define o momento em que o pagamento foi realizado.
     *
     * @param moment Momento em que o pagamento foi realizado.
     */
    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    /**
     * Obtém o pedido associado a este pagamento.
     *
     * @return Pedido associado a este pagamento.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Define o pedido associado a este pagamento.
     *
     * @param order Pedido associado a este pagamento.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Sobrescreve o método equals para comparar pagamentos com base no identificador.
     *
     * @param o Objeto a ser comparado.
     * @return true se os pagamentos tiverem o mesmo identificador, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    /**
     * Sobrescreve o método hashCode para gerar um código de hash com base no identificador.
     *
     * @return Código de hash gerado com base no identificador.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}