package com.adsware.service;

import com.adsware.exceptions.custom.InternalServerErrorException;
import com.adsware.repository.RatesRepository;
import com.adsware.repository.RoomRepository;
import com.adsware.utils.Util;
import com.adsware.validation.BusinessValidation;
import com.adswaresystem.clever.hotelier.clients.entity.Room;
import com.adswaresystem.clever.hotelier.clients.entity.RoomRate;
import com.adswaresystem.clever.hotelier.clients.model.GenericObjectRequest;
import com.adswaresystem.clever.hotelier.clients.model.RoomRateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.adsware.constant.Constants.*;


@Service
@Transactional
public class RatesService {

    private static final Logger log = LoggerFactory.getLogger(RatesService.class);
    /**
     * The repository attribute.
     */
    @Autowired
    private RatesRepository repository;
    /**
     * The room repository attribute.
     */
    @Autowired
    private RoomRepository roomsRepository;
    /**
     * The validations for business attribute.
     */
    @Autowired
    private BusinessValidation businessValidation;

    public Iterable<RoomRate> findAllRates() {
        return repository.findAll();
    }

    public RoomRate registerRate(final RoomRateRequest request) throws InternalServerErrorException {
        // Validar restricciones del modelo
        Util.validateConstraints(request, businessValidation);

        try {
            // Quitar espacios en blancos
            removeBlanks(request);

            return repository.save(
                    createObject(request, roomsRepository.findById(request.getRoomId())
                            .orElseThrow(() -> new InternalServerErrorException(REGISTRY_NOT_FOUND, PATH_RATES))));

        } catch (Exception ex) {
            log.error(REGISTRY_FAILED, ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage(), PATH_RATES);
        }
    }

    public void deleteRate(final GenericObjectRequest request) {
        // Validar restricciones del modelo
        Util.validateConstraints(request, businessValidation);

        repository.delete(repository.findById(request.getElementId())
                .orElseThrow(() -> new InternalServerErrorException(REGISTRY_NOT_FOUND, PATH_RATES)));
    }

    public RoomRate updateRate(final RoomRateRequest request) throws InternalServerErrorException {

        try {
            // Quitar espacios en blancos
            removeBlanks(request);
            final Room room = roomsRepository.findById(request.getRoomId())
                    .orElseThrow(() -> new InternalServerErrorException(REGISTRY_NOT_FOUND, PATH_RATES));

            final RoomRate rate = createObject(request, room);

            repository.save(rate);

            return rate;
        } catch (Exception ex) {
            log.error(REGISTRY_FAILED, ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage(), PATH_RATES);
        }

    }

    private RoomRate createObject(final RoomRateRequest request, final Room found) {
        return RoomRate.builder()
                .rateDescription(request.getRateDescription())
                .rate(request.getRate())
                .roomId(found)
                .build();
    }

    public void removeBlanks(final RoomRateRequest request) {
        request.setRateDescription(request.getRateDescription().trim());
    }

}
