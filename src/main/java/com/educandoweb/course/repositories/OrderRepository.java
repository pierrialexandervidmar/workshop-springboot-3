package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para a entidade Order.
 * Esta interface estende JpaRepository, fornecendo métodos prontos para operações
 * de persistência relacionadas à entidade Order, como salvar, buscar e excluir.
 *
 * @param <User> Tipo da entidade gerenciada pelo repositório.
 * @param <Long> Tipo da chave primária da entidade.
 *
 * @see JpaRepository
 * @author Pierri Alexander Vidmar
 * @version 1.0
 * @since 2023-01-01
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}