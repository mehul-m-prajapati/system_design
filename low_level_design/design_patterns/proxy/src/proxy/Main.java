package proxy;

import java.util.Objects;

interface DataBaseExecutor
{
    public abstract void executeQuery(String Type);
}

class DataBase
{
     public DataBase() {

     }
     
     void execute(String QueryType,String id) {
         System.out.println("executing the query : " + QueryType);
     }
}

class DataBaseProxy implements DataBaseExecutor
{
    String id;
    DataBase db;
    
    private DataBaseProxy() {

    }
    
    public DataBaseProxy(String id) {
        this.id = id;
        db = new DataBase();        //connection
    }

    @Override
    public void executeQuery(String QueryType) {
        if (QueryType.equals("DELETE") && !Objects.equals(this.id, "ADMIN"))
        {
            System.out.println("cannot execute the query , admin permission is needed");
            return;
        }
        db.execute(QueryType,this.id);
    }
}

public class Main {

	public static void main(String args[]) {
        DataBaseExecutor emp1 = new DataBaseProxy("NON ADMIN");
        emp1.executeQuery("READ");
        emp1.executeQuery("WRITE");
        emp1.executeQuery("DELETE");

        DataBaseExecutor emp2 = new DataBaseProxy("ADMIN");
        emp2.executeQuery("READ");
        emp2.executeQuery("WRITE");
        emp2.executeQuery("DELETE");
	}
}
