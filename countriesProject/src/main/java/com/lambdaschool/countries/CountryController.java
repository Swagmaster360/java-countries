package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// Java Spring Rest APIs -> Java back End
@RestController
@RequestMapping("/data")
public class CountryController {
    // create endpoints at localhost:8080
    //localhost:8080/data/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
        public ResponseEntity<?> getAllCountries() {
            ArrayList<String> countryNames = new ArrayList<String>();

            CountriesApplication.ourCountryList.countryList.forEach(c -> countryNames.add(c.getName()));
            java.util.Collections.sort(countryNames);
            return new ResponseEntity<>(countryNames, HttpStatus.OK);
        }

    //localhost:8080/data/start/:letter
    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter) {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:8080/data/names/size/:number
    @GetMapping(value = "/name/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByNameLength(@PathVariable int number) {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c -> c.getName().length() >= number);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:8080/data/population/size/:number
    @GetMapping(value = "/population/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulationSize(@PathVariable int number) {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c -> c.getPopulation() >= number);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:8080/data/population/min
    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getSmallestCountry() {

        ArrayList<Country> countryList = CountriesApplication.ourCountryList.countryList;
        countryList.sort((c1, c2) -> c1.getPopulation() - (c2.getPopulation()));

        Country rtnCountry = countryList.get(0);

        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getLargestCountry() {

        ArrayList<Country> countryList = CountriesApplication.ourCountryList.countryList;
        countryList.sort((c2, c1) -> c1.getPopulation() - (c2.getPopulation()));

        Country rtnCountry = countryList.get(0);

        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }


    //localhost:8080/data/country/:id
    @GetMapping(value = "/country/{id}", produces = {"application/json"})
    public ResponseEntity<?> getCountryById(@PathVariable long id) {
        Country rtnCountry = CountriesApplication.ourCountryList.findCountry(c -> (c.getId() == id));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }





}
