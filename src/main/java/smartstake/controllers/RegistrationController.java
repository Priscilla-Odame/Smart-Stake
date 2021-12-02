package smartstake.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import smartstake.registration.RegistrationRequest;
import smartstake.services.RegistrationService;
import smartstake.registration.token.ConfirmationTokenService;
import smartstake.services.UserService;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private  final RegistrationService registrationService;
    //private final UserService userService;
    //private final ConfirmationTokenService confirmationTokenService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
