package com.adsware.constant;

import lombok.NoArgsConstructor;

/**
 * The interface CredentialsRepository.
 *
 * @author AdsWare System
 */
@NoArgsConstructor
public final class Constants {

    /**
     * The REGISTRY_FAILED constant.
     */
    public static final String REGISTRY_FAILED =
            "Error al persistir el registro en base de datos: {}";

    /**
     * The REGISTRY_FAILED constant.
     */
    public static final String REGISTRY_NOT_FOUND =
            "Error al encontrar el registro en base de datos: {}";

    /**
     * The EMPTY_STRING constant.
     */
    public static final String EMPTY_STRING = "";

    /**
     * The ERR_TIME_PATTERN constant.
     */
    public static final String ERR_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";

    /**
     * The ERROR_RESPONSE_TYPE constant.
     */
    public static final String ERROR_RESPONSE_TYPE = "errorResponse.type, {}";

    /**
     * The ERROR_RESPONSE_CODE constant.
     */
    public static final String ERROR_RESPONSE_CODE = "errorResponse.code, {}";

    /**
     * The ERROR_RESPONSE_DETAILS constant.
     */
    public static final String ERROR_RESPONSE_DETAILS = "errorResponse.details, {}";

    /**
     * The ERROR_RESPONSE_LOCATION constant.
     */
    public static final String ERROR_RESPONSE_LOCATION = "errorResponse.location, {}";

    /**
     * The ERROR_RESPONSE_MORE_INFO constant.
     */
    public static final String ERROR_RESPONSE_MORE_INFO = "errorResponse.moreinfo, {}";

    /**
     * The ERROR_CODE_BAD_REQUEST constant.
     */
    public static final String ERROR_CODE_BAD_REQUEST = "400";

    /**
     * The ERROR_CODE_UNAUTHORIZED constant.
     */
    public static final String ERROR_CODE_UNAUTHORIZED = "401";

    /**
     * The ERROR_CODE_INTERNAL_SERVER_ERROR constant.
     */
    public static final String ERROR_CODE_INTERNAL_SERVER_ERROR = "500";

    /**
     * The SEMICOLON constant.
     */
    public static final String SEMICOLON = "; ";

    /**
     * The TWO_POINTS constant.
     */
    public static final String TWO_POINTS = " : ";

    /**
     * The VIOLATIONS_CONSTRAINT constant.
     */
    public static final String VIOLATIONS_CONSTRAINT = "violations";

    /**
     * The ISERROR_CONSTRAINT constant.
     */
    public static final String ISERROR_CONSTRAINT = "isError";

    /**
     * The ERROR_CONSTRAINT constant.
     */
    public static final String ERROR_CONSTRAINT = "Error en las restricciones del modelo: {}";

    /**
     * The ERROR_CONSTRAINT_EXCEPTION constant.
     */
    public static final String ERROR_CONSTRAINT_EXCEPTION = "Error en las restricciones del modelo";

    /**
     * The ROOM_NOT_EXISTS constant.
     */
    public static final String ROOM_NOT_EXISTS = "No existe la habitacion indicada: {}";

    /**
     * The PATH_CATEGORIES constant.
     */
    public static final String PATH_RATES = "/rates";

}
