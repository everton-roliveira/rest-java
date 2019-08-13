package br.com.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "TB_USR")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Campo 'Nome' é obrigatório")
    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private Character gender;

    @NotBlank(message = "Campo 'Email' é obrigatório")
    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private Boolean isActive;
    
    public User() {}
    
    public User(Long id, String name, Character gender, String email, Boolean isActive) {
    	this.id = id;
    	this.name = name;
    	this.gender = gender;
    	this.email = email;
    	this.isActive = isActive;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public Character getGender() {
        return this.gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Character gender) {
        this.gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return this.isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}