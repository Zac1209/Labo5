package cgg.informatique.jfl.securite.controleurs;

import cgg.informatique.jfl.securite.dao.CompteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class controleurMVC {
    @Autowired
    private CompteDao compteDao;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String racine(Map<String, Object> model) {
        return "publique/publique";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Map<String, Object> model) {
        return "admin/admin";
    }
    @RequestMapping(value = "/publique", method = RequestMethod.GET)
    public String publique(Map<String, Object> model) {
        return "publique/publique";
    }
    @RequestMapping(value = "/membre", method = RequestMethod.GET)
    public String membre(Map<String, Object> model) {
        return "membre/membre";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> model) {
        return "login";
    }
}

