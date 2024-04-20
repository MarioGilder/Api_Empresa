package com.codigo.pumaachullagildermario.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empresa")
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "tipo_documento",length = 1)
    private String tipoDocumento;
    @Column(name = "numero_documento",length = 11)
    private String numeroDocumento;
    @Column(name = "condicion",length = 10)
    private String condicion;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "distrito")
    private String distrito;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "es_agente_retencion")
    private Boolean esAgenteRetencion;
    @Column(name = "estado", nullable = false)
    private int estado;
    @Column(name = "usua_crea",length = 50)
    private String usuaCrea;
    @Column(name = "date_create")
    private Timestamp dateCreate;
    @Column(name = "usua_modif",length = 50)
    private String usuaModif;
    @Column(name = "date_modif")
    private Timestamp dateModif;
    @Column(name = "usua_delet",length = 50)
    private String usuaDelet;
    @Column(name = "date_delet")
    private Timestamp dateDelet;


}
