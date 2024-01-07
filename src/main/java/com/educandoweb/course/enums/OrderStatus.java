package com.educandoweb.course.enums;

/**
 * Enumeração que representa os possíveis estados de um pedido.
 * Cada valor define uma etapa específica no ciclo de vida de um pedido.
 */
public enum OrderStatus {
    /** Estado indicando que o pagamento do pedido está aguardando confirmação. */
    WAITING_PAYMENT(1),

    /** Estado indicando que o pagamento do pedido foi realizado com sucesso. */
    PAID(2),

    /** Estado indicando que o pedido foi despachado para envio. */
    SHIPPED(3),

    /** Estado indicando que o pedido foi entregue ao destinatário com sucesso. */
    DELIVERED(4),

    /** Estado indicando que o pedido foi cancelado antes da entrega. */
    CANCELED(5);

    private int code;

    /**
     * Construtor privado utilizado pela enumeração {@code OrderStatus} para inicializar um estado de pedido com o código fornecido.
     *
     * @param code O código associado ao estado de pedido.
     */
    private OrderStatus(int code) {
        this.code = code;
    }

    /**
     * Obtém o código associado ao estado de pedido.
     *
     * @return O código do estado de pedido.
     */
    public int getCode() {
        return code;
    }

    /**
     * Obtém o estado de pedido associado ao código especificado.
     *
     * @param code O código a ser procurado.
     * @return O estado de pedido correspondente ao código.
     * @throws IllegalArgumentException Se nenhum estado de pedido for encontrado com o código fornecido.
     */
    public static OrderStatus valueOf(int code) {
        for(OrderStatus value : OrderStatus.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus Code");
    }
}
