package controllers;

import models.Fibonacci;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import views.html.indexIn;

import javax.inject.Inject;


public class HomeController extends Controller {

    @Inject
    private FormFactory formFactory;

    public Result index() {
        Form<Fibonacci> fiboForm =  formFactory.form(Fibonacci.class);
        return ok(indexIn.render(fiboForm));
    }

}
