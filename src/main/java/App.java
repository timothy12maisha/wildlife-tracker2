
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;
public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
        get("/",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            model.put("allEndangered", EndangeredAnimal.getAllAnimals());
            model.put("allAnimals", EndangeredAnimal.getAll());
            model.put("allSightings", Sighting.getAll());
            return new ModelAndView(model,"registry.hbs");
        },new HandlebarsTemplateEngine());
        get("/NormalAnimal/new", (req,res)-> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"NormalAnimalForm.hbs");
        }, new HandlebarsTemplateEngine());
        get("/EndangeredAnimal/new", (req,res)-> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"EndangeredAnimalForm.hbs");
        }, new HandlebarsTemplateEngine());
        get("/sighting/new", (req,res)-> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"sighting.hbs");
        }, new HandlebarsTemplateEngine());
        post("/NormalAnimal/new",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("NormalAnimalName");
            String time = req.queryParams("NormalAnimalTime");
            NormalAnimal newNormalAnimal = new NormalAnimal(1,"",2001);
            newNormalAnimal.saveNormal();
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());
        post("/sighting/new",(req,res)->{
            Map<String,Object>model = new HashMap<>();
            String rangerName = req.queryParams("rangerName");
            String animalLocation = req.queryParams("animalLocation");
            Sighting sighting = new Sighting(1,animalLocation, rangerName);
            return new ModelAndView(model,"Success.hbs");
        },new HandlebarsTemplateEngine());
        post("EndangeredAnimal/new" ,(req,res)->{
            Map<String,Object> model = new HashMap<>();
            String name = req.queryParams("AnimalName");
            String time = req.queryParams("NewTime");
            String age = req.queryParams("Age");
            String health = req.queryParams("Health");
            EndangeredAnimal endangered = new EndangeredAnimal("",2001,"");
            endangered.saveEndangered();
            model.put("EndangeredAnimal",endangered);
            model.put("template", "Success.hbs");
            return new ModelAndView(model,"Success.hbs");
        },new HandlebarsTemplateEngine());
    }
}