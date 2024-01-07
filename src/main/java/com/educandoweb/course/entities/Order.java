package com.educandoweb.course.entities;

import com.educandoweb.course.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe que representa um pedido no sistema, contendo informações como identificador, momento de realização,
 * estado do pedido, e o cliente associado a ele.
 * A classe também implementa métodos para acesso, modificação e comparação de objetos Order.
 * @author Pierri Alexander Vidmar
 * @version 1.0
 * @since 2023-01-01
 */
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    /**
     * Identificador de versão serial para garantir a compatibilidade durante a serialização.
     * Este valor deve ser mantido consistente para evitar erros de desserialização.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único do objeto. É gerado automaticamente pelo sistema ao persistir o objeto no banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Instante de tempo representando o momento em que ocorreu a ação associada a este objeto.
     * Utilizado para registrar a data e hora exata de eventos relacionados ao objeto.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    /**
     * Estado atual do pedido associado a este objeto.
     * Pode representar diferentes etapas ou condições do ciclo de vida do pedido.
     */
    private Integer orderStatus;

    /**
     * Usuário associado a este objeto, representando o cliente relacionado ao pedido.
     * Este atributo estabelece uma relação muitos-para-um com a entidade User, usando a chave estrangeira "client_id".
     */
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    /**
     * Items associados ao pedido.
     * Busca a partir do Id informado na tabela Order Item, e busca na tabela OrderItemPK os items do pedido.
     */
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    /**
     * Construtor padrão sem argumentos.
     */
    public Order() {
    }

    /**
     * Construtor que inicializa os atributos da classe.
     *
     * @param id     O identificador único do pedido.
     * @param moment O momento em que o pedido foi realizado (Instant).
     * @param client O cliente associado a este pedido (objeto User).
     */
    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    /**
     * Obtém o identificador único do pedido.
     *
     * @return O identificador único do pedido.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do pedido.
     *
     * @param id O identificador único do pedido.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o momento em que o pedido foi realizado.
     *
     * @return O momento em que o pedido foi realizado (Instant).
     */
    public Instant getMoment() {
        return moment;
    }

    /**
     * Define o momento em que o pedido foi realizado.
     *
     * @param moment O momento em que o pedido foi realizado (Instant).
     */
    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    /**
     * Obtém o cliente associado a este pedido.
     *
     * @return O cliente associado a este pedido (objeto User).
     */
    public User getClient() {
        return client;
    }

    /**
     * Define o cliente associado a este pedido.
     *
     * @param client O cliente associado a este pedido (objeto User).
     */
    public void setClient(User client) {
        this.client = client;
    }

    /**
     * Obtém o status do pedido.
     *
     * @return O status atual do pedido.
     */
    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    /**
     * Define o status do pedido.
     *
     * @param orderStatus O novo status a ser atribuído ao pedido.
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    /**
     * Obtém os itens associados a este pedido.
     *
     * @return Os itens associados a este pedido.
     */
    public Set<OrderItem> getItems() {
        return items;
    }

    /**
     * Obtém o pagamento associado a este pedido.
     *
     * @return O pagamento associado a este pedido.
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Define o pagamento associado a este pedido.
     *
     * @param payment O pagamento a ser associado a este pedido.
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * Calcula e retorna o valor total do pedido, somando os subtotais de todos os itens.
     *
     * @return O valor total do pedido.
     */
    public Double getTotal() {
        double sum = 0.0;
        for (OrderItem x : items) {
            sum += x.getSubTotal();
        }
        return sum;
    }

    /**
     * Sobrescreve o método equals para comparar objetos Order por seus identificadores únicos.
     *
     * @param o O objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    /**
     * Sobrescreve o método hashCode para gerar um código de hash baseado no identificador único do pedido.
     *
     * @return O código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}