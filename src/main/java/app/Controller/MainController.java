package app.Controller;

import app.Repositories.userRepo;
import app.Models.userModel;
//import app.Service.webServices;
//import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    //GET:
    // - Find All                               (DONE)
    // - Find By ID                             (DONE)
    // - Find by Filtering string or ID
    // - Filtering by list
    //
    //POST: - (POST is NOT idempotent)
    // - Create new row (general use)
    // - Update row
    //
    //PUT - (PUT replaces an existing entity. If only a subset of data elements are provided, the rest will be replaced with empty or null.) (POST is idempotent)
    // - Create new row
    // - Update row (general use)
    //
    //PATCH (depreciated? + unsafe)
    // - Alter row/update row
    //
    //DELETE
    // - Delete by ID
    //
    // --------------------------
    // - Extra Info of responses: -
    //Status codes indicate the result of the HTTP request.
    //
    //1XX - informational
    //2XX - success
    //3XX - redirection
    //4XX - client error
    //5XX - server error
    @Autowired
    private userRepo repo;
//    @Autowired
//    private webServices service;

    //Get - FIND ALL
    @GetMapping(path = "/findall")
    public @ResponseBody Iterable<userModel> getAllUser() {
        return repo.findAll();
//        return service.findAllService();
    }

    //GET - FIND BY USER
    @GetMapping(path = "/findbyuser/{user}")
    public @ResponseBody
    String getById(@PathVariable String user) {
        return repo.findByUser(user).getUser();
    }
    //GET - FIND BY USER&PASS
    @GetMapping(path = "/login")
    public @ResponseBody
    String getById(@RequestParam String user, @RequestParam String pass) {
        try {

            return repo.findByUserAndPass(user, pass).getUser();
        }catch (Exception ex){
            return null;
        }
    }
    //GET - FIND LIST BY USER
    @GetMapping(path = "/findListByUser/")
    public @ResponseBody String getbyListUser(@PathVariable String user) {
        return repo.findByUser(user).getUser();
    }
    //GET - FIND ITEM BY LIST&USER
    @GetMapping(path = "/findbyuser/{user}")
    public @ResponseBody String getByItemListUser(@PathVariable String user,@PathVariable String list) {
        return repo.findByUser(user).getUser();
    }


    //Validate User login
    // Method - GET
    // Get User/Pass
    // Return - true/false, message
//    @GetMapping(path = "/login")
//    public @ResponseBody userModel ValidateUserLogin(@PathVariable String user,@PathVariable String Pass){
//        return null;
//    }



    //Post
//    @PostMapping(path = "/postmap")
//    public @ResponseBody
//    userModel postactor(@RequestBody userModel mActor){
//        return repo.save(mActor);
//    }

    //PUT
//    @PutMapping(path = "/puttingbyid/{id}")
//    public @ResponseBody
//    userModel putbyid(@PathVariable Integer id, @RequestBody userModel mActor){
//        return repo.findById(id)
//                .map(modelActor -> {
//                    modelActor.setFirst_name(mActor.getFirst_name());
//                    modelActor.setLast_name(mActor.getLast_name());
//                    modelActor.setLast_update(mActor.getLast_update());
//                    return repo.save(modelActor);
//                }).orElseGet(()->{
//                    mActor.setActor_id(id);
//                    return repo.save(mActor);
//                });
//    }
    // DELETE - delete by id
//    @DeleteMapping(value = "/deletebyid/{id}")
//    void deleteActor(@PathVariable Integer id){
//        repo.deleteById(id);
//    }
//    public void deleteActor


}
