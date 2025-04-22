package mapping;

import com.rvk.movie_ticket_booking_system_api.dto.UserRegistrationDto;
import com.rvk.movie_ticket_booking_system_api.entity.TheaterOwner;
import com.rvk.movie_ticket_booking_system_api.entity.User;

public class UserRegistrationMapping {

    public User registrationUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setUserName(userRegistrationDto.userName());
        user.setEmail(userRegistrationDto.email());
        user.setPhoneNumber(userRegistrationDto.phoneNumber());
        user.setPassword(userRegistrationDto.password());
        user.setDateOfBirth(userRegistrationDto.dateOfBirth());
        return user;
    }

    public TheaterOwner registrationTheaterOwner(UserRegistrationDto userRegistrationDto) {
        TheaterOwner theaterOwner = new TheaterOwner();
        theaterOwner.setUserName(userRegistrationDto.userName());
        theaterOwner.setEmail(userRegistrationDto.email());
        theaterOwner.setPhoneNumber(userRegistrationDto.phoneNumber());
        theaterOwner.setPassword(userRegistrationDto.password());
        theaterOwner.setDateOfBirth(userRegistrationDto.dateOfBirth());
        return theaterOwner;
    }

}
