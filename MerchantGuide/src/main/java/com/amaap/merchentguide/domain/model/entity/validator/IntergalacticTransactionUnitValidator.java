package com.amaap.merchentguide.domain.model.entity.validator;

public class IntergalacticTransactionUnitValidator {
    public static boolean isInvalidIntergalacticValue(String intergalacticValue) {
        return intergalacticValue == null || intergalacticValue.isEmpty();
    }

    public static boolean isInvalidRomanValue(String romanValue) {
        return romanValue == null || romanValue.isEmpty();
    }
}
