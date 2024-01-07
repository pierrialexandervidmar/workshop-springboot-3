package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

/**
 * Classe que representa uma categoria no sistema, contendo informações como identificador e nome.
 * A classe também implementa métodos para acesso, modificação e comparação de objetos Category.
 *
 * @author Pierri Alexander Vidmar
 * @version 1.0
 * @since 2023-01-01
 */
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    /** Identificador de versão serial para garantir a compatibilidade durante a serialização. */
    private static final long serialVersionUID = 1L;

    /** Identificador único da categoria, gerado automaticamente pelo sistema. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nome da categoria. */
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    /** Construtor padrão sem argumentos. */
    public Category() {
    }

    /**
     * Construtor que inicializa os atributos da classe.
     *
     * @param id   Identificador único da categoria.
     * @param name Nome da categoria.
     */
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /** Obtém o identificador único da categoria. */
    public Long getId() {
        return id;
    }

    /** Define o identificador único da categoria. */
    public void setId(Long id) {
        this.id = id;
    }

    /** Obtém o nome da categoria. */
    public String getName() {
        return name;
    }

    /** Define o nome da categoria. */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém a coleção de produtos associados a esta categoria.
     *
     * @return A coleção de produtos associados.
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Sobrescreve o método equals para comparar objetos Category por seus identificadores únicos.
     *
     * @param o Objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    /**
     * Sobrescreve o método hashCode para gerar um código de hash baseado no identificador único da categoria.
     *
     * @return O código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}