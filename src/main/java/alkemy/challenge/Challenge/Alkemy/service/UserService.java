package alkemy.challenge.Challenge.Alkemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import alkemy.challenge.Challenge.Alkemy.model.User;
import alkemy.challenge.Challenge.Alkemy.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;
    //Read
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NullPointerException("There is no character with the id : " + id));
    }
    //Create
    public User createUser(User user){
        if(user.getId() != null){
            throw new IllegalArgumentException("The User already exist. Try update it");
        }
        return userRepository.save(user);
    }

    //Update
    @Transactional
    public User updateUser(User user){
        var auxUser = findById(user.getId());
        auxUser.setFirstName(user.getFirstName());
        auxUser.setLastName(user.getLastName());
        auxUser.setEmail(user.getEmail());
        auxUser.setAge(user.getAge());
        auxUser.setPassword(user.getPassword());
        if(user.getPhoto() != null){auxUser.setPhoto(user.getPhoto());}
        return auxUser;
    }

    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " don't found"));
    }

    //Delete
    public Boolean deleteUserById(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<User> findByAge (int age){
        return userRepository.findByAge(age);
    }
}
