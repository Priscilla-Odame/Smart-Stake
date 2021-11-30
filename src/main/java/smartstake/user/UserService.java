package smartstake.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import smartstake.registration.token.ConfirmationToken;
import smartstake.registration.token.ConfirmationTokenService;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, email)));

    }

    public String signUpUser(AppUser appUser) {
        boolean userExist = repository.findByEmail(appUser.getEmail())
                .isPresent();
        if (userExist) {
            //Todo if email not confirmed send confirmation email
            //Todo 
            throw new IllegalStateException("email already in use.");
        }


        String encodePassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodePassword);
        repository.save(appUser);


        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        //Todo send email
        return token;
    }

    public int enableAppUser(String email) {
        return repository.enableAppUser(email);
    }
}
