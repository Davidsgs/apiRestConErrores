package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.User;
import alkemy.challenge.Challenge.Alkemy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @DeleteMapping()
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        if(userService.deleteUserById(id)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity createUser(@RequestBody User user){
        try{
            return new ResponseEntity(userService.createUser(user), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity updateUser(@RequestBody User user){
        try{
            return new ResponseEntity(userService.createUser(user), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{age}")
    public ResponseEntity getUserByAge (@PathVariable int age){
        return new  ResponseEntity (userService.findByAge(age), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
        return new  ResponseEntity (userService.loadUserByUsername(email), HttpStatus.ACCEPTED);
    }

}
