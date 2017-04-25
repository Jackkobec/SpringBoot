package com.gmail.jackkobec.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс для возвращения данных после действия
 * Например после:
 *
 * @RequestMapping(value = "/user",method = RequestMethod.POST)
 * public ResponseEntity<GeneralResponse> postUser(@RequestBody User user) {
 * User saved = userRepository.save(user);
 * return new ResponseEntity<GeneralResponse>(new GeneralResponse("success"), HttpStatus.OK);
 * }
 */
@NoArgsConstructor   // default constructor
@AllArgsConstructor  // constructor for all fields
public class GeneralResponse {

    @Getter @Setter
    public String message;
}