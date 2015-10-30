package services;


import com.wordnik.swagger.annotations.ApiOperation;
import domain.ConceptModel;
import hello.Greeting;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class ConceptModelController {

    private final AtomicInteger counter = new AtomicInteger();
    private Map<Integer, ConceptModel> conceptMap = new ConcurrentHashMap<Integer, ConceptModel>();

    @RequestMapping(value="/ont/ontology", method=RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value="Add Ontology to domain")
    public ResponseEntity<ConceptModel> addConcept(@RequestBody ConceptModel conceptModel){
        System.out.println(conceptModel);
        HttpHeaders httpHeaders = new HttpHeaders();
        conceptMap.put(counter.incrementAndGet(),conceptModel);
        httpHeaders.setLocation(URI.create("localhost:8080/ont/ontology"));
        return new ResponseEntity<ConceptModel>(conceptModel, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/ont/ontology", method=RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value="Get the available Ontology")
    public ResponseEntity<List<ConceptModel>> getConceptById(@RequestParam(value="id", defaultValue = "1") String conceptId){
        ConceptModel model = new ConceptModel(2,"Pulmonary Cancer");
        List<ConceptModel> conceptList = new ArrayList<ConceptModel>();
        for(Map.Entry<Integer,ConceptModel> entry : conceptMap.entrySet()){
            conceptList.add(entry.getValue());
        }
        return new ResponseEntity<List<ConceptModel>>(conceptList, HttpStatus.OK);
    }
}
