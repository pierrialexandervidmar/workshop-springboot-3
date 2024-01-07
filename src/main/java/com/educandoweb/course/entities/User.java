package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Representa uma entidade de usuário.
 * <p>
 * Esta classe é utilizada para representar informações sobre um usuário,
 * incluindo identificação, nome, email, telefone e senha.
 * Implementa a interface Serializable para suportar serialização.
 *
 * @author Pierri Alexander Vidmar
 * @version 1.0
 * @since 2023-01-01
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    /**
     * Associação com Pedidos, atributo onde um Cliente pode ter vários pedidos.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    /**
     * Construtor padrão sem argumentos.
     */
    public User() {
    }

    /**
     * Construtor com argumentos para inicializar todos os campos da entidade.
     *
     * @param id       Identificação única do usuário.
     * @param name     Nome do usuário.
     * @param email    Endereço de email do usuário.
     * @param phone    Número de telefone do usuário.
     * @param password Senha do usuário.
     */
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    /**
     * Obtém a identificação única do usuário.
     *
     * @return A identificação única do usuário.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define a identificação única do usuário.
     *
     * @param id A identificação única do usuário.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do usuário.
     *
     * @return O nome do usuário.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do usuário.
     *
     * @param name O nome do usuário.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o endereço de email do usuário.
     *
     * @return O endereço de email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de email do usuário.
     *
     * @param email O endereço de email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o número de telefone do usuário.
     *
     * @return O número de telefone do usuário.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Define o número de telefone do usuário.
     *
     * @param phone O número de telefone do usuário.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return A senha do usuário.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha do usuário.
     *
     * @param password A senha do usuário.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retorna a lista de pedidos associada a esta instância.
     *
     * @return Uma lista contendo objetos do tipo {@code Order} representando os pedidos.
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Sobrescreve o método equals para comparar objetos User por sua identificação única.
     *
     * @param o Objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    /**
     * Sobrescreve o método hashCode para gerar um código hash baseado na identificação única.
     *
     * @return O código hash gerado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}