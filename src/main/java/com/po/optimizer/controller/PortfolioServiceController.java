package com.po.optimizer.controller;

import com.po.optimizer.model.Optimizersummary;
import com.po.optimizer.model.RunIdDetails;
import com.po.optimizer.model.SnPConstituentData;
import com.po.optimizer.repository.OptimizersummaryRepository;
import com.po.optimizer.repository.RunIdDetailsRepository;
import com.po.optimizer.repository.SPDataRepository;
import com.po.optimizer.service.SubmitOptimizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/")
public class PortfolioServiceController {


    private SPDataRepository repository;
    @Autowired
    private RunIdDetailsRepository runIdDetailsRepository;
    @Autowired
    private OptimizersummaryRepository optSummaryRepository;
    @Autowired
    private SubmitOptimizer opt;
    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioServiceController.class);

    @Autowired
    public PortfolioServiceController(SPDataRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value="/getSPDataBySector", method = RequestMethod.GET)
    public @ResponseBody List<SnPConstituentData> getSPDataBySector(@RequestParam("sectorName") String sectorName) {

        //System.out.println("Getting data by name: " + sectorName);
        List<SnPConstituentData> data = repository.findBySector(sectorName);
        //System.out.println(data);
        return data;
    }

    @RequestMapping(value="/getSPDataByMktCap", method = RequestMethod.GET)
    public @ResponseBody List<SnPConstituentData> getSPDataBySectorMktCap(@RequestParam("marketCap") String marketCap )
    {
        List<SnPConstituentData> data = repository.findByMarketCap(marketCap);
        return data;
    }

    @RequestMapping(value="/getAllSPData", method = RequestMethod.GET)
    public @ResponseBody List<SnPConstituentData> getAllSPData()
    {
        List<SnPConstituentData> data = repository.findAll();
        return data;
    }

    @RequestMapping(value="/getSectorsAndMarketCap", method = RequestMethod.GET)
    public @ResponseBody Map<String,Set<String>> getSectorsAndMarketCap()
    {
        List<SnPConstituentData> data = repository.findAll();
        Map<String,Set<String>> sectorAndMakretCapData = new HashMap<>();
        Set<String> sectors = new HashSet<String>();
        Set<String> marketCapSet = new HashSet<String>();

        if(data!=null && !data.isEmpty()) {
            data.stream().forEach(snpConstituentData -> sectors.add(snpConstituentData.getSector()));
            data.stream().forEach(snpConstituentData -> marketCapSet.add(snpConstituentData.getMarket_Cap()));
        }
        Set<String> models = new HashSet<String>();
        models.add("Monte Carlo"); models.add("SLSQP");
        //System.out.println(sectors);
        sectorAndMakretCapData.put("Sectors",sectors);
        sectorAndMakretCapData.put("MarketCap",marketCapSet);
        sectorAndMakretCapData.put("Models",models);

        return sectorAndMakretCapData;
    }
    @RequestMapping(value="/getSPDataBySectorMktCap", method = RequestMethod.GET)
    public @ResponseBody List<SnPConstituentData> getSPDataBySectorMktCap(@RequestParam("sector") String sector,
                                                                          @RequestParam("marketCap") String marketCap)
    {
        List<SnPConstituentData> data = repository.findAllBy(sector,marketCap);
        return data;
    }
    @PostMapping ("/optimize")
    @ResponseBody
    public String submitOptimzation(@RequestBody RunIdDetails runInfo) {
        //long runId = 0;
        //first time comment this line
        long runId=runIdDetailsRepository.count();
        runInfo.setRunId(++runId);
        runIdDetailsRepository.save(runInfo);
        LOGGER.info("Calling service to submit message");
        //opt.sendMessage(runId);
        return ("Successfully submitted Message");
    }

    @GetMapping("/getRunDetails")
    @ResponseBody
    public RunIdDetails getRunDetails(long runId) {
        LOGGER.info("Calling getRunDetails");
        return runIdDetailsRepository.findItemByRunId(runId);
       }

    @GetMapping("/getRunDetailsByName")
    @ResponseBody
    public List<RunIdDetails> getRunDetailsByName(String name) {
        LOGGER.info("Calling getRunDetailsByName");
        return runIdDetailsRepository.findItemByName(name);
    }

    @GetMapping("/getRunStatus")
    @ResponseBody
    public String getRunStatus(long runId) {
        LOGGER.info("Calling getRunStatus");
        RunIdDetails runDtls= runIdDetailsRepository.findItemByRunId(runId);
        if(runDtls != null)
            return runDtls.getStatus();
        else
          return  "Status not found for Run Id"+runId;
    }
    @GetMapping("/getOptimizedSummary")
    @ResponseBody
    public Optimizersummary getOptimizedSummary(long runId) {
        LOGGER.info("Calling getOptimizedSummary");
        return optSummaryRepository.getOptimizersummarysByRunid(runId);
    }
    @GetMapping("/getMessage")
    @ResponseBody
    public String getMessage() {
        LOGGER.info("Calling getMessage");
        return "App is up";
    }

}
