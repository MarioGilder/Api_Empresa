package com.codigo.pumaachullagildermario.service.impl;
import com.codigo.pumaachullagildermario.constants.Constans;
import com.codigo.pumaachullagildermario.entity.EmpresaEntity;
import com.codigo.pumaachullagildermario.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.codigo.pumaachullagildermario.service.EmpresaService;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    /*Crear*/
    @Override
    public EmpresaEntity crearEmpresa(EmpresaEntity entity) {
        EmpresaEntity crear=empresaRepository.save(entity);
        crear.setUsuaCrea(Constans.USU_ADMIN);
        crear.setDateCreate(getTimestamp());
        return empresaRepository.save(crear);
    }

    /*Buscar id*/
    @Override
    public Optional<EmpresaEntity> buscarPorId(Long id) {
        return empresaRepository.findById(id);
    }
    /*Listar*/
    @Override
    public List<EmpresaEntity> listarTodo() {
        return empresaRepository.findAll();
    }
    /*Fecha de creacion*/
    private Timestamp getTimestamp() {
        Long currentime = System.currentTimeMillis();
        return new Timestamp(currentime);
    }
    /*Actualizar*/
    @Override
    public EmpresaEntity actualizarEmpresa(Long id, EmpresaEntity request) {
        Optional<EmpresaEntity> recuperarId = empresaRepository.findById(id);
        if (recuperarId.isPresent()) {
            EmpresaEntity empresa = recuperarId.get();
            empresa.setRazonSocial(request.getRazonSocial());
            empresa.setTipoDocumento(request.getTipoDocumento());
            empresa.setNumeroDocumento(request.getNumeroDocumento());
            empresa.setCondicion(request.getCondicion());
            empresa.setDireccion(request.getDireccion());
            empresa.setDistrito(request.getDistrito());
            empresa.setProvincia(request.getProvincia());
            empresa.setDepartamento(request.getDepartamento());
            empresa.setEsAgenteRetencion(request.getEsAgenteRetencion());
            empresa.setEstado(request.getEstado());
            empresa.setUsuaModif(Constans.USU_ADMIN);
            empresa.setDateModif(getTimestamp());
            return empresaRepository.save(empresa);
        }
        return null;
    }
    /*Eliminacion logica*/
    @Override
    public EmpresaEntity borrarEmpresa(Long id) {
        Optional<EmpresaEntity> recuperarId = empresaRepository.findById(id);
        if (recuperarId.isPresent()) {
            EmpresaEntity empresa = recuperarId.get();
            empresa.setEstado(0);
            empresa.setUsuaDelet(Constans.USU_ADMIN);
            empresa.setDateDelet(getTimestamp());
            return empresaRepository.save(empresa);
        }
        return null;
    }



}
