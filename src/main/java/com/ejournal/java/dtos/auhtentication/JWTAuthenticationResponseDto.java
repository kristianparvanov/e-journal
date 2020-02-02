package com.ejournal.java.dtos.auhtentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
@AllArgsConstructor
@Getter
@Setter
public class JWTAuthenticationResponseDto {

    private static final String TOKEN_TYPE = "Bearer";

    private String accessToken;

    public static String getTokenType() {
        return TOKEN_TYPE;
    }
}
