package com.progettomedusa.campaign_service.model.exception;

import com.progettomedusa.campaign_service.model.response.RestResponse;
import lombok.*;
import com.progettomedusa.campaign_service.model.response.Error;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommonErrorResponse extends RestResponse {
    private Error error;
}
