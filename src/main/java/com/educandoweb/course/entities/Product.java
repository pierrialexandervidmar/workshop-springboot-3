package com.educandoweb.course.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

/**
 * Classe que representa um produto no sistema, contendo informações como identificador, nome, descrição,
 * preço, URL da imagem e categorias associadas.
 * A classe implementa métodos para acesso, modificação e comparação de objetos Product.
 *
 * @author Pierri Alexander Vidmar
 * @version 1.0
 * @since 2023-01-01
 */
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    /** Identificador de versão serial para garantir a compatibilidade durante a serialização. */
    private static final long serialVersionUID = 1L;

    /** Identificador único do produto, gerado automaticamente pelo sistema. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nome do produto. */
    private String name;

    /** Descrição do produto. */
    private String description;

    /** Preço do produto. */
    private Double price;

    /** URL da imagem do produto. */
    private String imgUrl;

    /**
     * Produtos associados ao pedido.
     * Busca a partir do Id informado na tabela Order Item, e busca na tabela OrderItemPK os produtos do pedido.
     */
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    /** Conjunto de categorias associadas ao produto. */
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    /** Construtor padrão sem argumentos. */
    public Product() {
    }

    /**
     * Construtor que inicializa os atributos da classe.
     *
     * @param id          Identificador único do produto.
     * @param name        Nome do produto.
     * @param description Descrição do produto.
     * @param price       Preço do produto.
     * @param imgUrl      URL da imagem do produto.
     */
    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    /** Obtém o identificador único do produto. */
    public Long getId() {
        return id;
    }

    /** Define o identificador único do produto. */
    public void setId(Long id) {
        this.id = id;
    }

    /** Obtém o nome do produto. */
    public String getName() {
        return name;
    }

    /** Define o nome do produto. */
    public void setName(String name) {
        this.name = name;
    }

    /** Obtém a descrição do produto. */
    public String getDescription() {
        return description;
    }

    /** Define a descrição do produto. */
    public void setDescription(String description) {
        this.description = description;
    }

    /** Obtém o preço do produto. */
    public Double getPrice() {
        return price;
    }

    /** Define o preço do produto. */
    public void setPrice(Double price) {
        this.price = price;
    }

    /** Obtém a URL da imagem do produto. */
    public String getImgUrl() {
        return imgUrl;
    }

    /** Define a URL da imagem do produto. */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> set = new HashSet<>();
        for (OrderItem x : items) {
            set.add(x.getOrder());
        }
        return set;
    }

    /** Obtém o conjunto de categorias associadas ao produto. */
    public Set<Category> getCategories() {
        return categories;
    }

    /**
     * Sobrescreve o método equals para comparar objetos Product por seus identificadores únicos.
     *
     * @param o Objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    /**
     * Sobrescreve o método hashCode para gerar um código de hash baseado no identificador único do produto.
     *
     * @return O código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
