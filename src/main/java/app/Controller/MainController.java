package app.Controller;

import app.Repositories.itemRepo;
import app.Repositories.listRepo;
import app.Repositories.userRepo;
import app.Models.userModel;
//import app.Service.webServices;
//import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private userRepo urepo;
    @Autowired
    private listRepo lrepo;
    @Autowired
    private itemRepo Irepo;
//    @Autowired
//    private webServices service;

    //Get - FIND ALL
    @GetMapping(path = "/findall")
    public @ResponseBody Iterable<userModel> getAllUser() {
        return urepo.findAll();
//        return service.findAllService();
    }

    //GET - FIND BY USER
    @GetMapping(path = "/findbyuser/{user}")
    public @ResponseBody
    String getById(@PathVariable String user) {
        return urepo.findByUser(user).getUser();
    }

    //GET - FIND BY USER&PASS
    // for test: http://localhost:8080/login?user=test&pass=test
    @GetMapping(path = "/login")
    public @ResponseBody
    String getById(@RequestParam String user, @RequestParam String pass) {
        try {
            return urepo.findByUserAndPass(user, pass).getUser();
        }catch (Exception ex){
            return null;
        }
    }
    //GET - FIND LIST BY USER
    //http://localhost:8080/findListByUser?user=test
    @GetMapping(path = "/findListByUser")
    public @ResponseBody
    List<String> getbyListUser(@RequestParam String user) {
        Integer userData = urepo.findByUserAndGiveID(user);
        return lrepo.findAllListFromUserID(userData);
//        return null;
    }
    //GET - FIND List by userid
    @GetMapping(path = "/findbyuserid/{number}")
    public @ResponseBody List<String> getByListUser(@PathVariable Integer number) {
        return lrepo.findAllListFromUserID(number);
//    return null;
    }
    //GET - FIND ITEM BY listid
    @GetMapping(path = "/finditembyidlist/{number}")
    public @ResponseBody List<String> getByItemListUser(@PathVariable Integer number) {
        List<String> itemList = Irepo.findAllItemFromListID(number);
        List<String> descList = Irepo.findAlldescFromListID(number);
        ArrayList<String> ResultList = new ArrayList<>();
        int count2 = 0;
        for(int count = 0;count<=itemList.size()-1;count++){
            ResultList.add(count2,itemList.get(count));
            count2++;
            ResultList.add(count2,descList.get(count));
            count2++;
        }
        return ResultList;
    }

    //erroring out.
    @GetMapping(path = "/findAllListAndItem")
    public @ResponseBody List<String> getByuserAllListAndItem(@RequestParam String user) {
        Integer userData = urepo.findByUserAndGiveID(user);
        List<String> ListOfUser = lrepo.findAllListFromUserIDAndGiveID(userData);
        List<String> itemList = null;
        List<String> descList = null;
        int count3=0;
        while(ListOfUser.size()>count3){
            itemList = Irepo.findAllItemFromListID(Integer.parseInt(ListOfUser.get(count3)));
            descList = Irepo.findAlldescFromListID(Integer.parseInt(ListOfUser.get(count3)));
            count3++;
        }
        ArrayList<String> ResultList = new ArrayList<>();
        int count2 = 0;
        for(int count = 0;count<=itemList.size()-1;count++){
            ResultList.add(count2,itemList.get(count));
            count2++;
            ResultList.add(count2,descList.get(count));
            count2++;
        }
        return ResultList;
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
