package or.topguns.AuthenticationService.AuthenticationService.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
@PreAuthorize("hasRole('CLIENT')")
public class ClientController {
    @GetMapping
    public  String get(){
        return "GET :: client controller";
    }
    @PostMapping
    public  String create(){
        return "Post :: client controller";
    }
    @PutMapping
    public  String update(){
        return "PUT :: client controller";
    }
    @DeleteMapping
    public  String delete(){
        return "DELETE :: client controller";
    }
}
