package kata6;

import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Dictionary {
    @SerializedName(value = "text") @XmlElement(name = "xxx")
    private String txt;
    public String audio;
    public String sourceURL;
    public License license;

    @Override
    public String toString() {
        return "Dictionary{" + "text=" + txt + ", audio=" + audio +
                ", sourceURL=" + sourceURL + ", license=" + license + '}';
    }

    public static class License {
        public String name;
        public String url;
    }
}
    
