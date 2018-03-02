package controllers;

import models.Fibonacci;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.indexIn;
import views.html.indexOut;
import javax.inject.Inject;

public class FiboController extends Controller {
    private Fibonacci fibo;
    @Inject
    private FormFactory formFactory;

    public Result index(){
        return ok(indexOut.render(this.fibo));
    }

    public Result save(){
        Form<Fibonacci> fiboForm =  formFactory.form(Fibonacci.class).bindFromRequest();
        if(fiboForm.hasErrors()){
            return badRequest(indexIn.render(fiboForm));
        }
        this.fibo = fiboForm.get();
        fibo.fib();
        return redirect(routes.FiboController.index());
    }

    public Result back(){
        return redirect(routes.HomeController.index());
    }
}
