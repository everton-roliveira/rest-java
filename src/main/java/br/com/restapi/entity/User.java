package br.com.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "TB_USR", schema = "DB_TESTE")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @NotBlank(message = "Campo ")
    @Column(name = "name")
    private String Name;

    @Column(name = "gender")
    private Character Gender;

    @Column(name = "email")
    private String Email;

    @Column(name = "password")
    private String Password;

    @Column(name = "active")
    private Boolean IsActive;

    /**
     * @return the id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        Id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return the gender
     */
    public Character getGender() {
        return Gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Character gender) {
        Gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        Email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        Password = password;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return IsActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        IsActive = isActive;
    }
}