package cgg.informatique.jfl.securite.controleurs;

import cgg.informatique.jfl.securite.entite.Image;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class controleurMVCREST {
    //http://websystique.com/spring-security/spring-security-4-method-security-usingpreauthorize-postauthorize-secured-el/
    @RequestMapping(value = "/Mystere", method = RequestMethod.GET)
    public String racine(Map<String, Object> model) {
        // Base64 image convertisseur https://www.base64-image.de/
        return Image.getImage();
    }
}
