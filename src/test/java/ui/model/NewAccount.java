package ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class NewAccount {

    private String emailToSignUp;
    private String passwordToSignUp;
    private String confirmPasswordToSignUp;
}
