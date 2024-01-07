package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para a entidade OrderItem.
 * Esta interface estende JpaRepository, fornecendo métodos prontos para operações
 * de persistência relacionadas à entidade OrderItem, como salvar, buscar e excluir.
 *
 * @param <OrderItem> Tipo da entidade gerenciada pelo repositório.
 * @param <Long> Tipo da chave primária da entidade.
 *
 * @see JpaRepository
 * @author Pierri Alexander Vidmar
 * @version 1.0
 * @since 2023-01-01
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}