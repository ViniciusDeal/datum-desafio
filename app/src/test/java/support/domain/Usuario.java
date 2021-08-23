package support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {

    @Builder.Default
    private String name = "usuario_teste";
    @Builder.Default
    private String job = "qa";
}
