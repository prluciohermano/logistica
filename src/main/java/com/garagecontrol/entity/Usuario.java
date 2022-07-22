package com.garagecontrol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    
    @Column(name = "username", length = 20)
    @NotBlank
    private String login;
    
    @Column(name = "password", length = 180)
    @NotBlank
    private String senha;
    
    @Column
    @NotBlank
    private boolean admin;
    
    @ManyToOne()
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
    
}
