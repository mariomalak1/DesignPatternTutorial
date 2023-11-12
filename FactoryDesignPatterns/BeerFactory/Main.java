import java.util.Calendar;

public class Main {
  public static void main(String[] args) {
    Beer myBeer = BeerFactory.GetBeer();
    myBeer.brew();
  }
}


class BeerFactory {
  public static Beer GetBeer(){
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    
    Beer myBeer = null;

    if (day == calendar.MONDAY) {
      myBeer = new StoutBeer();
    }
    else if (day == calendar.SATURDAY) {
      myBeer = new StoutBeer();
    } else {
      myBeer = new IPABeer();
    }

    return myBeer;
  }
}

abstract class Beer {
  public abstract void malting();
  public abstract void steeping();
  public abstract void boiling();
  public abstract void fermentation();
  public abstract void bottling();

  public void brew() {
       malting();
       steeping();
       boiling();
       fermentation();
       bottling();
    }
}

/* IPABeer.java */
class IPABeer extends Beer {
  public void malting() { System.out.println("Malting with rye grains"); }
  public void steeping() { System.out.println("Steep grains through boiling water at 170 degrees"); }
  public void boiling() { System.out.println("Boil wort for 60 minutes"); }
  public void fermentation() { System.out.println("Let sit for 14"); }
  public void bottling() { System.out.println("Your IPA beer has been bottled!"); }
}

/* StoutBeer.java */
class StoutBeer extends Beer {
  public void malting() { System.out.println("Malting with oat grains"); }
  public void steeping() { System.out.println("Steep grains through boiling water at 160 degrees"); }
  public void boiling() { System.out.println("Boil wort for 75 minutes"); }
  public void fermentation() { System.out.println("Let sit for 20 days"); }
  public void bottling() { System.out.println("Your stout beer has been bottled!"); }
}