package pradeet.foodcatering;

/**
 * Created by pradeet on 24/7/15.
 */
public class CateersSepc {
    public String Name;
    public String Spec;
    public String Rate;
    public String Rating;
    public int IconID;

    public CateersSepc(){

    }

    public CateersSepc(String Name, String Spec, String Rate, String Rating){
        this.Name = Name;
        this.Rate = Rate;
        this.Spec = Spec;
        this.Rating = Rating;
    }
}
