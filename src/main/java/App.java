
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;
public class App {
    public static void main(String[] args){
        staticFileLocation("/public");

        post("/Sighting/new",(request,res)->{
            Map<String,Object>model = new HashMap<>();
            String rangerName = request.queryParams("rangerName");
            String animalLocation = request.queryParams("animalLocation");
            Sighting sighting = new Sighting(1,animalLocation, rangerName);
            return new ModelAndView(model,"Success.hbs");
        },new HandlebarsTemplateEngine());

        get("/Sighting/new", (req,res)-> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"SightingForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/EndangeredAnimal/new" ,(request,res)->{
            Map<String,Object> model = new HashMap<>();
            String name = request.queryParams("AnimalName");
            String time = request.queryParams("NewTime");
            String age = request.queryParams("Age");
            String health = request.queryParams("Health");
            EndangeredAnimal endangered = new EndangeredAnimal("",new Timestamp(12-12-2009),"");

            return new ModelAndView(model,"Success.hbs");
        },new HandlebarsTemplateEngine());


        get("/EndangeredAnimal/new", (req,res)-> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"EndangeredAnimalForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/NormalAnimal/new",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("NormalAnimalName");
            String time = req.queryParams("NormalAnimalTime");
            NormalAnimal newNormalAnimal = new NormalAnimal(1,"",new Timestamp(12-12-2009));
            newNormalAnimal.saveNormal();
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        get("/NormalAnimal/new", (req,res)-> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"NormalAnimalForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/AllAnimals",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            model.put("allEndangered", EndangeredAnimal.getAllAnimals());
            model.put("allAnimals", EndangeredAnimal.getAll());
            model.put("allSightings", Sighting.getAll());
            return new ModelAndView(model,"AllAnimals.hbs");
        },new HandlebarsTemplateEngine());

    }
}