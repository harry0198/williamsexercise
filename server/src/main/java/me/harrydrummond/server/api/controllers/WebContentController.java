package me.harrydrummond.server.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for displaying data on the front-end.
 * Serves web pages.
 */
@Controller
public class WebContentController {

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }
}
