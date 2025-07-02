package com.muntasir.authentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectedController {

    /// Spring will look for a request attribute named "username" and inject it as a String.
    /// If the attribute is not found, it will throw an exception by default.
    /// Using @RequestAttribute is cleaner and more declarative.
    @GetMapping("/greeting")
    public ResponseEntity<String> getPersonalizedGreeting(@RequestAttribute("username") String username) {

        /// The username is directly available here thanks to the annotation.
        /// No casting or null checks are needed (unless you make it optional).
        return ResponseEntity.ok("Welcome back, " + username + "!");
    }

    // Example of making it optional
    @GetMapping("/optional-greeting")
    public ResponseEntity<String> getOptionalGreeting(@RequestAttribute(name = "username", required = false) String username) {
        if (username != null) {
            return ResponseEntity.ok("Optional welcome for " + username);
        }
        return ResponseEntity.ok("Generic welcome for guests!");
    }
}