package com.codigo.pumaachullagildermario.service;
import com.codigo.pumaachullagildermario.entity.EmpresaEntity;
import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    /*Crear*/
    EmpresaEntity crearEmpresa (EmpresaEntity entity);

    /*Buscar por id*/
    Optional<EmpresaEntity> buscarPorId(Long id);
    /*BuscarAll*/
    List<EmpresaEntity> listarTodo();
    /*Actualizar*/
    EmpresaEntity actualizarEmpresa(Long id, EmpresaEntity request);
    /*Eliminar*/
    EmpresaEntity borrarEmpresa(Long id);

}
