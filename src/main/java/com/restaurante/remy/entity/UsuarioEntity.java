package com.restaurante.remy.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Builder
@Data
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {


    @Id
    @Column(name = "idUsuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "telefono", length = 45)
    private String telefono;

    @Column(name = "apellido1", nullable = false, length = 45)
    private String apellido1;

    @Column(name = "apellido2", length = 45)
    private String apellido2;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "nick", nullable = false, length = 45)
    private String nick;

    @Column(name = "clave", nullable = false, length = 45)
    private String clave;

    @Column(name = "tipo", nullable = false, length = 45)
    private String tipo;

    @Column(name = "fecha_creacion", nullable = false)
    @CreationTimestamp
    private Instant fechaCreacion;

    @Column(name = "fecha_modificacion")
    @UpdateTimestamp
    private Instant fechaModificacion;

    @Column(name = "usuario_crecion", length = 45)
    private String usuarioCrecion;

    @Column(name = "usuario_modificacion", length = 45)
    private String usuarioModificacion;

    @Column(name = "activo", nullable = false, length = 1)
    private String activo;

}