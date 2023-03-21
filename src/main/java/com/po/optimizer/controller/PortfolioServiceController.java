package com.po.optimizer.controller;

import com.po.optimizer.model.SnPConstituentData;
import com.po.optimizer.repository.SPDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/")
public class PortfolioServiceController {


    private SPDataRepository repository;

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
        //System.out.println(sectors);
        sectorAndMakretCapData.put("Sectors",sectors);
        sectorAndMakretCapData.put("MarketCap",marketCapSet);
        return sectorAndMakretCapData;
    }
    @RequestMapping(value="/getMarketCap", method = RequestMethod.GET)
    public @ResponseBody Set<String> getMarketCap()
    {
       /* List<SnPConstituentData> data = repository.findAll();
        (data!=null && !data.isEmpty())
            data.stream().forEach(snpConstituentData -> marketCapSet.add(snpConstituentData.getMarket_Cap()));*/
        return null;
    }

    @RequestMapping(value="/getSPDataBySectorMktCap", method = RequestMethod.GET)
    public @ResponseBody List<SnPConstituentData> getSPDataBySectorMktCap(@RequestParam("sector") String sector,
                                                                          @RequestParam("marketCap") String marketCap)
    {
        List<SnPConstituentData> data = repository.findAllBy(sector,marketCap);
        return data;
    }

}
