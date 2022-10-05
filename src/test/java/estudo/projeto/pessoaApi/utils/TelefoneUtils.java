package estudo.projeto.pessoaApi.utils;

import estudo.projeto.pessoaApi.controller.dto.request.TelefoneDTO;
import estudo.projeto.pessoaApi.enums.TelefoneTipo;
import estudo.projeto.pessoaApi.model.Telefone;

public class TelefoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final TelefoneTipo PHONE_TYPE = TelefoneTipo.MOBILE;
    private static final long PHONE_ID = 1L;

    public static Telefone createFakeDTO() {
        return Telefone.builder()
                .number(PHONE_NUMBER)
                .tipo(PHONE_TYPE)
                .build();
    }

    public static Telefone createFakeEntity() {
        return Telefone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .tipo(PHONE_TYPE)
                .build();
    }
}
