package com.core.federix.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findByUsuarioLogueo", query = "SELECT u FROM Usuario u WHERE u.usuarioLogueo = :usuarioLogueo")
})
public class Usuario  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Basic(optional = false)
    @Column(name = "nombre_y_apellido")
    private String nombreYApellido;

    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;

    @Basic(optional = false)
    @Column(name = "usuario_logueo")
    private String usuarioLogueo;

    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    @Basic(optional = false)
    @Column(name = "cant_intento_fallido")
    private int cantIntentoFallido;

    @Basic(optional = false)
    @Column(name = "pass_vigente")
    private String passVigente;

    @Basic(optional = false)
    @Column(name = "fecha_ult_act_pass")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltActPass;

    @Basic(optional = false)
    @Column(name = "token_cambio_pass")
    private String tokenCambioPass;

    @Basic(optional = false)
    @Column(name = "activo")
    private Boolean activo;

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
