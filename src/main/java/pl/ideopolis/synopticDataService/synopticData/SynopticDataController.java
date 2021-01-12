package pl.ideopolis.synopticDataService.synopticData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class SynopticDataController {

    @Autowired
    private SynopticDataService synopticDataService;

    @GetMapping("")
    public String getSynopticData (){
        return synopticDataService.getPostPlainJSON();
    }

}
