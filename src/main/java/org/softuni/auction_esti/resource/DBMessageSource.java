package org.softuni.auction_esti.resource;

import org.softuni.auction_esti.domain.entities.Language;
import org.softuni.auction_esti.repository.LanguageRepository;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {

    private static final String LOCAL_CODE_EN = "en";

    private final LanguageRepository languageRepository;

    public DBMessageSource(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    protected MessageFormat resolveCode(String key, Locale locale) {

        Language message = languageRepository.findByMessageKeyAndLocale(key, locale.getLanguage());

        if (message == null) {
            languageRepository.findByMessageKeyAndLocale(key, LOCAL_CODE_EN);
        }

        System.err.println(" ------- > key" + key + " ----- >  locale : " + locale);
        return new MessageFormat(message.getContent(), locale);
    }
}
