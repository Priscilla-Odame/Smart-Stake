package smartstake.registration;


import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import smartstake.registration.token.ConfirmationToken;
import smartstake.registration.token.ConfirmationTokenService;
import smartstake.user.AppUser;
import smartstake.user.UserService;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private  final RegistrationService registrationService;
    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
