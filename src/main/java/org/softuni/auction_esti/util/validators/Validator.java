package org.softuni.auction_esti.util.validators;

public interface Validator {
    <M> boolean isValid(M model);
}
