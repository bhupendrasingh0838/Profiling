package bhup9.profiling.Controller;

import bhup9.profiling.Entity.Item;
import bhup9.profiling.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProfileController {
    @Autowired
    ItemService service;

    @GetMapping("/message")   //Profiling
    public ResponseEntity<String> getWelcomeMessage() throws Exception {
        String welcomeMessage = service.getWelcomeMessage();
        ResponseEntity<String> response = new ResponseEntity<String>(welcomeMessage, HttpStatus.OK);
        return response;
    }                      // end logic

    @GetMapping("/getItem")
    public List<Item> getItem() {
        return service.getItem();
    }

    @PostMapping("/create")
    public String create(@RequestBody Item item) {
        service.save(item);
        return "Data Created Succesfully";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Data Delete Succesfully";
    }

    @GetMapping("/getItem/{id}")
    public Item getItem(@PathVariable int id) {
        Item item = service.getId(id);
        return item;

    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Item item) {
        service.update(id, item);
        return "Update date Succesfully";

    }
}
