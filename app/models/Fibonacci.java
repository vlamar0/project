package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fibonacci extends Model  {
    @Id
    @Constraints.Required
    @Constraints.Min(1)
    public Integer amount;
    public String sequence;

    public Fibonacci(){
    }
    public Fibonacci(Integer amount){
        this.amount = amount;
    }

    public void fib() {
        int n = this.amount;
        String str = "1 1 ";
        int n0 = 1;
        int n1 = 1;
        int n2;
        for(Integer i = 3; i <= n; i++){
            n2 = n0 + n1;
            str += n2 + " ";
            n0 = n1;
            n1 = n2;
        }
        this.sequence = str;
        if(n==1)  this.sequence = "1";
    }
}

