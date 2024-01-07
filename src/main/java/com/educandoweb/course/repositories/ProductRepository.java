package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para a entidade Product.
 * Esta interface estende JpaRepository, fornecendo métodos prontos para operações
 * de persistência relacionadas à entidade Product, como salvar, buscar e excluir.
 *
 * @param <Product> Tipo da entidade gerenciada pelo repositório.
 * @param <Long> Tipo da chave primária da entidade.
 *
 * @see JpaRepository
 * @author Pierri Alexander Vidmar
 * @version 1.0
 * @since 2023-01-01
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}