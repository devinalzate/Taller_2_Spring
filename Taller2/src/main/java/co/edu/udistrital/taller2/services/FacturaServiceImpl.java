package co.edu.udistrital.taller2.services;

import co.edu.udistrital.taller2.Models.FacturaModel;
import co.edu.udistrital.taller2.dtos.FacturaDTO;
import co.edu.udistrital.taller2.dtos.PagoDTO;
import co.edu.udistrital.taller2.dtos.ReservaDTO;
import co.edu.udistrital.taller2.entitys.FacturaEntity;
import co.edu.udistrital.taller2.entitys.PagoEntity;
import co.edu.udistrital.taller2.entitys.ReservaEntity;
import co.edu.udistrital.taller2.repos.FacturaRepository;
import co.edu.udistrital.taller2.repos.PagoRepository;
import co.edu.udistrital.taller2.repos.ReservaRepository;
import co.edu.udistrital.taller2.utils.FacturaMapper;
import co.edu.udistrital.taller2.utils.PagoMapper;
import co.edu.udistrital.taller2.utils.ReservaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//
@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements BaseService<FacturaEntity, FacturaModel, FacturaDTO> {

    private final FacturaRepository facturaRepository;
    private final ReservaRepository reservaRepository;
    private final PagoRepository pagoRepository;
    private final ReservaMapper reservaMapper;
    private final PagoMapper pagoMapper;

    @Override
    public FacturaEntity save(FacturaModel facturaModel) {
        FacturaEntity facturaEntity = FacturaMapper.toEntityFromModel(facturaModel);
        
        // Asegurar que no se establezca un ID para nuevas facturas
        facturaEntity.setId_factura(null);

        if (facturaModel.getFk_id_reserva() != null) {
            ReservaEntity reserva = reservaRepository.findById(facturaModel.getFk_id_reserva())
                    .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + facturaModel.getFk_id_reserva()));
            facturaEntity.setFk_id_reserva(reserva);
        }
        if (facturaModel.getFk_id_pago() != null) {
            PagoEntity pago = pagoRepository.findById(facturaModel.getFk_id_pago())
                    .orElseThrow(() -> new RuntimeException("Pago no encontrado con ID: " + facturaModel.getFk_id_pago()));
            facturaEntity.setFk_id_pago(pago);
        }

        return facturaRepository.save(facturaEntity);
    }

    public ReservaDTO getFkReservaById(Long id) {
        FacturaEntity facturaEntity = facturaRepository.findById(id).orElse(null);
        ReservaEntity reserva = facturaEntity != null ? facturaEntity.getFk_id_reserva() : null;
        if (reserva != null) {
            return reservaMapper.toDTO(reserva);
        }
        return null;
    }

    public PagoDTO getFkPagoById(Long id) {
        FacturaEntity facturaEntity = facturaRepository.findById(id).orElse(null);
        PagoEntity pago = facturaEntity != null ? facturaEntity.getFk_id_pago() : null;
        if (pago != null) {
            return pagoMapper.toDTO(pago);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        FacturaEntity facturaEntity = facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con ID: " + id));
        facturaRepository.delete(facturaEntity);
    }

    @Override
    public FacturaEntity update(FacturaModel facturaModel) {
        if (facturaModel.getId_factura() == null) {
            throw new RuntimeException("ID de factura es requerido para actualizar");
        }
        
        FacturaEntity existingFactura = facturaRepository.findById(facturaModel.getId_factura())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con ID: " + facturaModel.getId_factura()));
        
        // Actualizar campos básicos
        existingFactura.setFecha_emision(facturaModel.getFecha_emision());
        existingFactura.setValor_total(facturaModel.getValor_total() != null ? facturaModel.getValor_total().longValue() : null);

        // Actualizar relaciones si se proporcionan
        if (facturaModel.getFk_id_reserva() != null) {
            ReservaEntity reserva = reservaRepository.findById(facturaModel.getFk_id_reserva())
                    .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + facturaModel.getFk_id_reserva()));
            existingFactura.setFk_id_reserva(reserva);
        }
        if (facturaModel.getFk_id_pago() != null) {
            PagoEntity pago = pagoRepository.findById(facturaModel.getFk_id_pago())
                    .orElseThrow(() -> new RuntimeException("Pago no encontrado con ID: " + facturaModel.getFk_id_pago()));
            existingFactura.setFk_id_pago(pago);
        }

        return facturaRepository.save(existingFactura);
    }

    @Override
    public FacturaDTO findById(Long id) {
        FacturaEntity facturaEntity = facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con ID: " + id));
        return FacturaMapper.toDTO(facturaEntity);
    }

    @Override
    public List<FacturaDTO> findAll() {
        return facturaRepository.findAll().stream()
                .map(FacturaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
