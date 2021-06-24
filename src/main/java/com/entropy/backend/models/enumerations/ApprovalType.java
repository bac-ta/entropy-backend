package com.entropy.backend.models.enumerations;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.exceptions.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

public enum ApprovalType {
    REJECT(0, "REJECT"),
    ACCEPTED(1, "ACCEPTED"),
    WAITING(2, "WAITING");
    @Getter
    private final int value;
    @Getter
    private final String name;

    ApprovalType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static ApprovalType findByValue(int value) {
        return Arrays.stream(ApprovalType.values())
                .filter(approveType -> approveType.getValue() == value)
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.APPROVE_TYPE_INVALID));
    }
}
