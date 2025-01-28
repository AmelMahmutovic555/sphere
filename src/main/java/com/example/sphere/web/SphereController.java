package com.example.sphere.web;

import com.example.sphere.model.Client;
import com.example.sphere.model.Product;
import com.example.sphere.model.UserInformation;
import com.example.sphere.service.ClientService;
import com.example.sphere.service.ProductService;
import com.example.sphere.service.UserInformationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/", "/home"})
public class SphereController {

    private final ClientService clientService;
    private final ProductService productService;
    private final UserInformationService userInformationService;


    public SphereController(ClientService clientService, ProductService productService, UserInformationService userInformationService) {
        this.clientService = clientService;
        this.productService = productService;
        this.userInformationService = userInformationService;
    }

    @GetMapping
    public String showPage(Model model){
        List<Client> clientList = clientService.listAll();
        model.addAttribute("clients", clientList);
        model.addAttribute("authenticated", isAuthenticated);
        model.addAttribute("authenticated1", redirectHome);
        return "home";
    }

    @GetMapping("/add")
    public String showAdd(Model model){
        List<Client> client = clientService.listAll();
        List<Product> product = productService.listAll();
        model.addAttribute("clients", client);
        model.addAttribute("products", product);
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "edit";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegister(){
        return "register";
    }

    @PostMapping("/add")
    public String addItem(@RequestParam String name, @RequestParam String surname, @RequestParam String productName, @RequestParam double price){
        this.clientService.save(name, surname, productName, price);
        return "redirect:/home";
    }

    @PostMapping("/edit/{id}")
    public String addItem(@PathVariable Long id, @RequestParam String name, @RequestParam String surname, @RequestParam String productName, @RequestParam double price){
        this.clientService.edit(id, name, surname, productName, price);
        return "redirect:/home";
    }

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id){
        this.clientService.delete(id);
        return "redirect:/home";
    }

    boolean isAuthenticated = false;
    boolean redirectHome = false;

    @PostMapping("/login")
    public String loginPage(@RequestParam String email, @RequestParam String password){
        UserInformation userInformation = userInformationService.loginInformation(email, password);
        if (userInformation!=null && userInformation.getEmail().equals(email) && userInformation.getPassword().equals(password)){
            isAuthenticated = true;
            return "redirect:/home";
        }
        return "redirect:/login";
    }

    @PostMapping("/register")
    public String registerPage(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password){
        isAuthenticated = true;
        userInformationService.registerInformartion(firstName, lastName, email, password);
        return "redirect:/home";
    }

    @PostMapping("/logout")
    public String logoutPage(HttpSession session){
        session.invalidate();
        isAuthenticated = false;
        return "redirect:/home";
    }
}
