package cogran.pe.cqsapp.service;

import cogran.pe.cqsapp.service.PersonaService;
import cogran.pe.cqsapp.service.RetrofitInstance;

public class ApiUtils {
    private static final String BASE_URL = "http://192.168.100.23:8080/";

    public static final PersonaService getPersonaService(){
        return RetrofitInstance.getRetrofitInstance(BASE_URL).create(PersonaService.class);
    }

}
